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

}
