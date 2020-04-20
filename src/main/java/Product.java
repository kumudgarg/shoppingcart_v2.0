public class Product {

    private ProductType productType;

    private final double productPrice = 0.99;

    public Product(ProductType productType) {
        this.productType = productType;
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
