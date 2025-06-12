import java.util.ArrayList;
import java.util.List;

public class CulturaGeneral {
    private List<String> conocimientos;

    public CulturaGeneral() {
        this.conocimientos = new ArrayList<>();
        this.cargarInformacion();
    }

    private void cargarInformacion() {
        String[] datos = {
                "París es la capital de Francia.",
                "Miguel de Cervantes escribió Don Quijote.",
                "Marte es conocido como el planeta rojo.",
                "El hombre llegó a la Luna en 1969.",
                "El océano más grande es el Pacífico.",
                "Leonardo da Vinci pintó La Mona Lisa.",
                "El idioma más hablado es el chino mandarín.",
                "El oxígeno es el gas esencial para respirar.",
                "El litio es el metal más ligero.",
                "Italia tiene forma de bota."
        };
        for (String dato : datos) {
            this.conocimientos.add(dato);
        }
    }

    public List<String> getConocimientos() {
        return new ArrayList<>(this.conocimientos);
    }
}
