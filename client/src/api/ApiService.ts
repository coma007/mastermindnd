import { GET_CAMPAIGNS_URL, LOGIN_URL } from ".";
import { Credentials } from "./ApiTypes";
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

}