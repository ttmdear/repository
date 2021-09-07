package repo.java.memory.dump;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");

        List<Node> nodeList = new ArrayList<>();

        int i = 0;

        while (true) {
            nodeList.add(new Node());
            Thread.sleep(100);
            // for(int i=0; i <= 1000; i++) {
            //     nodeList.add(new Node());
            // }
        }
    }
}
