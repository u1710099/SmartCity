package com.idigital.epam.energy.service.Impl;
import javax.json.*;
import com.idigital.epam.energy.entity.Home;
import com.idigital.epam.energy.hmac.HMACUtils;
import com.idigital.epam.energy.repository.HomeRepository;
import com.idigital.epam.energy.service.HomeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    HomeRepository homeRepository;
    @Autowired
    private HMACUtils hmACUtils;



    @Override
    public List<Home> getAll() {
        return homeRepository.findAll();
    }

    @Override
    public Home getById(Long id) {
        return homeRepository.findById(id).get();
    }

    @Override
    public Home create(Home data) throws Exception {
        return null;
    }

    @Override
    public Home create() throws Exception{
        String json  = hmACUtils.getRequestWithHmac("ENERGY", "get_homes", "http://citymanagementfull-env.eba-tixcjyas.us-east-2.elasticbeanstalk.com/api/v1/request/homesWithOwner", "energyKey")
                .getBody().toString();
        JSONObject jsonObject = new JSONObject(json);
        JSONObject result = jsonObject.getJSONObject("result");

        JSONObject homes = result.getJSONObject("homes");
        String homeCode = homes.getString("homeCode");
        System.out.println(homeCode);
        return null;

    }

    @Override
    public Home update(Home data) throws Exception{


        if(data.getId() != null){
            return homeRepository.save(data);
        }
        throw new Exception("Id shouldn't be null");
    }

    @Override
    public void delete(Home data) {
        homeRepository.deleteById(data.getId());
    }
}
