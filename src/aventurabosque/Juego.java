package aventurabosque;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author megac
 */
public class Juego {

    private Heroe heroe;
    private ControlEscenarios controlEscenarios;
    private ControlAcertijos controlAcertijos;
    private int monstruosDerrotados = 0;
    private ControlEnemigo controlEnemigos;

    public Juego(String nombre) {
        heroe = new Heroe(nombre);
        controlEscenarios = new ControlEscenarios();
        controlAcertijos = new ControlAcertijos();
        controlEnemigos = new ControlEnemigo();
    }

    public void iniciar() {

        // Escenario inicial fijo
        JOptionPane.showMessageDialog(null,
                "Bienvenido/a " + heroe.getNombre() +
                "\nTienes 3 vidas y 100 de energía.\n" +
                "Te encuentras en un bosque tenebroso.",
                "Inicio",
        javax.swing.JOptionPane.PLAIN_MESSAGE);

        // Bucle principal
        while (heroe.estaVivo() && monstruosDerrotados < 4) {

            Escenario esc = controlEscenarios.getAleatorio();
            Acertijo ac = controlAcertijos.getAleatorio();
            Enemigo enemigo = controlEnemigos.getAleatorio();
            // Mostrar escenario + acertijo
            String respuesta = JOptionPane.showInputDialog(
                    null,
                    "Escenario: " + esc.getDescripcion() +
                    "\n\nAparece un enemigo\n" +
                    "Acertijo:\n" + ac.getPregunta(),
                    "Resuelve El Acertijo",
                     javax.swing.JOptionPane.PLAIN_MESSAGE
            );

            if (respuesta == null) return; // Cancelar cierra juego

            if (respuesta.equalsIgnoreCase(ac.getRespuesta())) {

                JOptionPane.showMessageDialog(null, "¡Correcto!" , "Bien hecho",  javax.swing.JOptionPane.PLAIN_MESSAGE);

                // Menú mientras el enemigo viva
                while (enemigo.estaVivo() && heroe.estaVivo()) {

                    String opcion = JOptionPane.showInputDialog(
                            null,
                           
                            "Aparecio: " + enemigo.getDescripcion() + " con " + enemigo.getVida() + " de energia\n" +
                            heroe.getNombre() +
                            "\nVidas: " + heroe.getVidas() +
                            "\nEnergía: " + heroe.getEnergia() +
                            "\n\n¿Qué deseas hacer?\n" +
                            "1. Atacar\n" +
                            "2. Escapar\n" +
                            "3. Usar poción",
                             "Menu De Acciones",
                    javax.swing.JOptionPane.PLAIN_MESSAGE);

                    if (opcion == null) return;

                    switch (opcion) {

                        case "1": // Atacar
                            if (heroe.getEnergia() >= 20) {
                                heroe.bajarEnergia(20);
                                enemigo.recibirDano(50);
                                JOptionPane.showMessageDialog(null, "Atacaste al enemigo.", "ATAQUE",javax.swing.JOptionPane.PLAIN_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "No tienes energía suficiente.", "SIN ENERGIA", javax.swing.JOptionPane.PLAIN_MESSAGE);
                            }
                            break;

                        case "2": // Escapar
                            if(heroe.getEnergia()>=10){
                            heroe.bajarEnergia(10);
                            JOptionPane.showMessageDialog(null, "Has huido del combate..", "ESCAPAR",javax.swing.JOptionPane.PLAIN_MESSAGE);
                            enemigo = null;
                            } else{
                                JOptionPane.showMessageDialog(null, "No tienes energía suficiente.", "SIN ENERGIA", javax.swing.JOptionPane.PLAIN_MESSAGE);
                            }
                        
                                
                            break;

                        case "3": // Usar poción
                            heroe.subirEnergia(50);
                            heroe.perderVida(); // enemigo golpea
                            JOptionPane.showMessageDialog(null,
                                    "Usaste una poción.\n" +
                                    "Recuperaste 50 energía.\n" +
                                    "El enemigo te golpea: pierdes 1 vida.",
                                    "POCIÓN",
                                   javax.swing.JOptionPane.PLAIN_MESSAGE );

                            if (!heroe.estaVivo()) break;
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida.");
                    }

                    if (enemigo == null) break;
                }

                // Si enemigo murió
                if (enemigo != null && !enemigo.estaVivo()) {
                    monstruosDerrotados++;
                    Random r = new Random();
                    int energiaGanada = r.nextInt(21)+20;
                    heroe.subirEnergia(energiaGanada);
                    JOptionPane.showMessageDialog(null,
                            "¡Has derrotado a un monstruo!\n" +
                           "Ganas " + energiaGanada + " de Energia.\n" +
                            "Monstruos derrotados: " + monstruosDerrotados,
                            "Has Ganado!",
                            javax.swing.JOptionPane.PLAIN_MESSAGE);
                            
                }

            } else {
                heroe.perderVida();
                JOptionPane.showMessageDialog(
                        null,
                        "Fallaste el acertijo.\n" +
                        "Pierdes 1 vida.\n" +
                        "Vidas restantes: " + heroe.getVidas(),
                        "Intentalo De Nuevo",
                        javax.swing.JOptionPane.PLAIN_MESSAGE);
                        
            }
        }

        if (monstruosDerrotados >= 4) {
            JOptionPane.showMessageDialog(
                    null,
                    "Has derrotado a 4 monstruos.\nGANASTE EL JUEGO.", 
                    "Felicidades",
                    javax.swing.JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "TE HAS QUEDADO SIN VIDAS",
                    "GAME OVER",
                    javax.swing.JOptionPane.PLAIN_MESSAGE);
        }
    }
}
