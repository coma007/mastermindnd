package com.ftn.sbnz.model.events;

import com.ftn.sbnz.model.models.enums.Theme;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.util.Date;

@Role(Role.Type.EVENT)
@Timestamp("timestamp")
public class ThemeQuery {
    private Long id;
    private String themeName;
    private Theme baseTheme;
    private Date timestamp;

    public ThemeQuery() {
    }

    public ThemeQuery(Long id, String themeName, Theme baseTheme, Date timestamp) {
        this.id = id;
        this.themeName = themeName;
        this.baseTheme = baseTheme;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public Theme getBaseTheme() {
        return baseTheme;
    }

    public void setBaseTheme(Theme baseTheme) {
        this.baseTheme = baseTheme;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
