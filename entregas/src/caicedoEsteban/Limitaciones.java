
public class Limitaciones {

    public boolean verificar(ProfesorSupervisor profesorSupervisor) {
        return !profesorSupervisor.estaImpartiendo();
    }

}
