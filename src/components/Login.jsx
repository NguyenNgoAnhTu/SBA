import React from 'react'

 export  const Login = () => {
    return (
        <div className="container py-5">
            <div className="row">
                <div className="col-12 col-md-6 offset-md-3">
                    <h2 className="text-center mb-4">Login</h2>
                    <form>
                        <div className="mb-3">
                            <label htmlFor="username" className="form-label">Username</label>
                            <input type="text" className="form-control" id="username" required />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="password" className="form-label">Password</label>
                            <input type="password" className="form-control" id="password" required />
                        </div>
                        <button type="submit" className="btn btn-primary w-100">Login</button>
                    </form>
                </div>
            </div>
        </div>
    )

}

export default Login