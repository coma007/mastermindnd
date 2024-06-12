const API_URL = "http://localhost:8000/api/";

export const LOGIN_URL = () => API_URL + "users/login";
export const GET_CAMPAIGNS_URL = () => API_URL + "users/campaigns";
export const SEARCH_CAMPAIGNS_URL = () => API_URL + "users/search";
export const SEARCH_CAMPAIGNS_BY_THEME_URL = () => API_URL + "campaign/themeSearch";