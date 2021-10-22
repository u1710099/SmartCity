package com.idigital.epam.energy.entity;

import javax.persistence.*;

enum BuildingType{
    BUSINEES,
    HOUSING,
    GOVERNMENT
}
@Entity
@Table(name ="home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Integer HomeCode;

    @ManyToOne
    private User user;

    public String BuildingType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHomeCode() {
        return HomeCode;
    }

    public void setHomeCode(Integer homeCode) {
        HomeCode = homeCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBuildingType() {
        return BuildingType;
    }

    public void setBuildingType(String buildingType) {
        BuildingType = buildingType;
    }
}
