package com.haratres.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table
public class WhislistEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long created;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "whislist_id")
    private Whislist whislist;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
