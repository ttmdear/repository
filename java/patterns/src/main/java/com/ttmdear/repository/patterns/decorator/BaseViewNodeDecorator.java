package com.ttmdear.repository.patterns.decorator;

import java.util.List;

public class BaseViewNodeDecorator implements ViewNode {
    private ViewNode node;

    public BaseViewNodeDecorator(ViewNode node) {
        this.node = node;
    }

    @Override
    public void render() {
        node.render();
    }

    @Override
    public void setParent(ViewNode viewNode) {
        node.setParent(viewNode);
    }

    @Override
    public ViewNode getParent() {
        return node.getParent();
    }

    @Override
    public List<ViewNode> getChilds() {
        return node.getChilds();
    }

    @Override
    public String getText() {
        return node.getText();
    }

    @Override
    public void setText(String text) {
        node.setText(text);
    }

    @Override
    public ViewNode getNativeObject() {
        return node.getNativeObject();
    }
}
