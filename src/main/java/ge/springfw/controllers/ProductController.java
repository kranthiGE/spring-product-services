package ge.springfw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ge.springfw.domain.DomainObject;
import ge.springfw.domain.Product;
import ge.springfw.services.ProductService;

/**
 * Created by kranthi on 15-Jul-16
 */
@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product/list")
    public List<DomainObject> listProducts(){
        return (List<DomainObject>) productService.listAll();
    }

    @RequestMapping("/product/{id}")
    public Product getProduct(@PathVariable Integer id){
        return productService.getById(id);
    }

}
