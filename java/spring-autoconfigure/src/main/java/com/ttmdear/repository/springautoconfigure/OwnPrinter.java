package com.ttmdear.repository.springautoconfigure;

import com.logi.Printer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class OwnPrinter implements Printer {

    @Override
    public void print(String s) {
        System.out.println("OwnPrinter " + s);
    }
}
