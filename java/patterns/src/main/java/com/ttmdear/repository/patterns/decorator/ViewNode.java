package com.ttmdear.repository.patterns.decorator;

import java.util.List;

public interface ViewNode {

    void render();

    void setParent(ViewNode viewNode);
    ViewNode getParent();

    List<ViewNode> getChilds();

    String getText();
    void setText(String text);

    ViewNode getNativeObject();
}
