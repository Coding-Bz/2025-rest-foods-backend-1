## Datenbank starten (Docker)

Führe diesen Befehl aus in der CLI in Docker Desktop (falls noch nicht gemacht), bevor du das Projekt startest:

```bash
docker run -d -p 5432:5432 \
  -e POSTGRES_PASSWORD=gruppe1 \
  -e POSTGRES_DB=RestFood \
  --name RestFood \
  postgres
