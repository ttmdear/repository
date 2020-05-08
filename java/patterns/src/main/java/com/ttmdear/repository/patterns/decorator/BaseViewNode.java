package com.ttmdear.repository.patterns.decorator;

import java.util.ArrayList;
import java.util.List;

abstract public class BaseViewNode implements ViewNode {
    private ViewNode parent;
    private List<ViewNode> childs = new ArrayList<>();
    private String text;

    @Override
    public void render() {
        System.out.println("BaseViewNode.render");
    }

    @Override
    public void setParent(ViewNode viewNode) {
        parent = viewNode;
    }

    @Override
    public ViewNode getParent() {
        return parent;
    }

    @Override
    public List<ViewNode> getChilds() {
        return childs;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public ViewNode getNativeObject() {
        return this;
    }
}
