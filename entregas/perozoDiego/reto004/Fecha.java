package entregas.perozoDiego.reto004;

public class Fecha {
    private int año, mes, dia;
    private int[] mesesConDiaExtra = {1,3,5,7,8,10,12};

    public Fecha(int año, int mes, int dia){
        assert this.año <= 2025 : "El año que fue ingresado no puede ser mayor al año actual";
        assert this.mes <= 12 : "El mes ingresado sobrepasa los 12 meses";
        verificacionDeDia();

        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha fecha){
        if(this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia){
            return true;
        }else{
            return false;
        }
    }

    public boolean antesQue(Fecha fecha){
        if(this.año >= fecha.año && this.mes >= fecha.mes && this.dia > fecha.dia){
            return true;
        }else{
            return false;
        }
    }

    public boolean despuesDe(Fecha fecha){
        if(this.año <= fecha.año && this.mes <= fecha.mes && this.dia < fecha.dia){
            return true;
        }else{
            return false;
        }
    }

    public Fecha siguiente(){
        return new Fecha(año, mes, (dia + 1));
    }

    public String toString(){
        return "El año es " + año + " del mes " + mes + " y el dia es";
    }

    public void esMesValido(int mes){
        if(mes >= 1 && mes <= 12){
            this.mes = mes;
        }
    }

    public void esDiaValido(int dia){
        if(dia >= 1 && dia <= 30){
            this.dia = dia;
        }
    }

    private void verificacionDeDia(){
        if (this.mes == 2 && this.año % 4 == 0){
            assert this.dia <= 29: "El dia ingresado no puede sobrepasar 29 dias";
        }else{
            assert this.dia <= 28: "El dia ingresado no puede sobrepasar 28 dias";
        }

        for(int i = 0; i < mesesConDiaExtra.length; i++){
            if (this.mes == mesesConDiaExtra[i]){
                assert this.dia <= 31: "El dia ingresado no puede sobrepasar 31 dias";
            }else{
                assert this.dia <= 30: "El dia ingresado no puede sobrepasar 30 dias";
            }
        }
    }
}