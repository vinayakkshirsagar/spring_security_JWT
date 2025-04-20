package com.bsl.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsl.business.entities.User;

@Repository
public interface UserReository extends JpaRepository<User, Long>{

}
