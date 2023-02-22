package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellerMinDTO {
    private String name;

    public SellerMinDTO() {
    }
    public SellerMinDTO(String name) {
        this.name = name;
    }

    public SellerMinDTO(Seller entity) {
        name = entity.getName();
    }

    public String getName() {
        return name;
    }
}
