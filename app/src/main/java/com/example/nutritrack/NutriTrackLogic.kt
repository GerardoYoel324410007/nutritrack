package com.example.nutritrack

data class NutriSummary(
    val totalRecords: Int,
    val distinctGroupsCount: Int,
    val totalPortions: Double,
    val diversityStatus: String,
    val educationalMessage: String,
    val isDiverse: Boolean,
)

object NutriTrackLogic {

    // Validasi Form Input (Syarat 6.2 & Skenario Uji 3, 4, 5)
    fun validateInput(foodName: String, portionText: String): String? {
        if (foodName.trim().isEmpty()) {
            return "Nama makanan tidak boleh kosong."
        }
        if (portionText.trim().isEmpty()) {
            return "Jumlah porsi wajib diisi."
        }

        // Mencegah crash jika diisi huruf, menggunakan toDoubleOrNull()
        val portion = portionText.trim().replace(",", ".").toDoubleOrNull()
            ?: return "Jumlah porsi harus berupa angka yang valid."

        if (portion <= 0.0) {
            return "Jumlah porsi harus lebih dari 0."
        }
        if (portion > 10.0) {
            return "Jumlah porsi di luar batas wajar (maksimal 10 porsi)."
        }

        return null // Valid
    }

    // Perhitungan Ringkasan & Status Edukatif (Syarat 6.4 & Studi Kasus 1)
    fun calculateSummary(records: List<FoodRecord>): NutriSummary {
        val totalRecords = records.size
        val distinctGroupsCount = records.map { it.foodGroup }.distinct().size
        val totalPortions = records.sumOf { it.portion }

        // Kriteria edukatif: Cukup bervariasi jika mencakup minimal 3 kelompok pangan berbeda
        val isDiverse = distinctGroupsCount >= 3
        val diversityStatus = if (isDiverse) "Cukup Bervariasi" else "Belum Bervariasi"

        val educationalMessage = when {
            totalRecords == 0 -> "Mulai catat makanan hari ini untuk melihat variasi gizimu."
            !isDiverse -> "Baru mencakup $distinctGroupsCount dari 5 kelompok pangan. Yuk, tambahkan kelompok pangan lain!"
            else -> "Hebat! Konsumsi harianmu sudah mencakup $distinctGroupsCount kelompok pangan yang berbeda."
        }

        return NutriSummary(
            totalRecords = totalRecords,
            distinctGroupsCount = distinctGroupsCount,
            totalPortions = totalPortions,
            diversityStatus = diversityStatus,
            educationalMessage = educationalMessage,
            isDiverse = isDiverse,
        )
    }
}
