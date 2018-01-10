import net.xgs.entity.Book;
import net.xgs.entity.BookType;
import net.xgs.payment.CheckoutSystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMethod {
    public List<Book> books = new ArrayList<>();
    public double totalPrice=0;
    @Before
    public void init(){
        Book book1 = new Book(BookType.NEW,20.0);
        Book book2 = new Book(BookType.NORMAL,15.0);
        Book book3 = new Book(BookType.UNSALABLE,10.0);
        Book book4 = new Book(BookType.NEW,30.0);
        Book book5 = new Book(BookType.UNSALABLE,40.0);

        books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
    }
    @After
    public void print(){
        System.out.println("测试成功"+totalPrice);
    }
    @Test
    public void ComputerPrice(){
        totalPrice = new CheckoutSystem().ComputerPrice(books);
    }
}
