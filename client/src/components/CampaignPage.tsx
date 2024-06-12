import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import CampaignCard from './CampaignCard';
import '../style/CampaignPage.css'
import { ApiService } from '../api/ApiService';

const CampaignsPage = () => {
    const location = useLocation();
    const type = new URLSearchParams(location.search).get('type');
    const [campaigns, setCampaigns] = useState([]);

    useEffect(() => {
        const fetchCampaigns = async () => {
            const campaignsData = await ApiService.getCampaigns(type!);
            setCampaigns(campaignsData);
        };

        fetchCampaigns();
    }, [type]);

    return (
        <div className="recommended-campaigns">
            <h1>Recommended Campaigns</h1>
            <div className="campaigns-grid">
                {campaigns.map((campaign, index) => (
                    <CampaignCard key={index} campaign={campaign} />
                ))}
            </div>
        </div>
    );
}

export default CampaignsPage;