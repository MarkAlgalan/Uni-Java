
package com.mycompany.tarea4;

public class Asistente extends Persona {
    private int edad;
    private String univ;
    private int identi;
    
    Asistente(){
    }
 public String datos(){
    String nom = this.getNom();
    String apep1 = this.getApellidop();
 
    return (nom + apep1);
 }

    public int getIdenti() {
        return identi;
    }

    public void setIdenti(int identi) {
        this.identi = identi;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getUniv() {
        return univ;
    }

    public void setUniv(String univ) {
        this.univ = univ;
    }
    
}
