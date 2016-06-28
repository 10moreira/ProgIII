/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.ImageIcon;

/**
 *
 * @author mateus
 */
public class Catalogo {
    
    private Integer id_foto;
    private byte[] imagem;

    public Catalogo() {
    }

    
     public ImageIcon getImage(){
//       
       return new ImageIcon(new ImageIcon(imagem).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
   }
    
    public Integer getId_foto() {
        return id_foto;
    }

    public void setId_foto(Integer id_foto) {
        this.id_foto = id_foto;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
    
    
    
}
