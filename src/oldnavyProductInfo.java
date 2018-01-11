// package com.products;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;



public class oldnavyProductInfo {

    private Document doc;

    // sets the object's document to the given doc
    public void setDoc(Document doc) {
        this.doc = doc;
    }

    // returns the object's document
    public Document getDoc() {
        return doc;
    }

    // makes a connection to the given url and sets the doc to its contents
    public oldnavyProductInfo(String url) throws IOException{
        setDoc(Jsoup.connect(url).get());

    }

    public static void getProductName(Document doc) {
        // gets the title of the webpage(the product name)
        String title = doc.title();

        // Capitalizes the first letter of each word in the title
        for(String str: title.split(" ")) {
            // puts all the letters in the title into lowercase
            str = str.toLowerCase();
            // capitalizes the first letter and adds on the rest of the string
            System.out.print(Character.toUpperCase(str.charAt(0)) + str.substring(1) + " ");
        }
        System.out.println();
    }

    // gets the price of the product
    public static String getProductPrice(Document doc) {
        // creates an Element price with the first <h5> element in the product-price class
        Element price = doc.select("h5.product-price").first();
        // creates a string with the contents of the element
        String productPrice = price.toString();
        // gets rid of everything in the string except the price
        productPrice = productPrice.substring(27, 33);
        // returns the price
        return productPrice;
    }

    // gets the product number
    public static String getProductNumber(Document doc) {
        // creates an Element number with the last <li> element in the dash-list with the parent <ul class="sp_top_sm.dash-list">
        Element number = doc.select("ul.sp_top_sm.dash-list > li.dash-list--item:contains(#)").last();
        // creates a string with the contents of the element
        String productNumber = number.toString();
        // gets rid of everything except the product number
        productNumber = productNumber.substring(28, 35);
        // returns the number
        return productNumber;
    }

    /*
    public static String getProductColor(Document doc) {
        Element color = doc.select("div.label-wrapper > span.label").first();
        String productColor = color.toString();
        return productColor;

    } */
}