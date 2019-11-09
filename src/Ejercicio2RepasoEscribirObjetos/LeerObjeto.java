package Ejercicio2RepasoEscribirObjetos;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
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
public class LeerObjeto extends Archivo {

    ObjectInputStream entrada;

    public LeerObjeto(String ruta) {
        super(ruta);
    }

    @Override
    public void abrirArchivo() {
        try {
            entrada = new ObjectInputStream(new FileInputStream(ruta));
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
            Logger.getLogger(LeerObjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cerrarArchivo() {
        try {
            //comprobar si es null antes de cerrar
            entrada.close();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el archivo");
        }
    }

//    public Participante leerParticipante() throws IOException {
//        Participante participante = null;
//        try {
//            participante = (Participante) entrada.readObject();
//        } catch (IOException ex) {
//            participante = null;
//        }finally{
//            return participante;
//        }
//    }
//    
//    public void leerTodos() {
//        Participante participante;
//        System.out.println("Dorsal  Posición  Nombre");
//        try {
//            participante = (Participante) entrada.readObject();
//            while (participante != null) {
//                System.out.println(participante.getDorsal()
//                        + "      " + participante.getPosicion()
//                        + "      " + participante.getNombre());
//                participante = (Participante) entrada.readObject();
//            }
//        } catch (IOException ex) {
//            System.out.println("Fin del archivo");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(LeerObjeto.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public Participante leerParticipante(int dorsal) {
//        Participante corredor;
//        
//        try {
//            while (true) {
//                corredor = (Participante) entrada.readObject();
//                if (corredor.getDorsal() == dorsal) {
//                    cerrarArchivo();
//                    return corredor;
//                }
//            }
//        } catch (IOException ex) {
//           
//        } catch (ClassNotFoundException ex) {
//           
//        } 
//        return null;
//    }
}
