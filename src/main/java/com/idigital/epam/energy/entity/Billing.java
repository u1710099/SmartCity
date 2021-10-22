package com.idigital.epam.energy.entity;


import javax.persistence.*;

enum paymentStatus{
    PAID,
    UNPAID,
    OVERDUE
}


@Entity
@Table
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer previousReading;
    private Integer currentReading;
    private Integer amountEnergyConsumption;
    private Integer Sum;

    @ManyToOne
    private EnergyMeter energyMeter;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPreviousReading() {
        return previousReading;
    }

    public void setPreviousReading(Integer previousReading) {
        this.previousReading = previousReading;
    }

    public Integer getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(Integer currentReading) {
        this.currentReading = currentReading;
    }

    public Integer getAmountEnergyConsumption() {
        return amountEnergyConsumption;
    }

    public void setAmountEnergyConsumption(Integer amountEnergyConsumption) {
        this.amountEnergyConsumption = amountEnergyConsumption;
    }

    public Integer getSum() {
        return Sum;
    }

    public void setSum(Integer sum) {
        Sum = sum;
    }

    public EnergyMeter getEnergyMeter() {
        return energyMeter;
    }

    public void setEnergyMeter(EnergyMeter energyMeter) {
        this.energyMeter = energyMeter;
    }
}
