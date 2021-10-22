package com.idigital.epam.energy.service;

import com.idigital.epam.energy.entity.Home;

public interface HomeService extends CommonService<Home>{
    public Home create() throws Exception;
}
