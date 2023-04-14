/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package localhost.unisulbank.jdbc.Login;

import java.sql.*;
import javax.swing.JOptionPane;
import static localhost.unisulbank.jdbc.JDBCConexao.conectar;

/**
 *
 * @author 1072222792
 */
public class JDBCCadastro {
    private ResultSet rs;
    private Connection con;
    private Statement stm;
    
    public boolean CadastrarUsuario(String usuarioDigitado, String senhaDigitada, String nomeDigitado) {
        int idUsuarioSenha = 0; 
        try {
            con = conectar();
            stm = con.createStatement();
            
            String query = "select usuario from usuario_senha where usuario = '"+usuarioDigitado+"';";
            rs = stm.executeQuery(query);
            
            if(!rs.next()) {
                Criptografia criptografia = new Criptografia();
                String senhaCriptografada = criptografia.encriptar(senhaDigitada);
                
                query = "insert into usuario_senha (usuario, senha) values ('"+usuarioDigitado+"', '"+senhaCriptografada+"');";
                stm.executeUpdate(query);
                
                query = "select max(id_usuario_senha) from usuario_senha";
                rs = stm.executeQuery(query);
                while (rs.next()) {
                    idUsuarioSenha = rs.getInt(1);
                }
                
                query = "insert into cliente (id_usuario_senha, nome, saldo) values ('"+idUsuarioSenha+"', '"+nomeDigitado+"', '"+0+"');";
                stm.executeUpdate(query);                
                
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
           return false;
        }
         
    }


}
