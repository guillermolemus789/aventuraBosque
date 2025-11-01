/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package aventurabosque;

/**
 *
 * @author megac
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre = javax.swing.JOptionPane.showInputDialog("Ingresa el nombre de tu personaje:");

        if (nombre == null || nombre.isBlank()) return;

        Juego juego = new Juego(nombre);
        juego.iniciar();
    }
}

        
