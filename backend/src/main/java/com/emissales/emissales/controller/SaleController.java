package com.emissales.emissales.controller;

import com.emissales.emissales.dto.request.SaleRequest;
import com.emissales.emissales.dto.response.SaleResponse;
import com.emissales.emissales.entities.Sale;
import com.emissales.emissales.mapper.SaleMapper;
import com.emissales.emissales.service.SaleService;
import com.emissales.emissales.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v0/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private SmsService smsService;

    @Autowired
    private SaleMapper saleMapper;

    @GetMapping
    public Page<Sale> findSales(Pageable pageable){
      return saleService.findSales(pageable);
    }

    @GetMapping("/date")
    public Page<Sale> findSalesByDate(
            @RequestParam(value ="minDate", defaultValue = "") String minDate,
            @RequestParam(value ="maxDate", defaultValue = "") String maxDate,
                                      Pageable pageable){
      return saleService.findSalesByDate(minDate, maxDate, pageable);
    }

    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id) {
        smsService.sendSms(id);
    }

    @GetMapping("/all")
    public List<SaleResponse> findAll() {
        List<Sale> saleList = saleService.findAll();
        return saleMapper.toSaleCollectionDto(saleList);
    }

    @PostMapping
    public SaleResponse create(@Validated @RequestBody SaleRequest saleRequest){
        Sale sale = saleMapper.toEntity(saleRequest);
        var newSale = saleService.salve(sale);
        return saleMapper.toModel(newSale);
    }

}
