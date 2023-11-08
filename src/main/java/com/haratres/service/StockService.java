package com.haratres.service;

import com.haratres.entity.Stock;

import java.util.List;

public interface StockService {

    List<Stock> getAllStock();

    Stock getStockById(Long id);

    Stock saveStock(Stock stock);

    void deleteStock(Long id);


    Long findAvailableStockForProductId(Long id);
}
