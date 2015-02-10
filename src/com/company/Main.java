package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class Main {


    public static void main(String[] args) throws IOException {

        String baseURL = "http://www.clubmonaco.com/product/index.jsp?productId=";
        String[] urls = {"45602436", "52816966", "53008816"};
        LocalDate currentDate = LocalDate.now();
        PrintWriter out = new PrintWriter(currentDate + ".csv");
        PrintWriter priceChange = new PrintWriter("price change.csv");

        for (int i = 0; i < urls.length; i++) {

            Document doc = Jsoup.connect(baseURL + urls[i]).get();

            Product product = new Product(doc);
            String name = product.getName();
            String price = product.getPrice();

            out.println(name + "," + price + "," + baseURL + urls[i]);

            if (product.isPriceChanged()) {

                priceChange.println(name);
                priceChange.println(price);
            }

        }

        out.close();
        priceChange.close();

    }
}
