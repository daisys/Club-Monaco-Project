package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String url = "http://www.clubmonaco.com/product/index.jsp?productId=45602436";
        Document doc = Jsoup.connect(url).get();

        Elements price = doc.getElementsByClass("money");
        Element img = doc.getElementById("alternate-images");

        System.out.println("Item Name: " + doc.title());
        System.out.println("Price: " + price.text());
        System.out.println("Image: "+ img.text());
        System.out.println("URL: "+ url);
    }
}
