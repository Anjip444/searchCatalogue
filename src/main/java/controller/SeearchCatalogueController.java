package controller;

import entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.ProductRepository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class SeearchCatalogueController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/search/{clientId}")
    public Collection<String> searchProduct(
            @PathVariable Integer clientId,
            @RequestParam String brand,
            @RequestParam(required =false) String color,
            @RequestParam(required =false) String size,
            @RequestParam(required =false) Long price,
            @RequestParam(required =false) Seller seller
    ){
        Collection<String> products  = productRepository.findProductByClientIdOrBrandOrColorOrPriceOrSize(brand,color,size,price,clientId);
        return products;
    }

    @GetMapping("/search/{clientId}")
    public Collection<String> searchBySeller(
            @PathVariable Integer clientId,
            @RequestParam(required =true) Seller seller
    ){
        Collection<String> products  = productRepository.findProductBySeller(clientId,seller);
        return products;
    }
}
