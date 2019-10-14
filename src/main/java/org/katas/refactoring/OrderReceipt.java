package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {

    private static final String CONST_HEADER = "======Printing Orders======\n";
    private static final Double CONST_SALES_TAX = .10;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {

        StringBuilder receipt = new StringBuilder();

        double totSalesTx = 0d;
        double total = 0d;

        receipt.append(CONST_HEADER);
        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());


        for (LineItem lineItem : order.getLineItems()) {
            receipt.append(lineItem.getDescription()).append('\t');
            receipt.append(lineItem.getPrice()).append('\t');
            receipt.append(lineItem.getQuantity()).append('\t');
            receipt.append(lineItem.totalAmount()).append('\n');

            double salesTax = lineItem.totalAmount() * CONST_SALES_TAX;
            totSalesTx += salesTax;

            total += lineItem.totalAmount() + salesTax;
        }

        receipt.append("Sales Tax").append('\t').append(totSalesTx);

        receipt.append("Total Amount").append('\t').append(total);

        return receipt.toString();
    }
}