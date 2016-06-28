/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Carro;
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
public class CarroDAO {

        CidadeDAO daocidade = new CidadeDAO();
        Cidade cid = new Cidade();
        
//Método incluir que passa por parametro o objeto Carro e inseri uma query sql em minha tabela carros.        
    public boolean incluir(Carro obj) {
        String sql = "insert into carros (nomeCarro, chassi, marca, cor, placa, cidade) values(?,?,?,?,?,?)";

        try {

            PreparedStatement pst = Conexao.getPreparedStatement(sql);

            pst.setString(1, obj.getNomeCarro());         
            pst.setString(2, obj.getChassi());
            pst.setString(3, obj.getMarca());
            pst.setString(4, obj.getCor());
            pst.setString(5, obj.getPlaca());

            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Veiculo incluido com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Veiculo não incluido");
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }

    }
 //Método localizar que passa por parametro o codigo para buscar e selecionar o carro na minha tabela carros  
    public Carro localizar(Integer codigo) {
        String sql = "select * from carros where codigo = ?";
        Carro obj = new Carro();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);

            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
              
                obj.setCodigo(rs.getInt("codigo"));
                obj.setNomeCarro(rs.getString("nomeCarro"));
                obj.setChassi(rs.getString("chassi"));
                obj.setMarca(rs.getString("marca"));
                obj.setCor(rs.getString("cor"));
                obj.setPlaca(rs.getString("placa"));
             
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return null;
    }
  //Método list que passa o objeto Carro e adiciona a uma lista 
    public List<Carro> getLista() {
        String sql = "select * from carros";
        List<Carro> lista = new ArrayList<>();

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Carro obj = new Carro();
          
                obj.setCodigo(rs.getInt("codigo"));
                obj.setNomeCarro(rs.getString("nomeCarro"));
                obj.setChassi(rs.getString("chassi"));
                obj.setMarca(rs.getString("marca"));
                obj.setCor(rs.getString("cor"));
                obj.setPlaca(rs.getString("placa"));              
                             
                lista.add(obj);
       
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }

        return lista;
    }
    //Método que remove o objeto Carro da lista.
    public boolean remover(Carro obj) {
        String sql = "delete from carros where codigo = ?";

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodigo());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Carro excluido com sucesso!!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Carro não excluida!!");
                return false;
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }

    }
}
