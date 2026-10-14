# SkyTrace3

Source dari zip SkyTrace + **system bubble** + **DNS ad block**.

## Fitur ekstra

1. **System bubble** — floating overlay saat capture ON (cek support: supported / needs_permission / unsupported)
2. **DNS ad block** — domain iklan/tracker dijawab NXDOMAIN saat VPN aktif (`adBlockEnabled`, default ON)

## Struktur

File project di **root** (bukan folder `skytrace-main/`).

## Full source

Pakai zip lengkap project, atau merge modul di `android/app/src/main/kotlin/com/skytrace/` dari repo ini ke clone upstream.

```bash
bash scripts/bootstrap.sh
flutter pub get
flutter run
```

Version: **1.3.0+4**
