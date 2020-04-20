import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {

    @Test
    public void shouldReturnTrueWhenASingleProductAdded() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE);
        boolean flag = shoppingCart.getAddedToCart(apple);
        Assert.assertEquals(true, flag);
    }

    @Test
    public void shouldReturnTotalPriceWhenASingleProductAdded() {
        int quantity = 5;
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE);
        boolean flag = shoppingCart.getAddedToCart(apple);
        double totalPrice = shoppingCart.getTotalPrice(quantity);
        Assert.assertEquals(4.95, totalPrice, 0.0);
    }

    @Test
    public void shouldReturnTotalPriceWhenMultipleProductAdded() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE);
        shoppingCart.getAddedToCart(apple);
        shoppingCart.getTotalPrice(3);
        Product mask = new Product(ProductType.MASK);
        shoppingCart.getAddedToCart(mask);
        double totalPrice = shoppingCart.getTotalPrice(3);
        Assert.assertEquals(8.94, totalPrice, 0.0);
    }
}
