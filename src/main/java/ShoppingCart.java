import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private boolean flag;

    private List<Product> products;

    public ShoppingCart() {
        this.flag = false;
        this.products = new ArrayList<>();
    }

    public boolean getAddedToCart(Product product) {
        products.add(product);
        return flag = true;
    }

    public double getTotalPrice(int quantity) {
        if(flag)
            return products.stream().mapToDouble(product -> product.getProductPrice() * quantity).sum();
        return 0.0;
    }


}
