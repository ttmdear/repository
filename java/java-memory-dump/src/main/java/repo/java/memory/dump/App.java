package repo.java.memory.dump;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");

        List<Node> nodeList = new ArrayList<>();

        while (true) {
            Thread.sleep(1);

            nodeList.add(new Node());
            nodeList.add(new Node());
            nodeList.add(new Node());
            // for(int i=0; i <= 1000; i++) {
            //     nodeList.add(new Node());
            // }
        }
    }
}
