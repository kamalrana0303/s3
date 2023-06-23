package com.myamazon.s3.service;

import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    void uploadImage(String productId, MultipartFile file);
}
