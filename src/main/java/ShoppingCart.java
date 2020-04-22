import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {

    List<Product> products;

    private SalesTax salesTax;

    private Product product;

    private double discount;

    private double totalPrice = 0.0;

    public ShoppingCart() {
        this.products = new ArrayList<>();
        this.salesTax = new SalesTax();
    }

    public void addToCart(Product product, int quantity) throws ShoppingCartException {
        if (product.getProductType() == null) {
            throw new ShoppingCartException("null product type", ShoppingCartException.ExceptionType.NULL_PRODUCT_TYPE);
        }
        this.product = product;
        int revisedQuantity = product.getOffer().getQuantity(quantity); //law of demeter
        getDiscount();
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
        totalPrice = totalPrice - discount;
        double grandTotal = this.totalPrice + salesTax.getSalesTax(totalPrice);
        double roundedTotal = Double.parseDouble(String.format("%.2f", grandTotal));
        return roundedTotal;
    }

    public double getDiscount() {
        int freeProduct = product.getOffer().getFreeProduct();
        discount = discount + freeProduct * product.getProductPrice();
        return this.discount;
    }

}

