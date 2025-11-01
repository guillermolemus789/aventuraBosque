
package aventurabosque;


public class Heroe {
    

    private String nombre;
    private int vidas;
    private int energia;

    public Heroe(String nombre) {
        this.nombre = nombre;
        this.vidas = 3;
        this.energia = 100;
    }

    public void bajarEnergia(int cantidad) {
        energia -= cantidad;
        if (energia < 0) energia = 0;
    }

    public void subirEnergia(int cantidad) {
        energia += cantidad;
        if (energia > 100) energia = 100;
    }

    public void perderVida() {
        vidas--;
    }

    public boolean estaVivo() {
        return vidas > 0;
    }

    public int getVidas() { return vidas; }
    public int getEnergia() { return energia; }
    public String getNombre() { return nombre; }
}
