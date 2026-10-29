import { ArrowUpRight, CalendarDays, MapPin, Users } from 'lucide-react';
import type { CemEvent } from '../types';

const accents = ['event-purple', 'event-blue', 'event-orange', 'event-green'];

export default function EventCard({ event, index, onRegister }: { event: CemEvent; index: number; onRegister: (event: CemEvent) => void }) {
  const date = new Date(event.startsAt);
  const available = Math.max(0, event.capacity - event.registeredCount);
  return (
    <article className="event-card">
      <div className={`event-art ${accents[index % accents.length]}`}>
        <span className="event-category">{event.category}</span>
        <div className="event-art-shape shape-one" />
        <div className="event-art-shape shape-two" />
        <div className="event-art-copy">{event.category.toUpperCase()}</div>
        <span className="event-art-arrow"><ArrowUpRight size={17} /></span>
      </div>
      <div className="event-card-body">
        <h3>{event.title}</h3>
        <p className="event-description">{event.description}</p>
        <div className="event-meta"><CalendarDays size={15} /><span>{date.toLocaleDateString(undefined, { month: 'short', day: 'numeric', year: 'numeric' })}</span></div>
        <div className="event-meta"><MapPin size={15} /><span>{event.venue}</span></div>
        <div className="event-card-footer">
          <span className="seat-count"><Users size={14} /> {available} seats left</span>
          <button className="small-action" type="button" onClick={() => onRegister(event)} title="Register for this event">Register <ArrowUpRight size={14} /></button>
        </div>
      </div>
    </article>
  );
}
