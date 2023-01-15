package com.v1project.MyDrugs.models.dtos;

import lombok.Builder;
import java.math.BigDecimal;

public record ProductDTO(int id,
         String productName,
         String tag,
         BigDecimal price) {
    @Builder public ProductDTO {}
}
