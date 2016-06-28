/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Estado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mateus
 */
public class EstadosDAO {
    
     public List<Estado> getLista() {
         
        String sql = "select * from bas_estados";
        List<Estado> lista = new ArrayList<>();

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
               Estado obj = new Estado();
               
               obj.setId(rs.getString("id"));
               obj.setRef_pais(rs.getInt("ref_pais"));
               obj.setNome(rs.getString("nome"));
               obj.setPrefixo(rs.getString("prefixo"));
                lista.add(obj);
          
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }

        return lista;
    }
     
     
      public boolean Salvar(Estado obj) {

        if (obj.getId() == null) {
            return incluir(obj);
        }
        else {
            return alterar(obj);
        }

    }

    public boolean incluir(Estado obj) {
        String sql = "insert into bas_estados (nome,ref_pais) values(?,?)";

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);

            pst.setString(1, obj.getNome());
            pst.setInt(2, obj.getRef_pais());
          
  

            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Estado incluida com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Estado não incluida");
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }

    }
    
      public boolean alterar(Estado obj) {
        String sql = "update bas_estados set nome = ?, ref_pais = ? where id = ?";

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());    
            pst.setInt(2, obj.getRef_pais());
           
          
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Estado alterado com sucesso!!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Estado não alterado!!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
     
    }
     
      public boolean remover(Estado obj){
        String sql = "delete from bas_estados where id = ?";
        
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getId());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!!");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Cidade não excluida!!");
                return false;
            }
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
        
        
    }
     
}
