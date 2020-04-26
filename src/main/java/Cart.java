import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> cartItems = new ArrayList<>();

    private CartOffer cartOffer;

    public Cart() {
    }

    public Cart(CartOffer cartOffer) {
        this.cartOffer = cartOffer;
    }

    public void addProduct(Product product, int quantity) throws NullProductTypeException, NullProductNameException {
        if(product == null){
            throw new NullProductTypeException("product should not be null");
        }
        CartItem existingCartItem = findCartItem(product.getName());
        if (existingCartItem != null) {
            existingCartItem.increaseQuantity(quantity);
        } else {
            CartItem newCartItem = new CartItem(product, quantity);
            cartItems.add(newCartItem);
        }
    }

    private CartItem findCartItem(String name) {
        return cartItems.stream().filter(cartItem -> {
            try {
                return cartItem.getName() == name;
            } catch (NullProductNameException e) {
                e.getMessage();
                return false;
            }
        }).findFirst().orElseThrow(null);
    }

    private double getItemsTotal() {
        return cartItems.stream().mapToDouble(CartItem::getPrice).sum();
    }

    public double getSalesTax() {
        return MoneyUtility.getSalesTax(getItemsTotal());
    }

    public double getTotal() {
        double totalPrice = getItemsTotal() + getSalesTax() - getDiscountByCartOffer();
        return MoneyUtility.format(totalPrice);
    }

    public double getDiscount() {
        double discount = cartItems.stream().mapToDouble(CartItem::getDiscount).sum() + getDiscountByCartOffer();
        return MoneyUtility.format(discount);
    }

    public double getDiscountByCartOffer() {
        if(cartOffer != null && getItemsTotal() > cartOffer.getLeastBuyPrice()) {
            return  (getItemsTotal() * cartOffer.getDiscountRate()) / 100;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(cartItems);
    }
}

