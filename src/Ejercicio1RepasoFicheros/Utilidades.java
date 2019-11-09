/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1RepasoFicheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dpinepadi
 */
public class Utilidades {

    private static File carpetaInicial;
    private static File carpetaFinal;
    private static LeerTexto ficheroAlumnos;
    private static FileInputStream entrada;
    private static FileOutputStream salida;
    private static byte[] buffer = new byte[4];

    public static void main(String[] args) {
//        copiarFichero("D:\\texto.txt", "D:\\repaso");
//        crearCarpeta("D:\\repaso", "D:\\alumnos.txt");
//        moverDirectorio("D:\\repaso\\feovasloc", "D:\\repaso\\copia");
        copiarDirectorio("D:\\repaso\\luiagrago", "D:\\repaso\\copia");
    }

    public static void crearCarpeta(String ruta, String nombreFichero) {
        carpetaInicial = new File(ruta);
        ficheroAlumnos = new LeerTexto(nombreFichero);
        StringBuilder nombreCarpeta = new StringBuilder();
        StringTokenizer stLinea;
        String linea, palabra;

        if (!ficheroAlumnos.existe()) {
            System.out.println("No se encuentra el fichero de nombres");
        } else {

            ficheroAlumnos.abrirArchivo();
            carpetaInicial.mkdirs();
            linea = ficheroAlumnos.leerLinea();
            while (linea != null) {
                nombreCarpeta.delete(0, nombreCarpeta.length());
                stLinea = new StringTokenizer(linea, ",");
                while (stLinea.hasMoreTokens()) {
                    palabra = stLinea.nextToken();
                    if (palabra.length() < 3) {
                        nombreCarpeta.append(palabra);
                    } else {
                        nombreCarpeta.append(palabra.substring(0, 3));
                    }
                }
                carpetaFinal = new File(ruta + "\\" + nombreCarpeta.toString());
                carpetaFinal.mkdir();
                linea = ficheroAlumnos.leerLinea();
            }
            ficheroAlumnos.cerrarArchivo();
        }
    }

    public static void copiarFichero(String origen, String destino) {
        File archivo = new File(origen);
        try {
            entrada = new FileInputStream(archivo);
            salida = new FileOutputStream(destino + "\\" + archivo.getName());
            
            entrada.read(buffer);
            
            while (entrada.read(buffer) != -1){
            salida.write(buffer);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void copiarDirectorio(String origen, String destino) {
        File[] subcarpetas;
        File carpetaInicial = new File(origen);
        File carpetaFinal = new File(destino);

        if (!carpetaInicial.isDirectory()){
            copiarFichero(carpetaInicial.getPath(), destino);
        } else {
            carpetaFinal = new File(destino + "\\" + carpetaInicial.getName());
            carpetaFinal.mkdirs();
            subcarpetas = carpetaInicial.listFiles();
            for (int i = 0; i < subcarpetas.length; i++) {
                System.out.println(subcarpetas[i]);
            }
            for (int i = 0; i < subcarpetas.length; i++) {
                System.out.println(subcarpetas[i]);
                copiarDirectorio(subcarpetas[i].getPath(), carpetaFinal.getPath());
            }
        }
    }

    public static void moverDirectorio(String origen, String destino) {
        carpetaInicial = new File(origen);
        carpetaFinal = new File(destino);
        carpetaFinal.mkdirs();

        carpetaInicial.renameTo(new File(carpetaFinal.getPath() + "\\" + carpetaInicial.getName()));
    }
}
