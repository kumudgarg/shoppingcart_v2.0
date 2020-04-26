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
        assertEquals("[{\"product\":{\"name\":\"apple\",\"price\":0.99},\"quantity\":5}]", cart.toString());
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
        assertEquals(0.18,cart.getSalesTax(), 0.01);
        assertEquals(9.12, total, 0.01);
        assertEquals("[{\"product\":{\"name\":\"apple\",\"price\":0.99},\"quantity\":3},{\"product\":{\"name\":\"mask\",\"price\":1.99},\"quantity\":3}]", cart.toString());
    }

    @Test
    public void shouldReturnTotalPriceToSupportOfferWhenMultipleProductAdded() {
        Cart cart = new Cart();
        Product apple = new Product("Apple", 0.99, new BuyXGetYOffer(2, 1));
        Product mask = new Product("Mask", 1.99);
        cart.addProduct(apple, 5);
        cart.addProduct(mask, 3);
        assertEquals(0.2, cart.getSalesTax(), 0.01);
        assertEquals(0.99, cart.getDiscount(), 0.01);
        assertEquals(10.13, cart.getTotal(), 0.01);
        assertEquals("[{\"product\":{\"name\":\"Apple\",\"price\":0.99,\"offer\":{\"buyQuantity\":2,\"freeQuantity\":1}},\"quantity\":5},{\"product\":{\"name\":\"Mask\",\"price\":1.99},\"quantity\":3}]",cart.toString());
    }

    @Test
    public void shouldReturnTotalPriceToSupportCartOfferWhenMultipleProductAdded() {
        Cart cart = new Cart(new CartOffer(10,10));
        Product apple = new Product("Apple", 0.99, new BuyXGetYOffer(2, 1));
        Product mask = new Product("Mask", 1.99);
        cart.addProduct(apple, 10);
        cart.addProduct(mask, 3);
        assertEquals(0.26, cart.getSalesTax(), 0.01);
        assertEquals(4.26, cart.getDiscount(), 0.01);
        assertEquals(1.29, cart.getDiscountByCartOffer(),0.01);
        assertEquals(11.87, cart.getTotal(), 0.01);
        assertEquals("[{\"product\":{\"name\":\"Apple\",\"price\":0.99,\"offer\":{\"buyQuantity\":2,\"freeQuantity\":1}},\"quantity\":10},{\"product\":{\"name\":\"Mask\",\"price\":1.99},\"quantity\":3}]", cart.toString());
    }

}


