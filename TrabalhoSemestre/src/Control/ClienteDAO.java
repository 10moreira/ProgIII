/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Cliente;
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
public class ClienteDAO {

    CarroDAO daoCarro = new CarroDAO();
    
    
    public List<Cliente> getLista() {
        String sql = "select * from clientes";
        List<Cliente> lista = new ArrayList<>();

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cliente obj = new Cliente();

                obj.setCodigo(rs.getInt("codigo"));
                obj.setNome(rs.getString("nome"));
                obj.setSobreNome(rs.getString("sobreNome"));
                obj.setEmail(rs.getString("email"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setCep(rs.getString("cep"));
                obj.setRua(rs.getString("rua"));
                obj.setNro(rs.getInt("nro"));
                obj.setBairro(rs.getString("bairro"));
                obj.setFone(rs.getString("fone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCarro(daoCarro.localizar(rs.getInt("carro")));
                lista.add(obj); //Não esquecer de chamar o objeto lista do meu arrayList e o metodo add que adiciona o objeto Cliente.

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }

        return lista;
    }

    public boolean Salvar(Cliente obj) {

        if (obj.getCodigo() == null) {
            return incluir(obj);
        }
        else {
            return alterar(obj);
        }

    }

    public boolean incluir(Cliente obj) {
        String sql = "insert into clientes (nome,sobrenome,email,cpf,rg,cep,rua,nro,bairro,fone,celular,carro) values(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);

            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getSobreNome());
            pst.setString(3, obj.getEmail());
            pst.setString(4, obj.getCpf());
            pst.setString(5, obj.getRg());
            pst.setString(6, obj.getCep());
            pst.setString(7, obj.getRua());
            pst.setInt(8, obj.getNro());
            pst.setString(9, obj.getBairro());
            pst.setString(10, obj.getFone());
            pst.setString(11, obj.getCelular());
            pst.setInt(12, obj.getCarro().getCodigo());
  

            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente incluido com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não incluido");
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }

    }

    public boolean alterar(Cliente obj) {
        String sql = "update clientes set nome = ?, sobreNome = ?, email = ?, cpf = ?, rg = ?, cep = ?, rua = ?, nro = ?, bairro = ?, fone = ?, celular = ?, carro = ?  where codigo = ?";

        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());    
            pst.setString(2, obj.getSobreNome());
            pst.setString(3, obj.getEmail());
            pst.setString(4, obj.getCpf());
            pst.setString(5, obj.getRg());
            pst.setString(6, obj.getCep());
            pst.setString(7, obj.getRua());
            pst.setInt(8, obj.getNro());
            pst.setString(9, obj.getBairro());
            pst.setString(10, obj.getFone());
            pst.setString(11, obj.getCelular());
            pst.setInt(12, obj.getCarro().getCodigo());
          
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não alterado!!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
     
    }

    public boolean remover(Cliente obj){
        String sql = "delete from clientes where codigo = ?";
        
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodigo());
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
      public Cliente localizar(Integer Codigo){
        String sql = "select * from clientes where codigo = ?";
        Cliente obj = new Cliente();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, Codigo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getSobreNome());
            pst.setString(3, obj.getEmail());
            pst.setString(4, obj.getCpf());
            pst.setString(5, obj.getRg());
            pst.setString(6, obj.getCep());
            pst.setString(7, obj.getRua());
            pst.setInt(8, obj.getNro());
            pst.setString(9, obj.getBairro());
            pst.setString(10, obj.getFone());
            pst.setString(11, obj.getCelular());
            pst.setInt(12, obj.getCarro().getCodigo());
          
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return null;
    }

}
