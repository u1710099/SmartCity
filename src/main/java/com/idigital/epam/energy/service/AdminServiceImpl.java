package com.idigital.epam.energy.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.idigital.epam.energy.dao.AdminDao;
import com.idigital.epam.energy.entity.Admin;
import com.idigital.epam.energy.exception.AdminException;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	@Override
	public Admin addAdmin(Admin admin)throws AdminException {
		try {
			Admin a1 = adminDao.save(admin);
			return a1;	
		}catch(DataAccessException dataAccessException) {
			throw new AdminException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new AdminException(exception.getMessage(),exception);
		}

	}

	@Override
	public Admin getAdminById(Integer id) throws AdminException {

		try {
			Optional<Admin> optional=adminDao.findById(id);
			if(optional.isPresent()) {
				System.out.println(optional.get());
				return optional.get();
			}else {
				return null;
			}
		}catch(DataAccessException dataAccessException) {
			throw new AdminException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new AdminException(exception.getMessage(),exception);
		}
	}


	@Override
	public Integer deleteAdmin(Integer id) throws AdminException {
		try {
			adminDao.deleteById(id);
			return 1;
		}catch(DataAccessException dataAccessException) {
			throw new AdminException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new AdminException(exception.getMessage(),exception);
		}
	}

	@Override
	public Admin addAdminDetails(Admin admin, Integer id) throws AdminException {
		try {
			Admin edit=adminDao.findById(id).get();
			edit.setAdminFirstName(admin.getAdminFirstName());
			edit.setAdminLastName(admin.getAdminLastName());
			edit.setAdminMobile(admin.getAdminMobile());

			Admin addMore=adminDao.save(edit);
			return addMore;

		}catch(DataAccessException dataAccessException) {
			throw new AdminException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new AdminException(exception.getMessage(),exception);
		}
	}


	@Override
	public Integer getAdminIdByEmail(String adminEmail) throws AdminException {
		try {
			Optional<Admin> admin=adminDao.getAdminDataByEmail(adminEmail);
			if(admin.isPresent()) {
				return admin.get().getId();
			}
			else {
				throw new AdminException("Id not found");
			}
		}catch(DataAccessException dataAccessException) {
			throw new AdminException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new AdminException(exception.getMessage(),exception);
		}
	}

	@Override
	public Admin updateAdminProfile(Admin admin) throws AdminException {

		try {
			Admin update=adminDao.save(admin);
			return update;
		}catch(DataAccessException dataAccessException) {
			throw new AdminException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new AdminException(exception.getMessage(),exception);
		}
	}


}
