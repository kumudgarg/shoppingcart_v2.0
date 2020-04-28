public class BuyXGetYOffer {

    private int buyQuantity;
    private int freeQuantity;

    public BuyXGetYOffer(int x, int freeQuantity) {
        this.buyQuantity = x;
        this.freeQuantity = freeQuantity;
    }

    public double getDiscount(Product product, int quantity){
        int freeItems = (quantity / (buyQuantity + freeQuantity)) * freeQuantity;
           return freeItems * product.getPrice();
        }
}
