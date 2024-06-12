import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import CampaignCard from './CampaignCard';
import '../style/CampaignPage.css'
import { ApiService } from '../api/ApiService';

const CampaignsPage = () => {
    const location = useLocation();
    const type = new URLSearchParams(location.search).get('type');
    const [campaigns, setCampaigns] = useState<any[]>([]);

    useEffect(() => {
        if (type === "search") {
            const state = location.state as { campaigns: any[] };
            if (state && state.campaigns) {
                setCampaigns(state.campaigns);
            }
        } else {
            const fetchCampaigns = async () => {
                const campaignsData = await ApiService.getCampaigns(type!);
                setCampaigns(campaignsData);
            };

            fetchCampaigns();
        }
    }, [type]);

    return (
        <div className="recommended-campaigns">
            {type == "recommended" ? 
            (<h1>Recommended Campaigns</h1>) : null
            }
            {type == "preference" ? 
            (<h1>Liked Campaigns</h1>) : null
            }
            {type == "history" ? 
            (<h1>Played Campaigns</h1>) : null
            }
            {type == "wishlist" ? 
            (<h1>Saved Campaigns</h1>) : null
            }
            <div className="campaigns-grid">
                {campaigns.map((campaign, index) => (
                    <CampaignCard key={index} campaign={campaign} />
                ))}
            </div>
        </div>
    );
}

export default CampaignsPage;