package net.xgs.model;

/**
 * @author WangT
 * @date 2018/1/10 14:22
 */
public abstract class Book {
    protected double price;
    public Book(double price){
        this.price = price;
    }

    public abstract double getRealPrice();
}
