package cz.pettep.main;

import cz.pettep.csv.CSVReader;
import cz.pettep.entity.Customer;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        /* try (Connection conn = new ConnectionFactory().createConnection();) {

                List<Test> list =  TestRepository.getAllTests(conn);
                for (Test test : list){
                    System.out.println(test);
                }

            } catch (SQLException ex) {
                System.out.println("Chyba při komunikaci s databází");
            }
*/
             List<Customer> customers = CSVReader.readCustomerFromCSV("cus");

           for (Customer b : customers) {
               System.out.println(b);
           }

        String[] o = CSVReader.splitCSV("2,\"Rostislav ,ProchĂˇzka\",P,1946-08-13,1979-10-19,558273600");
        for (int i = 0;i<o.length;i++){
            System.out.println(o[i]);
        }
    }
}