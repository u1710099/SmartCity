package com.idigital.epam.energy.hmac;

import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

@Component
public class HMACUtil {

    public static void main(String[] args) {
        long now = new Date().getTime() + 86400;
        System.out.println(now);
        String s = HMACUtil.calculateHASH2("ENERGY", String.valueOf(now), "get_resident", "energyKey");
        System.out.println(s);
    }


    public static String calculateHASH2(String keyId, String timestamp, String action, String secretKey) {
        String data = "keyId="+keyId+";timestamp="+timestamp+";action="+action;  //keyId=HOTEL;timestamp=12345465;action=get_citizen_info
        try {
            SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(data.getBytes());
            return new String(Base64.getEncoder().encode(rawHmac));
        } catch (GeneralSecurityException e) {
            throw new IllegalArgumentException();
        }



//
//        public String calculateHash(String keyId, String timestamp, String action,String secretKey) {
//        String data = "keyId=" + keyId + ";timestamp=" + timestamp + ";action=" + action;
//
//        SecretKeySpec signInKey = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
//        Mac mac = null;
//        try {
//            mac = Mac.getInstance("HmacSHA256");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        try {
//            mac.init(signInKey);
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        }
//        byte[] rawHmac = mac.doFinal(data.getBytes());
//        return new String(Base64.getEncoder().encode(rawHmac));

    }





}






//    public static void main(String[] args) {
//        long now = new Date().getTime() + 86400;
//        System.out.println(now);
//        String s = HMACUtil.calculateHASH2("MEDICINE", String.valueOf(now), "get_clinic_info", "medicineKey");
//        System.out.println(s);
//    }
//
//    public static String calculateHASH2(String keyId, String timestamp, String action, String secretKey) {
//        String data = "keyId="+keyId+";timestamp="+timestamp+";action="+action;  //keyId=HOTEL;timestamp=12345465;action=get_citizen_info
//        try {
//            SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
//            Mac mac = Mac.getInstance("HmacSHA256");
//            mac.init(signingKey);
//            byte[] rawHmac = mac.doFinal(data.getBytes());
//            return new String(Base64.getEncoder().encode(rawHmac));
//        } catch (GeneralSecurityException e) {
//            throw new IllegalArgumentException();
//        }
//    }
//}
