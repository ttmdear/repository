package com.ttmdear.repository.springautoconfigure;

import com.logi.Printer;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final Printer printer;

    public UserService(Printer printer) {
        this.printer = printer;
    }

    void print(String out) {
        printer.print(out);
    }
}
