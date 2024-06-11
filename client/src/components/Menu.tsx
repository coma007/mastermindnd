import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import { FaHeart, FaHistory, FaHome, FaList, FaSearch, FaSignOutAlt } from 'react-icons/fa';
import '../style/Menu.css';

const Menu = () => {
    const location = useLocation();
    const hideMenu = location.pathname === '/login';

    if (hideMenu) {
        return null;
    }

    const handleLogout = (e: any) => {
        localStorage.removeItem('id');
    };

    return (
        <div className="menu">
            <Link to="/campaigns?type=recommended" className="logo-link">
                <img src='/logo.png' alt="Logo" className="logo" />
            </Link>
            <div className="menu-options">
                <Link to="/campaigns?type=recommended" className="menu-option"><FaHome /></Link>
                <Link to="/search" className="menu-option"><FaSearch /></Link>
                <Link to="/campaigns?type=preference" className="menu-option"><FaHeart /></Link>
                <Link to="/campaigns?type=history" className="menu-option"><FaHistory /></Link>
                <Link to="/campaigns?type=wishlist" className="menu-option"><FaList /></Link>
            </div>
            <div className='menu-options'>
                <Link to="/login" className="menu-option" onClick={handleLogout}><FaSignOutAlt /></Link>
            </div>
        </div>
    );
}

export default Menu;
