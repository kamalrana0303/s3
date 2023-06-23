package com.myamazon.s3.service.impl;

import com.myamazon.s3.service.ProductService;
import com.myamazon.s3.service.S3Service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final S3Service s3Service;

    public ProductServiceImpl(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @Override
    public void uploadImage(String productId, MultipartFile file){
        try {
            s3Service.putObject(file.getBytes(),"product-image/%s/%s".formatted(productId, UUID.randomUUID().toString()));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
