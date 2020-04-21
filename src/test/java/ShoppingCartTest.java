import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

    @Test
    public void shouldReturnTrueWhenASingleProductAdded() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE,0.99);
        shoppingCart.addToCart(apple, 2);
        int size = shoppingCart.products.size();
        Assert.assertEquals(2, size);
    }

//    @Test
//    public void shouldReturnTotalPriceWhenASingleProductAdded() throws ShoppingCartException {
//        int quantity = 5;
//        ShoppingCart shoppingCart = new ShoppingCart();
//        Product apple = new Product(ProductType.APPLE, 0.99);
//        boolean flag = shoppingCart.getAddedToCart(apple);
//        double totalPrice = shoppingCart.getTotalPrice(quantity);
//        Assert.assertEquals(4.95, totalPrice, 0.0);
//    }
//
//    @Test
//    public void shouldReturnTotalPriceWhenMultipleProductAdded() throws ShoppingCartException {
//        ShoppingCart shoppingCart = new ShoppingCart();
//        Product apple = new Product(ProductType.APPLE, 0.99);
//        shoppingCart.getAddedToCart(apple);
//        shoppingCart.getTotalPrice(3);
//        Product mask = new Product(ProductType.MASK, 1.99);
//        shoppingCart.getAddedToCart(mask);
//        double totalPrice = shoppingCart.getTotalPrice(3);
//        Assert.assertEquals(8.94, totalPrice, 0.0);
//    }
//
//    @Test
//    public void shouldThrowCustomExceptionWhenAListOfProductEmpty() throws ShoppingCartException {
//        try {
//            int quantity = 5;
//            ShoppingCart shoppingCart = new ShoppingCart();
//            Product apple = new Product(ProductType.APPLE, 0.99);
//            double totalPrice = shoppingCart.getTotalPrice(quantity);
//        } catch (ShoppingCartException ex) {
//            Assert.assertEquals(ShoppingCartException.ExceptionType.EMPTY_PRODUCTS, ex.type);
//        }
//    }
//
//    @Test
//    public void shouldThrowCustomExceptionWhenNullProductTypeAdded() throws ShoppingCartException {
//        try {
//            int quantity = 5;
//            ShoppingCart shoppingCart = new ShoppingCart();
//            Product apple = new Product(null, 0.99);
//            shoppingCart.getAddedToCart(apple);
//        }
//        catch (ShoppingCartException ex){
//            Assert.assertEquals(ShoppingCartException.ExceptionType.NULL_PRODUCT_TYPE, ex.type);
//
//        }
//
//    }
//
//    @Test
//    public void shouldReturnTotalPriceWithSalesTaxWhenMultipleProductAdded() throws ShoppingCartException {
//        ShoppingCart shoppingCart = new ShoppingCart();
//        Product apple = new Product(ProductType.APPLE, 0.99);
//        shoppingCart.getAddedToCart(apple);
//        shoppingCart.getTotalPrice(2);
//        shoppingCart.getAddedToCart(apple);
//        shoppingCart.getTotalPrice(1);
//        Product mask = new Product(ProductType.MASK, 1.99);
//        shoppingCart.getAddedToCart(mask);
//        double totalPrice = shoppingCart.getTotalPrice(3);
//        String totalPriceWithsalesTax = shoppingCart.getTotalPriceWithsalesTax(totalPrice);
//        Assert.assertEquals("9.12", totalPriceWithsalesTax);
//    }
//    @Test
//    public void shouldReturnTotalPriceWithSalesTaxWhenMultipleProductAddedIntoCart() throws ShoppingCartException {
//        List<Product> products = new ArrayList<>();
//        ShoppingCart shoppingCart = new ShoppingCart();
//        Product apple = new Product(ProductType.APPLE, 0.99);
//        shoppingCart.addToCart(apple, 2);
//        int size = shoppingCart.products.size();
//        Assert.assertEquals(2, size);

        //Assert.assertEquals(true, cart);
//        shoppingCart.getTotalPrice(2);
//        shoppingCart.getAddedToCart(apple);
//        shoppingCart.getTotalPrice(1);
//        Product mask = new Product(ProductType.MASK, 1.99);
//        shoppingCart.getAddedToCart(mask);
//        double totalPrice = shoppingCart.getTotalPrice(3);
//        String totalPriceWithsalesTax = shoppingCart.getTotalPriceWithsalesTax(totalPrice);
//        Assert.assertEquals("9.12", totalPriceWithsalesTax);
    }




