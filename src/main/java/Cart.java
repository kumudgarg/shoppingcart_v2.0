import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> cartItems = new ArrayList<>();

    private CartOffer cartOffer;

    private double discount;

    private double totalPrice;

    public Cart() {
        this.cartOffer = null;
    }

    public Cart(CartOffer cartOffer) {
        this.cartOffer = cartOffer;
    }

    public void addProduct(Product product, int quantity) {
        CartItem existingCartItem = findCartItem(product.getName());
        if (existingCartItem != null) {
            existingCartItem.increaseQuantity(quantity);
        } else {
            CartItem newCartItem = new CartItem(product, quantity);
            cartItems.add(newCartItem);
        }

    }

    private CartItem findCartItem(String name) {
        return cartItems.stream().filter(cartItem -> cartItem.getName() == name).findFirst().orElse(null);
    }

    private double getItemsTotal() {
        totalPrice = cartItems.stream().mapToDouble(cartItems -> cartItems.getPrice()).sum();
        return totalPrice;
    }


    private double getDiscountByProductOffer() {
        discount = cartItems.stream().mapToDouble(CartItem::getDiscount).sum();
        return discount;
    }

    public double getSalesTax() {
        return MoneyUtility.getSalesTax(totalPrice - discount);
    }

    public double getTotal() {
        double grandTotal = getItemsTotal() - getTotalDiscount() + getSalesTax();
        return MoneyUtility.format(grandTotal);
    }

    public double getTotalDiscount() {
        double cartDiscount = 0.0;
        discount = getDiscountByProductOffer();
        if(cartOffer !=  null)
          cartDiscount = cartOffer.getDiscountByCartOffer(totalPrice, discount);
        discount += cartDiscount;
        return MoneyUtility.format(discount);
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(cartItems);
    }
}

