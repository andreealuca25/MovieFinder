import React from "react";
import "./App.css";
import { Outlet } from "react-router-dom";

const App = () => {
  return (
    <div>
      <h1 className="title">Movie Finder</h1>
      <Outlet />
    </div>
  );
};

export default App;
