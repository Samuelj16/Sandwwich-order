package services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptService {
    public static void generateReceipt(OrderService orderService){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
        Date date = new Date();
        String fileName = formatter.format(date) + ".txt";

        try{
            File file = new File("receipts/"+fileName);
            file.createNewFile();

            FileWriter writer = new FileWriter(file);
            writer.write(orderService.toString()+"\n total = " + orderService.calculateTotal());
            writer.close();
            System.out.println("Receipt saved as " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
