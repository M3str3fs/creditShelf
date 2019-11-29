package com.Lincoln.creditShelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Lincoln.creditShelf.entity.CompanyEntity;


@Repository
public interface CompanyRepository 
        extends JpaRepository<CompanyEntity, Long> {
 }