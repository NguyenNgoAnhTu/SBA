import React, { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import apiService from '../api/apiService';
import toast from 'react-hot-toast';

export default function OrderDetailsPage() {
    const [order, setOrder] = useState(null);
    const [loading, setLoading] = useState(true);
    const { orderId } = useParams(); // Lấy orderId từ URL

    useEffect(() => {
        const fetchOrderDetails = async () => {
            if (!orderId) return;
            try {
                // Chỉ cần gọi API lấy chi tiết của một đơn hàng
                const response = await apiService.get(`/api/v1/orders/${orderId}`);
                setOrder(response.data);
            } catch (error) {
                toast.error("Could not fetch order details.");
                console.error("Error fetching order details:", error);
            } finally {
                setLoading(false);
            }
        };
        fetchOrderDetails();
    }, [orderId]);

    const formatPrice = (price) => new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(price || 0);
    const formatDate = (dateString) => new Date(dateString).toLocaleString('en-GB');

    if (loading) {
        return <div className="text-center p-10 text-xl font-medium">Loading Order Details...</div>;
    }

    if (!order) {
        return <div className="text-center p-10 text-xl font-medium">Order not found.</div>;
    }

    return (
        <div className="min-h-screen bg-gray-50 p-4 sm:p-8">
            <div className="max-w-4xl mx-auto">
                <nav className="text-sm mb-6" aria-label="Breadcrumb">
                    <ol className="list-reset flex text-gray-500">
                        <li><Link to="/home" className="hover:text-indigo-600 font-medium">Home</Link></li>
                        <li><span className="mx-2">/</span></li>
                        <li><Link to="/order-history" className="hover:text-indigo-600 font-medium">Order History</Link></li>
                        <li><span className="mx-2">/</span></li>
                        <li className="text-gray-800 font-semibold">Order #{order.orderId}</li>
                    </ol>
                </nav>

                <div className="bg-white p-8 rounded-2xl shadow-xl">
                    <div className="flex flex-col sm:flex-row justify-between items-start border-b pb-6 mb-6">
                        <div>
                            <h1 className="font-bold text-3xl text-gray-800">Order #{order.orderId}</h1>
                            <p className="text-sm text-gray-500 mt-1">Placed on: {formatDate(order.orderDate)}</p>
                        </div>
                        <span className={`px-4 py-2 text-sm font-semibold rounded-full ${
                            order.orderStatus === 'COMPLETED' ? 'bg-green-100 text-green-800' :
                            order.orderStatus === 'CANCELLED' ? 'bg-red-100 text-red-800' :
                            'bg-yellow-100 text-yellow-800'
                        }`}>
                            {order.orderStatus}
                        </span>
                    </div>

                    <h2 className="text-xl font-bold mb-4">Items Ordered</h2>
                    <div className="space-y-4 mb-6">
                        {order.orderDetails.map(detail => (
                            <div key={detail.orchidId} className="flex items-center gap-4 p-4 bg-gray-50 rounded-lg">
                                <img src={detail.orchidImageUrl} alt={detail.orchidName} className="w-20 h-20 rounded-lg object-cover"/>
                                <div className="flex-grow">
                                    <p className="font-semibold text-lg">{detail.orchidName}</p>
                                    <p className="text-sm text-gray-600">Quantity: {detail.quantity}</p>
                                </div>
                                <div className="text-right">
                                    <p className="font-semibold">{formatPrice(detail.price)}</p>
                                    <p className="text-sm text-gray-500">Subtotal: {formatPrice(detail.price * detail.quantity)}</p>
                                </div>
                            </div>
                        ))}
                    </div>

                    <div className="grid grid-cols-1 md:grid-cols-2 gap-6 border-t pt-6 mb-6">
                         <div>
                            <h3 className="font-bold text-lg mb-2">Shipping Address</h3>
                            <p className="text-gray-600">{order.shippingAddress}</p>
                        </div>
                        <div>
                            <h3 className="font-bold text-lg mb-2">Customer</h3>
                            <p className="text-gray-600">{order.customerName}</p>
                        </div>
                        {order.note && (
                            <div className="md:col-span-2">
                                <h3 className="font-bold text-lg mb-2">Order Note</h3>
                                <p className="text-gray-600 bg-yellow-50 p-3 rounded-lg">{order.note}</p>
                            </div>
                        )}
                    </div>

                    <div className="text-right font-bold text-2xl mt-6 border-t pt-6">
                        Total Amount: <span className="text-indigo-600">{formatPrice(order.totalAmount)}</span>
                    </div>
                </div>
            </div>
        </div>
    );
}