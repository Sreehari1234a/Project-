# Start CEM on your Mac

## 1. Open the project

Extract the ZIP and open the `cem-web-platform` folder in VS Code. The folder you open must contain both `backend` and `frontend`.

## 2. Start the Java backend

Open VS Code → Terminal → New Terminal, then run:

```bash
cd backend
mvn spring-boot:run
```

Wait for `Started CemApplication`. Leave this terminal running.

## 3. Start the React website

Open a second terminal (Terminal → New Terminal), then run:

```bash
cd frontend
npm install
npm run dev
```

Open the `Local` URL printed by Vite, normally `http://localhost:5173`.

## 4. Try the three portals

- **Principal / Faculty:** `principal@cem.local` / `ChangeMe!2026` (local demo only).
- **Organizer:** choose Organizer → Create account. Submit an event scheduled in the future.
- **Student:** choose Student → Create account. You will only see approved events; register and then cancel to test the full participation flow.

The principal/admin can create faculty reviewer accounts inside the reviewer portal. Faculty can approve/reject submissions and export attendee CSV files, but cannot create other reviewer accounts.

## 5. End-to-end test

1. Create an organizer account and submit a future event.
2. Sign out; sign in as Principal/Faculty and approve the event.
3. Sign out; create/sign in as a student and register for the event.
4. Cancel the registration and check the seat count.
5. Sign out; return as organizer to verify event status.
6. Return as reviewer and test attendee CSV export.

## Notes

- Keep both terminals running.
- H2 is the default local in-memory database and resets when the backend stops.
- Maven and npm dependencies must be downloaded on your Mac the first time.
- The project is a classroom MVP. Change the demo admin credentials and configure PostgreSQL, exact CORS origins, HTTPS, backups, and production secrets before public hosting.
