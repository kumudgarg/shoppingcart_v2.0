import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

    @Test
    public void shouldReturnTrueWhenASingleProductAdded() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE, 0.99);
        shoppingCart.addToCart(apple, 2);
        int size = shoppingCart.products.size(); //design damage
        Assert.assertEquals(2, size);
    }

    @Test
    public void shouldReturnTotalPriceWhenASingleProductAdded() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE, 0.99);
        shoppingCart.addToCart(apple, 5);
        double totalPrice = shoppingCart.getTotalPrice();
         totalPrice = shoppingCart.getTotalPrice();
        Assert.assertEquals(4.95, totalPrice, 0.0);
    }


    @Test
    public void shouldReturnTotalPriceWhenMultipleProductAdded() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE, 0.99);
        shoppingCart.addToCart(apple, 3);
        Product mask = new Product(ProductType.MASK, 1.99);
        shoppingCart.addToCart(mask, 3);
        double totalPrice = shoppingCart.getTotalPrice();
        Assert.assertEquals(8.94, totalPrice, 0.0);
    }


    @Test
    public void shouldThrowCustomExceptionWhenAListOfProductEmpty() throws ShoppingCartException {
        try {
            ShoppingCart shoppingCart = new ShoppingCart();
            Product apple = new Product(ProductType.APPLE, 0.99);
            double totalPrice = shoppingCart.getTotalPrice();
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
            shoppingCart.addToCart(apple, 3);
        } catch (ShoppingCartException ex) {
            Assert.assertEquals(ShoppingCartException.ExceptionType.NULL_PRODUCT_TYPE, ex.type);

        }

    }

    @Test
    public void shouldReturnTotalPriceToHandleSalesTaxWhenMultipleProductAdded() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE, 0.99);
        shoppingCart.addToCart(apple, 2);
        shoppingCart.addToCart(apple,1);
        Product mask = new Product(ProductType.MASK, 1.99);
        shoppingCart.addToCart(mask, 3);
        shoppingCart.getTotalPrice();
        double totalPriceWithsalesTax = shoppingCart.getTotalPriceWithSalesTax();
        Assert.assertEquals(9.12, totalPriceWithsalesTax, 0.0);
    }

    @Test
    public void shouldReturnTotalPriceToSupportOfferWhenMultipleProductAdded() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Offer offer = new Offer(OfferType.WITH_OFFER);
        Product apple = new Product(ProductType.APPLE, 0.99);
        apple.setOffer(offer);
        shoppingCart.addToCart(apple, 5);
        Offer noOffer = new Offer(OfferType.NO_OFFER);
        Product mask = new Product(ProductType.MASK, 1.99);
        mask.setOffer(noOffer);
        shoppingCart.addToCart(mask, 3);
        shoppingCart.getTotalPrice();
        double grandTotal = shoppingCart.getTotalPriceWithSalesTax();
        Assert.assertEquals(10.12, grandTotal, 0.0);
    }
}

