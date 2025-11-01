package aventurabosque;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Random;
/**
 *
 * @author megac
 */
public class ControlEnemigo {

    private Enemigo[] nombreEnemigo;

    public ControlEnemigo() {
        nombreEnemigo = new Enemigo[]{
            new Enemigo("Oso "),
            new Enemigo("Marciano "),
            new Enemigo("El diavlo "),
            new Enemigo("La llorona "),
            new Enemigo("El chupacabras "),
            new Enemigo("Masiosare "),
            new Enemigo("Slenderman "),
            new Enemigo("Crepper ")
        };
    }
      public Enemigo getAleatorio() {
        Random r = new Random();
        return nombreEnemigo[r.nextInt(nombreEnemigo.length)];
    }

}
