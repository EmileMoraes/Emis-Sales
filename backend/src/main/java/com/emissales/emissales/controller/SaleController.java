package com.emissales.emissales.controller;

import com.emissales.emissales.entities.Sale;
import com.emissales.emissales.service.SaleService;
import com.emissales.emissales.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v0/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private SmsService smsService;

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
}
