public class SalesTax {

    private static final double SALES_TAX_RATE = 2.0;

    public static double getSalesTax(double price){
        double salesTax = (price * SALES_TAX_RATE) / 100;
        return salesTax;
    }
}
