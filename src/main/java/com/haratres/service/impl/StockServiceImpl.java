package com.haratres.service.impl;

import com.haratres.entity.Stock;
import com.haratres.repository.StockRepository;
import com.haratres.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;


    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElseThrow();
    }

    @Override
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public Long findAvailableStockForProductId(Long id){
        return stockRepository.findStockByProductId(id).getCount();

    }

}
