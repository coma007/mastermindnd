import { GET_CAMPAIGNS_URL, LOGIN_URL, MARK_CAMPAIGN_URL, SEARCH_CAMPAIGNS_BY_THEME_URL, SEARCH_CAMPAIGNS_URL } from ".";
import { Credentials, SearchByTheme, SearchData } from "./ApiTypes";
import axios from "axios";

export const ApiService = {

  login: async (credentials: Credentials): Promise<any> => {
    const response = await axios.post(LOGIN_URL(), credentials, {
      headers: {
        'Content-Type': 'application/json'
      },
      withCredentials: true
    });
    return response.data;
  },


  markCampaign: async (campaignId: number, type: string): Promise<any> => {
    const response = await axios.put(MARK_CAMPAIGN_URL(type) + "?campaignId=" + campaignId + "&userId=" + localStorage.getItem("id"), {
      headers: {
        'Content-Type': 'application/json'
      },
      withCredentials: true
    });
    return response.data;
  },

  getCampaigns: async (type: string): Promise<any> => {
    const response = await axios.get(GET_CAMPAIGNS_URL() + "?type=" + type + "&userId=" + localStorage.getItem("id"), {
      headers: {
        'Content-Type': 'application/json'
      },
      withCredentials: true
    });
    return response.data;
  },

  searchCampaigns: async (search: SearchData): Promise<any> => {
    const response = await axios.post(SEARCH_CAMPAIGNS_URL() + "?userId=" + localStorage.getItem("id"), search, {
      headers: {
        'Content-Type': 'application/json'
      },
      withCredentials: true
    });
    return response.data;
  },

  searchCampaignsByTheme: async (search: SearchByTheme): Promise<any> => {
    const response = await axios.get(SEARCH_CAMPAIGNS_BY_THEME_URL() + "?theme=" + search.theme);
    return response.data;
  },

}