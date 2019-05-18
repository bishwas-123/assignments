package edu.mum.cs.cs425.finalexam.prodmgmt.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pro")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_number", unique = true, nullable = false)
    private Long productNumber;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "unit_price", nullable = false)
    private Float unitPrice;

    @Column(name = "date_mfd", nullable = false)
    private LocalDate dateMfd;

    public Product() {

    }

    public Product(Long productNumber, String name, Float unitPrice, LocalDate dateMfd) {
        this.productNumber = productNumber;
        this.name = name;
        this.unitPrice = unitPrice;
        this.dateMfd = dateMfd;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDate getDateMfd() {
        return dateMfd;
    }

    public void setDateMfd(LocalDate dateMfd) {
        this.dateMfd = dateMfd;
    }

//    public String toJsonFormat(){
//          return "{"+"Product Name:"+productNumber+"Product Name"+productNumber +"}";
//    }

}
