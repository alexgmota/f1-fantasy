import Model.*;

import java.util.Arrays;

public class Controller {

    public static void mejorEquipo(Constructor[] constructores, Piloto[] pilotos, MiembroEquipo[] mejorEquipo, Entero mejorPuntuacion, int posicion, double precioMax, MiembroEquipo[] candidato,  int puntuacionCandidato, int indice) {

        if (posicion == mejorEquipo.length) {
            if (puntuacionCandidato > mejorPuntuacion.getValor()) {
                for (int j = 0; j < mejorEquipo.length; j++) mejorEquipo[j] = candidato[j];
                mejorPuntuacion.setValor(puntuacionCandidato);
            }
        } else {
            int i = 0;
            MiembroEquipo c;
            if (posicion == 0) {
                while (i < constructores.length) {
                    c = constructores[i];
                    candidato[0] = c;
                    precioMax -= c.getCoste();
                    puntuacionCandidato += c.getPuntos();
                    posicion++;
                    if (precioMax >= 0) {
                        mejorEquipo(constructores, pilotos, mejorEquipo, mejorPuntuacion, posicion, precioMax, candidato, puntuacionCandidato, i);
                    }
                    posicion--;
                    puntuacionCandidato -= c.getPuntos();
                    precioMax += c.getCoste();
                    candidato[0] = null;
                    i++;
                }
            } else {
                i = indice;
                while (i < pilotos.length) {
                    c = pilotos[i];
                    candidato[posicion] = c;
                    precioMax -= c.getCoste();
                    puntuacionCandidato += c.getPuntos();
                    posicion++;
                    if (precioMax >= 0 && noEsta(c, candidato, posicion)) {
                        mejorEquipo(constructores, pilotos, mejorEquipo, mejorPuntuacion, posicion, precioMax, candidato, puntuacionCandidato, i);
                    }
                    posicion--;
                    puntuacionCandidato -= c.getPuntos();
                    precioMax += c.getCoste();
                    candidato[posicion] = null;
                    i++;
                }
            }
        }
    }

    public static boolean noEsta(MiembroEquipo piloto, MiembroEquipo[] equipo, int pos) {
        boolean noEsta = true;
        int i = 0;
        while (noEsta && i < pos - 1) {
            noEsta = piloto != equipo[i];
            i++;
        }
        return noEsta;
    }


    public static double costeEquipo(MiembroEquipo[] equipo){
        return Arrays.stream(equipo)
                .mapToDouble(c -> c.getCoste())
                .sum();
    }

    public static int puntosEquipo(MiembroEquipo[] equipo){
        return Arrays.stream(equipo)
                .mapToInt(c -> c.getPuntos())
                .sum();
    }
}