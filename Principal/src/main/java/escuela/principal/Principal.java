/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package escuela.principal;

/**
 *
 * @author joseA
 */
public class Principal {

    public static void main(String[] args) {
        Direccion d1= new Direccion("calle 2 oriente",125);
        Direccion d2= new Direccion("calle privada 3 sur",25);
        Alumno a= new Alumno("Angeles",30);
        a.setDireccion(d1);
        Escuela e= new Escuela();
        e.setRegistro("XYCVF");
        e.setDirección(d2);
        System.out.println("Dirección del alumno "+a.getDireccion().getCalle());
        System.out.println("Dirección de su escuela "+e.getDirección().getCalle());
    }
}
