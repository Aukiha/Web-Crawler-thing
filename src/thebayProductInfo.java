// package com.products;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class thebayProductInfo {


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
    public thebayProductInfo(String url) throws IOException{
        setDoc(Jsoup.connect(url).get());
    }


    // gets the product's name
    public void getProductName(Document doc) {
        String title = doc.title();

        // if the first letter of the title is "M"(for the "Men | Men |" prefix in the title)
        if((title.charAt(0)) == 'M') {
            // removes the prefix in the title
            title = title.substring(12, (title.length() - 14));
        }
        // if the first letter of the title is "W"(for the "Women | Women | prefix in the title)
        else if((title.charAt(0)) == 'W') {
            // removes the prefix in the title
            title = title.substring(15, (title.length() - 14));
        }

        System.out.println(title);

    }

    /*
    public static String getProductPrice(Document doc) {
        Element price = doc.select(".detial_pric > .ora").first();
        String productPrice = price.toString();
        return productPrice;
    }
    */

    // gets the product number
    public String getProductNumber(Document doc) {
        // creates an Element number with the contents of the first <p> of the parent element <div class="webid">
        Element number = doc.select("div.webid > p").first();
        // creates a string with the contents of the element
        String productNumber = number.toString();
        // removes everything but the product number
        productNumber = productNumber.substring(13, (productNumber.length() - 4));
        // returns the product number
        return productNumber;
    }
}
