package com.haratres.dto;

import com.haratres.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductWithStockDTO {

    Product product;
    Long availableStock;

}
