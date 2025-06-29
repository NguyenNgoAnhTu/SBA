import "bootstrap/dist/css/bootstrap.min.css";
import { Routes, Route } from "react-router-dom";
import ListOfOrchids from "./components/ListOfOrchids";
import EditOrchid from "./components/EditOrchid";
import HomeScreen from "./components/HomeScreen";
import NavBar from "./components/NavBar";
import ListOfEmployees from "./components/ListOfEmployees";
import DetailOrchid from "./components/DetailOrchid";
import Login from "./components/Login";
import Register from "./components/Register";
import Account from "./components/Account";
import CartPage from "./components/CartPage";
import OrderConfirmationPage from "./components/OrderConfirmationPage";
import OrderHistoryPage from "./components/OrderHistoryPage";
import OrderDetailsPage from "./components/OrderDetailPage";
import AdminRoute from "./components/AdminRoute";
import AdminLayout from "./pages/admin/AdminLayout";
import DashboardOverview from "./pages/admin/DashboardOverview";
import ManageOrders from "./pages/admin/ManageOrder";
import ProtectedRoute from "./components/ProtectedRoute";

function App() {
  return (
    <>
      <NavBar />
      <Routes>
        {/* Public Routes */}
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/home" element={<HomeScreen />} />
        <Route path="/" element={<HomeScreen />} />

        {/* Protected User Routes */}
        <Route element={<ProtectedRoute />}>
          <Route path="/detail/:id" element={<DetailOrchid />} />
          <Route path="/cart" element={<CartPage />} />
          <Route path="/order-history" element={<OrderHistoryPage />} />
          <Route path="/orders/:orderId" element={<OrderDetailsPage />} />
          <Route path="/order-confirmation/:orderId" element={<OrderConfirmationPage />} />
        </Route>

        {/* Admin Routes */}
        <Route element={<AdminRoute />}>
          <Route path="/admin" element={<AdminLayout />}>
            <Route path="overview" element={<DashboardOverview />} />
            <Route path="orders" element={<ManageOrders />} />
            {/* Add more admin child routes here if needed */}
          </Route>
        </Route>
      </Routes>
    </>
  );
}

export default App;
