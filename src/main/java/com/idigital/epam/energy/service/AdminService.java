package com.idigital.epam.energy.service;

import com.idigital.epam.energy.entity.Admin;
import com.idigital.epam.energy.exception.AdminException;

public interface AdminService {
	public Admin addAdmin(Admin admin) throws AdminException;
	public Admin getAdminById(Integer eid) throws AdminException;
	public Integer deleteAdmin(Integer id) throws AdminException;
	public Admin addAdminDetails(Admin admin,Integer id) throws AdminException;
	public Integer getAdminIdByEmail(String adminEmail) throws AdminException;
	public Admin updateAdminProfile(Admin admin) throws AdminException;
}
