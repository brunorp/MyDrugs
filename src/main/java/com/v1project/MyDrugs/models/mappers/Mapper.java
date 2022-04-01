package com.v1project.MyDrugs.models.mappers;

import com.v1project.MyDrugs.models.Product;
import com.v1project.MyDrugs.models.User;
import com.v1project.MyDrugs.models.dtos.ProductDTO;
import com.v1project.MyDrugs.models.dtos.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper implements MapperInterface {

    @Override
    public ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getProductName(),
                product.getTag(),
                product.getPrice()
        );
    }

    @Override
    public UserDTO toUserDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getUserName(),
                user.getPassword()
        );
    }
}
