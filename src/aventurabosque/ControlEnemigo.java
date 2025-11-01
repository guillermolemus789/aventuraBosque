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

    private String[] descripcionesEnemigos;
    private int[] vidasPosibles;

    public ControlEnemigo() {
        descripcionesEnemigos = new String[]{
            "Oso",
            "Marciano",
            "El diavlo",
            "La llorona",
            "El chupacabras",
            "Masiosare",
            "Slenderman",
            "Crepper"
        };
        vidasPosibles = new int[]{200, 300, 500};
    }

    public Enemigo getAleatorio() {
        Random r = new Random();
        String descripcion = descripcionesEnemigos[r.nextInt(descripcionesEnemigos.length)];
        int vida = vidasPosibles[r.nextInt(vidasPosibles.length)];
        return new Enemigo(descripcion, vida);
    }

}
