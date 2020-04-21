import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ShoppingCart {

    List<Product> products;

    private SalesTax salesTax;

    private BigDecimal bigDecimal;

    private double totalPrice = 0.0;


    public ShoppingCart() {
        this.products = new ArrayList<>();
        this.salesTax = new SalesTax();
    }

    public void addToCart(Product product, int quantity) throws ShoppingCartException {
        if (product.getProductType() == null) {
            throw new ShoppingCartException("null product type", ShoppingCartException.ExceptionType.NULL_PRODUCT_TYPE);
        }
        for (int i = 0; i < quantity; i++)
            products.add(product);
    }


    public double getTotalPrice() throws ShoppingCartException {
        if (products.isEmpty()) {
            throw new ShoppingCartException("Empty Product List", ShoppingCartException.ExceptionType.EMPTY_PRODUCTS);
        }
        totalPrice = this.totalPrice + products.stream().mapToDouble(product -> product.getProductPrice()).sum();
        return totalPrice;
    }

    public double getTotalPriceWithSalesTax() throws ShoppingCartException {
        double totalPrice = getTotalPrice();
        double grandTotal = this.totalPrice + salesTax.getSalesTax(totalPrice);
        double precisedTotal = Double.parseDouble(String.format("%.2f", grandTotal));;
        return precisedTotal;
    }


}

