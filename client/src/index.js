import React from "react";
import ReactDOM from "react-dom/client";
import router from "../router";
import { RouterProvider } from "react-router-dom";

const container = document.getElementById("root");
const root = ReactDOM.createRoot(container);
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
