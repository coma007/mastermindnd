import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../style/LoginPage.css';
import axios from 'axios';

const LoginPage = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleLogin = async (e: any) => {
        e.preventDefault();
        console.log('Username:', username);
        console.log('Password:', password);

        try {
            const response = await axios.post('http://localhost:8000/api/users/login', {
                username,
                password,
            });

            console.log(response.data); // Handle the response data as needed
        } catch (error) {
            console.error('There was an error logging in!', error);
        }

        navigate('/campaigns');
    };

    return (
        <div className="login-page">
            <form onSubmit={handleLogin}>
                <div className="form-group">
                    <h1>Welcome to Mastermin<span>dnd</span></h1>
                    <label htmlFor="username">Username:</label>
                    <input
                        type="text"
                        id="username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password:</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                <button type="submit" className="button">Login</button>
            </form>
        </div>
    );
}

export default LoginPage;
