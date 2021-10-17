package com.idigital.epam.energy.hmac;
import com.idigital.epam.energy.entity.ExternalApiCredentials;
import com.idigital.epam.energy.service.hmac.ExternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class HMACAuthFilter {


    @Autowired
    private ExternalApiService externalApiService;

    @Autowired
    private HMACUtil HMACUtil;

    public boolean doFilter(ServletRequest servletRequest) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String keyId = request.getHeader("sm-keyid");
        String timestamp = request.getHeader("sm-timestamp");
        String action = request.getHeader("sm-action");
        String requestSignature = request.getHeader("sm-signature");
        ExternalApiCredentials externalApiCredentials = externalApiService.findByKeyId(keyId) ;


        String signature = HMACUtil.calculateHASH2(keyId,timestamp,action,externalApiCredentials.getValue());
        System.out.println("request:"+requestSignature+"**** calculated:"+signature);
        if (requestSignature.equals(signature)){
            return true;
        }
        else {
            return false;
        }
    }




}
