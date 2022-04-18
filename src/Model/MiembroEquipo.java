package Model;

public abstract class MiembroEquipo {

    private String nombre;
    private double coste;
    private int puntos;

    public MiembroEquipo(String nombre, double coste, int puntos) {
        this.nombre = nombre;
        this.coste = coste;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCoste() {
        return coste;
    }

    public int getPuntos() {
        return puntos;
    }
    @Override
    public String toString() {
        return getClass().getName() + "{"+ "Nombre: " + getNombre() + ", "
                 + " Coste: " +  getCoste() + ", " + " Puntos: " +getPuntos() + "}";
    }
}
