package com.emissales.emissales.service;

import com.emissales.emissales.entities.Sale;
import com.emissales.emissales.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SalesRepository repository;

    public Page<Sale> findSales(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Sale> findSalesByDate(String minDate,
                                      String maxDate,
                                      Pageable pageable) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusDays(1) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

        return repository.findSalesByDate(min, max, pageable);
    }

    @Transactional
    public List<Sale> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Sale salve(Sale sale) {
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        sale.setDate(today);
        return repository.save(sale);
    }
}
