# CEM Hosting Guide (Vercel + Render + Neon)

This project is configured for a simple student/demo deployment. It is not production-hardened.

## 1. Push source to GitHub
Create a new GitHub repository and upload the contents of this `cem-web-platform` folder (the folder contents, not the outer ZIP wrapper). Keep it private if preferred.

## 2. Create a PostgreSQL database on Neon
Create a project at https://console.neon.tech and copy its connection details. Keep the password private. For the backend environment variable `CEM_DATABASE_URL`, use the JDBC form:
`jdbc:postgresql://HOST/DBNAME?sslmode=require`
Set `CEM_DATABASE_USERNAME` and `CEM_DATABASE_PASSWORD` from Neon as well.

## 3. Deploy backend on Render
Create a Web Service from the GitHub repository. Choose Docker runtime and set Root Directory to `backend` (so Render finds `backend/Dockerfile` as `Dockerfile`). Add these environment variables:
- `SPRING_PROFILES_ACTIVE` = `postgres`
- `CEM_DATABASE_URL` = `jdbc:postgresql://YOUR_NEON_HOST/YOUR_DB?sslmode=require`
- `CEM_DATABASE_USERNAME` = your Neon database username
- `CEM_DATABASE_PASSWORD` = your Neon database password
- `CEM_ADMIN_EMAIL` = your chosen principal/admin email
- `CEM_ADMIN_PASSWORD` = a unique strong password
- `CEM_CORS_ALLOWED_ORIGINS` = temporary `http://localhost:5173` until frontend deployment; replace with the exact Vercel origin after deploying the frontend

Deploy and copy the Render service URL, e.g. `https://your-service.onrender.com`.

## 4. Deploy frontend on Vercel
Import the same GitHub repository into https://vercel.com. Set Root Directory to `frontend`. Set environment variable:
- `VITE_API_BASE_URL` = `https://YOUR-RENDER-SERVICE.onrender.com/api`
Deploy and copy the Vercel URL, e.g. `https://your-project.vercel.app`.

## 5. Finish CORS
In Render, change `CEM_CORS_ALLOWED_ORIGINS` to the exact Vercel origin (scheme + host only; no path), e.g. `https://your-project.vercel.app`, then redeploy/restart the backend.

## 6. Test all roles
1. Sign in as the configured principal/admin.
2. Create an organizer account and submit an event with a future date.
3. Approve the event as Principal/Faculty.
4. Create a student account, register, cancel, and test attendee CSV export.

## Important
- Never commit passwords, API keys, or database credentials to GitHub.
- The default demo admin credentials must not be used for public hosting.
- Free services may sleep, have quotas, or change terms; check current provider limits.
- Before public use, add email verification, password reset, rate limiting, audit logs, backups, monitoring, and security testing.
