# NutriTrack - Edukasi Gizi Seimbang & Keragaman Pangan

**Repository GitHub:** [https://github.com/GerardoYoel324410007/nutritrack.git](https://github.com/GerardoYoel324410007/nutritrack.git)

NutriTrack adalah aplikasi mobile berbasis Android yang dikembangkan menggunakan **Jetpack Compose** dan **Material Design 3**. Aplikasi ini dirancang untuk membimbing pengguna dalam mencatat konsumsi harian serta mengevaluasi keragaman pangan harian berdasarkan 5 kelompok pangan utama (Makanan Pokok/Karbohidrat, Lauk Hewani, Lauk Nabati, Sayur-sayuran, dan Buah-buahan).

---

## 👥 Informasi Anggota Kelompok

- **Anggota 1 (Ketua):** Gerardo Yoel (NIM: 324410007) - Username GitHub: `@GerardoYoel324410007`
- **Anggota 2 (Kolaborator):** [Nama Anggota 2] (NIM: [NIM Anggota 2]) - Username GitHub: `@[username-anggota2]`

---

## 📱 Fitur Utama Aplikasi

1. **Pencatatan Makanan Harian (Form Input):**
   - Pemilihan waktu makan (Sarapan, Makan Siang, Makan Malam, Camilan).
   - Input nama makanan (wajib).
   - Pemilihan kelompok pangan (5 pilihan kelompok pangan utama).
   - Input porsi sederhana (pilihan numerik dengan penanganan koma/titik).
   - Catatan tambahan opsional.

2. **Validasi Input Aman & Anti-Crash:**
   - Memastikan nama makanan dan jumlah porsi diisi.
   - Menggunakan `toDoubleOrNull()` untuk mencegah aplikasi *crash* jika pengguna memasukkan karakter non-numerik (seperti huruf/teks).
   - Menghindari porsi bernilai <= 0 atau > 10 porsi.

3. **Ringkasan Gizi & Indikator Keragaman Pangan:**
   - Menghitung total catatan makanan hari ini.
   - Menghitung jumlah kelompok pangan unik yang telah dikonsumsi.
   - Menghitung total porsi harian.
   - Mengubah status indikator secara otomatis:
     - **"Belum Bervariasi"** jika kurang dari 3 kelompok pangan.
     - **"Cukup Bervariasi"** jika telah mencakup minimal 3 kelompok pangan berbeda.

4. **Daftar Riwayat Konsumsi (`LazyColumn`):**
   - Menampilkan riwayat pencatatan dengan visual kartu Material 3.
   - Penanganan *Empty State* yang informatif saat riwayat masih kosong.

5. **Banner Etika & Batas Keselamatan:**
   - Menampilkan pesan edukatif bahwa indikator bersifat refleksi diri dan edukatif, bukan diagnosis klinis.

---

## 🛠️ Teknologi yang Digunakan

- **Bahasa Pemrograman:** Kotlin
- **UI Framework:** Jetpack Compose (Material Design 3)
- **Minimum SDK:** API 24 (Android 7.0 Nougat)
- **Target SDK / Compile SDK:** API 35 / API 37
- **Architecture:** State Management (`remember`, `mutableStateOf`, `mutableStateListOf`) & Clean Business Logic Object (`NutriTrackLogic`)

---

## 📸 Tangkapan Layar Aplikasi (Screenshots)

Berikut adalah tangkapan layar tampilan aplikasi NutriTrack:

| Tampilan Awal (Empty State) | Validasi Form (Pesan Error) | Ada Data & Ringkasan Gizi |
| :---: | :---: | :---: |
| ![Empty State](docs/screenshots/01-empty-state.png) | ![Validasi Error](docs/screenshots/02-validasi.png) | ![Ada Data](docs/screenshots/03-ada-data.png) |

*(Catatan: Tangkapan layar disimpan di folder `docs/screenshots/`)*

---

## 📄 Dokumen Pendukung Lainnya

- [Dokumen Pengujian (Test Cases)](docs/test-cases.md)
- [Dokumen Kontribusi Kelompok (CONTRIBUTIONS.md)](CONTRIBUTIONS.md)
- [Dokumen Penggunaan AI (AI_USAGE.md)](AI_USAGE.md)
- [Dokumen Panduan Presentasi (PRESENTATION.md)](PRESENTATION.md)

---

## 🚀 Petunjuk Menjalankan Proyek

1. Clone repository ini:
   ```bash
   git clone https://github.com/GerardoYoel324410007/nutritrack.git
   ```
2. Buka proyek di **Android Studio Ladybug (2024.2+)** atau versi terbaru.
3. Tunggu proses **Gradle Sync** selesai.
4. Hubungkan emulator Android (API 24+) atau perangkat fisik dengan USB Debugging.
5. Klik tombol **Run 'app' (▶)**.
