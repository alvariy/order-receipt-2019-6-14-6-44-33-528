package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {

    public static final char TAB = '\t';
    private static final String CONST_HEADER = "======Printing Orders======\n";
    private static final Double CONST_SALES_TAX = .10;
    public static final char NEW_LINE = '\n';
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();

        receipt.append(CONST_HEADER);
        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());

        for (LineItem lineItem : order.getLineItems()) {
            getInformation(receipt, lineItem);
        }

        receipt.append("Sales Tax").append(TAB).append(computeTax());
        receipt.append("Total Amount").append(TAB).append(computeTotal());

        return receipt.toString();
    }

    private void getInformation(StringBuilder receipt, LineItem lineItem) {
        receipt.append(lineItem.getDescription()).append(TAB);
        receipt.append(lineItem.getPrice()).append(TAB);
        receipt.append(lineItem.getQuantity()).append(TAB);
        receipt.append(lineItem.totalAmount()).append(NEW_LINE);
    }

    private double computeSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * CONST_SALES_TAX;
    }

    public double computeTax()
    {
        double totSalesTx = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            totSalesTx += computeSalesTax(lineItem);
        }
        return totSalesTx;
    }

    public double computeTotal()
    {
        double total = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            total += lineItem.totalAmount();
        }
        return total + computeTax();
    }
}