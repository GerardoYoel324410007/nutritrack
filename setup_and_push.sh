#!/bin/bash

echo "=================================================="
echo "   NutriTrack - Git Setup & Automation Script"
echo "=================================================="

# 1. Pastikan folder docs/screenshots ada
mkdir -p docs/screenshots

# 2. Atur Remote Origin ke GitHub
echo "[1/4] Mengatur Remote Git Origin..."
git remote remove origin 2>/dev/null
git remote add origin https://github.com/GerardoYoel324410007/nutritrack.git
git branch -M main

# 3. Add & Commit berkas proyek
echo "[2/4] Menyiapkan commit berkas proyek..."
git add .
git commit -m "chore: complete NutriTrack project setup and documentation"

# 4. Push ke GitHub
echo "[3/4] Melakukan Push ke GitHub..."
git push -u origin main

echo "=================================================="
echo "   SUCCESS! Proyek NutriTrack Berhasil Di-push!"
echo "   Repository: https://github.com/GerardoYoel324410007/nutritrack.git"
echo "=================================================="
