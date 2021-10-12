/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Eric Gass
 */

package ex44;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.List;
import java.util.Scanner;

class Product
{
    public String name;
    public Double price;
    public int quantity;

    public void setName(String name)
    {
        this.name = name;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public String getName()
    {
        return name;
    }
    public Double getPrice()
    {
        return price;
    }
    public int getQuantity()
    {
        return quantity;
    }
}

class Data
{
    private List<Product> products;

    public List<Product> getProducts()
    {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

public class App
{
    public static boolean objectFound(String object, Data products)
    {
        for(int i = 0 ; i < products.getProducts().size();i++)
        {
            if(object.equals(products.getProducts().get(i).name))
            {
                //print output
                //set itemExist to true
                System.out.println("Name: "+products.getProducts().get(i).name);
                System.out.println(String.format("Price: %.2f",products.getProducts().get(i).price));
                System.out.println("Quantity: "+products.getProducts().get(i).quantity);
                return true;
            }
        }
        System.out.println("Sorry, that product was not found in our inventory");
        return false;
    }

    public static void main( String[] args ) throws IOException
    {
        Scanner scan  = new Scanner(System.in);
        Gson g = new Gson();
        Object obj;
        try
        {
            JsonParser parser = new JsonParser();
            obj = parser.parse(new FileReader("src/main/java/ex44/exercise44_input.json"));
            JsonObject jsonObject = (JsonObject) obj;
            Data products = g.fromJson(jsonObject,Data.class);

            boolean itemExists = false;
            while(!itemExists)
            {
                System.out.print("What is the product name? ");
                String item = scan.nextLine();

                itemExists = objectFound(item,products);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
