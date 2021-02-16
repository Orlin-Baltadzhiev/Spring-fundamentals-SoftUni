package com.exam.service;


import com.exam.model.entities.Product;
import com.exam.model.entities.enums.CategoryName;
import com.exam.model.service.ProductServiceModel;
import com.exam.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryName categoryName);

    void buyId(String id);

    void buyAll();

}
