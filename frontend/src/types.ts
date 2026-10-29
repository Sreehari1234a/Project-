export type CemEvent = {
  id: number; title: string; category: string; venue: string; startsAt: string;
  capacity: number; registeredCount: number; description: string;
  status: 'PENDING_APPROVAL' | 'APPROVED' | 'REJECTED'; organizerName?: string; organizerEmail?: string;
};
export type CreateEventInput = Pick<CemEvent,'title'|'category'|'venue'|'startsAt'|'capacity'|'description'>;
