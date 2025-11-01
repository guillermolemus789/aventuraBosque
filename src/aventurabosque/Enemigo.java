/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aventurabosque;

/**
 *
 * @author megac
 */
public class Enemigo {


    private int vida;
    private String descripcion;

    public Enemigo(String descripcion) {
        this.vida = 100;
        this.descripcion = descripcion;
    }


    public void recibirDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public int getVida() {
        return vida;
    }

    public String getDescripcion() {
        return descripcion;
    }


}
