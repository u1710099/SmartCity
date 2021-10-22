package com.idigital.epam.energy.repository;

import com.idigital.epam.energy.entity.EnergyMeter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyMeterRepository extends JpaRepository<EnergyMeter, Long> {
}
