package io.transwarp.complexsearch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    static {
        try {
            Class.forName(Constant.DRIVER_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            if (Constant.MODE.equals("simple")) {
                connection = DriverManager.getConnection(Constant.SIMPLE_JDBC_URL);
            } else if (Constant.MODE.equals("LDAP")) {
                connection = DriverManager.getConnection(Constant.LDAP_JDBC_URL,
                        Constant.LDAP_NAME, Constant.LDAP_PASSWD);
            } else {
                connection = DriverManager.getConnection(Constant.KERBEROS_JDBC_URL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
