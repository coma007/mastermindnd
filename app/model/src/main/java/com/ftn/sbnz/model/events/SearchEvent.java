package com.ftn.sbnz.model.events;


import com.ftn.sbnz.model.models.SearchData;
import org.kie.api.definition.type.Role;

import java.util.List;

@Role(Role.Type.EVENT)
public class SearchEvent {
    private SearchData searchData;

    public SearchEvent(SearchData searchDataList) {
        this.searchData = searchDataList;
    }

    public SearchData getSearchData() {
        return searchData;
    }
}
