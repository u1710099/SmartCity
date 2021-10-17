package com.idigital.epam.energy.service;

import org.springframework.stereotype.Component;

@Component
public class ExternalApiService {
    ExternalApiCredentials findByKeyId(String keyId);
}
