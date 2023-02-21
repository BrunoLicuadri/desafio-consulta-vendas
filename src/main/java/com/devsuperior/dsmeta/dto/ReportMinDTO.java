package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

import java.time.LocalDate;

public class ReportMinDTO {

    private Long id;
    private LocalDate date;
    private Double amount;
    private String name;


    public ReportMinDTO(){
    }

    public ReportMinDTO(Long id, LocalDate date, Double amount, String name){
        this.id=id;
        this.date=date;
        this.amount=amount;
        this.name=name;
    }

    public ReportMinDTO(Sale projection){
        id=projection.getId();
        date=projection.getDate();
        amount=projection.getAmount();
        name=projection.getSeller().getName();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ReportMinDTO{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                '}';
    }
}
