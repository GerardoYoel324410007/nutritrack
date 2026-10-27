# Panduan Presentasi & Defense UTS (PRESENTATION.md)

**Nama Proyek:** NutriTrack - Aplikasi Edukasi Gizi Seimbang & Keragaman Pangan  
**Link Repository:** https://github.com/GerardoYoel324410007/nutritrack.git  

---

## ⏱️ Alur Demo Presentasi (Durasi: 3 - 5 Menit)

### Menit 0:00 - 0:45 | Pembukaan & Latar Belakang
- **Salam & Pengenalan:** Sebutkan nama anggota kelompok, NIM, dan judul aplikasi **NutriTrack**.
- **Latar Belakang Singkat:** NutriTrack dibuat untuk mengedukasi masyarakat mengenai pentingnya **keragaman pangan harian** (bukan sekadar menghitung kalori klinis). Aplikasi membantu pengguna memantau konsumsi dari 5 kelompok pangan utama.

### Menit 0:45 - 2:00 | Demo Fitur Aplikasi
1. **Tampilan Awal (Empty State):** Tunjukkan bahwa saat aplikasi pertama kali dibuka, Card Ringkasan menampilkan status *"Belum Bervariasi"* (0/5 kelompok pangan) dan riwayat menampilkan pesan *"Belum Ada Catatan Makanan"*.
2. **Pengujian Validasi (Handling Error):**
   - KOSONGKAN nama makanan lalu klik **Tambah** -> Tunjukkan pesan error *"Nama makanan tidak boleh kosong."*
   - ISI nama makanan, tetapi ISI porsi dengan teks huruf `"dua"` -> Tunjukkan pesan error *"Jumlah porsi harus berupa angka yang valid."* (Tekankan bahwa aplikasi **tidak crash**).
3. **Pencatatan Makanan Bervariasi:**
   - Input Catatan 1: *Nasi Putih* (Kelompok: Makanan Pokok / Karbohidrat) -> Porsi `1`.
   - Input Catatan 2: *Ayam Goreng* (Kelompok: Lauk Hewani) -> Porsi `1`.
   - *Tunjukkan:* Jumlah kelompok pangan baru 2/5, status masih *"Belum Bervariasi"*.
   - Input Catatan 3: *Sayur Bayam* (Kelompok: Sayur-sayuran) -> Porsi `1`.
   - *Tunjukkan:* Status langsung berubah otomatis menjadi **"Cukup Bervariasi"** dengan indikator visual warna hijau dan pesan edukatif apresiasi.

### Menit 2:00 - 3:30 | Penjelasan Arsitektur & Kode
- Jelaskan pembagian berkas: `FoodRecord.kt` (data model & enum), `NutriTrackLogic.kt` (logika bisnis murni tanpa dependensi UI), dan `NutriTrackScreen.kt` (UI Jetpack Compose).
- Jelaskan penggunaan `toDoubleOrNull()` untuk keamanan input dan `mutableStateListOf` untuk reaksi UI instan.

### Menit 3:30 - 4:00 | Penutup
- Sampaikan kesimpulan bahwa aplikasi NutriTrack telah memenuhi seluruh kriteria teknis, bebas crash, dan siap diuji lebih lanjut.

---

## ❓ Tabel Tanya-Jawab (Q&A Defense UTS)

Berikut adalah daftar pertanyaan yang berpotensi diajukan oleh dosen penguji beserta jawaban teknis yang siap Anda sampaikan:

| No | Potensi Pertanyaan Penguji | Jawaban Teknis / Penjelasan |
|---|---|---|
| 1 | *Mengapa logika bisnis dipisahkan ke dalam object `NutriTrackLogic`?* | Kami menerapkan prinsip **Separation of Concerns (SoC)**. Dengan memisahkan `NutriTrackLogic`, logika validasi dan perhitungan keragaman pangan dapat diuji secara terisolasi (Unit Test) tanpa perlu memuat komponen UI Android atau Jetpack Compose. |
| 2 | *Bagaimana cara aplikasi mencegah crash jika porsi diisi huruf atau simbol?* | Kami tidak langsung menggunakan `String.toDouble()`, melainkan `trim().replace(",", ".").toDoubleOrNull()`. Jika pengubahan ke angka gagal, method akan mengembalikan `null`, dan fungsi validasi mengembalikan pesan kesalahan yang ramah pengguna. |
| 3 | *Apa perbedaan `mutableStateListOf` dengan `ArrayList` biasa di Compose?* | `ArrayList` biasa tidak memiliki mekanisme pemberitahuan (notification trigger) ke Compose runtime. `mutableStateListOf` secara otomatis memicu proses **re-composition** pada UI (seperti `LazyColumn` dan `SummaryCard`) setiap kali ada penambahan, penghapusan, atau perubahan data. |
| 4 | *Bagaimana aplikasi menentukan bahwa makanan harian pengguna "Cukup Bervariasi"?* | Aplikasi menggunakan fungsi `records.map { it.foodGroup }.distinct().size` untuk menghitung kelompok pangan unik yang dikonsumsi. Sesuai indikator edukatif gizi seimbang, jika pengguna mengonsumsi **minimal 3 kelompok pangan berbeda** dalam sehari, status berubah menjadi "Cukup Bervariasi". |
| 5 | *Mengapa menggunakan `FlowRow` untuk pilihan Waktu Makan & Kelompok Pangan?* | `FlowRow` dari `androidx.compose.foundation.layout` secara otomatis mengatur komponen `FilterChip` agar berpindah ke baris baru secara adaptif jika lebar layar HP tidak cukup, sehingga tampilan tetap rapi di berbagai ukuran layar. |
