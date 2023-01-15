package com.v1project.MyDrugs.models.dtos;

import lombok.Builder;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public record ProductDTO(Integer id,
         String productName,
         String tag,
         BigDecimal price) {
    @Builder public ProductDTO {}
}
