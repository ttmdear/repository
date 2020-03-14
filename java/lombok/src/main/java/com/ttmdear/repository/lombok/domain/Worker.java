package com.ttmdear.repository.lombok.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.IOException;
import java.io.OutputStream;

@Builder
@Getter
@Setter
public class Worker {
    private String id;
    private String name;

    public void sendTo(@NonNull OutputStream stream) {
        // Dodanie sprawdzenia czy
        try {
            stream.write(this.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
