public class CartOffer {

    private double discountRate;

    private int leastBuyPrice;

    public CartOffer(double discountRate, int leastBuyPrice) {
        this.discountRate = discountRate;
        this.leastBuyPrice = leastBuyPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getLeastBuyPrice() {
        return leastBuyPrice;
    }

}
