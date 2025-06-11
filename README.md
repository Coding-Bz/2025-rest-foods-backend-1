## Datenbank starten (Docker)

Führe diesen Befehl aus, bevor du das Projekt startest:

```bash
docker run -d -p 5432:5432 \
  -e POSTGRES_PASSWORD=gruppe1 \
  -e POSTGRES_DB=RestFood \
  --name RestFood \
  postgres
