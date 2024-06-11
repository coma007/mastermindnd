import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import CampaignCard from './CampaignCard';
import '../style/CampaignPage.css'
import { ApiService } from '../api/ApiService';


const campaigns = [
    {
        name: 'The Dragon’s Hoard',
        theme: 'Fantasy',
        gameplayStyle: 'Exploration',
        numberOfPlayers: 4,
        duration: '5 hours',
        difficulty: 'Hard',
        description: 'Embark on a daring adventure to find the legendary dragon’s hoard. Explore ancient ruins, fight fearsome monsters, and uncover hidden secrets.',
    },
    {
        name: 'Mystery of the Lost City',
        theme: 'Mystery',
        gameplayStyle: 'Puzzle',
        numberOfPlayers: 3,
        duration: '4 hours',
        difficulty: 'Medium',
        description: 'Solve the mystery of a lost city that has reappeared after centuries. Decipher cryptic clues, outwit cunning traps, and discover the city’s dark past.',
    },
    {
        name: 'Curse of the Phantom Isle',
        theme: 'Horror',
        gameplayStyle: 'Survival',
        numberOfPlayers: 5,
        duration: '6 hours',
        difficulty: 'Hard',
        description: 'Survive the night on a haunted island cursed by vengeful spirits. Face your worst fears, uncover the curse’s origin, and find a way to lift it.',
    },
    {
        name: 'The Wizard’s Tower',
        theme: 'Magic',
        gameplayStyle: 'Dungeon Crawl',
        numberOfPlayers: 4,
        duration: '3 hours',
        difficulty: 'Easy',
        description: 'Delve into the magical tower of a reclusive wizard. Navigate through enchanted traps, solve magical puzzles, and discover powerful artifacts.',
    },
    {
        name: 'Siege of Castle Blackwood',
        theme: 'Medieval',
        gameplayStyle: 'Strategy',
        numberOfPlayers: 6,
        duration: '5 hours',
        difficulty: 'Medium',
        description: 'Defend Castle Blackwood from a relentless siege. Plan your defenses, manage resources, and lead your troops to victory against overwhelming odds.',
    },
    {
        name: 'Quest for the Silver Chalice',
        theme: 'Adventure',
        gameplayStyle: 'Roleplay',
        numberOfPlayers: 4,
        duration: '4 hours',
        difficulty: 'Medium',
        description: 'Embark on a quest to retrieve the fabled Silver Chalice. Forge alliances, make tough decisions, and journey through treacherous lands to complete your mission.',
    },
    {
        name: 'The Enchanted Forest',
        theme: 'Fantasy',
        gameplayStyle: 'Exploration',
        numberOfPlayers: 3,
        duration: '3 hours',
        difficulty: 'Easy',
        description: 'Explore the mysterious Enchanted Forest filled with magical creatures and hidden dangers. Uncover its secrets and find your way out before it’s too late.',
    },
];


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