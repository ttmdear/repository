package repo.java.jhm.bytecode;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GetSizeInLoop {
    private int value = 0;

    public static void main(String[] args) throws IOException {
        GetSizeInLoop getSizeInLoop = new GetSizeInLoop();

        getSizeInLoop.getter();
        getSizeInLoop.getterWithSize();
        getSizeInLoop.print();
    }

    public GetSizeInLoop() {
        value = 10;
    }

    private void print() {
        System.out.println(value);
    }

    public int getter() {
        List<Integer> list = Arrays.asList(1, 2, 3);

        int sum = 0;
        int size = list.size();

        for (int i = 0; i < size; i++) {
            sum += list.get(i);
        }

        return sum;
    }

    public int getterArray() {
        Integer[] list = new Integer[]{4, 5, 6};
        int sum = 0;
        int size = 100;

        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }

        return sum + size;
    }

    public int getterWithSize() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        int sum = 0;
        int size = 100;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        return sum + size;
    }
}
