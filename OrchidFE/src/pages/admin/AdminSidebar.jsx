import React from 'react';
import { NavLink } from 'react-router-dom';
import { ChartBarIcon, ShoppingBagIcon, UsersIcon, TagIcon, CogIcon } from '@heroicons/react/24/outline';

const navigation = [
    { name: 'Overview', href: '/admin/overview', icon: ChartBarIcon },
    { name: 'Manage Orders', href: '/admin/orders', icon: ShoppingBagIcon },
    { name: 'Manage Orchids', href: '/admin/orchids', icon: CogIcon },
    { name: 'Manage Accounts', href: '/admin/accounts', icon: UsersIcon },
    { name: 'Manage Categories', href: '/admin/categories', icon: TagIcon },
];

export default function AdminSidebar() {
    return (
        <aside className="w-64 flex-shrink-0 bg-white border-r border-gray-200">
            <div className="h-full flex flex-col p-4">
                <div className="text-2xl font-bold text-indigo-600 mb-8 p-2">
                    🌸 Admin Panel
                </div>
                <nav className="flex-1 space-y-2">
                    {navigation.map((item) => (
                        <NavLink
                            key={item.name}
                            to={item.href}
                            className={({ isActive }) =>
                                `flex items-center px-3 py-2 text-sm font-medium rounded-lg transition-colors duration-200 ${
                                isActive ? 'bg-indigo-500 text-white shadow' : 'text-gray-600 hover:bg-gray-100 hover:text-gray-900'
                                }`
                            }
                        >
                            <item.icon className="h-6 w-6 mr-3" />
                            {item.name}
                        </NavLink>
                    ))}
                </nav>
            </div>
        </aside>
    );
}