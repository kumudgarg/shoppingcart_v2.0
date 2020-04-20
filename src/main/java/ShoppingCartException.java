public class ShoppingCartException extends Exception {

    public enum ExceptionType{
       EMPTY_PRODUCTS, NULL_PRODUCT_TYPE
    }

    public ShoppingCartException.ExceptionType type;

    public ShoppingCartException(String message, String name) {
        super(message);
        this.type = ShoppingCartException.ExceptionType.valueOf(name);
    }

    public ShoppingCartException(String message, ShoppingCartException.ExceptionType type) {
        super(message);
        this.type = type;
    }
}
