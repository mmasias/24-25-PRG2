import java.util.*;

public class Main {
    public static void main(String[] args) {
        Universidad uni = new Universidad("Universidad Europea del Atlántico");

        
        uni.crearAsignatura("Tecnologías de ña información y comunicación", "PRG2", 6);
        uni.contratarProfesor("Lázaro", "244455555X", false);
        uni.contratarProfesor("Manuel", "666456666X", true);

        
        uni.asignarAsignaturaAProfesor("TIC", "244455555X");

       
        uni.crearExamen("TIC", 3);

      
        uni.asignarVigilanteAExamen("TIC", "666456666X");

        
        uni.mostrarEscenarioCompleto();
    }
}
