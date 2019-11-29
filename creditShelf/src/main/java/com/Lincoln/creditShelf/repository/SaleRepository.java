package com.Lincoln.creditShelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.Lincoln.creditShelf.entity.SaleEntity;


@Repository
public interface SaleRepository 
        extends JpaRepository<SaleEntity, Long> {
 }
