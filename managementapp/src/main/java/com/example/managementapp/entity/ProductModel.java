package com.example.managementapp.entity;

import javax.persistence.*;

@Entity
@Table(name= "product")
public class ProductModel {

    @Id
    private int id;
    private String name;
    private String description;
    private String producer;
    private int quantity;
    private String lot;

    @ManyToOne
    private DepositModel depositModel;

    public DepositModel getDepositModel() {
        return depositModel;
    }

    public void setDepositModel(DepositModel depositModel) {
        this.depositModel = depositModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }
}
