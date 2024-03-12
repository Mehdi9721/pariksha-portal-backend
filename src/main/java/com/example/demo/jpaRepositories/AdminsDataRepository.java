package com.example.demo.jpaRepositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Models.AdminsDataModel;

import jakarta.transaction.Transactional;
public interface AdminsDataRepository extends JpaRepository<AdminsDataModel,Long>{
	  @Query("SELECT a FROM AdminsDataModel a WHERE a.adminUserName = :username OR a.adminEmail = :email")
	   AdminsDataModel findByAdminUserNameOrAdminEmail(@Param("username") String username, @Param("email") String email);
	   
	  Optional<AdminsDataModel> findByAdminEmail(String adminEmail); 
	  
	  @Transactional
	  @Modifying
	  @Query("UPDATE AdminsDataModel a SET a.adminName = :adminName, a.adminUserName = :adminUserName, a.adminEmail = :adminEmail, a.adminPassword = :adminPassword WHERE a.adminEmail = :adminEmail")
	  void updateAdmin(@Param("adminName") String adminName, @Param("adminUserName") String adminUserName, @Param("adminEmail") String adminEmail, @Param("adminPassword") String adminPassword);

	  @Transactional
	  @Modifying
	  @Query("DELETE from AdminsDataModel e where e.id= :id")
	  void deleteAdminById(@Param("id") String id); 
}