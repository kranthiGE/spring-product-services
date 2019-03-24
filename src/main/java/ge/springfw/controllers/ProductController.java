package ge.springfw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ge.springfw.domain.DomainObject;
import ge.springfw.domain.Product;
import ge.springfw.services.ProductService;
import ge.springfw.util.RestPreconditions;

/**
 * Created by kranthi on 15-Jul-16
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/list")
    public List<DomainObject> listProducts(){
        return (List<DomainObject>) productService.listAll();
    }

    @RequestMapping("/{id}")
    public Product getProduct(@PathVariable Integer id){
        return RestPreconditions.checkFound(productService.getById(id), "Product " + id + " not found") ;
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product createProduct(@RequestBody Product product) {
    		return productService.saveOrUpdate(product);
    }

}
