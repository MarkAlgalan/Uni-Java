/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuela.principal;

/**
 *
 * @author joseA
 */
public class Escuela {
    private String registro;
   private Direccion dirección;
   public Direccion getDirección(){
       return dirección;
   }
   public void setDirección(Direccion dirección){
       this.dirección = dirección;
   }
   public String gerRegistro(){
       return registro;
   }
   public void setRegistro(String registro){
       this.registro= registro;
   }
}
