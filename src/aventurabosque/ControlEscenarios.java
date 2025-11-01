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
            new Escenario("Un castillo abandonado cubierto de telarañas"),
            new Escenario("Una playa desierta iluminada por la luna"),
            new Escenario("Una cueva con cristales brillantes"),
            new Escenario("Un pueblo fantasma totalmente silencioso")
        };
    }

    public Escenario getAleatorio() {
        Random r = new Random();
        return escenarios[r.nextInt(escenarios.length)];
    }
}
