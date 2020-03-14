package com.ttmdear.repository.xml;

import com.ttmdear.repository.xml.dom.CreateDocument;
import com.ttmdear.repository.xml.transform.TransformStreamToStream;

public class App
{
    public static void main( String[] args ) {
        new CreateDocument().run();
        new TransformStreamToStream().run();
    }
}
