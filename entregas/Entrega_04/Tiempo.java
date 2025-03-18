package entregas.Entrega_04;

public class Tiempo {
    private static int MINUTOS = 60;
    private static int HORAS = 60;
    private static int SEGUNDOS = 60;
  
    private int horas;
    private int minutos;
    private int segundos;
  
    public Tiempo(int horas, int minutos, int segundos) {
      this.horas = horas;
      this.minutos = minutos;
      this.segundos = segundos;
    }
  
    public boolean equals(Tiempo tiempo) {
      return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos;
    }
  
    public boolean antesQue(Tiempo tiempo) {
      return compareTo(tiempo) < 0;
    }
  
    public boolean despuesDe(Tiempo tiempo) {
      return compareTo(tiempo) > 0;
    }
  
    public int compareTo(Tiempo tiempo) {
      if ((this.horas < tiempo.horas) || (this.horas == tiempo.horas && this.minutos < tiempo.minutos) ||
          (this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos < tiempo.segundos)) {
        return -1;
      } else if ((this.horas > tiempo.horas) || (this.horas == tiempo.horas && this.minutos > tiempo.minutos) ||
          (this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos > tiempo.segundos)) {
        return 1;
      } else {
        return 0;
      }
    }
  
    public Tiempo siguiente() {
      int nuevosSegundos = segundos + 1;
      int nuevosMinutos = minutos;
      int nuevaHora = horas;
      if (nuevosSegundos == SEGUNDOS) {
        nuevosSegundos = 0;
        nuevosMinutos = minutos + 1;
        if (nuevosMinutos == MINUTOS) {
          nuevosMinutos = 0;
          nuevaHora = horas + 1;
          if (nuevaHora == HORAS) {
            nuevaHora = 0;
          }
        }
      }
      return new Tiempo(nuevaHora, nuevosMinutos, nuevosSegundos);
    }
  
    public String toString() {
      return horas + ":" + minutos + ":" + segundos;
    }
  
    public Tiempo sumar (Tiempo tiempo) {
      int totalSegundos = this.segundos + tiempo.segundos;
      int totalMinutos = this.minutos + tiempo.minutos;
      int totalHoras = this.horas + tiempo.horas;
      return new Tiempo(totalHoras % HORAS, totalMinutos % MINUTOS, totalSegundos % SEGUNDOS);
    }
  
    public boolean verificarHora(int hora) {
      return hora >= 0 && hora < HORAS;
    }
  
    public boolean verificarMinuto(int minuto) {
      return minuto >= 0 && minuto < MINUTOS;
    }
  
    public boolean verificarSegundo(int segundo) {
      return segundo >= 0 && segundo < SEGUNDOS;
    }
  }