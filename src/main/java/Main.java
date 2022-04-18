import Model.Constructor;
import Model.Entero;
import Model.MiembroEquipo;
import Model.Piloto;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Entero puntuacion = new Entero(0);
        LectorDatos lectorDatos = new LectorDatos();
        Constructor[] constructores = lectorDatos.getConstructores();
        Piloto[] pilotos = lectorDatos.getPilotos();

        MiembroEquipo[] mejorEquipo = new MiembroEquipo[6];
        MiembroEquipo[] actual = new MiembroEquipo[6];

        Controller.mejorEquipo(constructores, pilotos, mejorEquipo, puntuacion, 0, 100d, actual, 0, 0);

        System.out.println(" El mejor equipo del año pasado en el f1 fantasy es: ");
        System.out.println("\n" + Arrays.toString(mejorEquipo).replace("},", "}, \n").replace("["," ").replace("]", " "));
        DecimalFormat dc = new DecimalFormat(".##");
        System.out.println();
        System.out.println(" El coste del mejor equipo es: " + dc.format(Controller.costeEquipo(mejorEquipo)));
        System.out.println(" Los puntos del mejor equipo es: " + Controller.puntosEquipo(mejorEquipo));
    }
}
