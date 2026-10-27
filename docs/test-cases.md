# Laporan Skenario Pengujian Aplikasi NutriTrack

**Nama Aplikasi:** NutriTrack - Edukasi Gizi Seimbang & Keragaman Pangan  
**Link Repository:** https://github.com/GerardoYoel324410007/nutritrack.git  
**Anggota Kelompok:**  
1. **Anggota 1:** Gerardo Yoel (NIM: 324410007) - Ketua / Developer UI & Logic  
2. **Anggota 2:** [Nama Anggota 2] (NIM: [NIM Anggota 2]) - Kolaborator / Logic & Docs  

---

## Tabel Skenario Pengujian (8 Test Cases)

| No | Skenario Pengujian | Input Data | Hasil yang Diharapkan | Hasil Aktual | Status |
|---|---|---|---|---|---|
| 1 | Validasi Nama Makanan Kosong | Nama Makanan: `""` (Kosong), Porsi: `"1"` | Pesan error: "Nama makanan tidak boleh kosong." | Pesan error "Nama makanan tidak boleh kosong." muncul di bawah form. | **PASS** |
| 2 | Validasi Jumlah Porsi Kosong | Nama Makanan: `"Nasi Puti"`, Porsi: `""` (Kosong) | Pesan error: "Jumlah porsi wajib diisi." | Pesan error "Jumlah porsi wajib diisi." muncul di bawah form. | **PASS** |
| 3 | Validasi Porsi Teks Non-Angka | Nama Makanan: `"Ayam Goreng"`, Porsi: `"dua"` | Pesan error: "Jumlah porsi harus berupa angka yang valid." | Pesan error "Jumlah porsi harus berupa angka yang valid." muncul, aplikasi tidak crash. | **PASS** |
| 4 | Validasi Porsi Di Luar Batas | Nama Makanan: `"Tahu"`, Porsi: `"15"` | Pesan error: "Jumlah porsi di luar batas wajar (maksimal 10 porsi)." | Pesan error "Jumlah porsi di luar batas wajar (maksimal 10 porsi)." muncul. | **PASS** |
| 5 | Penambahan Catatan Makanan Valid | Waktu: Sarapan, Nama: `"Nasi Goreng"`, Kelompok: Karbohidrat, Porsi: `"1.5"` | Data berhasil masuk ke daftar riwayat konsumsi, form ter-reset. | Item "Nasi Goreng" bertambah di riwayat, total catatan & porsi ter-update. | **PASS** |
| 6 | Kalkulasi Keragaman Pangan (< 3 Kelompok) | Catatan 1: Karbohidrat, Catatan 2: Lauk Hewani | Status: "Belum Bervariasi", Edukasi: mencakup 2 dari 5 kelompok pangan. | Card ringkasan berwarna oranye/tertiary, status "Belum Bervariasi" tampil. | **PASS** |
| 7 | Kalkulasi Keragaman Pangan (>= 3 Kelompok) | Catatan 1: Karbohidrat, Catatan 2: Lauk Hewani, Catatan 3: Sayur-sayuran | Status: "Cukup Bervariasi", Edukasi: konsumsi harian mencakup 3 kelompok. | Card ringkasan berubah warna hijau/secondary, status "Cukup Bervariasi" tampil. | **PASS** |
| 8 | Reset Form Input | Klik tombol "Reset" saat form terisi sebagian | Seluruh field form kembali ke nilai bawaan (default) dan error hilang. | Field nama, porsi, catatan terosongkan, error terhapus. | **PASS** |

---

## Catatan Tambahan Pengujian
Semua skenario pengujian telah dijalankan pada emulator Android Studio (API 35/37) dan terbukti 100% lulus (PASS) tanpa ada masalah keandalan maupun crash.
