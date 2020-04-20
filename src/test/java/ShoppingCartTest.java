import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {

    @Test
    public void shouldReturnTrueWhenASingleProductAdded() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE,0.99);
        boolean flag = shoppingCart.getAddedToCart(apple);
        Assert.assertEquals(true, flag);
    }

    @Test
    public void shouldReturnTotalPriceWhenASingleProductAdded() throws ShoppingCartException {
        int quantity = 5;
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE, 0.99);
        boolean flag = shoppingCart.getAddedToCart(apple);
        double totalPrice = shoppingCart.getTotalPrice(quantity);
        Assert.assertEquals(4.95, totalPrice, 0.0);
    }

    @Test
    public void shouldReturnTotalPriceWhenMultipleProductAdded() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE, 0.99);
        shoppingCart.getAddedToCart(apple);
        shoppingCart.getTotalPrice(3);
        Product mask = new Product(ProductType.MASK, 1.99);
        shoppingCart.getAddedToCart(mask);
        double totalPrice = shoppingCart.getTotalPrice(3);
        Assert.assertEquals(8.94, totalPrice, 0.0);
    }

    @Test
    public void shouldThrowCustomExceptionWhenAListOfProductEmpty() throws ShoppingCartException {
        try {
            int quantity = 5;
            ShoppingCart shoppingCart = new ShoppingCart();
            Product apple = new Product(ProductType.APPLE, 0.99);
            double totalPrice = shoppingCart.getTotalPrice(quantity);
        } catch (ShoppingCartException ex) {
            Assert.assertEquals(ShoppingCartException.ExceptionType.EMPTY_PRODUCTS, ex.type);
        }
    }

    @Test
    public void shouldThrowCustomExceptionWhenNullProductTypeAdded() throws ShoppingCartException {
        try {
            int quantity = 5;
            ShoppingCart shoppingCart = new ShoppingCart();
            Product apple = new Product(null, 0.99);
            shoppingCart.getAddedToCart(apple);
        }
        catch (ShoppingCartException ex){
            Assert.assertEquals(ShoppingCartException.ExceptionType.NULL_PRODUCT_TYPE, ex.type);

        }

    }

    @Test
    public void shouldReturnTotalPriceWithSalesTaxWhenMultipleProductAdded() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE, 0.99);
        shoppingCart.getAddedToCart(apple);
        shoppingCart.getTotalPrice(2);
        shoppingCart.getAddedToCart(apple);
        shoppingCart.getTotalPrice(1);
        Product mask = new Product(ProductType.MASK, 1.99);
        shoppingCart.getAddedToCart(mask);
        double totalPrice = shoppingCart.getTotalPrice(3);
        double grandTotal = shoppingCart.salesTaxHandler(totalPrice);
        Assert.assertEquals(9.12, grandTotal, 0.0);
    }



}
