import React, { useState } from "react";
import "./Welcome.css";
const Login = () => {
  const [formData, setformData] = useState({
    email: "",
    password: "",
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    alert("success!");
    //TODO: add validation
  };

  const handleInputChange = (e) => {
    console.log(e.target.value);
    setformData({ ...formData, [e.target.name]: e.target.value });
  };

  return (
    <form onSubmit={handleSubmit} className="auth-form">
      <h2>Login</h2>

      <label>Email</label>
      <input
        type="email"
        name="email"
        value={formData.email}
        onChange={handleInputChange}
        required
      />

      <label>Password</label>
      <input
        type="password"
        name="password"
        value={formData.password}
        onChange={handleInputChange}
        required
      />
      <button type="submit">Sign Up</button>
    </form>
  );
};

export default Login;
