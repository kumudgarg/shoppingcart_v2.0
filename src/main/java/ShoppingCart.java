import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ShoppingCart {

    List<Product> products;

    private SalesTax salesTax;

    private Product product;

    private double totalPrice = 0.0;

    private Offer offer;

    public ShoppingCart() {
        this.products = new ArrayList<>();
        this.salesTax = new SalesTax();
        this.offer = new Offer();
    }

    public void addToCart(Product product, int quantity) throws ShoppingCartException {
        if (product.getProductType() == null) {
            throw new ShoppingCartException("null product type", ShoppingCartException.ExceptionType.NULL_PRODUCT_TYPE);
        }
        this.product = product;
        int revisedQuantity = product.getOffer().getQuantity(quantity);
        for (int i = 0; i < revisedQuantity; i++)
            products.add(product);
    }


    public double getTotalPrice() throws ShoppingCartException {
        if (products.isEmpty()) {
            throw new ShoppingCartException("Empty Product List", ShoppingCartException.ExceptionType.EMPTY_PRODUCTS);
        }
        totalPrice = products.stream().mapToDouble(product -> product.getProductPrice()).sum();
        return totalPrice;
    }

    public double getTotalPriceWithSalesTax() throws ShoppingCartException {
        totalPrice = totalPrice - getDiscount();
        double grandTotal = this.totalPrice + salesTax.getSalesTax(totalPrice);
        double roundedTotal = Double.parseDouble(String.format("%.2f", grandTotal));
        return roundedTotal;
    }


    public double getDiscount(){
        double discount = product.getOffer().getFreeProduct() * product.getProductPrice();
        return discount;
    }

    public double getGrandTotal() throws ShoppingCartException {
        double grandTotal = getTotalPriceWithSalesTax() - getDiscount();
        return grandTotal;
    }


}

