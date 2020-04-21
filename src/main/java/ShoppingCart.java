import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ShoppingCart {

    private boolean flag;

     List<Product> products;

    private SalesTax salesTax;

    private DecimalFormat df;

    private final String PATTERN = "#.##";

    private double totalPrice = 0.0;

    private int limit;

    private int quantity;

    public ShoppingCart() {
        this.flag = false;
        this.products = new ArrayList<>();
        this.salesTax = new SalesTax();
        this.df = new DecimalFormat(this.PATTERN);
    }

    public void addToCart(Product product, int quantity) throws ShoppingCartException {
        this.quantity = quantity;
        if(product.getProductType() == null){
            throw new ShoppingCartException("null product type", ShoppingCartException.ExceptionType.NULL_PRODUCT_TYPE);
        }
        for (int i = 0; i < quantity; i++)
            products.add(product);
    }


    public double getTotalPrice() throws ShoppingCartException {
        if(products.isEmpty()){
            throw new ShoppingCartException("Empty Product List", ShoppingCartException.ExceptionType.EMPTY_PRODUCTS);
        }

        totalPrice = this.totalPrice + products.stream().mapToDouble(product -> product.getProductPrice()).sum();
        return totalPrice;

//
//        }

//    public String getTotalPriceWithsalesTax(double totalPrice){
//        double grandTotal = totalPrice + salesTax.getSalesTax(totalPrice);
//        String format = df.format(grandTotal);
//        return format;
//    }

    }
}
