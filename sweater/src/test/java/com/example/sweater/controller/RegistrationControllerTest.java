package com.example.sweater.controller;

import com.example.sweater.domain.User;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.UserException;
import org.postgresql.Driver;
import org.postgresql.core.Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationControllerTest {

    @Test
    void TLogValidation() {
        User nuser = new User();
        nuser.setUsername("Anton");
        nuser.setPassword("123");
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        boolean flag = nuser.getUsername().matches(pattern);
        assertTrue(flag);

    }

    @Test
    void TPasValidation() {
        User nuser = new User();
        nuser.setUsername("Anton");
        nuser.setPassword("L+6$6l");
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        boolean flag = nuser.getPassword().matches(pattern);
        assertTrue(flag);

    }

    @Test
    void FLogValidation() {
        User nuser = new User();
        nuser.setUsername("ShreK1$+777");
        nuser.setPassword("123");
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        boolean flag = nuser.getUsername().matches(pattern);
        assertFalse(flag);

    }
    @Test
    void FpPasValidation() {
        User nuser = new User();
        nuser.setUsername("ShreK1$+777");
        nuser.setPassword("123");
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        boolean flag = nuser.getUsername().matches(pattern);
        assertFalse(flag);

    }

    @Test
    void UsercountAnd() throws SQLException {
        User neuser = new User();
        neuser.setUsername("ChiefKeef+6$6");
        neuser.setPassword("L+6$6l");
        String login = neuser.getUsername();
        String pas = neuser.getPassword();

        String url = "jdbc:postgresql://localhost/userss";
        try {
            DriverManager.registerDriver(new Driver());
            Connection conn = DriverManager.getConnection(url,"postgres", "123");
            Statement stat = conn.createStatement();

            Statement stH2 = (Statement) conn.createStatement();
            String insert = "SELECT * FROM usr WHERE username = '"+login+"' and password = '"+pas+"'";


            boolean flag1 = (stH2.executeQuery(insert)!=null);
            assertTrue(flag1);




        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    @Test
    void UsercountF() throws SQLException {
        User neuser = new User();
        neuser.setUsername("KROL");
        neuser.setPassword("322");
        String login = neuser.getUsername();
        String pas = neuser.getPassword();

        String url = "jdbc:postgresql://localhost/userss";
        try {
            DriverManager.registerDriver(new Driver());
            Connection conn = DriverManager.getConnection(url,"postgres", "123");
            Statement stat = conn.createStatement();

            Statement stH2 = (Statement) conn.createStatement();
            String insert = "SELECT * FROM usr WHERE username = '"+login+"' and password = '"+pas+"'";


            boolean flag1 = (stH2.executeQuery(insert)!=null);
            assertFalse(flag1);




        } catch (SQLException e1) {

            e1.printStackTrace();
        }
    }
}
