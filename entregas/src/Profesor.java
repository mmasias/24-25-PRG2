package src;
public class Profesor{
    private String Name;
    private String DNI;

    public Profesor(String Name, String DNI) {
        this.Name = Name;
        this.DNI = DNI;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String dni) {
        this.DNI = dni;
    }


}