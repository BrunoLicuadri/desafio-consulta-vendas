package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Seller;
import com.devsuperior.dsmeta.projections.SummaryMinProjection;

public class SummaryMinDTO {
    private Double amountSum;
    private String name;

    public SummaryMinDTO() {
    }
    public SummaryMinDTO(Double amount, String name) {
        this.amountSum = amount;
        this.name = name;
    }

    public SummaryMinDTO(SummaryMinProjection projection) {
        amountSum = projection.getAmountSum();
        name = projection.getName();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SummaryMinDTO{" +
                "amountSum=" + amountSum +
                ", name='" + name + '\'' +
                '}';
    }
}
