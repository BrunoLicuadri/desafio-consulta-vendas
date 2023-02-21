package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.ReportMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepo;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = saleRepo.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}


	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

	@Transactional(readOnly = true)
	public Page<ReportMinDTO> Report(String minDate, String maxDate, String name, Pageable pageable){

		LocalDate startDate = LocalDate.parse(minDate, fmt1);
		LocalDate endDate = LocalDate.parse(maxDate, fmt1);

		if(endDate.equals("")){
			endDate = today;
			if(startDate.equals("")){
				startDate=endDate.minusYears(1L);
			}
		}
		else if(startDate.equals("")){
			startDate=endDate.minusYears(1L);
		}

		//Sale entity = new Sale();
		//entity.setAmount(dto.getAmount);

		Page<ReportMinDTO> dto= saleRepo.Report();
		return new ReportMinDTO(dto);
	}


}
