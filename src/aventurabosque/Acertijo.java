/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aventurabosque;

/**
 *
 * @author megac
 */
public class Acertijo {
    
    private String pregunta;
    private String respuesta;

    public Acertijo(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() { return pregunta; }
    public String getRespuesta() { return respuesta; }
}
