package com.emissales.emissales.mapper;

import com.emissales.emissales.dto.request.SaleRequest;
import com.emissales.emissales.dto.response.SaleResponse;
import com.emissales.emissales.entities.Sale;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class SaleMapper {

    private ModelMapper mapper;

    public SaleResponse toModel(Sale sale) {
        return mapper.map(sale, SaleResponse.class);
    }

    public List<SaleResponse> toSaleCollectionDto(List<Sale> sales) {
        return sales.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Sale toEntity(SaleRequest saleRequest) {
        return mapper.map(saleRequest, Sale.class);
    }
}
