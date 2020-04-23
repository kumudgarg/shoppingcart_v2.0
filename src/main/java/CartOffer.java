public class CartOffer {

    private final static double discountRate = 10;

    public static double getDiscountByCartOffer(double totalPrice) {
        double totalOffPrice = (totalPrice * discountRate) / 100;
        return totalOffPrice;
    }



}
