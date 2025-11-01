package aventurabosque;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import aventurabosque.ControlAcertijos;
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
                "Te encuentras en un bosque tenebroso.");

        // Bucle principal
        while (heroe.estaVivo() && monstruosDerrotados < 3) {

            Escenario esc = controlEscenarios.getAleatorio();
            Acertijo ac = controlAcertijos.getAleatorio();
            Enemigo enemigo = controlEnemigos.getAleatorio();
            // Mostrar escenario + acertijo
            String respuesta = JOptionPane.showInputDialog(
                    "Escenario: " + esc.getDescripcion() +
                    "\n\nAparece un enemigo\n" +
                    "Acertijo:\n" + ac.getPregunta());

            if (respuesta == null) return; // Cancelar cierra juego

            if (respuesta.equalsIgnoreCase(ac.getRespuesta())) {

                JOptionPane.showMessageDialog(null, "¡Correcto!");

                // Menú mientras el enemigo viva
                while (enemigo.estaVivo() && heroe.estaVivo()) {

                    String opcion = JOptionPane.showInputDialog(
                            "Aparecio: " + enemigo.getDescripcion() + "con " + enemigo.getVida() + " de vida\n" +
                            heroe.getNombre() +
                            "\nVidas: " + heroe.getVidas() +
                            "\nEnergía: " + heroe.getEnergia() +
                            "\n\n¿Qué deseas hacer?\n" +
                            "1. Atacar\n" +
                            "2. Escapar\n" +
                            "3. Usar poción");

                    if (opcion == null) return;

                    switch (opcion) {

                        case "1": // Atacar
                            if (heroe.getEnergia() >= 25) {
                                heroe.bajarEnergia(25);
                                enemigo.recibirDano(50);
                                JOptionPane.showMessageDialog(null, "Atacaste al enemigo.");
                            } else {
                                JOptionPane.showMessageDialog(null, "No tienes energía suficiente.");
                            }
                            break;

                        case "2": // Escapar
                            JOptionPane.showMessageDialog(null, "Escapaste...");
                            enemigo = null;
                            break;

                        case "3": // Usar poción
                            heroe.subirEnergia(50);
                            heroe.perderVida(); // enemigo golpea
                            JOptionPane.showMessageDialog(null,
                                    "Usaste una poción.\n" +
                                    "Recuperaste 50 energía.\n" +
                                    "El enemigo te golpea: pierdes 1 vida.");

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
                    JOptionPane.showMessageDialog(null,
                            "¡Has derrotado a un monstruo!\n" +
                            "Monstruos derrotados: " + monstruosDerrotados);
                }

            } else {
                heroe.perderVida();
                JOptionPane.showMessageDialog(null,
                        "Fallaste el acertijo.\n" +
                        "Pierdes 1 vida.\n" +
                        "Vidas restantes: " + heroe.getVidas());
            }
        }

        if (monstruosDerrotados >= 3) {
            JOptionPane.showMessageDialog(null,
                    "¡FELICIDADES!\nHas derrotado a 3 monstruos.\nGANASTE EL JUEGO.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "TE HAS QUEDADO SIN VIDAS.\nGAME OVER.");
        }
    }
}
