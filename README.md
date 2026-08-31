# Utility Client

Mod utility/QoL untuk Minecraft 1.21.1 Fabric — bukan cheat kompetitif, semua fair untuk dipakai di server manapun (kecuali server tsb secara eksplisit melarang mod client apapun).

## Fitur
- **Fullbright** — bikin tempat gelap jadi terang
- **FPS Boost** — turunin render distance/particle/graphics buat FPS lebih stabil
- **Zoom** — tahan tombol C untuk zoom in
- **Sprint Lock** — auto sprint terus
- **Auto Walk** — auto jalan maju
- **Coordinates HUD** — nampilin posisi XYZ
- **FPS Display** — nampilin FPS
- **CPS Counter** — nampilin klik per detik
- **Keystrokes** — nampilin WASD yang lagi ditekan
- **Combat Info** — cooldown attack + HP mob/player yang dilihat

Buka menu dengan pause game (tombol **ESC** / Back di HP), lalu tap tombol **"Client"** di pojok kanan atas menu (sebelah tombol Resume/Disconnect).

## Build (lewat HP, tanpa PC)
1. Buat akun GitHub kalau belum punya.
2. Upload semua folder/file project ini ke repo GitHub baru (lewat app GitHub / browser, drag & drop, atau `git push` dari Termux).
3. Buka tab **Actions** di repo tsb → workflow "Build Mod" akan otomatis jalan tiap push ke branch `main` (atau klik "Run workflow" manual).
4. Tunggu sampai selesai (~3-5 menit), lalu buka hasil run itu → scroll ke bawah ke bagian **Artifacts** → download `utility-client-jar`. Isinya adalah file `.jar` mod-nya.

## Install di HP (Android)
1. Install launcher yang support Fabric di Android, misalnya **PojavLauncher**, **FCL (Fold Craft Launcher)**, atau **Zalith Launcher**.
2. Di launcher, install dulu **Minecraft 1.21.1**, lalu install **Fabric Loader 0.18.4** untuk versi itu (biasanya ada opsi "Install Fabric" di launcher).
3. Download juga **Fabric API** untuk 1.21.1 dari [Modrinth](https://modrinth.com/mod/fabric-api) (mod ini butuh Fabric API supaya jalan).
4. Pindahkan 2 file jar (Fabric API + jar mod hasil build kamu) ke folder:
   `.minecraft/mods/`
   (biasanya di `Android/data/<package launcher>/files/.minecraft/mods/` — pakai File Manager, aktifkan "show hidden files" kalau perlu)
5. Buka launcher, pilih profil **Fabric 1.21.1**, lalu Play.
6. Di dalam game, pause (ESC/Back) lalu tap tombol **"Client"** di menu pause buat buka Utility Client.

## Kalau build gagal
Buka log error di tab Actions — biasanya cuma soal versi dependency yang perlu disesuaikan sedikit (Yarn/Fabric API/Loom). Versi di `gradle.properties` sudah aku cek per Agustus 2026, tapi kalau ada update baru, cek versi terbaru di https://fabricmc.net/develop dan ganti angkanya di `gradle.properties`.
