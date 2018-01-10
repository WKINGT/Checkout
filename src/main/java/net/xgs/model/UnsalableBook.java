package net.xgs.model;

/**
 * @author WangT
 * @date 2018/1/10 14:31
 */
public class UnsalableBook extends Book {
    private static final double DISCOUNT = 0.6;

    public UnsalableBook(double price) {
        super(price);
    }

    @Override
    public double getRealPrice() {
        return price*DISCOUNT;
    }
}
