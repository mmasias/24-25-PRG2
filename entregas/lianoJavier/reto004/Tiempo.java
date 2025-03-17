package entregas.lianoJavier.reto004;

public class Tiempo {
        private int horas, minutos, segundos;
        private int SEGUNDO_POR_MINUTO = 60;
        private int MINUTOS_POR_HORA = 60;
        private int HORAS_POR_DIA = 24;

        Tiempo(int horas, int minutos, int segundos) {
            this.horas = horas;
            this.minutos = minutos;
            this.segundos = segundos;
            validarTiempo("Inicialización");
        }

        public boolean equals(Tiempo tiempo) {
                if (horas != tiempo.horas) return false;
                if (minutos != tiempo.minutos) return false;
                if (segundos != tiempo.segundos) return false;
                return true;
        }

        public boolean antesQue(Tiempo tiempo) {
                if (horas < tiempo.horas) return true;
                if (minutos < tiempo.minutos) return true;
                if (segundos < tiempo.segundos) return true;
                return false;
        }
        
        public boolean despuesDe(Tiempo tiempo) {
                if (horas > tiempo.horas) return true;
                if (minutos > tiempo.minutos) return true;
                if (segundos > tiempo.segundos) return true;
                return false;
        }

        public int compareTo(Tiempo tiempo) {
                if (antesQue(tiempo)) return -1;
                if (equals(tiempo)) return 0;
                return 1;
        }

        private Tiempo sumarSegundos(int segundos) {
                this.segundos += segundos;
                formatearReloj();
                validarTiempo("Sumar segundos");
                return this;
        }

        private Tiempo sumarMinutos(int minutos) {
                this.minutos += minutos;
                formatearReloj();
                validarTiempo("Sumar minutos");
                return this;
        }

        private Tiempo sumarHoras(int horas) {
                this.horas += horas;
                formatearReloj();
                validarTiempo("Sumar horas");
                return this;
        }

        private void formatearReloj() {
                formatearSegundos();
                formatearMinutos();
        }

        private void formatearMinutos() {
                if (minutos >= MINUTOS_POR_HORA) {
                        sumarHoras(minutos / MINUTOS_POR_HORA);
                        minutos %= MINUTOS_POR_HORA;
                }
        }

        private void formatearSegundos() {
                if (segundos >= SEGUNDO_POR_MINUTO) {
                        sumarMinutos(segundos / SEGUNDO_POR_MINUTO);
                        segundos %= SEGUNDO_POR_MINUTO;
                }
        }

        public Tiempo sumar(Tiempo tiempo) {
                sumarHoras(tiempo.horas);
                sumarMinutos(tiempo.minutos);
                sumarSegundos(tiempo.segundos);
                return this;
        }

        public Tiempo next() {
                return sumarSegundos(1);
        }

        public String toString() {
                return "Tiempo [horas=" + horas + ", minutos=" + minutos + ", segundos=" + segundos + "]";
        }
        
        public boolean esHoraValida() {
                return horas >= 0 && horas < HORAS_POR_DIA;
        }

        public boolean esMinutoValido() {
                return minutos >= 0 && minutos < MINUTOS_POR_HORA;
        }

        public boolean esSegundoValido() {
                return segundos >= 0 && segundos < SEGUNDO_POR_MINUTO;
        }

        private void validarTiempo(String contexto) {
                assert esHoraValida() : "Hora no válida en " + contexto;
                assert esMinutoValido() : "Minuto no válido en " + contexto;
                assert esSegundoValido() : "Segundo no válido en " + contexto;
        }
}
