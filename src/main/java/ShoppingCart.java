import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private boolean flag;

    private List<Product> products;

    public ShoppingCart() {
        this.flag = false;
        this.products = new ArrayList<>();
    }

    public boolean getAddedToCart(Product product) throws ShoppingCartException {
        if(product.getProductType() == null){
            throw new ShoppingCartException("null product type", ShoppingCartException.ExceptionType.NULL_PRODUCT_TYPE);
        }
        products.add(product);
        return flag = true;
    }

    public double getTotalPrice(int quantity) throws ShoppingCartException {
        if(flag)
            return products.stream().mapToDouble(product -> product.getProductPrice() * quantity).sum();
        throw new ShoppingCartException("Empty Product List", ShoppingCartException.ExceptionType.EMPTY_PRODUCTS);
    }


}
