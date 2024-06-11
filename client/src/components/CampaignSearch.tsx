import React, { useState } from 'react';
import '../style/CampaignSearch.css'; // Assuming you have a CSS file for styling the form


interface FormData {
    themes: string[];
    level: string[];
    gameplayStyle: string[];
    characterClass: string[];
    characterRace: string[];
    duration: string[];
    partySize: string[];
}

const CampaignSearch = () => {
    const [formData, setFormData] = useState<FormData>({
        themes: [],
        level: [],
        gameplayStyle: [],
        characterClass: [],
        characterRace: [],
        duration: [],
        partySize: []
    });

    const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value, type, checked } = event.target;
        if (type === 'checkbox' && checked) {
            setFormData(prevState => ({
                ...prevState,
                [name]: [...prevState[name as keyof FormData], value]
            }));
        } else if (type === 'checkbox' && !checked) {
            setFormData(prevState => ({
                ...prevState,
                [name]: prevState[name as keyof FormData].filter(item => item !== value)
            }));
        } else {
            setFormData(prevState => ({
                ...prevState,
                [name]: [value]
            }));
        }
        console.log(formData)
    };

    const handleSubmit = (event: any) => {
        event.preventDefault();
        // Construct the request payload
        const payload = {
            themes: formData.themes,
            level: formData.level,
            gameplayStyle: formData.gameplayStyle,
            characterClass: formData.characterClass,
            characterRace: formData.characterRace,
            duration: formData.duration,
            partySize: formData.partySize
        };

        // Example: Send request using fetch API
    };

    return (
        <div className="search-page">
            <h1>
                Search for Campaigns<span>...</span>
            </h1>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <p className='main-label'>Themes:</p>
                    <div className="checkbox-group">
                        {["Fantasy", "Horror", "Adventure", "Mystery", "War", "Political Intrigue", "Survival", "High Seas", "Urban", "Historical"].map(theme => (
                            <label key={theme}>
                                <input type="checkbox" name="theme" value={theme.toUpperCase().replace(' ', '_')}
                                    onChange={handleInputChange} />
                                {theme}
                            </label>
                        ))}
                    </div>
                </div>
                <div className="form-row">
                    <div className="form-group">
                        <p className='main-label'>Level:</p>
                        <div className="radio-group">
                            {["Easy", "Medium", "Hard"].map(level => (
                                <label key={level}>
                                    <input type="radio" name="level" value={level.toUpperCase()} onChange={handleInputChange} />
                                    {level}
                                </label>
                            ))}
                        </div>
                    </div>
                    <div className="form-group">
                        <p className='main-label'>Gameplay Style:</p>
                        <div className="radio-group">
                            {["Combat", "Role Playing", "Puzzle", "Sandbox"].map(style => (
                                <label key={style}>
                                    <input type="radio" name="gameplayStyle" value={style.toUpperCase().replace(/ /g, '_')} onChange={handleInputChange} />
                                    {style}
                                </label>
                            ))}
                        </div>
                    </div>
                </div>
                <div className="form-row">

                    <div className="form-group">
                        <p className='main-label'>Character Class:</p>
                        <div className="checkbox-group">
                            {["Barbarian", "Wizard", "Paladin", "Bard", "Cleric", "Sorcerer", "Druid", "Ranger", "Fighter", "Rogue", "Warlock", "Monk"].map(characterClass => (
                                <label key={characterClass}>
                                    <input type="checkbox" name="characterClass" value={characterClass.toUpperCase()} onChange={handleInputChange} />
                                    {characterClass}
                                </label>
                            ))}
                        </div>
                    </div>
                    <div className="form-group">
                        <p className='main-label'>Character Race:</p>
                        <div className="checkbox-group">
                            {["Human", "Elf", "Dwarf", "Halfling", "Half-Orc", "Gnome", "Tiefling", "Dragonborn"].map(characterRace => (
                                <label key={characterRace}>
                                    <input type="checkbox" name="characterRace" value={characterRace.toUpperCase()} onChange={handleInputChange} />
                                    {characterRace}
                                </label>
                            ))}
                        </div>
                    </div>
                </div>
                <div className="form-row">
                    <div className="form-group">
                        <p className='main-label'>Estimated Duration:</p>
                        <div className="radio-group">
                            {["Short", "Medium", "Long"].map(duration => (
                                <label key={duration}>
                                    <input type="radio" name="duration" value={duration.toUpperCase()} onChange={handleInputChange} />
                                    {duration}
                                </label>
                            ))}
                        </div>
                    </div>
                    <div className="form-group">
                        <p className='main-label'>Party Size:</p>
                        <input type="number" name="partySize" min="1" max="20" onChange={handleInputChange} />
                    </div>
                </div>
                <button type="submit" className="button">Search</button>
            </form>
        </div>
    );
}

export default CampaignSearch;
