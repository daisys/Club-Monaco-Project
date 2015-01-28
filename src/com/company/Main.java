package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    private static int FIX_PRICE = 7;

    public static void main(String[] args) throws IOException {

        String baseURL = "http://www.clubmonaco.com/product/index.jsp?productId=";
        String[] urls = {"45602436", "52816966" };
        PrintWriter out = new PrintWriter("output.txt");
        PrintWriter priceChange = new PrintWriter("price change.txt");

        for(int i=0; i<urls.length; i++){

            Document doc = Jsoup.connect(baseURL + urls[i]).get();

            Elements price = doc.getElementsByClass("money");
            Element img = doc.getElementById("alternate-images");

            out.println("Item Name: " + doc.title());
            out.println("Price: " + price.text());
            out.println("Image: "+ img.text());
            out.println("URL: "+ baseURL + urls[i]);

            System.out.println("Item Name: " + doc.title());
            System.out.println("Price: " + price.text());
            System.out.println("Image: "+ img.text());
            System.out.println("URL: " + baseURL + urls[i]);


            if(price.text().length()> FIX_PRICE){
                priceChange.println(doc.title());
                priceChange.println(price.text());
            }
        }

        out.close();
        priceChange.close();

    }
}
