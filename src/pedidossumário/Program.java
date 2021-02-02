/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedidossumário;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Mateus
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth Date(DD/MM/YYYY): ");
        Date clientBirthDate = sdf.parse(sc.next());
        Date orderMoment = new Date();
        sc.nextLine();

        Client client = new Client(clientName, clientEmail, clientBirthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(orderMoment, status, client);

        System.out.println("");

        System.out.print("How many items to this order?: ");
        int nItems = sc.nextInt();
        System.out.println("");

        for (int i = 1; i <= nItems; i++) {
            sc.nextLine();
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price:  ");
            Double productPrice = sc.nextDouble();
            System.out.print("Quantity:  ");
            int productQuantity = sc.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem item = new OrderItem(productQuantity, productPrice, product);

            order.addItem(item);
            System.out.println("");
        }

        System.out.println("");

        System.out.println("ORDER SUMARY: ");
        System.out.println(order);

        sc.close();
    }

}
