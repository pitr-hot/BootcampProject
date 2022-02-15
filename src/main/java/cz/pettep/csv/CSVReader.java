package cz.pettep.csv;

import cz.pettep.entity.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {
    public static List<Customer> readCustomerFromCSV (String fileName){
        List<Customer> customers = new ArrayList<>();
        File pathToFile =new  File(System.getProperty("user.home")+File.separator+ "BootCamp"+File.separator+"INPUT"+File.separator+"RS_1_Customer_20170201.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = splitCSV(line);
  //              if (attributes.length != 6){
  //                  System.out.println("Invalid data from "+fileName+"!");
  //                  System.exit(0);
 //               }
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
        String CU_OLD_ID =metadata[0];
        String CU_NAME= metadata[1];
        String CU_TYPE = metadata[2];
        String CU_ORIGIN_DATE =metadata[3];
        String CU_REG_DATE =metadata[4];
        String CU_PHONE_NUMBER =metadata[5];
        return new Customer(CU_OLD_ID,CU_NAME,CU_TYPE,CU_ORIGIN_DATE,CU_REG_DATE,CU_PHONE_NUMBER);
    }

    public static String[] splitCSV (String s){
        int startPosition = 0;
        List<String> mylist = new ArrayList<>();
        boolean isInQuotes=false;
        for (int currentPosition = 0;currentPosition <s.length();currentPosition++){
            if (s.charAt(currentPosition) == '\"') {
                isInQuotes = !isInQuotes;
            }
            else if (s.charAt(currentPosition) == ',' && !isInQuotes) {
                mylist.add(s.substring(startPosition, currentPosition));
                startPosition = currentPosition + 1;
            }
        }
        String lastLine = s.substring(startPosition);
        mylist.add(lastLine);
        String[] output = new String[mylist.size()];
        int i = 0;
        for (String st : mylist) {
            output[i] = st;
            i++;
        }
        return output;
    }
}
