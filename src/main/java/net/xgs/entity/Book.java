package net.xgs.entity;

/**
 * @author WangT
 * @date 2018/1/9 16:31
 */
public class Book {
    private BookType bookType;
    private double price;
    public Book(){}
    public Book(BookType bookType,double price){
        this.bookType = bookType;
        this.price = price;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
