/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aventurabosque;
import java.util.Random;

/**
 *
 * @author megac
 */
public class ControlEscenarios {

    private Escenario[] escenarios;

    public ControlEscenarios() {
        escenarios = new Escenario[]{
            new Escenario("Un bosque oscuro lleno de niebla"),
            new Escenario("Un pantano con burbujas misteriosas"),
            new Escenario("Una cueva terrorifica"),
            new Escenario("Un pueblo abandonado"),
            new Escenario("Lo más profundo del tenebroso bosque..."),
            new Escenario("Montaña del la locura"),
            new Escenario(" El claro del bosque")
        };
    }

    public Escenario getAleatorio() {
        Random r = new Random();
        return escenarios[r.nextInt(escenarios.length)];
    }
}
