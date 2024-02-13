package com.minio.MinioDemoProject.test;

import io.minio.ListObjectsArgs;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.errors.*;
import io.minio.messages.Item;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MinIOObjectCRUD {

    MinioClient minioClient = MinioClient
            .builder()
            .endpoint("http://127.0.0.1:9000")
            .credentials("minioadmin", "minioadmin")
            .build();

    public List<String> getListOfObjects() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Iterable<Result<Item>> listOfObjects =  minioClient
                .listObjects(
                        ListObjectsArgs
                                .builder()
                                .bucket("test-bucket")
                                .build()
                );
        List<String> resultList = new ArrayList<>();
        for(Result<Item> resultItem : listOfObjects) {
            resultList.add(resultItem.get().objectName());
        }
        return resultList;
    }
}
