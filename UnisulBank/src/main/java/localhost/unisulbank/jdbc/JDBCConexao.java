/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package localhost.unisulbank.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 1072222792
 */
public class JDBCConexao {
    private static Connection con;  
    private static String url = "jdbc:postgresql://localhost:5432/bank";
    private static String user = "herik";
    private static String password = "123";
     
    public static Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url ,user, password);
            return con;
        } catch (Exception e) {
            System.err.println("ERRO ao conectar com o banco de dados");
            return null;
        }
    }

}
