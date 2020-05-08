package com.ttmdear.repository.patterns.decorator;

public class TranslatedViewNode extends BaseViewNodeDecorator {
    public TranslatedViewNode(ViewNode node) {
        super(node);
    }

    @Override
    public String getText() {
        return String.format("translated:%s", super.getText());
    }
}
