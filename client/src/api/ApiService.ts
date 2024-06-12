import { GET_CAMPAIGNS_URL, LOGIN_URL, SEARCH_CAMPAIGNS_URL } from ".";
import { Credentials, SearchData } from "./ApiTypes";
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


  getCampaigns: async (type: String): Promise<any> => {
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

}