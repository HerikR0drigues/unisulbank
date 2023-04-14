/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package localhost.unisulbank.jdbc.Login;


import java.sql.*;
import localhost.unisulbank.dominio.Cliente;
import static localhost.unisulbank.jdbc.JDBCConexao.conectar;

/**
 *
 * @author Herik
 */

public class JDBCLogin {
    private ResultSet rs;
    private Connection con;
    private Statement stm;
    
    public String buscarSenha(String usuario) {
        String senhaCriptografada = null;
        try {
            con = conectar();
            stm = con.createStatement();
            
            String query = "select senha from usuario_senha where usuario = '"+usuario+"';";
            rs = stm.executeQuery(query);
            while(rs.next()){
                senhaCriptografada = rs.getString("senha");                 
            }
            
            Criptografia criptografia = new Criptografia();
            String senhaDesencriptada = criptografia.desencriptar(senhaCriptografada);
            
            return senhaDesencriptada;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Cliente carregarCliente(String usuario) {
        int idUsuario = 0;
        String nome =  null;
        
        try {
            con = conectar();
            stm = con.createStatement();
            
            String query = "select id_usuario_senha from usuario_senha where usuario = '"+usuario+"';";
            rs = stm.executeQuery(query);
            while(rs.next()){
                idUsuario = rs.getInt("id_usuario_senha");                 
            }
            
            query = "select nome from cliente where id_usuario_senha = '"+idUsuario+"';";
            rs = stm.executeQuery(query);
            while(rs.next()){
                nome = rs.getString("nome");                 
            }
            
            Cliente cliente = new Cliente(idUsuario, nome);
            return cliente;
            
        } catch (Exception e) {
            return null;
        }
    }
    
}