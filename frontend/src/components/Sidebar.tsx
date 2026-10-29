import { CalendarDays, ChartNoAxesCombined, Compass, LayoutDashboard, Settings, ShieldCheck, Users } from 'lucide-react';

type SidebarProps = {
  activeView: string;
  onNavigate: (label: string) => void;
};

const nav = [
  { icon: LayoutDashboard, label: 'Overview' },
  { icon: Compass, label: 'Discover events' },
  { icon: CalendarDays, label: 'My registrations' },
  { icon: ChartNoAxesCombined, label: 'Analytics' },
  { icon: Users, label: 'People' }
];

export default function Sidebar({ activeView, onNavigate }: SidebarProps) {
  return (
    <aside className="sidebar">
      <div className="brand">
        <div className="brand-mark">C</div>
        <div><strong>campus<span>+</span></strong><small>EVENT MANAGER</small></div>
      </div>
      <div className="workspace-label">WORKSPACE</div>
      <nav className="nav-list" aria-label="Main navigation">
        {nav.map(({ icon: Icon, label }) => (
          <button
            className={`nav-item ${activeView === label ? 'active' : ''}`}
            key={label}
            type="button"
            aria-current={activeView === label ? 'page' : undefined}
            onClick={() => onNavigate(label)}
          >
            <Icon size={18} strokeWidth={1.8} /><span>{label}</span>
            {label === 'Discover events' && <span className="nav-dot" />}
          </button>
        ))}
      </nav>
      <div className="sidebar-bottom">
        <div className="help-card">
          <div className="help-icon"><ShieldCheck size={18} /></div>
          <strong>Your campus, connected.</strong>
          <p>One place for every idea, event, and community.</p>
        </div>
        <button className={`nav-item ${activeView === 'Settings' ? 'active' : ''}`} type="button" onClick={() => onNavigate('Settings')} aria-current={activeView === 'Settings' ? 'page' : undefined}>
          <Settings size={18} /><span>Settings</span>
        </button>
        <div className="user-mini">
          <div className="avatar">C</div>
          <div className="user-mini-text"><strong>Campus Workspace</strong><small>Event workspace</small></div>
          <span className="online-dot" />
        </div>
      </div>
    </aside>
  );
}
