// package com.products;


import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.io.IOException;



public class Main {

    public static void main(String[] args) throws IOException {

        // Test values, replace with actual search values
        String website = "uniqlo";
        String description = "flannel checked long sleeve shirt";

        // Searches for the link of the product using the website and the product description
        String link = (productSearch(website, description));
        switch(website) {

            // if the website is UNIQLO
            case "uniqlo":

                // initializes a new uniqloProductInfo object named uni for the webpage link
                uniqloProductInfo uni = new uniqloProductInfo(link);

                // creates a Document that holds the webpage contents
                Document docUni = uni.getDoc();

                // gets the product name from the document
                uni.getProductName(docUni);

                // gets the product price from the document
                System.out.println(uni.getProductPrice(docUni));

                // gets the product color from the document
                System.out.println(uni.getProductColor(docUni));

                // gets the product number from the document
                System.out.println(uni.getProductNumber(docUni));
                break;

            // if the website is Old Navy
            case "old navy":

                // initializes a new oldnavyProductInfo objected called navy for the webpage link
                oldnavyProductInfo navy = new oldnavyProductInfo(link);

                // creates a Document that holds the webpage contents
                Document docNavy = navy.getDoc();

                // gets the product name
                navy.getProductName(docNavy);

                // gets the product number
                System.out.println(navy.getProductNumber(docNavy));
                break;

            // if the website is The Bay
            case "the bay":

                // initializes a new thebayProductInfo object called bay
                thebayProductInfo bay = new thebayProductInfo(link);

                // creates a Document that holds the webpage contents
                Document docBay = bay.getDoc();

                // gets the product name
                bay.getProductName(docBay);

                // gets the product number
                System.out.println(bay.getProductNumber(docBay));
        }

    }

    // uses a Google Advanced Search to get the webpage of the product
    public static String productSearch(String website, String description) throws IOException {

        // removes all spaces in the website and description strings
        website = website.replaceAll("\\s+", "");
        description = description.replaceAll("\\s+","");

        // if the website given is uniqlo
        if(website.equals("uniqlo")) {

            // google search link
            String searchURL = "https://www.Google.ca/search?q=" + website + "+" + description + "&as_sitesearch=http://www.uniqlo.com/ca/en";

            // creates a new Document that holds the results of the Google search
            Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();

            // selects the first <a> element in the first <h3> element in the document
            Element result = doc.select("h3.r >a").first();

            // creates a link from the first result
            String link = result.attr("href");
            link = link.substring(7, link.indexOf("&"));

            // for testing
            System.out.println(link);

            // returns the link
            return link;
        }

        // if the website is old navy
        else if(website.equals("oldnavy")) {

            // google search link
            String searchURL = "https://www.Google.ca/search?q=" + website + "+" + description + "&as_sitesearch=http://www.oldnavy.ca";

            // creates a Document that holds the contents of the Google search
            Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();

            // selects the first <a> element in the first <h3> element in the document
            Element result = doc.select("h3.r >a").first();

            // creates a link from the first result
            String link = result.attr("href");
            link = link.substring(7, link.indexOf("&"));

            // for testing
            System.out.println(link);

            // returns the link
            return link;
        }
        // if the website is the bay...
        else if(website.equals("thebay")) {
            String searchURL = "https://www.Google.ca/search?q=" + website + "+" + description + "&as_sitesearch=http://www.thebay.com";
            Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
            Element result = doc.select("h3.r >a").first();
            String link = result.attr("href");
            link = link.substring(7, link.indexOf("&"));
            System.out.println(link);

            return link;
        }
        else {
            String searchURL = "https://www.Google.ca/search?q=" + website + "+" + description;
            Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
            Element result = doc.select("h3.r >a").first();
            String link = result.attr("href");
            link = link.substring(7, link.indexOf("&"));
            System.out.println(link);

            return link;
        }

    }
}