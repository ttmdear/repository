package com.ttmdear.repository.patterns.decorator;

public class StrongViewNode extends BaseViewNodeDecorator {
    public StrongViewNode(ViewNode node) {
        super(node);
    }

    @Override
    public String getText() {
        return String.format("<b>%s</b>", super.getText());
    }
}
