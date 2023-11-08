package com.haratres.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private BigDecimal price;

    private BigDecimal totalprice;

    private String memory;

    private String storageText;

    private String storage;

    private String poweradapter;

    private String description;

    private String cpuNumber;

    private String gpuNumber;
    @OneToMany
    private List<Image> images;

    private String baseImage;
}
