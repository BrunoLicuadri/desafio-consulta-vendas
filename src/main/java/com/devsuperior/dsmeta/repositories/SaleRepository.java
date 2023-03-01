package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.ReportMinDTO;
import com.devsuperior.dsmeta.dto.SummaryMinDTO;
import com.devsuperior.dsmeta.projections.SummaryMinProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsmeta.dto.ReportMinDTO (obj.id, obj.date, SUM (obj.amount), obj.seller.name) " +
            "FROM Sale obj " +
            "WHERE obj.date BETWEEN :startDate AND :endDate " +
            "AND UPPER (obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%')) " +
            "GROUP BY obj.id, obj.seller.name " +
            "ORDER BY obj.id "
        )
    Page<Sale> report (LocalDate startDate, LocalDate endDate, String name, Pageable pageable);


    @Query("SELECT new com.devsuperior.dsmeta.dto.SummaryMinDTO (SUM (obj.amount), obj.seller.name) " +
            "FROM Sale obj " +
            "WHERE obj.date BETWEEN :startDate AND :endDate " +
            "GROUP BY obj.seller.name " +
            "ORDER BY obj.seller.name "
    )
    List<SummaryMinDTO> summary (LocalDate startDate, LocalDate endDate);

}
