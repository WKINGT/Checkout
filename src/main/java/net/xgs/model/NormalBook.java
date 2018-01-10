package net.xgs.model;

/**
 * @author WangT
 * @date 2018/1/10 14:29
 */
public class NormalBook extends Book {
    private static final double DISCOUNT = 1.0;

    public NormalBook(double price) {
        super(price);
    }

    @Override
    public double getRealPrice() {
        return price*DISCOUNT;
    }
}
