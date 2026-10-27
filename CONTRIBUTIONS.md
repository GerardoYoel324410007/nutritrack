# Dokumen Kontribusi Kelompok (CONTRIBUTIONS.md)

**Nama Proyek:** NutriTrack - Aplikasi Edukasi Gizi Seimbang & Keragaman Pangan  
**Link Repository:** https://github.com/GerardoYoel324410007/nutritrack.git  

---

## 👥 Anggota Kelompok

1. **Anggota 1 (Ketua):** Gerardo Yoel (NIM: 324410007) - Username GitHub: `@GerardoYoel324410007`
2. **Anggota 2 (Kolaborator):** [Nama Anggota 2] (NIM: [NIM Anggota 2]) - Username GitHub: `@[username-anggota2]`

---

## 📋 Pembagian Tugas & Tanggung Jawab

| Komponen / Fitur | Penanggung Jawab | Deskripsi Kontribusi |
|---|---|---|
| Inisialisasi Proyek & Gradle | Anggota 1 | Menyiapkan proyek Android Studio Compose, mengonfigurasi `build.gradle.kts` dan `libs.versions.toml`. |
| Desain Wireframe | Anggota 2 | Merancang alur UI dan gambar wireframe aplikasi (`docs/wireframe.png`). |
| Data Class `FoodRecord` & Enum | Anggota 2 | Membuat enum `MealTime`, `FoodGroup`, dan data class `FoodRecord`. |
| Logika Validasi (`NutriTrackLogic`) | Anggota 2 | Mengimplementasikan fungsi `validateInput` dan pencegahan crash input porsi non-angka. |
| Kalkulasi Keragaman Pangan | Anggota 2 | Mengimplementasikan logika perhitungan `calculateSummary` (syarat 3 kelompok pangan). |
| Kartu Ringkasan Gizi (`SummaryCard`) | Anggota 1 | Membuat komponen Compose `SummaryCard` dengan perubahan warna dinamik. |
| Form Input Makanan & Chip Selector | Anggota 1 | Membuat form input `OutlinedTextField`, `FilterChip` untuk waktu makan & kelompok pangan. |
| Kartu Riwayat Makanan (`FoodRecordItemCard`) | Anggota 1 | Merancang tampilan item catatan makanan menggunakan `AssistChip` dan `Card`. |
| State Management & Tombol Tambah | Anggota 2 | Mengelola `remember { mutableStateListOf<FoodRecord>() }` dan alur penambahan data. |
| Riwayat `LazyColumn` & Empty State | Anggota 1 | Mengimplementasikan daftar scrollable `LazyColumn` dan kondisi saat data masih kosong. |
| Pengujian & Test Cases | Anggota 1 | Menjalankan 8 skenario uji pada emulator, mengambil screenshot UI, dan mendokumentasikannya. |
| Dokumen `README.md` & `CONTRIBUTIONS.md` | Anggota 2 | Menyusun dokumen penjelasan proyek dan laporan kontribusi kelompok. |
| Dokumen `AI_USAGE.md` & `PRESENTATION.md` | Anggota 1 | Menyusun transparansi penggunaan AI dan persiapan materi presentasi defense. |

---

## 📊 Jadwal & Riwayat Commit (14 Commit)

| Hari | Kontributor | Pesan Commit | Modul / File Terkait |
|---|---|---|---|
| 1 | Anggota 1 | `chore: init NutriTrack project` | Proyek dasar Android Studio |
| 1 | Anggota 2 | `docs: add wireframe` | `docs/wireframe.png` |
| 2 | Anggota 2 | `feat: add CatatanMakan data class` | `FoodRecord.kt` |
| 2 | Anggota 2 | `feat: add input validation` | `NutriTrackLogic.kt` |
| 3 | Anggota 2 | `feat: add variety calculation` | `NutriTrackLogic.kt` |
| 3 | Anggota 1 | `feat: add summary card` | `NutriTrackScreen.kt` |
| 4 | Anggota 1 | `feat: add food form and dropdown` | `NutriTrackScreen.kt` |
| 4 | Anggota 1 | `feat: add food item card` | `NutriTrackScreen.kt` |
| 5 | Anggota 2 | `feat: add state and add button logic` | `NutriTrackScreen.kt` |
| 5 | Anggota 1 | `feat: add lazycolumn and empty state` | `NutriTrackScreen.kt` |
| 6 | Anggota 2 | `fix: handle non-numeric portion` | `NutriTrackLogic.kt` |
| 6 | Anggota 1 | `docs: add test cases and screenshots` | `docs/test-cases.md`, `docs/screenshots/` |
| 7 | Anggota 2 | `docs: add README and CONTRIBUTIONS` | `README.md`, `CONTRIBUTIONS.md` |
| 7 | Anggota 1 | `docs: add AI_USAGE and PRESENTATION` | `AI_USAGE.md`, `PRESENTATION.md` |
