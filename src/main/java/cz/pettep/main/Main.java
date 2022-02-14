package cz.pettep.main;

import cz.pettep.dao.TestRepository;
import cz.pettep.database.ConnectionFactory;
import cz.pettep.entity.Test;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

            try (Connection conn = new ConnectionFactory().createConnection();) {

                List<Test> list =  TestRepository.getAllTests(conn);
                for (Test test : list){
                    System.out.println(test);
                }

            } catch (SQLException ex) {
                System.out.println("Chyba při komunikaci s databází");
            }

    }
}