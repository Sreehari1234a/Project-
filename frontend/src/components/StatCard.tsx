import type { LucideIcon } from 'lucide-react';

type Props = { label: string; value: string; detail: string; icon: LucideIcon; tone: string };
export default function StatCard({ label, value, detail, icon: Icon, tone }: Props) {
  return (
    <article className="stat-card">
      <div className={`stat-icon ${tone}`}><Icon size={19} /></div>
      <div className="stat-label">{label}</div>
      <div className="stat-value">{value}</div>
      <div className="stat-detail">{detail}</div>
    </article>
  );
}
