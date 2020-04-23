import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> products = new ArrayList<>();

    private double discount = 0.0;

    private double totalPrice = 0.0;

    public void addToCart(Product product, int quantity) throws ShoppingCartException {
        if (product.getProductType() == null) {
            throw new ShoppingCartException("null product type");
        }

        int revisedQuantity = quantity;
        if (product.getOffer() != null) {
            revisedQuantity = product.getOffer().getQuantity(quantity); //law of demeter
            updateDiscount(product);
        }

        for (int i = 0; i < revisedQuantity; i++)
            products.add(product);
    }

    public double getTotalPrice() throws ShoppingCartException {
        if (products.isEmpty()) {
            throw new ShoppingCartException("Empty Product List");
        }
        totalPrice = products.stream().mapToDouble(product -> product.getProductPrice()).sum();
        return totalPrice;
    }

    public double getGrandTotalPriceWithSalesTax() {
        totalPrice = totalPrice - (discount + CartOffer.getDiscountByCartOffer(totalPrice));
        double grandTotal = this.totalPrice + SalesTax.getSalesTax(totalPrice);
        return Double.parseDouble(String.format("%.2f", grandTotal));
    }

    public void updateDiscount(Product product) {
        int freeProduct = product.getOffer().getFreeProduct();
        discount += freeProduct * product.getProductPrice();
    }

    public int getCartSize() {
        return products.size();
    }

}

