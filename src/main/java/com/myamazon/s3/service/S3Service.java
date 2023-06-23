package com.myamazon.s3.service;

public interface S3Service {
    void putObject(byte[] file, String key);
    byte[] getObject(String key);
}
