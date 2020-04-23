import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {

    @Test
    public void shouldReturnTrueWhenASingleProductAdded() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE, 0.99);
        shoppingCart.addToCart(apple, 2);
        int size = shoppingCart.getCartSize(); //design damage
        Assert.assertEquals(2, size);
    }

    @Test
    public void shouldReturnTotalPriceWhenASingleProductAdded() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE, 0.99);
        shoppingCart.addToCart(apple, 5);
        double totalPrice = shoppingCart.getTotalPrice();
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
            Assert.assertEquals("Empty Product List", ex.getMessage());
        }
    }


    @Test
    public void shouldThrowCustomExceptionWhenNullProductTypeAdded() throws ShoppingCartException {
        try {
            ShoppingCart shoppingCart = new ShoppingCart();
            Product apple = new Product(null, 0.99);
            shoppingCart.addToCart(apple, 3);
        } catch (ShoppingCartException ex) {
            Assert.assertEquals("null product type", ex.getMessage());


        }
//TODO: What will the test fail?
    }

    @Test
    public void shouldReturnTotalPriceToHandleSalesTaxWhenMultipleProductAdded() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE, 0.99);
        shoppingCart.addToCart(apple, 2);
        shoppingCart.addToCart(apple, 1);
        Product mask = new Product(ProductType.MASK, 1.99);
        shoppingCart.addToCart(mask, 3);
        shoppingCart.getTotalPrice();
        double totalPriceWithsalesTax = shoppingCart.getGrandTotalPriceWithSalesTax();
        Assert.assertEquals(9.12, totalPriceWithsalesTax, 0.0);
    }

    @Test
    public void shouldReturnTotalPriceToSupportOfferWhenMultipleProductAdded() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE, 0.99);
        Offer offer = new Offer(2, 3);
        apple.setOffer(offer);
        shoppingCart.addToCart(apple, 5);
        Product mask = new Product(ProductType.MASK, 1.99);
        shoppingCart.addToCart(mask, 3);
        shoppingCart.getTotalPrice();
        double grandTotal = shoppingCart.getGrandTotalPriceWithSalesTax();
        Assert.assertEquals(10.13, grandTotal, 0.0);
    }

    @Test
    public void shouldReturnTotalPriceToSupportMoreOfferWhenMultipleProductAdded() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product(ProductType.APPLE, 0.99);
        Offer offer = new Offer(2, 3);
        apple.setOffer(offer);
        shoppingCart.addToCart(apple, 10);
        Product mask = new Product(ProductType.MASK, 1.99);
        shoppingCart.addToCart(mask, 3);
        shoppingCart.getTotalPrice();
        double grandTotal = shoppingCart.getGrandTotalPriceWithSalesTax();
        Assert.assertEquals(13.16, grandTotal, 0.0);
    }

    @Test
    public void shouldReturnTotalPriceToSupportMoreOfferForCartProducts() throws ShoppingCartException {
        ShoppingCart shoppingCart = new ShoppingCart();
        CartOffer.setDiscountRateAndleastLimitProduct(10, 10);
        Product apple = new Product(ProductType.APPLE, 0.99);
        Offer offer = new Offer(2, 3);
        apple.setOffer(offer);
        shoppingCart.addToCart(apple, 10);
        Product mask = new Product(ProductType.MASK, 1.99);
        shoppingCart.addToCart(mask, 3);
        shoppingCart.getTotalPrice();
        double grandTotal = shoppingCart.getGrandTotalPriceWithSalesTax();
        Assert.assertEquals(11.54, grandTotal, 0.0);
    }



}

