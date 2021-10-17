package com.idigital.epam.energy.dao;

import com.idigital.epam.energy.entity.ExternalApiCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExternalApiRepository extends JpaRepository<ExternalApiCredentials,Long> {

    ExternalApiCredentials findByKeyId(String keyId);
}




