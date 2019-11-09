/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2RepasoEscribirObjetos;

/**
 *
 * @author dpinepadi
 */
public class GestorFiguras {

    LeerObjeto lecRectangulos, lecCirculos;
    EscribirObjeto escRectangulos, escCirculos;
//    EscribirTexto escFiguras;
//    LeerTexto leerFiguras;

    public GestorFiguras(String rutaFiguras, String rutaRectangulos, String rutaCirculos) {

        lecRectangulos = new LeerObjeto(rutaRectangulos);
        lecCirculos = new LeerObjeto(rutaCirculos);

        escRectangulos = new EscribirObjeto(rutaRectangulos);
        escCirculos = new EscribirObjeto(rutaCirculos);
    }

    void crearArchivo(int nFigura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void añadir(int nFigura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void mostrarTodos(int nFigura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
