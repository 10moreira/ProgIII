/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mateus
 */
public class TesteJDBC {

    
    //Método que reliza a conexão ao meu banco de dados e a minha base TrabalhoSemestre
    public static void main(String[] args) {
 
        String banco = "jdbc:postgressql://localhost:5433/TrabalhoSemestre";
        String driver = "org.postgressql.Driver";
        String usuario = "postgres";
        String senha = "postgres";
        Connection con = null;
        

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(banco, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Não conseguiu conectar com o banco" + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Não encontrou o Driver" + ex.getMessage());
        }

    }
}
