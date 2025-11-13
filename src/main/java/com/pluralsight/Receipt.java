package com.pluralsight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    public static void saveReceipt(Order order) {
        try {
            File folder = new File("Receipts");
            if (!folder.exists()) {
                folder.mkdir();
            }

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            File receipt = new File(folder, timestamp + ".txt");

            try (BufferedWriter writer= new BufferedWriter(new FileWriter(receipt))) {
                writer.write(order.getReceiptText());
                writer.newLine();

//                out.println(order.getReceiptText());
//                out.close();
            }
        } catch (Exception e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
