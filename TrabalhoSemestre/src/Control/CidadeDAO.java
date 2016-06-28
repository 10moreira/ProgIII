/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Cidade;
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
public class CidadeDAO {
    
    
    public List<Cidade> getLista() {
         
        String sql = "select * from bas_cidades";
        List<Cidade> lista = new ArrayList<>();

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
               Cidade obj = new Cidade();
               
               obj.setId(rs.getInt("id"));
               obj.setRef_estado(rs.getString("ref_estado"));
               obj.setNome(rs.getString("nome"));              
                lista.add(obj);
          
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }

        return lista;
    }
    
    public boolean Salvar(Cidade obj) {

        if (obj.getId() == null) {
            return incluir(obj);
        }
        else {
            return alterar(obj);
        }

    }

    public boolean incluir(Cidade obj) {
        String sql = "insert into bas_cidades (nome,ref_estado) values(?,?)";

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);

            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getRef_estado());
          
  

            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cidade incluida com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cidade não incluida");
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }

    }
    
     public boolean alterar(Cidade obj) {
        String sql = "update bas_cidade set nome = ?, ref_estado = ? where id = ?";

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());    
            pst.setString(2, obj.getRef_estado());
          
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cidade alterada com sucesso!!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cidade não alterada!!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
     
    }

    public boolean remover(Cidade obj){
        String sql = "delete from bas_cidade where id = ?";
        
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getId());
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
      public Cidade localizar(Integer id){
        String sql = "select * from bas_cidade where id = ?";
        Cidade obj = new Cidade();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getRef_estado());
          
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return null;
    }
    
    
    
}
