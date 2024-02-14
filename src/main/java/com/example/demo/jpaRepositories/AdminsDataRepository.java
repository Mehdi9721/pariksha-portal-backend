package com.example.demo.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.AdminsDataModel;
public interface AdminsDataRepository extends JpaRepository<AdminsDataModel,Long>{

}