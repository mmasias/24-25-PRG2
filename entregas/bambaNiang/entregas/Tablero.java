package bambaniang;


   private int filas = 6;
   private int columnas =6;
   private char[][] casillas;
   private String casillaVacia = "_";
   private char despejado = "D";
   private char mina = "M";
   private int numMinas = 6;



   public tablero() {
    casillas = new char[filas][columnas];
    Random random = new Random();
    int minasPuestas = 0;
    for(int i=0; i<casillas.lenght; i++){
        for(int j=0; j<casillas[i]; j++){
            casillas[i][j] = casillaVacia;
        }
    }

    while(minasPuestas<numMinas){
        int fila = random.nextint(filas);
        int columnas = random.nextint(columnas);
        if(casillas[fila][columnas] != mina){
            numMinas++;
        }
    }


   }

   public void mostrar(){
    System.out.print(" ");
    for(int i = 1; i<columnas; i++){
        System.out.print(i+" ");

    }
    System.out.print();
    for(int i=0; i<fila;i++){
        System.out.print((i+1) " ");


    }
   }



   

    
