package com.example.nutritrack

// Pilihan Waktu Makan (Elemen Data 1)
enum class MealTime(val label: String) {
    SARAPAN("Sarapan"),
    MAKAN_SIANG("Makan Siang"),
    MAKAN_MALAM("Makan Malam"),
    CAMILAN("Camilan")
}

// Pilihan Kelompok Makanan (Elemen Data 3)
enum class FoodGroup(val label: String) {
    KARBOHIDRAT("Makanan Pokok / Karbohidrat"),
    PROTEIN_HEWANI("Lauk Hewani"),
    PROTEIN_NABATI("Lauk Nabati"),
    SAYURAN("Sayur-sayuran"),
    BUAH("Buah-buahan")
}

// Data Class Utama NutriTrack (Syarat 6.1)
data class FoodRecord(
    val id: Long = System.currentTimeMillis(),
    val mealTime: MealTime,      // Waktu makan (Enum)
    val foodName: String,        // Nama makanan (String)
    val foodGroup: FoodGroup,    // Kelompok makanan (Enum)
    val portion: Double,         // Jumlah porsi sederhana (Double / Numerik, Bukan String)
    val notes: String,           // Catatan tambahan (String)
)
