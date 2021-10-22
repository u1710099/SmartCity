package com.idigital.epam.energy.hmac;

public interface HMACUtilsService {


    /**
     * To create hashed signature
     * @param keyId Unique key between the two components
     * @param timestamp Long value of time, it must be 5 minutes ahead from now
     * @param action Short description of action(get_resident_info)
     * @param secretKey Secret key between the two components
     * @return Hash value
     */
    String calculateHASH(String keyId, String timestamp, String action, String secretKey);





}
