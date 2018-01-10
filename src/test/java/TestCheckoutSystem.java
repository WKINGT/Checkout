import net.xgs.model.Book;
import net.xgs.model.NewBook;
import net.xgs.model.NormalBook;
import net.xgs.model.UnsalableBook;
import net.xgs.payment.CheckoutSystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangT
 * @date 2018/1/10 14:36
 */
public class TestCheckoutSystem {
    public List<Book> books = new ArrayList<>();
    public double totalPrice=0;
    @Before
    public void init(){
        Book book1 = new NewBook(20.0);
        Book book2 = new NormalBook(15.0);
        Book book3 = new UnsalableBook(10.5);
        Book book4 = new UnsalableBook(30.0);
        Book book5 = new NormalBook(40.0);
        Book book6 = new NewBook(50.5);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
    }
    @After
    public void print(){
        System.out.println("测试结果，总价："+totalPrice);
    }
    @Test
    public void ComputerPrice(){
        totalPrice = new CheckoutSystem().ComputerPrice1(books);
    }
}
