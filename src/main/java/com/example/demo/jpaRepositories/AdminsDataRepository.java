package com.example.demo.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Models.AdminsDataModel;
public interface AdminsDataRepository extends JpaRepository<AdminsDataModel,Long>{
	  @Query("SELECT a FROM AdminsDataModel a WHERE a.adminUserName = :username OR a.adminEmail = :email")
	   AdminsDataModel findByAdminUserNameOrAdminEmail(@Param("username") String username, @Param("email") String email);
}