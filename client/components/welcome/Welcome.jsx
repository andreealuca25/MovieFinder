import React from "react";
import "./Welcome.css";
import { Link } from "react-router-dom";
const Welcome = () => {
  return (
    <div className="welcome-description">
      <h2>🎬 Welcome to MovieFinder! 🍿 </h2>
      <p>Discover your next favorite film with us! </p>
      <p>
        🌟 New to MovieFinder? Sign up now to unlock a world of cinematic
        wonders!
      </p>
      <p>
        🔑 Already a member? Log in and continue your movie adventure! Let's
        make movie night unforgettable! 🎉
      </p>

      <div className="welcome-buttons">
        <Link to="signup" className="welcome-button">
          Sign Up
        </Link>
        <Link to="login" className="welcome-button">
          Log In
        </Link>
      </div>
    </div>
  );
};

export default Welcome;
