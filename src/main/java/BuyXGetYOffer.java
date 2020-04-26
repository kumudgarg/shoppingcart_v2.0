public class BuyXGetYOffer {

    private int buyQuantity;
    private int freeQuantity;

    public BuyXGetYOffer(int x, int freeQuantity) {
        buyQuantity = x;
        this.freeQuantity = freeQuantity;
    }

    public int getBuyQuantity() {
        return buyQuantity;
    }

    public int getFreeQuantity() {
        return freeQuantity;
    }
}
