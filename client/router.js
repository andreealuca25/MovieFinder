import React from "react";
import { createBrowserRouter } from "react-router-dom";
import App from "./src/App";
import Login from "./components/welcome/Login";
import SignUp from "./components/welcome/SignUp";
import Welcome from "./components/welcome/Welcome";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      { index: true, element: <Welcome /> },
      { path: "login", element: <Login /> },
      { path: "signup", element: <SignUp /> },
      { path: "about", element: <div>About</div> },
    ],
  },
]);

export default router;
