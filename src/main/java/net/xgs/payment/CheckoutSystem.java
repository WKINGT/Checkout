package net.xgs.payment;

import net.xgs.model.Book;

import java.util.List;

/**
 * @author WangT
 * @date 2018/1/10 14:35
 */
public class CheckoutSystem {
    public double ComputerPrice1(List<Book> books){
        double totalPrice=0;
        for(Book book : books){
            totalPrice+=book.getRealPrice();
        }
        return totalPrice;
    }
}
