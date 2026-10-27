# Dokumen Penggunaan AI (AI_USAGE.md)

**Nama Proyek:** NutriTrack - Aplikasi Edukasi Gizi Seimbang & Keragaman Pangan  
**Link Repository:** https://github.com/GerardoYoel324410007/nutritrack.git  

---

## 🤖 Ringkasan Penggunaan AI / LLM

Dalam pengembangan aplikasi **NutriTrack**, kami memanfaatkan AI (Android Studio Bot / LLM) sebagai asisten pemograman untuk:
1. Menyiapkan dan memperbaiki konfigurasi dependency Jetpack Compose Material 3 di file `app/build.gradle.kts` dan Version Catalog `libs.versions.toml`.
2. Memberikan masukan dalam merancang struktur UI berbasis Komponen Compose (`Scaffold`, `LazyColumn`, `FilterChip`, `Card`).
3. Membantu merumuskan logika validasi form yang aman dari *crash* saat pengguna memasukkan teks non-numerik pada bidang porsi makanan.

---

## 💬 Tabel Prompt dan Hasil Generasi AI

| No | Modul / Fitur | Prompt Utama yang Diberikan ke AI | Jawaban / Kode yang Dihasilkan AI |
|---|---|---|---|
| 1 | Konfigurasi Gradle Compose | *"analisis kesalahan kompilasi Jetpack Compose unresolved reference di MainActivity"* | AI memberikan petunjuk penambahan BOM Compose, `activity-compose`, `material3`, dan `buildFeatures { compose = true }` di `build.gradle.kts`. |
| 2 | Logika Validasi Porsi | *"Bagaimana cara mencegah aplikasi Android crash jika pengguna mengisi porsi makanan dengan huruf di Jetpack Compose?"* | AI menyarankan penggunaan `.replace(",", ".").toDoubleOrNull()` untuk mengonversi string ke `Double?` serta mengembalikan pesan error jika hasilnya `null`. |
| 3 | Perhitungan Keragaman Pangan | *"Buat fungsi logika Kotlin untuk menghitung jumlah kelompok pangan unik dari daftar catatan makanan harian."* | AI menghasilkan fungsi `records.map { it.foodGroup }.distinct().size` dan mengecek apakah hasilnya `>= 3` untuk menentukan status "Cukup Bervariasi". |
| 4 | Layout `NutriTrackScreen` | *"Buat layout Compose dengan Scaffold, TopAppBar, Form Input, Card Ringkasan, dan LazyColumn riwayat."* | AI menghasilkan struktur dasar `@Composable fun NutriTrackScreen()` dengan komponen Material 3 modern. |

---

## 🧠 Modifikasi dan Pemahaman Kode (Code Comprehension)

Sebagai prasyarat etika dan akademis, seluruh kode yang dihasilkan oleh AI telah **dibaca, dipahami, dan disesuaikan** oleh tim kami:

### 1. Pemahaman Logika Anti-Crash pada Input Porsi (`NutriTrackLogic.kt`)
- **Kode:**
  ```kotlin
  val portion = portionText.trim().replace(",", ".").toDoubleOrNull()
      ?: return "Jumlah porsi harus berupa angka me-valid."
  ```
- **Pemahaman Kami:** Fungsi `toDoubleOrNull()` bertindak sebagai penyaring aman. Jika pengguna mengetik huruf seperti `"dua"` atau simbol `"%#"`, fungsi ini akan mengembalikan `null` daripada melempar `NumberFormatException` yang biasanya menyebabkan aplikasi menutup paksa (*crash*). Kami juga menambahkan `.replace(",", ".")` agar pengguna Indonesia yang mengetik koma (misal: `"1,5"`) tetap terbaca sebagai angka desimal valid `1.5`.

### 2. Pemahaman State Management Compose (`NutriTrackScreen.kt`)
- **Kode:**
  ```kotlin
  val foodRecords = remember { mutableStateListOf<FoodRecord>() }
  ```
- **Pemahaman Kami:** `mutableStateListOf` adalah daftar terobservasi (reactive list) di Jetpack Compose. Ketika item baru ditambahkan ke `foodRecords`, Compose secara otomatis memicu *re-composition* pada `LazyColumn` dan `SummaryCard` tanpa perlu memanggil `notifyDataSetChanged()` manual seperti pada RecyclerView tradisional.

### 3. Pemahaman Kalkulasi Keragaman Pangan (`calculateSummary`)
- **Kode:**
  ```kotlin
  val distinctGroupsCount = records.map { it.foodGroup }.distinct().size
  val isDiverse = distinctGroupsCount >= 3
  ```
- **Pemahaman Kami:** Kami menggunakan fungsi koleksi Kotlin `map` untuk mengambil daftar `FoodGroup` dari setiap catatan, lalu `distinct()` membuang duplikasi kelompok pangan yang sama (misalnya jika pengguna memasukkan 2 jenis makanan pokok). Jika jumlah kelompok unik minimal 3, sistem memberikan predikat edukatif **"Cukup Bervariasi"**.
