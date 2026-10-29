import type { CemEvent, CreateEventInput } from '../types';
const API_BASE = import.meta.env.VITE_API_BASE_URL ?? 'http://localhost:8080/api';
export type CemRole = 'STUDENT' | 'ORGANIZER' | 'FACULTY' | 'ADMIN';
export type CemUser = { token: string; fullName: string; email: string; role: CemRole };
export type Registration = { id: number; eventId: number; studentName: string; email: string; studentId: string; status: 'REGISTERED' | 'CANCELLED'; registeredAt: string };
let activeToken = '';
export function setAuthToken(token: string) { activeToken = token; }
async function request<T>(path: string, options: RequestInit = {}, authenticated = true): Promise<T> {
  const headers = new Headers(options.headers);
  if (options.body && !headers.has('Content-Type')) headers.set('Content-Type', 'application/json');
  if (authenticated && activeToken) headers.set('Authorization', `Bearer ${activeToken}`);
  const response = await fetch(`${API_BASE}${path}`, { ...options, headers });
  if (!response.ok) { const body = await response.json().catch(() => null); throw new Error(body?.message ?? `Request failed (${response.status}).`); }
  if (response.status === 204) return undefined as T;
  return response.json() as Promise<T>;
}
export function login(email: string, password: string) { return request<CemUser>('/auth/login', {method:'POST',body:JSON.stringify({email,password})}, false); }
export function registerAccount(fullName:string,email:string,password:string,role:'STUDENT'|'ORGANIZER') { return request<CemUser>('/auth/register',{method:'POST',body:JSON.stringify({fullName,email,password,role})},false); }
export function logout() { return request<{message:string}>('/auth/logout',{method:'POST'}); }
export function createFaculty(fullName:string,email:string,temporaryPassword:string) { return request<{id:number;fullName:string;email:string;role:string}>('/auth/faculty',{method:'POST',body:JSON.stringify({fullName,email,temporaryPassword})}); }
export async function getEvents():Promise<CemEvent[]> { return request('/events',{},false); }
export function createEvent(input:CreateEventInput):Promise<CemEvent> { return request('/events',{method:'POST',body:JSON.stringify(input)}); }
export function getOrganizerEvents():Promise<CemEvent[]> { return request('/events/mine'); }
export function getMyRegistrations():Promise<Registration[]> { return request('/registrations'); }
export function registerForEvent(eventId:number,studentId:string):Promise<Registration> { return request(`/events/${eventId}/registrations`,{method:'POST',body:JSON.stringify({studentId})}); }
export function cancelRegistration(id:number):Promise<void> { return request(`/registrations/${id}`,{method:'DELETE'}); }
export function getPendingEvents():Promise<CemEvent[]> { return request('/admin/events/pending'); }
export function getAllAdminEvents():Promise<CemEvent[]> { return request('/admin/events/all'); }
export function reviewEvent(id:number,decision:'approve'|'reject'):Promise<CemEvent> { return request(`/admin/events/${id}/${decision}`,{method:'POST'}); }
export function getEventRegistrations(eventId:number):Promise<Registration[]> { return request(`/admin/events/${eventId}/registrations`); }
