package com.study.jpa.entity;
import	java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: 张远志
 * @Date: 2020/5/11 16:33
 */

@Entity
public class PersistentLogins {

    @Id
    private String series;

    private String username;

    private String password;

    private Date lastUsed;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }
}
