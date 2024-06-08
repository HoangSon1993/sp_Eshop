package com.sondev.Eshop.services.admin;

import com.sondev.Eshop.dao.ProductTypeDAO;
import com.sondev.Eshop.entities.ProductType;
import com.sondev.Eshop.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductTypeDAO productTypeDAO;

    public List<ProductType> getAllProductType() {
        return productTypeRepository.findAll();
    }
}
