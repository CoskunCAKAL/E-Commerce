package com.haratres.repository;

import com.haratres.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {


    Stock findStockByProductId(Long id);
}
