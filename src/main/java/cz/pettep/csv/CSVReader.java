package cz.pettep.csv;

import cz.pettep.entity.Customer;
import cz.pettep.entity.Repair;
import cz.pettep.entity.Vehicle;

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
  //          if (firstString[0].equals("oldId") || firstString[1].equals("name") || firstString[2].equals("custType") || firstString[3].equals("originDate") || firstString[4].equals("custRegDate") || firstString[5].equals("phoneNumber") || firstString.length != 6) {
  //              System.out.println("Invalid header of CSV document");
  //              System.exit(0);
  //          }
            String line = br.readLine();
            while (line != null) {
                String[] attributes = splitCSV(line);
                if (attributes.length != 6) {
                    System.out.println("Invalid data from " + pathToFile.getName() + "!");
                    System.exit(0);
                }
                Customer customer = createCustomer(attributes);
                for (Customer x : customers) {
                    if (x.CU_OLD_ID == customer.CU_OLD_ID) {
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

    public static List<Vehicle> readVehicleFromCSV(String fileName) {
        List<Vehicle> vehicles = new ArrayList<>();
        File pathToFile = new File(System.getProperty("user.home") + File.separator + "BootCamp" + File.separator + "INPUT" + File.separator + "RS_1_Vehicle_20170201.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String[] firstString = br.readLine().split(",");
//            if (firstString[0].equals("oldId") || firstString[1].equals("name") || firstString[2].equals("custType") || firstString[3].equals("originDate")  || firstString[4].equals("custRegDate") || firstString[5].equals("phoneNumber") || firstString.length != 6) {
//                System.out.println("Invalid header of CSV document");
//                System.exit(0);
//            }
            String line = br.readLine();
            while (line != null) {
                String[] attributes = splitCSV(line);
                if (attributes.length != 14) {
                    System.out.println("Invalid data from " + pathToFile.getName() + "!");
                    System.exit(0);
                }
                Vehicle vehicle = createVehicle(attributes);
                for (Vehicle x : vehicles) {
                    if (x.VEH_OLD_ID == vehicle.VEH_OLD_ID) {
                        System.out.println("Duplicate value in vehicle ID!");
                        System.exit(0);
                    }
                }
                vehicles.add(vehicle);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public static List<Repair> readRepairFromCSV(String fileName) {
        List<Repair> repairs = new ArrayList<>();
        File pathToFile = new File(System.getProperty("user.home") + File.separator + "BootCamp" + File.separator + "INPUT" + File.separator + "RS_3_RepairItem_20171201.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String[] firstString = br.readLine().split(",");
//            if (firstString[0].equals("oldId") || firstString[1].equals("name") || firstString[2].equals("custType") || firstString[3].equals("originDate")  || firstString[4].equals("custRegDate") || firstString[5].equals("phoneNumber") || firstString.length != 6) {
//                System.out.println("Invalid header of CSV document");
//                System.exit(0);
//            }
            String line = br.readLine();
            while (line != null) {
                String[] attributes = splitCSV(line);
                if (attributes.length != 5) {
                    System.out.println("Invalid data from " + pathToFile.getName() + "!");
                    System.exit(0);
                }
                Repair repair = createRepair(attributes);
                for (Repair x : repairs) {
                    if (x.RE_OLD_ID == repair.RE_OLD_ID) {
                        System.out.println("Duplicate value in repair ID!");
                        System.exit(0);
                    }
                }
                repairs.add(repair);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return repairs;
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

    private static Vehicle createVehicle(String[] metadata) {
        int VEH_OLD_ID = Integer.parseInt(metadata[0]);
        int VEH_CU_ID = Integer.parseInt(metadata[1]);
        String VEH_VIN = metadata[2];
        LocalDate VEH_REG_DATE = dateConverter(metadata[3]);
        String VEH_REG_COUNTRY = metadata[4];
        String VEH_MANUFACTURER = metadata[5];
        String VEH_TYPE = metadata[6];
        String VEH_BODY = metadata[7];
        String VEH_ENGINE = metadata[8];
        String VEH_RESTRAINT = metadata[9];
        String VEH_MODEL = metadata[10];
        int VEH_YEAR = Integer.parseInt(metadata[11]);
        String VEH_PLANT = metadata[12];
        String VEH_SERIAL_NUMBER = metadata[13];
        return new Vehicle(VEH_OLD_ID, VEH_CU_ID, VEH_VIN, VEH_REG_DATE, VEH_REG_COUNTRY, VEH_MANUFACTURER, VEH_TYPE, VEH_BODY, VEH_ENGINE, VEH_RESTRAINT, VEH_MODEL, VEH_YEAR, VEH_PLANT, VEH_SERIAL_NUMBER);
    }

    private static Repair createRepair(String[] metadata) {
        int RE_OLD_ID = Integer.parseInt(metadata[0]);
        int RE_VEH_OLD_ID = Integer.parseInt(metadata[1]);
        int RE_DET_ID = Integer.parseInt(metadata[2]);
        int RE_SHOP_ID = Integer.parseInt(metadata[3]);
        LocalDate RE_BILL_DATE = dateConverter(metadata[4]);
        return new Repair(RE_OLD_ID, RE_VEH_OLD_ID, RE_DET_ID, RE_SHOP_ID, RE_BILL_DATE);
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

    public static Integer phoneNumberConverter(String s) {
        Integer output = null;
        if (s.length() != 9) {
            System.out.println("Invalid phone number!");
            System.exit(0);
        }
        try {
            output = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Invalid phone number!");
            System.exit(0);
        }
        return output;
    }
}
