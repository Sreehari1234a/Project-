# Campus Event Manager (CEM) — Role-based Local MVP

A responsive campus event management platform built as a KTU second-year Java OOP project. The React + TypeScript frontend talks to a Java 17 + Spring Boot REST API. H2 is the default local database; a PostgreSQL profile is included for hosting preparation.

## The three portals

### 1. Student
- Create a student account and sign in.
- Browse only events approved by Principal/Faculty.
- Register for an event, with server-side duplicate and capacity checks.
- View registration history and cancel an active registration.

### 2. Organizer
- Create an organizer account and sign in.
- Submit a future-dated event with category, venue, capacity, and description.
- See their own submissions and whether each is pending, approved, or rejected.
- New submissions are not visible to students until approved.

### 3. Principal / Faculty reviewer
- Sign in with the seeded principal/admin account or a faculty account created by the campus administrator.
- Review pending submissions, approve/publish or reject them.
- Browse the full event history and export attendee lists as CSV.
- Faculty reviewers can review events; only the campus administrator can create faculty accounts.

## Run locally on Mac

Prerequisites: JDK 17+, Maven 3.9+, Node.js, and npm. Open the extracted `cem-web-platform` root folder in VS Code.

**Terminal 1 — backend**

```bash
cd backend
mvn spring-boot:run
```

Backend: `http://localhost:8080`

- Health check: `http://localhost:8080/api/health`
- Public approved event list: `http://localhost:8080/api/events`

**Terminal 2 — frontend**

```bash
cd frontend
npm install
npm run dev
```

Open the Vite URL, normally `http://localhost:5173`. Keep both terminals running.

## Local demo Principal / administrator login

- Portal: **Principal / Faculty**
- Email: `principal@cem.local`
- Password: `ChangeMe!2026`

On first backend startup, the application creates this account if it does not already exist. Use the administrator portal to create faculty reviewer accounts. Students and organizers can register their own accounts from the login page.

**These are development-only credentials. Change `CEM_ADMIN_EMAIL` and `CEM_ADMIN_PASSWORD` before hosting.** If you have already run the app against a persistent PostgreSQL database, changing these environment variables does not change an already-created account's password; update the account through a proper account-management flow before deployment.

## Database

By default, H2 is in-memory and resets when the backend stops. To use the included local PostgreSQL service, ensure Docker is installed, then:

```bash
docker compose up -d postgres
cd backend
SPRING_PROFILES_ACTIVE=postgres mvn spring-boot:run
```

The example Docker credentials are for local development only. Change them before sharing the database. PostgreSQL data is stored in a Docker volume.

## API security in this MVP

- Student and organizer signup is available; reviewer signup is not public.
- Passwords are stored as PBKDF2-HMAC-SHA256 hashes with random salts.
- Login creates a random bearer session token that expires after seven days.
- Event creation is restricted to organizer accounts.
- Approval, rejection, attendee export, and faculty account creation are role-restricted on the backend.
- Student registration and cancellation are tied to the signed-in student's account, not a user-supplied email address.

Before a real public launch, also add email verification, password reset, login rate limiting, audit trails, security monitoring, stronger account recovery, managed PostgreSQL, production secrets, HTTPS, backups, and an automated end-to-end test suite. Do not use real student data until those deployment controls are completed and reviewed. The default local administrator credentials must never be used in a public deployment.

## Hosting configuration (next phase after local test)

Frontend `.env` example:

```env
VITE_API_BASE_URL=https://YOUR-BACKEND-DOMAIN/api
```

Backend environment variables to configure on the hosting provider:

```env
SPRING_PROFILES_ACTIVE=postgres
CEM_ADMIN_EMAIL=your-private-admin-email
CEM_ADMIN_PASSWORD=a-long-unique-password
CEM_DATABASE_URL=jdbc:postgresql://YOUR-DB-HOST:5432/YOUR-DB-NAME
CEM_DATABASE_USERNAME=YOUR-DB-USER
CEM_DATABASE_PASSWORD=YOUR-DB-PASSWORD
CEM_CORS_ALLOWED_ORIGINS=https://YOUR-FRONTEND-DOMAIN
```

Use the exact deployed frontend origin in `CEM_CORS_ALLOWED_ORIGINS`. Never commit `.env` files, production credentials, or secrets to GitHub.

## Suggested local acceptance test

1. Sign in to Principal/Faculty using the local demo account.
2. Create a faculty reviewer account from the administrator portal, then sign out.
3. Create an organizer account and submit an event scheduled in the future.
4. Sign in as Principal/Faculty and approve the event.
5. Sign in as a student and verify the event appears, register, then cancel the registration.
6. Check that capacity updates and duplicate registrations are rejected.
7. Sign in as organizer and verify the event's status.
8. Sign in as reviewer and export the attendee CSV.
9. Restart the backend and verify the behavior expected for the selected database (H2 resets; PostgreSQL persists).

## KTU OOP viva map

The `backend/src/main/java/com/cem/learning/oop/` package demonstrates an abstract parent class, inheritance (`extends`), an interface, overriding, overloading, polymorphism, and custom exceptions. Application code also separates controllers, services, repositories, entities, and DTOs to demonstrate separation of responsibilities.
