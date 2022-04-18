import Model.Constructor;
import Model.Piloto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.CharBuffer;
import java.util.Scanner;

public class LectorDatos {

    Constructor[] constructores;
    Piloto[] pilotos;

    public LectorDatos() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type tipoConstructor = new TypeToken< Constructor[] >() {}.getType();
        Type tipoPiloto = new TypeToken< Piloto[] >() {}.getType();

        String constructoresJson = leerArchivo("./src/main/resources/Constructores.json");
        String pilotosJson = leerArchivo("./src/main/resources/Pilotos.json");
        constructores = gson.fromJson(constructoresJson, tipoConstructor);
        pilotos = gson.fromJson(pilotosJson, tipoPiloto);
    }

    public Constructor[] getConstructores() {
        return constructores;
    }

    public Piloto[] getPilotos() {
        return pilotos;
    }

    private String leerArchivo(String ruta) {
        StringBuilder str = new StringBuilder();
        try {
            File archivo = new File(ruta);
            Scanner sc = new Scanner(archivo);
            while (sc.hasNext())
                str.append(sc.next());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return str.toString();
    }
}
