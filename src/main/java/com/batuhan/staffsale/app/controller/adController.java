package com.batuhan.staffsale.app.controller;


import com.batuhan.staffsale.app.model.dto.AdDTO;
import com.batuhan.staffsale.app.model.entity.Ad;
import com.batuhan.staffsale.app.services.AdServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docs")
public class adController {

    @Autowired
    private AdServices adServices;

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody AdDTO adDTO){
        Ad ad = adServices.create(adDTO);
        if(ad == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PRODUCT NOT CREATED");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("PRODUCT CREATED");
    }

    @GetMapping("/products")
    public ResponseEntity getAllProduct(){
        List<Ad> allProducts = adServices.getAllProducts();
        if(allProducts == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UNEXPECTED FAİLED");
        }
        return ResponseEntity.status(HttpStatus.OK).body(allProducts);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteAdByProductId(@PathVariable("id") Long productId){
        Boolean delete = adServices.deleteAdById(productId);
        if(delete == false){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PRODUCT NOT DELETED");
        }
        return ResponseEntity.status(HttpStatus.OK).body("PRODUCT DELETED");
    }

    @PutMapping("/products/{id}")
    public ResponseEntity updateById(@PathVariable Long id, @RequestBody AdDTO adDTO){
        Ad updateAd = adServices.update(id, adDTO);
        if(updateAd == null){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PRODUCT NOT UPDATED");
        }
        return ResponseEntity.status(HttpStatus.OK).body(updateAd);
    }

}
