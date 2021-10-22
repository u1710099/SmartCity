package com.idigital.epam.energy.repository;

import com.idigital.epam.energy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByCitizenCardId(String citizenCardId);
}


