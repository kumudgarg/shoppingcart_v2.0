public class Offer {

    private int actualQuantity;

    private int buyProduct;

    private int getProduct;

    public Offer(int buyProduct, int getProduct) {
        this.buyProduct = buyProduct;
        this.getProduct = getProduct;
    }

    private int getBaseFreeProduct() {
        if (this.getProduct > this.buyProduct)
            return getProduct - buyProduct;
        return getProduct;
    }

    public int getQuantity(int quantity) {
        actualQuantity = quantity;
        int remainder = quantity % getProduct;
        if (remainder == buyProduct)
            return quantity + 1;
        return quantity;

    }

    public int getFreeProduct() {
        int baseFreeProduct = getBaseFreeProduct();
        int quotient = actualQuantity / getProduct;
        int remainder = actualQuantity % getProduct;
        if (remainder == buyProduct)
            return (quotient + 1) * baseFreeProduct;
        return quotient * baseFreeProduct;
    }

}
