package com.myamazon.s3.resource;//package com.portfolio.userportfolio.resource;


import com.myamazon.s3.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class S3Resource {
    private final ProductService productService;

    public S3Resource(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "{product-id}/product-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadProductImage(@PathVariable("product-id") String productId, @RequestParam("file")MultipartFile image){
        this.productService.uploadImage(productId,image);
        return ResponseEntity.ok().body(null);
    }
}

