// package com.products;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class uniqloProductInfo {


    private Document doc;

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public Document getDoc() {
        return doc;
    }

    public uniqloProductInfo(String url) throws IOException{
        setDoc(Jsoup.connect(url).get());
    }

    // Returns the product name
    public static void getProductName(Document doc) {
        String title = doc.title();

        // Capitalizes the first letter of each word in the title
        for(String str: title.split(" ")) {
            str = str.toLowerCase();
            System.out.print(Character.toUpperCase(str.charAt(0)) + str.substring(1) + " ");
        }
        System.out.println();
    }

    // Returns product price
    public String getProductPrice(Document doc) {
        // creates an Element price with the contents of the first <span> of the parent element <li class="price">
        Element price = doc.select("li.price > span").first();
        // creates a string with the contents of the element
        String productPrice = price.toString();
        // removes everything but the price
        productPrice = productPrice.substring(6, 13);
        // returns the product price
        return productPrice;
    }

    // Returns the product number
    public String getProductNumber(Document doc) {
        Element number = doc.select("li.number").first();
        String productNumber = number.toString();
        productNumber = productNumber.substring(19, 38);
        return productNumber;
    }

    // Returns the product color
    public String getProductColor(Document doc) {
        Element color = doc.select("span.colorName").first();
        String productColor = color.toString();
        productColor = productColor.substring(24, (productColor.length() - 7));
        return productColor;

    }
}