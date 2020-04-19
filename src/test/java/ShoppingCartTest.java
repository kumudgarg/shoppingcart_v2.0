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
}
