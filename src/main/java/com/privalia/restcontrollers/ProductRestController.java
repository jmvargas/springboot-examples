package com.privalia.restcontrollers;

import com.privalia.domain.Product;
import com.privalia.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Api(value = "onlinestore", description = "Operations pertaining to productsin Online Store")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Search a product with an ID", response = Product.class)
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public Product showProduct(@PathVariable Integer id){
        return productService.getProductById(id);
    }
}
