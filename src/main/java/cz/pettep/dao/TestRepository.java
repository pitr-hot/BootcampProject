package cz.pettep.dao;

import cz.pettep.entity.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestRepository {
    public static List<Test> getAllTests(Connection conn) throws SQLException
    {
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM test");
             ResultSet rs = ps.executeQuery();) {
            List<Test> listTest = new ArrayList<>();
            while (rs.next()) {
                listTest.add(new Test(rs.getInt("ID"), rs.getString("NAME")));

            }
            return listTest;
        }
    }
}
