# Fast Shield (Fabric, Minecraft 1.21.11)

Shields start blocking after 3 ticks instead of 5. Everything else about the shield
(damage reduction, sounds, cooldown) stays vanilla.

All files sit in one folder (no src/ needed). Build with GitHub Actions
(.github/workflows/main.yml) and use the jar from the artifact.

Install: put the jar and Fabric API in `mods/`. It must be on the server AND your
client (or just your client in singleplayer).
