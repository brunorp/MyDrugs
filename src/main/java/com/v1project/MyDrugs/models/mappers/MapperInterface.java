package com.v1project.MyDrugs.models.mappers;

import com.v1project.MyDrugs.models.Product;
import com.v1project.MyDrugs.models.User;
import com.v1project.MyDrugs.models.dtos.ProductDTO;
import com.v1project.MyDrugs.models.dtos.UserDTO;

public interface MapperInterface {
    ProductDTO toProductDTO(Product product);
    UserDTO toUserDTO(User user);
}
