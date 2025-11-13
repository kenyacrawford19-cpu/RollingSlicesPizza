package com.pluralsight;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

            try (PrintWriter out = new PrintWriter(receipt)) {
                out.println(order.getReceiptText());
            }
        } catch (Exception e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
