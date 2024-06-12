import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import '../style/CampaignSearch.css'; // Assuming you have a CSS file for styling the form
import { SearchByTheme, SearchData } from '../api/ApiTypes';
import { ApiService } from '../api/ApiService';


const ThemeSearch = () => {

    const navigate = useNavigate();
    const [formData, setFormData] = useState<SearchByTheme>({
        theme: ""
    });

    const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value, type, checked } = event.target;

        setFormData(prevState => {
            return {
                ...prevState,
                [name]: value
            };
            
        });
    };

    useEffect(() => {
        console.log(formData);
    }, [formData])

    const handleSubmit = async (event: any) => {
        event.preventDefault();

        const payload = {
            theme: formData.theme,
        };

        let campaigns = await ApiService.searchCampaignsByTheme(payload);
        console.log(campaigns);
        navigate('/campaigns?type=search', {
            state: { campaigns }
        });
    };

    return (
        <div className="search-page">
            <h1>
                Search by Theme<span>...</span>
            </h1>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <p className='main-label'>Themes:</p>
                    <div className="checkbox-group">
                        {["Fantasy", "Horror", "Adventure", "Mystery", "War", "Political Intrigue", "Survival", "High Seas", "Urban", "Historical"].map(theme => (
                            <label key={theme}>
                                <input type="radio" name="theme" value={theme.toUpperCase().replace(' ', '_')}
                                    onChange={handleInputChange} />
                                {theme}
                            </label>
                        ))}
                    </div>
                </div>
                <button type="submit" className="button">Search</button>
            </form>
        </div>
    );
}

export default ThemeSearch;
