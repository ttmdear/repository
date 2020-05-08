package com.ttmdear.repository.patterns;

import com.ttmdear.repository.patterns.decorator.Input;
import com.ttmdear.repository.patterns.decorator.StrongViewNode;
import com.ttmdear.repository.patterns.decorator.TranslatedViewNode;
import com.ttmdear.repository.patterns.decorator.ViewNode;

public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        ViewNode viewNode = findViewNode();

        Input input = new Input("Node A");
        ViewNode decorated = new TranslatedViewNode(new StrongViewNode(input));

        System.out.println(decorated instanceof Input);
        System.out.println(decorated.getNativeObject() instanceof Input);

        System.out.println(viewNode.getText());
    }

    private ViewNode findViewNode() {
        Input input = new Input("Node A");

        return new TranslatedViewNode(new StrongViewNode(input));
    }
}
