public class Offer {

    private int actualQuantity;

    private int buyProduct;

    private int getProduct;

    private OfferType offerType;

    public Offer() {
    }

    public Offer( OfferType offerType, int buyProduct, int getProduct) {
        this.buyProduct = buyProduct;
        this.getProduct = getProduct;
        this.offerType = offerType;
    }

    public Offer(OfferType offerType) {
        this.offerType = offerType;
    }

    private int getBaseFreeProduct(){
        if(this.getProduct > this.buyProduct)
            return getProduct - buyProduct;
        return getProduct;
    }


    public int getQuantity(int quantity) {
        actualQuantity = quantity;
        if (offerType.equals(OfferType.WITH_OFFER)) {
            int remainder = quantity % getProduct;
                if(remainder == buyProduct)
                    return quantity + 1;
                return quantity;
        }
            return quantity;

    }

    public int getFreeProduct() {
        if(offerType.equals(OfferType.WITH_OFFER)) {
            int baseFreeProduct = getBaseFreeProduct();
            int quotient = actualQuantity / getProduct;
            int remainder = actualQuantity % getProduct;
            if(remainder == buyProduct)
                return (quotient + 1) * baseFreeProduct;
            return quotient * baseFreeProduct;
        }
        return 0;
    }

}
