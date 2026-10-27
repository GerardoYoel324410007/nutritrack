@echo off
echo ==================================================
echo    NutriTrack - Git Setup ^& Automation Script
echo ==================================================

REM 1. Membuat folder screenshots jika belum ada
if not exist "docs\screenshots" mkdir "docs\screenshots"

REM 2. Mengatur Git Remote
echo [1/4] Mengatur Remote Git Origin...
git remote remove origin 2>nul
git remote add origin https://github.com/GerardoYoel324410007/nutritrack.git
git branch -M main

REM 3. Staging & Commit
echo [2/4] Menyiapkan commit berkas proyek...
git add .
git commit -m "chore: complete NutriTrack project setup and documentation"

REM 4. Push ke GitHub
echo [3/4] Melakukan Push ke GitHub...
git push -u origin main

echo ==================================================
echo    SUCCESS! Proyek NutriTrack Berhasil Di-push!
echo    Repository: https://github.com/GerardoYoel324410007/nutritrack.git
echo ==================================================
pause
