    export const Login = () => {
        
        return (
            <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-indigo-50 to-white px-2">
                <div className="bg-white p-8 rounded-2xl shadow-2xl w-full max-w-sm">
                    <h2 className="text-3xl font-bold mb-8 text-center text-gray-800">Login</h2>
                    <form className="space-y-6">
                        <div>
                            <label htmlFor="username" className="block text-sm font-semibold text-gray-700 mb-1">Username</label>
                            <input type="text" id="username" required className="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-400 focus:border-indigo-400 transition" autoComplete="username" />
                        </div>
                        <div>
                            <label htmlFor="password" className="block text-sm font-semibold text-gray-700 mb-1">Password</label>
                            <input type="password" id="password" required className="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-400 focus:border-indigo-400 transition" autoComplete="current-password" />
                        </div>
                        <button type="submit" className="w-full flex justify-center py-2 px-4 border border-transparent rounded-lg shadow font-semibold text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 transition">
                            Login
                        </button>
                    </form>
                </div>
            </div>
        )
    }

    export default Login