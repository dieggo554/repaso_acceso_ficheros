package Ejercicio2RepasoEscribirObjetos;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dpinepadi
 */
public class EscribirObjeto extends Archivo {

    ObjectOutputStream salida;
    
    public EscribirObjeto(String ruta){
        super(ruta);
    }
    
    @Override
    public void abrirArchivo() {
        try {
//            salida = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ruta)));
//            no utlizaremos el buffer para poder leer datos inmediatamente del archivo
            salida = new ObjectOutputStream(new FileOutputStream(ruta));
        } catch (FileNotFoundException ex) {
//            System.out.println("Error al abrir archivo");
            Logger.getLogger(EscribirObjeto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscribirObjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void abrirArchivoConDatos(){
        try {
//            salida = new MiObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ruta)));
            //            no utlizaremos el buffer para poder leer datos inmediatamente del archivo
            salida = new MiObjectOutputStream(new FileOutputStream(ruta, true));
        } catch (FileNotFoundException ex) {
            System.out.println("Error al abrir archivo");
        } catch (IOException ex) {
            Logger.getLogger(EscribirObjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cerrarArchivo() {
        try {
            salida.close();
        } catch (IOException ex) {
            System.out.println("Error al cerrar archivo");
        }
    }
    
//    public void escribirParticipante(Participante participante){
//        try {
//            salida.writeObject(participante);
//        } catch (IOException ex) {
//            System.out.println("Error de escritura");
//        }
//    }
}
