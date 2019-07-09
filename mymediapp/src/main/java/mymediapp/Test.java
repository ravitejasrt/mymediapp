package mymediapp;

import java.sql.*;

public class Test {

	public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:postgresql://ec2-50-17-227-28.compute-1.amazonaws.com:5432/dct6531hfmt0r3";
        String username = "lumkepkqyitrty";
        String password = "2dfc739f4667694d0be4368ea47cabe68447a95116e5084f2088fedd7fffa87a";
        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM company");
            while (rs.next()) {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString(2));
                System.out.print("Column 2 returned ");
                System.out.println(rs.getString(3));
            }
            rs.close();
            st.close();
            }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
/*
 spring.jpa.database = POSTGRESQL
spring.datasource.platform = postgres
spring.datasource.url = jdbc:postgresql://isilo.db.elephantsql.com:5432/gmblwixk?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory
spring.datasource.username = gmblwixk
spring.datasource.password = j8ZZm2ynllULXbe6allhdodWCtUlM5jj




spring.datasource.driver-class-name = org.postgresql.Driver

spring.datasource.testWhileIdle = true
#spring.datasource.validationQuery = SELECT 1
spring.datasource.timeBetweenEvictionRunsMillis = 3600000
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update

spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect


spring.jpa.properties.jadira.usertype.autoRegisterUserTypes = true                                
                                
 * */
 