package com.eny.bookretail.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class BookEntity extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "UNIT_PRICE")
    private double unitPrice;

    @OneToOne(mappedBy = "book",  cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    private StockEntity stock;
/*
    @OneToMany(mappedBy = "book", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<OrderDetailEntity> orderDetails = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "stock_id", referencedColumnName = "id", insertable = false, updatable = false)
    private StockEntity stock;
    */

}
