import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CartTest {

    @Test
    public void shouldHaveContentAndTotalWhenSingleProductIsAdded() {
        Cart cart = new Cart();
        Product apple = new Product("apple", 0.99);
        cart.addProduct(apple, 5);
        double totalPrice = cart.getTotal();
        assertEquals(5.05, totalPrice, 0.01);
        assertEquals("Cart{cartItems=[CartItem{product=Product{name='apple', price=0.99}, quantity=5}]}", cart.toString());
    }

    @Test
    public void shouldReturnZeroCartSizeWhenAListOfProductEmpty() {
        Cart cart = new Cart();
        double totalPrice = cart.getTotal();
        assertEquals(0, totalPrice, 0.0);
    }

    @Test
    public void shouldReturnTotalPriceAndSalesTaxWhenMultipleProductAdded() {
        Cart cart = new Cart();
        Product apple = new Product("apple", 0.99);
        cart.addProduct(apple, 2);
        cart.addProduct(apple, 1);
        Product mask = new Product("mask", 1.99);
        cart.addProduct(mask, 3);

        double total = cart.getTotal();
        //TODO:get sales tax and content
        assertEquals(9.12, total, 0.0);
    }

    @Test
    public void shouldReturnTotalPriceToSupportOfferWhenMultipleProductAdded() {
        Cart shoppingCart = new Cart();
        Product apple = new Product("Apple", 0.99, new BuyXGetYOffer(2, 1));
        Product mask = new Product("Mask", 1.99);
        shoppingCart.addProduct(apple, 5);
        shoppingCart.addProduct(mask, 3);

        assertEquals(0.2, shoppingCart.getSalesTax(), 0.01);
        assertEquals(0.99, shoppingCart.getDiscount(), 0.01);
        assertEquals(10.13, shoppingCart.getTotal(), 0.01);
    }

    @Test
    public void shouldReturnTotalPriceToSupportCartOfferWhenMultipleProductAdded() {
        Cart shoppingCart = new Cart(new CartOffer(10,10));
        Product apple = new Product("Apple", 0.99, new BuyXGetYOffer(2, 1));
        Product mask = new Product("Mask", 1.99);
        shoppingCart.addProduct(apple, 10);
        shoppingCart.addProduct(mask, 3);
        assertEquals(0.26, shoppingCart.getSalesTax(), 0.01);
        assertEquals(4.26, shoppingCart.getDiscount(), 0.01);
        assertEquals(1.29, shoppingCart.getDiscountByCartOffer(),0.01);
        assertEquals(11.87, shoppingCart.getTotal(), 0.01);
    }

}


