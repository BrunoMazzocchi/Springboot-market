package com.example.market.web.controller;

import com.example.market.domain.*;
import com.example.market.domain.service.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController //Controller de una API Rest
@RequestMapping("/products")//Define por donde se pasan los datos
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @ApiOperation("Gets all products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @ApiOperation("Search a specific product with an ID")
    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found")
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The ID of the product", required = true, example = "1") @PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/byCategory/{categoryId}")
    public ResponseEntity<List<Product>> getByCategoryId(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public Optional<List<Product>> getScarseProducts(int quantity, int active){
        return productService.getScarseProducts(quantity, active);
    }

    @ApiOperation("Saves a product with the information required")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @PostMapping("/save")
    public ResponseEntity<Product> save(@ApiParam(value = "The product entity", required = true, example = "" +
            "{\n" +
            "  \"active\": 0,\n" +
            "  \"category\": {\n" +
            "    \"active\": 0,\n" +
            "    \"category\": \"string\",\n" +
            "    \"categoryId\": 0\n" +
            "  }" +
            "")  @RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
        public ResponseEntity delete(@PathVariable("id") int productId){
        if(productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
