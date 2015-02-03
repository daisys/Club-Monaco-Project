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
        PrintWriter priceChange = new PrintWriter("price change.csv");

        for(int i=0; i<urls.length; i++){

            Document doc = Jsoup.connect(baseURL + urls[i]).get();

            Product product = new Product(doc);
            String name = product.getName();
            String price = product.getPrice();

            out.println(name+ "," + price + "," + baseURL+urls[i]);
            //TODO: for testing purpose, to delete after
            System.out.println("Item Name: " + name);
            System.out.println("Price: " + price);
            System.out.println("URL: " + baseURL + urls[i]);


            Main.isPriceChanged(priceChange, name, price);
        }

        out.close();
        priceChange.close();

    }
        public static void isPriceChanged(PrintWriter priceChange, String name, String price) {
        if(price.length()> FIX_PRICE){
            priceChange.println(name);
            priceChange.println(price);
        }
    }
}
