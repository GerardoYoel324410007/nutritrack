package com.example.nutritrack

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun NutriTrackScreen() {
    // State daftar sementara (Syarat 6.3)[cite: 4]
    val foodRecords = remember { mutableStateListOf<FoodRecord>() }

    // State form input
    var selectedMealTime by remember { mutableStateOf(MealTime.SARAPAN) }
    var foodNameInput by remember { mutableStateOf("") }
    var selectedFoodGroup by remember { mutableStateOf(FoodGroup.KARBOHIDRAT) }
    var portionInput by remember { mutableStateOf("") }
    var notesInput by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val summary = NutriTrackLogic.calculateSummary(foodRecords)

    fun resetForm() {
        selectedMealTime = MealTime.SARAPAN
        foodNameInput = ""
        selectedFoodGroup = FoodGroup.KARBOHIDRAT
        portionInput = ""
        notesInput = ""
        errorMessage = null
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("NutriTrack", fontWeight = FontWeight.Bold)
                        Text(
                            "Edukasi Gizi Seimbang & Keragaman Pangan",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            // Banner Batas Keselamatan & Etika[cite: 5]
            item {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Catatan: Indikator hanya bersifat edukatif dan refleksi diri, bukan penilaian klinis atau diagnosis status gizi[cite: 5].",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }

            // Kartu Ringkasan Harian (Syarat 6.4)[cite: 4]
            item {
                SummaryCard(summary = summary)
            }

            // Formulir Pencatatan (Syarat 6.2)[cite: 4]
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "Tambah Catatan Makanan",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Text("1. Waktu Makan:", style = MaterialTheme.typography.labelLarge)
                        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            MealTime.entries.forEach { mealTime ->
                                FilterChip(
                                    selected = (selectedMealTime == mealTime),
                                    onClick = { selectedMealTime = mealTime },
                                    label = { Text(mealTime.label) }
                                )
                            }
                        }

                        OutlinedTextField(
                            value = foodNameInput,
                            onValueChange = { foodNameInput = it; errorMessage = null },
                            label = { Text("2. Nama Makanan (Wajib)") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Text("3. Kelompok Makanan:", style = MaterialTheme.typography.labelLarge)
                        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            FoodGroup.entries.forEach { group ->
                                FilterChip(
                                    selected = (selectedFoodGroup == group),
                                    onClick = { selectedFoodGroup = group },
                                    label = { Text(group.label) }
                                )
                            }
                        }

                        OutlinedTextField(
                            value = portionInput,
                            onValueChange = { portionInput = it; errorMessage = null },
                            label = { Text("4. Jumlah Porsi Sederhana (Wajib)") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = notesInput,
                            onValueChange = { notesInput = it },
                            label = { Text("5. Catatan (Opsional)") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )

                        if (errorMessage != null) {
                            Text(
                                text = errorMessage!!,
                                color = MaterialTheme.colorScheme.error,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Button(
                                onClick = {
                                    val error = NutriTrackLogic.validateInput(foodNameInput, portionInput)
                                    if (error != null) {
                                        errorMessage = error
                                    } else {
                                        val record = FoodRecord(
                                            mealTime = selectedMealTime,
                                            foodName = foodNameInput.trim(),
                                            foodGroup = selectedFoodGroup,
                                            portion = portionInput.trim().replace(",", ".").toDouble(),
                                            notes = notesInput.trim()
                                        )
                                        foodRecords.add(0, record)
                                        resetForm()
                                    }
                                },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Tambah")
                            }

                            OutlinedButton(
                                onClick = { resetForm() },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Reset")
                            }
                        }
                    }
                }
            }

            item {
                Text(
                    text = "Riwayat Konsumsi Hari Ini (${foodRecords.size})",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            // Empty State atau List Item (Syarat 6.3)[cite: 4]
            if (foodRecords.isEmpty()) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Belum Ada Catatan Makanan",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Isi formulir di atas untuk mulai memantau keragaman pangan.",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            } else {
                items(foodRecords, key = { it.id }) { record ->
                    FoodRecordItemCard(record = record)
                }
            }
        }
    }
}

@Composable
fun SummaryCard(summary: NutriSummary) {
    val containerColor = if (summary.isDiverse) {
        MaterialTheme.colorScheme.secondaryContainer
    } else {
        MaterialTheme.colorScheme.tertiaryContainer
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = containerColor)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ringkasan Gizi Harian",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Surface(
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(
                        text = summary.diversityStatus,
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Catatan", style = MaterialTheme.typography.labelMedium)
                    Text(summary.totalRecords.toString(), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                }
                Column {
                    Text("Kelompok Pangan", style = MaterialTheme.typography.labelMedium)
                    Text("${summary.distinctGroupsCount} / 5", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                }
                Column {
                    Text("Total Porsi", style = MaterialTheme.typography.labelMedium)
                    Text("${summary.totalPortions}", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                }
            }

            HorizontalDivider()

            Text(
                text = summary.educationalMessage,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun FoodRecordItemCard(record: FoodRecord) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = record.foodName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${record.portion} Porsi",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AssistChip(onClick = {}, label = { Text(record.mealTime.label) })
                AssistChip(onClick = {}, label = { Text(record.foodGroup.label) })
            }

            if (record.notes.isNotEmpty()) {
                Text(
                    text = "Catatan: ${record.notes}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}