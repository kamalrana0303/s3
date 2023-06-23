package com.myamazon.s3.service.impl;
import com.myamazon.s3.config.BucketConfig;
import com.myamazon.s3.service.S3Service;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import java.io.IOException;
import software.amazon.awssdk.services.kms.KmsClient;
@Service
public class S3ServiceImpl implements S3Service {
    private final S3Client s3Client;
    private final BucketConfig bucketConfig;

    public S3ServiceImpl(S3Client s3Client, BucketConfig bucketConfig) {
        this.s3Client = s3Client;
        this.bucketConfig = bucketConfig;
    }

    @Override
    public void putObject(byte[] file, String key){
        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketConfig.getProduct())
                .key(key)
                .build();
        s3Client.putObject(objectRequest, RequestBody.fromBytes(file));
    }

    @Override
    public byte[] getObject(String key){
        GetObjectRequest objectRequest = GetObjectRequest.builder()
                .bucket(bucketConfig.getProduct())
                .key(key)
                .build();
        ResponseInputStream<GetObjectResponse> response = s3Client.getObject(objectRequest);
        try{
            return response.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
