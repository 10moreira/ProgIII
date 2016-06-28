/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Paises;
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
public class PaisesDAO {
    
    
     public List<Paises> getLista() {
        String sql = "select * from bas_paises";
        List<Paises> lista = new ArrayList<>();

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
               Paises obj = new Paises();
               
               obj.setId(rs.getInt("id"));
               obj.setNome(rs.getString("nome"));
               obj.setNacionalidade(rs.getString("nacionalidade"));
                lista.add(obj);
          
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }

        return lista;
    }
     
     
      public boolean Salvar(Paises obj) {

        if (obj.getId() == null) {
            return incluir(obj);
        }
        else {
            return alterar(obj);
        }

    }

    public boolean incluir(Paises obj) {
        String sql = "insert into bas_paises (nome,nacionalidade) values(?,?)";

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);

            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getNacionalidade());
         
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Paises incluida com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Paises não incluida");
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }

    }
    
      public boolean alterar(Paises obj) {
        String sql = "update bas_paises set nome = ?, nacionalidade = ? where id = ?";

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());    
            pst.setString(2, obj.getNacionalidade());
           
          
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Nacionalidade alterado com sucesso!!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Nacionalidade não alterado!!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
     
    }
    
       public boolean remover(Paises obj){
        String sql = "delete from bas_paises where id = ?";
        
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getId());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Pais excluido com sucesso!!");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Pais não excluida!!");
                return false;
            }
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
        
        
    }
     
 
}
