package net.xgs.model;

/**
 * @author WangT
 * @date 2018/1/10 14:24
 */
public class NewBook extends Book {
    private static final double DISCOUNT = 1.2;

    public NewBook(double price) {
        super(price);
    }

    @Override
    public double getRealPrice() {
        return price*DISCOUNT;
    }
}
