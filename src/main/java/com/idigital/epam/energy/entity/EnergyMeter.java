package com.idigital.epam.energy.entity;

import lombok.Data;

import javax.persistence.*;

enum Building{
    RESIDENTIAL,
    INSTITUTIONAL
}

@Entity
@Table
public class EnergyMeter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    private Home home;

    private Integer EnergyConsuption;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Integer getEnergyConsuption() {
        return EnergyConsuption;
    }

    public void setEnergyConsuption(Integer energyConsuption) {
        EnergyConsuption = energyConsuption;
    }
}
