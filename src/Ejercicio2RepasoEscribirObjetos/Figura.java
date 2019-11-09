/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2RepasoEscribirObjetos;

import java.io.Serializable;

/**
 *
 * @author dpinepadi
 */
class Punto implements Serializable {

    private int x, y;

    Punto(int i, int y) {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Figura implements Serializable {

    private Punto Origen;

    public Figura(int x, int y) {
    }
}

class Circulo extends Figura {

    private double radio;
    private static final double PI = 3.1416;

    public Circulo(int x, int y, double radio) {
        super(x, y);
        this.radio = radio;
    }

    public double radio() {
        return radio;
    }

    public double area() {
        return radio * PI;
    }
}

class Rectangulo extends Figura {

    private double ancho, alto;

    public Rectangulo(int x, int y, double ancho, double alto) {
        super(x, y);
        this.ancho = ancho;
        this.alto = alto;
    }
        
    public double area() {
        return (ancho * alto) / 2;
    }
}
