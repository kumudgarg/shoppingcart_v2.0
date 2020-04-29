import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> cartItems = new ArrayList<>();

    private CartOffer cartOffer;

    private double discount;

    private double totalPrice;

    private double salesTax;

    public Cart() {
        this.cartOffer = null;
    }

    public Cart(CartOffer cartOffer) {
        this.cartOffer = cartOffer;
    }

    public void addProduct(Product product, int quantity) throws NullProductOrNullProductNameTypeException {
       try {
           CartItem existingCartItem = findCartItem(product.getName());
           if (existingCartItem != null) {
               existingCartItem.increaseQuantity(quantity);
           } else {
               CartItem newCartItem = new CartItem(product, quantity);
               cartItems.add(newCartItem);
           }
           updateActualTotal();
           updateDiscountByProductOffer();
           updateDiscountByCartOffer();
           updateSalesTax();
       }catch (NullPointerException ex){
           throw  new NullProductOrNullProductNameTypeException("either product is null or product name");
       }

    }

    private CartItem findCartItem(String name) {
        return cartItems.stream().filter(cartItem -> cartItem.getName() == name).findFirst().orElse(null);
    }

    private double updateActualTotal() {
        totalPrice = cartItems.stream().mapToDouble(cartItems -> cartItems.getPrice()).sum();
        return totalPrice;
    }


    private double updateDiscountByProductOffer() {
        discount = cartItems.stream().mapToDouble(CartItem::getDiscount).sum();
        return discount;
    }

    private double updateDiscountByCartOffer() {
        if(cartOffer != null)
            discount += cartOffer.getDiscountByCartOffer(totalPrice, discount);
        return discount;
    }

    private double updateSalesTax() {
        salesTax =  MoneyUtility.getSalesTax(totalPrice - discount);
        return salesTax;
    }

    public double getSalesTax(){
        return salesTax;
    }

    public double getTotal() {
        double grandTotal = totalPrice - discount + salesTax;
        return MoneyUtility.format(grandTotal);
    }

    public double getTotalDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(cartItems);
    }
}

