import React from 'react';
import { FaClock, FaHeart, FaPlay, FaSave, FaUsers } from 'react-icons/fa';
import '../style/CampaignCard.css';

const CampaignCard = (props: { campaign: any }) => {

    const handleIconClick = (action: string) => {
        console.log(`${action} clicked`);
    };

    return (
        <div className="card">
            <h2>{props.campaign.name}</h2>
            <p className="campaign-info">
                {props.campaign.theme} &middot; {props.campaign.gameplayStyle} &middot; {props.campaign.level}
            </p>
            <p className='campaign-description'>
                {props.campaign.summary.length > 500 ? `${props.campaign.summary.substring(0, 500)}...` : props.campaign.summary}
            </p>
            <div className="campaign-details">
                <p className="campaign-detail">
                    <FaClock /> {props.campaign.estimatedDuration} min
                </p>
                <div className="icon-container">
                    <FaHeart onClick={() => handleIconClick('like')} />
                    <FaPlay onClick={() => handleIconClick('play')} />
                    <FaSave onClick={() => handleIconClick('save')} />
                </div>
                <p className="campaign-detail">
                    <FaUsers /> {props.campaign.partySize}
                </p>
            </div>
        </div>
    );
}

export default CampaignCard;
