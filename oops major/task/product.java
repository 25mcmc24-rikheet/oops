import java.util.*;

abstract class Product
{
    String name;
    double price;

    Product(String name,double price)
    {
        this.name = name;
        this.price = price;
    }

    abstract double calculateDiscount();

    abstract double calculateTax();

    double finalPrice()
    {
        return price - calculateDiscount() + calculateTax();
    }

    void display()
    {
        System.out.println("Product : " + name);
        System.out.println("Price : " + price);
        System.out.println("Discount : " + calculateDiscount());
        System.out.println("Tax : " + calculateTax());
        System.out.println("Final Price : " + finalPrice());
    }
}

interface Returnable
{
    void returnPolicy();
}

class Electronics extends Product implements Returnable
{
    double discountPercent;

    Electronics(String name,double price,double discountPercent)
    {
        super(name,price);

        this.discountPercent = discountPercent;
    }

    double calculateDiscount()
    {
        return price * discountPercent / 100;
    }

    double calculateTax()
    {
        return price * 15 / 100;
    }

    public void returnPolicy()
    {
        System.out.println("Electronics return within 7 days");
    }
}

class Clothing extends Product implements Returnable
{
    double fixedDiscount;

    Clothing(String name,double price,double fixedDiscount)
    {
        super(name,price);

        this.fixedDiscount = fixedDiscount;
    }

    double calculateDiscount()
    {
        return fixedDiscount;
    }

    double calculateTax()
    {
        return price * 5 / 100;
    }

    public void returnPolicy()
    {
        System.out.println("Clothing return within 15 days");
    }
}

class Grocery extends Product
{
    Grocery(String name,double price)
    {
        super(name,price);
    }

    double calculateDiscount()
    {
        return 0;
    }

    double calculateTax()
    {
        return price * 2 / 100;
    }
}

public class product
{
    public static void main(String[] args)
    {
        ArrayList<Product> list = new ArrayList<>();

        list.add(
            new Electronics(
                "Laptop",
                50000,
                10));

        list.add(
            new Clothing(
                "Shirt",
                2000,
                200));

        list.add(
            new Grocery(
                "Rice",
                1000));

        for(Product p : list)
        {
            p.display();

            if(p instanceof Returnable)
            {
                Returnable r = (Returnable)p;

                r.returnPolicy();
            }

            System.out.println();
        }
    }
}