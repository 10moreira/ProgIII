/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Carro;
import Model.Catalogo;
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
public class CatalogoDAO {

    public List<Catalogo> getLista() {

        String sql = "select * from catalago";
        List<Catalogo> lista = new ArrayList<>();

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Catalogo obj = new Catalogo();

                obj.setId_foto(rs.getInt("id_foto"));
                obj.setImagem(rs.getBytes("imagem"));

                lista.add(obj);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }

        return lista;
    }

    public Boolean inserir(Catalogo cat) {
        Boolean retorno = false;
        String sql = "INSERT INTO catalago (imagem) values (?)";

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setBytes(1, cat.getImagem());
            pst.executeUpdate();
            retorno = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return retorno;

    }

    public Catalogo buscar(Integer id_foto) {
        
        Catalogo retorno = null;
        String sql = "SELECT id_foto, imagem from catalogo where id_foto=?";
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {

            pst.setInt(1, id_foto);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                retorno = new Catalogo();
                retorno.setId_foto(rs.getInt("id_foto"));
                retorno.setImagem(rs.getBytes("imagem"));

            }

        } catch (Exception e) {
//            e.printStackTrace();
            retorno = null;
        }

        return retorno;

    }

    public boolean remover(Catalogo obj) {

        String sql = "delete from catalogo where id_foto = ?";

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getId_foto());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Imagem excluida com sucesso!!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Imagem não excluida!!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }

    }

}
