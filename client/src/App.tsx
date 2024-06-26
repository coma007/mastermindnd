import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Menu from './components/Menu';
import CampaignPage from './components/CampaignPage';
import LoginPage from './components/LoginPage';
import CampaignSearch from './components/CampaignSearch';
import ThemeSearch from './components/ThemeSearch';

const App = () => {

  return (
    <Router>
      <Menu />
      <Routes>
        <Route path="/" element={<CampaignPage />} />
        <Route index path="/login" element={<LoginPage />} />
        <Route index path="/search" element={<CampaignSearch />} />
        <Route index path="/theme-search" element={<ThemeSearch />} />
        <Route path="/campaigns" element={<CampaignPage />} />
      </Routes>
    </Router>
  );
}

export default App;
