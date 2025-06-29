import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import apiService from '../api/apiService';
import toast from 'react-hot-toast';

export default function OrderHistoryPage() {
    const [orders, setOrders] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchOrderHistory = async () => {
            try {
                const response = await apiService.get('/api/v1/orders/my-orders');
                setOrders(response.data);
            } catch (error) {
                toast.error("Could not fetch order history.");
                console.error("Error fetching order history:", error);
            } finally {
                setLoading(false);
            }
        };
        fetchOrderHistory();
    }, []);

    const formatPrice = (price) => new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(price || 0);
    const formatDate = (dateString) => new Date(dateString).toLocaleDateString('en-GB');

    if (loading) {
        return <div className="text-center p-10">Loading your order history...</div>;
    }

        return (
        <div className="min-h-screen bg-gray-50 p-4 sm:p-8">
            <div className="max-w-5xl mx-auto">
                <h1 className="text-4xl font-bold text-gray-900 mb-8">My Order History</h1>
                {orders.length > 0 ? (
                    <div className="space-y-6">
                        {orders.map(order => (
                            // Bọc toàn bộ thẻ div của đơn hàng trong một component Link
                            <Link key={order.orderId} to={`/orders/${order.orderId}`} className="block bg-white p-6 rounded-2xl shadow-lg hover:shadow-xl hover:border-indigo-500 border border-transparent transition-all duration-300">
                                <div className="flex justify-between items-start">
                                    <div>
                                        <h2 className="font-bold text-xl text-gray-800">Order #{order.orderId}</h2>
                                        <p className="text-sm text-gray-500">Placed on: {formatDate(order.orderDate)}</p>
                                    </div>
                                    <span className={`px-3 py-1 text-sm font-semibold rounded-full ...`}>
                                        {order.orderStatus}
                                    </span>
                                </div>
                                <div className="text-right font-bold text-xl mt-4 border-t pt-4">
                                    Total: <span className="text-indigo-600">{formatPrice(order.totalAmount)}</span>
                                </div>
                                <div className="text-right text-sm text-indigo-600 font-semibold mt-2">View Details &rarr;</div>
                            </Link>
                        ))}
                    </div>

                ) : (
                    <p className="text-center text-gray-500">You have no past orders.</p>
                )}
            </div>
        </div>
    );
}