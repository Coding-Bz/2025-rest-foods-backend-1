## Datenbank starten (Docker)

Führe diesen Befehl aus in der CLI in Docker Desktop (falls noch nicht gemacht), bevor du das Projekt startest:

```bash
docker run -d -p 5432:5432 \
  -e POSTGRES_PASSWORD=gruppe1 \
  -e POSTGRES_DB=RestFood \
  --name RestFood \
  postgres
```
## Alternative: Datenbank mit Docker Compose starten

Anstatt den PostgreSQL-Container manuell mit einem langen `docker run`-Befehl zu erstellen und danach jedesmal auf Docker-Desktop wechseln um den Docker zu starten, kannst du auch einfach `docker-compose` verwenden.  

### Über Docker-Compose starten

Im Terminal in IntelliJ folgenden Befehl eingeben:
```
docker-compose up -d
```

---
## Swagger-UI benutzen

Sobald das Projekt läuft, kann Swagger zur Dokumentation und zum Testen der API verwendet werden.

### Swagger aufrufen

Öffne im Browser:

http://localhost:8080/swagger-ui/index.html

Dort kannst du:

- Alle REST-Endpunkte sehen
- Requests direkt im Browser ausführen
- Antworten anzeigen lassen
