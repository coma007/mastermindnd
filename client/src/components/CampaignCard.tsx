import React from 'react';
import { FaClock, FaUsers } from 'react-icons/fa';
import '../style/CampaignCard.css';

const CampaignCard = (props: { campaign: any }) => {
    return (
        <div className="card">
            <h2>{props.campaign.name}</h2>
            <p className="campaign-info">
                {props.campaign.theme} &middot; {props.campaign.gameplayStyle} &middot; {props.campaign.difficulty}
            </p>
            <p className='campaign-description'>{props.campaign.description}</p>
            <div className="campaign-details">
                <p className="campaign-detail">
                    <FaClock /> {props.campaign.duration}
                </p>
                <p className="campaign-detail">
                    <FaUsers /> {props.campaign.numberOfPlayers}
                </p>
            </div>
        </div>
    );
}

export default CampaignCard;
