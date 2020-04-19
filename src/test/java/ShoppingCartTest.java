import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {

    @Test
    public void shouldReturnTrueWhenASingleProductAdded() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Object apple = new Object();
        boolean flag = shoppingCart.getAddedToCart(apple);
        Assert.assertEquals(true, flag);
    }
}
