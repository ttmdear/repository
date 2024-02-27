package org.example;

import org.example.proto.CreateUser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class WriteTo {
    public static void main(String[] args) throws IOException {
        CreateUser createUser = CreateUser.newBuilder()
            .setUserId(UUID.randomUUID().toString())
            .setName("jan@gmail.com")
            .build();

        createUser.writeTo(new FileOutputStream("C:\\home\\repository\\java\\protobuf\\target\\CreateUser.%s.data".formatted(createUser.getUserId())));
    }
}