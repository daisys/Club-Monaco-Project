package com.company;

import com.company.Main;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by daisyshih on 2/3/15.
 */
public class Product {

    private static int FIX_PRICE = 7;

    //TODO: ADD IMG AND URL

    private final String name;
    private final String price;

    public Product(Document doc) {

        this.name = doc.getElementById("product-information").child(0).text();
        this.price = doc.getElementsByClass("money").text();

    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public boolean isPriceChanged(){
        return price.length()>FIX_PRICE;
    }



}
