/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mateus
 */
public class Carro {
    
    private int codigo;
    private String nomeCarro;
    private String chassi;
    private String marca;
    private String cor;
    private String placa;
//    private Cidade cidade;

    public Carro() {
    }

//   public ImageIcon getImage(){
//       
//       return new ImageIcon(new ImageIcon(caminhoImagem).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
//   }
   
    public String getNomeCarro() {
        return nomeCarro;
    }

    public void setNomeCarro(String nomeCarro) {
        this.nomeCarro = nomeCarro;
    }

    
    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

//    public Cidade getCidade() {
//        return cidade;
//    }
//
//    public void setCidade(Cidade cidade) {
//        this.cidade = cidade;
//    }
   
    @Override
    public String toString() {
        return nomeCarro;
    }
    
    
}
