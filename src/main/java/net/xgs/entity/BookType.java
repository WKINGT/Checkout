package net.xgs.entity;

/**
 * @author WangT
 * @date 2018/1/9 16:27
 */
public enum BookType {
    NEW(1),NORMAL(2),UNSALABLE(3);
    private int value;
    BookType(int value) {
        this.value = value;
    }
    public static BookType getBookType(int value){
        switch (value){
            case 1:
                return BookType.NEW;
            case 2:
                return BookType.NORMAL;
            case 3:
                return BookType.UNSALABLE;
            default:
                return BookType.NORMAL;
        }
    }

}
