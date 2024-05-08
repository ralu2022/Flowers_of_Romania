package com.example.flowersOfRomania.flowersrecyclerview;


import android.content.Context;

import com.example.flowersOfRomania.R;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLFlowersData {
    private final Flower[] flowersData;

    public Flower[] getFlowersData() {
        return flowersData;
    }

    public XMLFlowersData(Context context) {
        // open input stream to XML file
        InputStream stream;
        DocumentBuilder builder;
        Document xmlDoc = null;

        try {
            stream = context.getResources().openRawResource(R.raw.flowers);
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlDoc = builder.parse(stream);
        } catch (Exception ignored) {

        }

        // cut document to generate node lists
        assert xmlDoc != null;
        NodeList nameList = xmlDoc.getElementsByTagName("name");
        NodeList typeList = xmlDoc.getElementsByTagName("type");
        NodeList descriptionList = xmlDoc.getElementsByTagName("description");
        NodeList urlList = xmlDoc.getElementsByTagName("url");
        NodeList imageList = xmlDoc.getElementsByTagName("image");

        int count = nameList.getLength();
        flowersData = new Flower[count];

        for (int i = 0; i < count; ++i) {
            // extract data from each node
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String type = typeList.item(i).getFirstChild().getNodeValue();
            String description = descriptionList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();

            Flower flower = new Flower(name, type, description, url, image);
            flowersData[i] = flower;
        }
    }
}
