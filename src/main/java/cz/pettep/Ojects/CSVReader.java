package cz.pettep.Ojects;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVReader {
    public static List<Customer> readCustomerFromCSV (String fileName){
        List<Customer> customers = new ArrayList<>();
        Path pathToFile = Path.of(System.getProperty("user.home"), "BootCamp","INPUT","RS_1_Customer_20170201.csv");

        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {

            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Customer customer = createCustomer(attributes);
                customers.add(customer);
                line = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }
    private static Customer createCustomer(String [] metadata){
         String CU_OLD_ID = metadata[0] ;
        String CU_NAME= metadata[1];
        String CU_TYPE = metadata[2];
        String CU_ORIGIN_DATE =metadata[3];
        String CU_REG_DATE =metadata[4];
        String CU_PHONE_NUMBER = metadata[5] ;
        return new Customer(CU_OLD_ID,CU_NAME,CU_TYPE,CU_ORIGIN_DATE,CU_REG_DATE,CU_PHONE_NUMBER);
    }
}
