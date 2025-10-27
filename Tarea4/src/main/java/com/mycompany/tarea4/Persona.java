
package com.mycompany.tarea4;

public class Persona {
    private String Nom;
    private String apellidop;
    private String apellidom;
Persona(){
    Nom = " ";
    apellidop = " ";
    apellidom = " ";
}
    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }
    
    
}
