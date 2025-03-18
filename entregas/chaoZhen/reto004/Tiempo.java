package chaoZhen.reto004;

public class Tiempo {

    private int horas; 
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        assert esHoraValida(horas) : "La hora no es válida (debe estar entre 0 y 23)";
        assert esMinutoValido(minutos) : "El minuto no es válido (debe estar entre 0 y 59)";
        assert esSegundoValido(segundos) : "El segundo no es válido (debe estar entre 0 y 59)";

        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public boolean equals(Tiempo tiempo) {
        assert tiempo != null : "El Tiempo no puede ser nulo";
        return this.horas == tiempo.horas && 
               this.minutos == tiempo.minutos && 
               this.segundos == tiempo.segundos;
    }

    public boolean antesQue(Tiempo tiempo) {
        assert tiempo != null : "El  Tiempo no puede ser nulo";

        if (this.horas < tiempo.horas) {
            return true;
        } else if (this.horas == tiempo.horas) {
            if (this.minutos < tiempo.minutos) {
                return true;
            } else if (this.minutos == tiempo.minutos) {
                return this.segundos < tiempo.segundos;
            }
        }
        return false;
    }

    public boolean despuesDe(Tiempo tiempo) {
        assert tiempo != null : "El Tiempo no puede ser nulo";

        if (this.horas > tiempo.horas) {
            return true;
        } else if (this.horas == tiempo.horas) {
            if (this.minutos > tiempo.minutos) {
                return true;
            } else if (this.minutos == tiempo.minutos) {
                return this.segundos > tiempo.segundos;
            }
        }
        return false;
    }

    public int compareTo(Tiempo tiempo) {
    assert tiempo != null : "El Tiempo no puede ser nulo";

    if (this.horas > tiempo.horas) {
        return 1;
        } else if (this.horas < tiempo.horas) {
            return -1;
        } else { 
            if (this.minutos > tiempo.minutos) {
                return 1;
            } else if (this.minutos < tiempo.minutos) {
                return -1;
            } else { 
                if (this.segundos > tiempo.segundos) {
                    return 1;
                } else if (this.segundos < tiempo.segundos) {
                    return -1;
                } else {
                    return 0; 
                }
            }
        }
    }

       public Tiempo next () {
        int segundos = this.segundos;
        int minutos = this.minutos;
        int horas = this.horas;
        if (segundos == 59) {
            segundos = 0;
            if (minutos == 59) {
                minutos = 0;
                if (horas == 23) {
                    horas = 0;
                } else {
                    horas++;
                }
            } else {
                minutos++;
            }
        } else {
            segundos++;
        }
        return new Tiempo(horas, minutos, segundos);
    }

    public String toString() {
         return String.format("%02d:%02d:%02d", this.horas, this.minutos, this.segundos);
    }

    public Tiempo sumar (Tiempo tiempo) {
        int segundos = this.segundos + tiempo.segundos;
        int minutos = this.minutos + tiempo.minutos;
        int horas = this.horas + tiempo.horas;
        if (segundos >= 60) {
            segundos -= 60;
            minutos++;
        }
        if (minutos >= 60) {
            minutos -= 60;
            horas++;
        }
        if (horas >= 24) {
            horas -= 24;
        }
        return new Tiempo(horas, minutos, segundos);
    }

    private boolean esHoraValida(int hora) {
        return hora >= 0 && hora <= 23;
    }

    private boolean esMinutoValido(int minuto) {
        return minuto >= 0 && minuto <= 59;
    }

    private boolean esSegundoValido(int segundo) {
        return segundo >= 0 && segundo <= 59;
    }
}