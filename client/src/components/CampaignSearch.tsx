import React from 'react';
import '../style/CampaignSearch.css'; // Assuming you have a CSS file for styling the form

const CampaignSearch = () => {
    return (
        <div className="search-form">
            <h1>
                Search for Campaigns<span>...</span>
            </h1>
            <form>
                <div className="form-group">
                    <label htmlFor="theme">Theme:</label>
                    <select id="theme" name="theme">
                        <option value="fantasy">Fantasy</option>
                        <option value="horror">Horror</option>
                        <option value="survival">Survival</option>
                        <option value="adventure">Adventure</option>
                        <option value="mystery">Mystery</option>
                        <option value="war">War</option>
                        <option value="political">Political Intrigue</option>
                        <option value="high-seas">High Seas</option>
                        <option value="urban">Urban</option>
                        <option value="historical">Historical</option>
                    </select>
                </div>
                <div className="form-group">
                    <label htmlFor="gameplay-style">Gameplay Style:</label>
                    <select id="gameplay-style" name="gameplay-style">
                        <option value="combat-focused">Combat Focused</option>
                        <option value="role-playing">Role Playing</option>
                        <option value="puzzle-solving">Puzzle Solving</option>
                        <option value="sandbox-exploration">Sandbox Exploration</option>
                    </select>
                </div>
                <div className="form-group">
                    <label htmlFor="duration">Duration:</label>
                    <select id="duration" name="duration">
                        <option value="one-shot">One Shot</option>
                        <option value="short">Short</option>
                        <option value="medium">Medium</option>
                        <option value="long">Long</option>
                    </select>
                </div>
                <div className="form-group">
                    <label htmlFor="difficulty">Difficulty:</label>
                    <select id="difficulty" name="difficulty">
                        <option value="easy">Easy</option>
                        <option value="medium">Medium</option>
                        <option value="hard">Hard</option>
                    </select>
                </div>
                <button type="submit" className="button">Search</button>
            </form>
        </div>
    );
}

export default CampaignSearch;
