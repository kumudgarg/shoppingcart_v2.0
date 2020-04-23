import java.util.List;

public class CartOffer {

    private static double discountRate;

    private static int leastLimitProduct;

    public static void setDiscountRateAndleastLimitProduct(double rate,int limit){
        discountRate = rate;
        leastLimitProduct = limit;
    }

    public static double getDiscountByCartOffer(List<Product> products,double totalPrice) {
        if(products.size() > leastLimitProduct) {
            double totalOffPrice = (totalPrice * discountRate) / 100;
            return totalOffPrice;
        }
        return 0.0;
    }



}
