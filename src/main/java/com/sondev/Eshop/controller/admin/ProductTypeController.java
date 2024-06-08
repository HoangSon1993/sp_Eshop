package com.sondev.Eshop.controller.admin;

import com.sondev.Eshop.entities.ProductType;
import com.sondev.Eshop.services.admin.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;
    @GetMapping("")
    String index(Model model){
        List<ProductType> productTypeList = productTypeService.getAllProductType();
        model.addAttribute("productTypeList",productTypeList);
        return ("admin/productType/index");
    }

}
