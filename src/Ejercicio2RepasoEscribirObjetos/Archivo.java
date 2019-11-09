package Ejercicio2RepasoEscribirObjetos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;

/**
 *
 * @author dpinepadi
 */
public abstract class Archivo {

    File ruta;
    
    public Archivo(String ruta) {
        this.ruta = new File(ruta);
    }
    
    public abstract void abrirArchivo();
    
    public abstract void cerrarArchivo();
    
    public boolean existe() {
        return (ruta.exists());
    }
    
    public boolean renombrarArchivo(String nuevaRuta) {
        return ruta.renameTo(new File(nuevaRuta));
    }

    public boolean borrarArchivo() {
        return ruta.delete();
    }
}
