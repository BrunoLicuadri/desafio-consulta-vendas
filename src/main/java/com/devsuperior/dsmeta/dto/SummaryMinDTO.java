package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Seller;
import com.devsuperior.dsmeta.projections.SummaryMinProjection;

public class SummaryMinDTO {
    private Double total;
    private String sellerName;

    public SummaryMinDTO() {
    }

    public SummaryMinDTO(Double total, String sellerName) {
        this.total = total;
        this.sellerName = sellerName;
    }

    public Double getTotal() {
        return total;
    }

    public String getSellerName() {
        return sellerName;
    }

    @Override
    public String toString() {
        return "SummaryMinDTO{" +
                "total=" + total +
                ", sellerName='" + sellerName + '\'' +
                '}';
    }
}
