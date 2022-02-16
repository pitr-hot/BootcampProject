package cz.pettep.csv;

import cz.pettep.entity.Customer;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {
    public static List<Customer> readCustomerFromCSV(String fileName) {
        List<Customer> customers = new ArrayList<>();
        File pathToFile = new File(System.getProperty("user.home") + File.separator + "BootCamp" + File.separator + "INPUT" + File.separator + "RS_1_Customer_20170201.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String[] firstString = br.readLine().split(",");
            if (firstString[0] != "oldId" && firstString[1] != "name" && firstString[2] != "custType" && firstString[3] != "originDate" && firstString[4] != "custRegDate" && firstString[5] != "phoneNumber" && firstString.length != 6) {
                System.out.println("Invalid header of CSV document");
                System.exit(0);
            }
            String line = br.readLine();
            while (line != null) {
                String[] attributes = splitCSV(line);
                if (attributes.length != 6) {
                    System.out.println("Invalid data from " + pathToFile.getName() + "!");
                    System.exit(0);
                }
                Customer customer = createCustomer(attributes);
                for (Customer x : customers){
                    if (x.CU_OLD_ID ==customer.CU_OLD_ID){
                        System.out.println("Duplicate value in customer ID!");
                        System.exit(0);
                    }
                }
                customers.add(customer);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    private static Customer createCustomer(String[] metadata) {
        int CU_OLD_ID = Integer.parseInt(metadata[0]);
        String CU_NAME = metadata[1];
        char CU_TYPE = customerTypeController(metadata[2]);
        LocalDate CU_ORIGIN_DATE = dateConverter(metadata[3]);
        LocalDate CU_REG_DATE = dateConverter(metadata[4]);
        Integer CU_PHONE_NUMBER = phoneNumberConverter(metadata[5]);
        return new Customer(CU_OLD_ID, CU_NAME, CU_TYPE, CU_ORIGIN_DATE, CU_REG_DATE, CU_PHONE_NUMBER);
    }


    public static String[] splitCSV(String s) {
        int startPosition = 0;
        ArrayList<String> myList = new ArrayList<>();
        boolean isInQuotes = false;
        for (int currentPosition = 0; currentPosition < s.length(); currentPosition++) {
            if (s.charAt(currentPosition) == '\"') {
                isInQuotes = !isInQuotes;
            } else if (s.charAt(currentPosition) == ',' && isInQuotes == false) {
                myList.add(s.substring(startPosition, currentPosition));
                startPosition = currentPosition + 1;
            }
        }
        String lastLine = s.substring(startPosition);
        myList.add(lastLine);
        String[] output = new String[myList.size()];
        int i = 0;
        for (String st : myList) {
            output[i] = st;
            i++;
        }
        return output;
    }

    public static LocalDate dateConverter(String date) {
        LocalDate dateOutput = null;
        try {
            dateOutput = LocalDate.parse(date);
        } catch (DateTimeParseException ex) {
            System.out.println("Wrong date format!");
            System.exit(0);
        }
        return dateOutput;
    }

    public static char customerTypeController(String s) {
        char output = s.charAt(0);
        if (s.length() != 1 && (output != 'B' || output != 'P')) {
            System.out.println("Invalid Customer type");
            System.exit(0);
        }
        return output;
    }

    public static Integer phoneNumberConverter(String s){
        Integer output=null;
        if (s.length() != 9) {
            System.out.println("Invalid phone number!");
            System.exit(0);
        }
        try{
            output = Integer.parseInt(s);
        }

        catch (NumberFormatException e){
            System.out.println("Invalid phone number!");
            System.exit(0);
        }
        return  output;
    }
}
