public class Product {

    private ProductType productType;

    private  double productPrice;

    public Product(ProductType productType, double productPrice) {
        this.productType = productType;
        this.productPrice = productPrice;
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
