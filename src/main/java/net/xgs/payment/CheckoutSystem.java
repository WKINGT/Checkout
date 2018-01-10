package net.xgs.payment;

import net.xgs.entity.Book;
import net.xgs.entity.BookType;

import java.util.List;

/**
 * @author WangT
 * @date 2018/1/9 16:16
 */
public class CheckoutSystem {

    public double ComputerPrice(List<Book> books){
        double totalPrice=0;
        for(Book book : books){
            totalPrice+=getBookPrice(book);
        }
        System.out.println(totalPrice);
        return totalPrice;

    }
    public double getBookPrice(Book book){
        BookType bookType = book.getBookType();
        switch (bookType){
            case NEW:
                return book.getPrice()*1.2;
            case NORMAL:
                return book.getPrice();
            case UNSALABLE:
                return book.getPrice()*0.6;
        }
        return 0;
    }


}
