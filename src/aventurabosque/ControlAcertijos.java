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
public class ControlAcertijos {

    private Acertijo[] acertijos;

    public ControlAcertijos() {
        acertijos = new Acertijo[]{
            new Acertijo("¿Qué tiene cabeza pero no tiene cerebro?", "ajo"),
            new Acertijo("¿Qué sube pero nunca baja?", "edad"),
            new Acertijo("¿Qué tiene agujas pero no cose?", "reloj"),
            new Acertijo("¿Qué se moja mientras seca?", "toalla"),
            new Acertijo("Agua pasa por mi casa, cate de mi corazón, el que no lo adivine, es un burro cabezon.","Aguacate"),
            new Acertijo("¿Qué hay en un minuto, dos veces en un momento y nunca en cien años?", "m"),
            new Acertijo("Si me tienes, me quieres compartir. Si me compartes, ya no me tienes. ¿Qué soy?", "Secreto"),
            new Acertijo("Usas un cuchillo para cortarme la cabeza y lloras a mi lado cuando estoy muerta. ¿Qué soy?", "Cebolla"),
            new Acertijo("No muerde ni ladra, pero tiene dientes y la casa guarda.", "Llave"),
            new Acertijo("Tiene ciudades, pero no casas; montañas, pero no árboles; agua, pero no peces.", "Mapa"),
            new Acertijo("¿Qué animal tiene las cinco vocales en su nombre?", "murcielago")
            
        };
    }

    public Acertijo getAleatorio() {
        Random r = new Random();
        return acertijos[r.nextInt(acertijos.length)];
    }
}
