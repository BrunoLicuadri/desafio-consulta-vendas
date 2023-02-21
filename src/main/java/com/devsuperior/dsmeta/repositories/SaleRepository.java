package com.devsuperior.dsmeta.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT tb_sales.id, tb_sales.date, SUM (tb_sales.amount), tb_seller.name" +
            "FROM tb_sales" +
            "INNER JOIN tb_seller ON tb_sales.seller_id = tb_seller.id" +
            "WHERE tb_sales.date BETWEEN :startDate AND endDate" +
            "WHERE UPPER (tb_seller.name) LIKE UPPER(CONCAT('%', :name, '%')" +
            "GROUP BY tb_sales.id, tb_seller.name" +
            "ORDER BY tb_sales.id"
        )
    Page<Sale> Report (LocalDate startDate, LocalDate endDate, String name, Pageable pageable);

}
