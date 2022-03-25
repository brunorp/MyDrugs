package com.v1project.MyDrugs.models.dtos;

import com.v1project.MyDrugs.models.Product;
import lombok.*;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductDTO {
    private int id;
    private String productName;
    private String tag;
    private BigDecimal price;
}
