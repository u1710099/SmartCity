package com.idigital.epam.energy.service.hmac;

import com.idigital.epam.energy.dao.ExternalApiRepository;
import com.idigital.epam.energy.entity.ExternalApiCredentials;
import com.idigital.epam.energy.service.hmac.ExternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternalApiServiceImpl extends ExternalApiService {

    @Autowired
    private ExternalApiRepository externalApiRepository;

    @Override
    public ExternalApiCredentials findByKeyId(String keyId) {
        return externalApiRepository.findByKeyId(keyId);
    }
}

