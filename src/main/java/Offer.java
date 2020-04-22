public class Offer {



    private int actualQuantity;

    private int count;

    private int buyProduct = 2;

    private int getProduct = 3;

    private int freeProduct = getProduct - buyProduct;

   private OfferType offerType;

    public Offer() {
    }

    public Offer(OfferType offerType) {
        this.offerType = offerType;
    }

    public int getQuantity(int quantity) {
        actualQuantity = quantity;
        if(offerType.equals(OfferType.WITH_OFFER)){
            int remainder = quantity % 2;
            quantity += remainder;
            return quantity;
        }
        else if(offerType.equals(OfferType.NO_OFFER))
        return quantity;
        return 0;
    }

    public int getFreeProduct(){
            int quotient = actualQuantity / 2;
            while (quotient >= 1){
                quotient = quotient / 2;
                count++;
            }
            return count * freeProduct;
    }

}
