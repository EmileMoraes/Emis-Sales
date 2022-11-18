package com.emissales.emissales.controller;

import com.emissales.emissales.entities.Sale;
import com.emissales.emissales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v0/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public Page<Sale> findSales(Pageable pageable){
      return saleService.findSales(pageable);
    }

    @GetMapping(path = "/")
    public Page<Sale> findSalesByDate(
            @RequestParam(value ="minDate", defaultValue = "") String minDate,
            @RequestParam(value ="maxDate", defaultValue = "") String maxDate,
                                      Pageable pageable){
      return saleService.findSalesByDate(minDate, maxDate, pageable);
    }
}
