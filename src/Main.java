import Model.Constructor;
import Model.Entero;
import Model.MiembroEquipo;
import Model.Piloto;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(" El mejor equipo del año pasado en el f1 fantasy es: ");
        Entero puntuacion = new Entero(0);
        Constructor[] constructores = new Constructor[] {
                new Constructor("Mercedes", 37.4, 264),
                new Constructor("Red Bull", 26d, 289),
                new Constructor("McLaren", 18.7, 195),
                new Constructor("Ferrari", 19.7, 178),
                new Constructor("Aston Martin", 16.4, 85),
                new Constructor("Alpine", 15.2, 83),
                new Constructor("AlphaTauri", 12.6, 71),
                new Constructor("Alfa Romeo", 9.2, 62),
                new Constructor("Williams", 6.3, 36),
                new Constructor("Haas", 6.1, 46)
        };

        Piloto[] pilotos = new Piloto[]{
                new Piloto("L.Hamilton", 33.3, 209),
                new Piloto("M.Verstapen", 25.5, 217),
                new Piloto("V.Bottas", 23.1, 85),
                new Piloto("S.Perez", 18d, 102),
                new Piloto("D.Ricciardo", 16.1, 74),
                new Piloto("C.Leclerc", 18.3, 103),
                new Piloto("S.Vettel", 14.9, 48),
                new Piloto("F.Alonso", 14.8, 28),
                new Piloto("C.Sainz", 14.8, 85),
                new Piloto("L.Stroll", 13.4, 62),
                new Piloto("L.Norris", 13.9, 151),
                new Piloto("P.Gasly", 11.5, 64),
                new Piloto("E.Ocon", 10.5, 65),
                new Piloto("K.Raikkonen", 9.4, 36),
                new Piloto("Y.Tsunoda", 8.5, 12),
                new Piloto("Y.Giovinazzi", 8d, 36),
                new Piloto("N.Latifi", 6.4, 6),
                new Piloto("G.Russell", 6.2, 22),
                new Piloto("M.Schumacher", 5.8, 40),
                new Piloto("N.Mazepin", 5.3, 11)
        };
        MiembroEquipo[] mejorEquipo = new MiembroEquipo[6];
        MiembroEquipo[] actual = new MiembroEquipo[6];
        Controller.mejorEquipo(constructores, pilotos, mejorEquipo, puntuacion, 0, 100d, actual, 0, 0);
        System.out.println("\n" + Arrays.toString(mejorEquipo).replace("},", "}, \n").replace("["," ").replace("]", " "));
        DecimalFormat dc = new DecimalFormat(".##");
        System.out.println();
        System.out.println(" El coste del mejor equipo es: " + dc.format(Controller.costeEquipo(mejorEquipo)));
        System.out.println(" Los puntos del mejor equipo es: " + Controller.puntosEquipo(mejorEquipo));
    }
}
