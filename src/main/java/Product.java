public class Product {

    private ProductType productType;

    private  double productPrice;

    private Offer offer;

    public Product(ProductType productType, double productPrice) {
        this.productType = productType;
        this.productPrice = productPrice;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public ProductType getProductType() {
        return productType;
    }

    public double getProductPrice() {
        return productPrice ;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
