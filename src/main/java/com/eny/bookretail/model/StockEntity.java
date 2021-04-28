package com.eny.bookretail.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "stocks")
@EqualsAndHashCode(exclude="book")
public class StockEntity extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private BookEntity book;

    @Column(name = "QUANTITY")
    private int quantity;
}
