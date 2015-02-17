package com.company;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Product {

    //TODO: ADD IMG AND URL

    private final String name;
    private final String price;

    public Product(Document doc) {

        this.name = doc.getElementById("product-information").child(0).text();

        Element salePrice = doc.getElementsByClass("sale-price").first();
        if(salePrice != null && salePrice.text().length()>0){
            this.price = salePrice.text();
        }else{
            this.price = doc.getElementsByClass("money").text();
        }

    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

}
