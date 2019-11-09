/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2RepasoEscribirObjetos;

import java.util.Scanner;

/**
 *
 * @author dpinepadi
 */
public class Menu {

    private static String rutaFiguras;
    private static String rutaRectangulos;
    private static String rutaCirculos;
    private static GestorFiguras datos;
//    enum Figuras {Figura, Rectángulo, Circulo};

    public static void main(String[] args) {
        datos = new GestorFiguras(rutaFiguras, rutaRectangulos, rutaCirculos);
        int nFigura;
        int nOperacion;

        nFigura = menuPrincipal();
        while (nFigura != 4) {
            do {
                nOperacion = menuSecundario(nFigura);

                switch (nOperacion) {
                    case 1:
                        datos.crearArchivo(nFigura);
                        break;
                    case 2:
                        datos.añadir(nFigura);
                        break;
                    case 3:
                        datos.mostrarTodos(nFigura);
                }
            } while (nOperacion != 4);
            nFigura = menuPrincipal();
        }
    }

    private static int menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.print("Menú de opciones\n"
                    + "-----------------\n"
                    + " 1.-Operaciones Rectángulo\n"
                    + " 2.-Operaciones Circulo\n"
                    + " 3.-Crear un archivo de texto con Rectángulos y Circulos\n"
                    + " 4.-Salir\n"
                    + "Elige una opción <1-4>: ");
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception ex) {
                opcion = 0;
            }
        } while (opcion < 1 || opcion > 4);
        return opcion;
    }

    private static int menuSecundario(int f) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.print("Menú de operacines\n"
                    + "-----------------\n"
                    + " 1.-Crear\n"
                    + " 2.-Añadir\n"
                    + " 3.-Leer todos\n"
                    + " 4.-Volver\n"
                    + "Elige una opción <1-4>: ");
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception ex) {
                opcion = 0;
            }
        } while (opcion < 1 || opcion > 4);
        return opcion;
    }
}
