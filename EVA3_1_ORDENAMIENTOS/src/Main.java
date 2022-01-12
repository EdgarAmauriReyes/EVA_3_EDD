public class Main {
    public static void main(String[] args) {
        // VAMOS A ORDENAR ARREGLOS(INT)
        int [] datos =new int [1000000];
        int [] copiaSel = new int [datos.length];
        int [] copiaIns = new int [datos.length];
        int [] copiaBubble = new int [datos.length];
        int [] copiaQuicks = new int [datos.length];
        long iniT, finT;
        llenar(datos); //envio  el arreglo a llenar con valores aleatorios

        System.out.println("PRUEBA CON SELECTION SORT");
        duplicar(datos, copiaSel);
        //imprimir(copiaSel);
        iniT=System.nanoTime();//tiempo antes  de empezar el metodos
        selectionSort(copiaSel);
        finT=System.nanoTime();//tiempo al termiinar  el metodos
        //imprimir(copiaSel);
        //System.out.println("");
        System.out.println("Tiempo en ordenar" + (finT - iniT));

        System.out.println("PRUEBA CON INSERTION SORT");
        duplicar(datos, copiaIns);
        //imprimir(copiaIns);
        iniT=System.nanoTime();//tiempo antes  de empezar el metodos
        insertionSort(copiaIns);
        finT=System.nanoTime();//tiempo al termiinar  el metodos
        //imprimir(copiaIns);
        //System.out.println("");
        System.out.println("Tiempo en ordenar" + (finT - iniT));


        System.out.println("PRUEBA CON BUBBLE SORT");
        duplicar(datos, copiaBubble);
        //imprimir(copiaBubble);
        iniT=System.nanoTime();//tiempo antes  de empezar el metodos
        buubleSort(copiaBubble);
        finT=System.nanoTime();//tiempo al termiinar  el metodos
        //imprimir(copiaBubble);
        //System.out.println("");
        System.out.println("Tiempo en ordenar" + (finT - iniT));

        System.out.println("PRUEBA CON QUICK SORT");
        duplicar(datos, copiaQuicks);
        //imprimir(copiaQuicks);
        iniT=System.nanoTime();//tiempo antes  de empezar el metodos
        buubleSort(copiaQuicks);
        finT=System.nanoTime();//tiempo al termiinar  el metodos
        //imprimir(copiaQuicks);
        //System.out.println("");
        System.out.println("Tiempo en ordenar" + (finT - iniT));
    }

    //LLENADO DE ARREGLOS
    public static void llenar(int [] datos){
        for(int i=0; i<datos.length; i++){
            datos[i]= (int)(Math.random()*100);
        }
    }
    // DUPLICAR ARREGLO (arreglos del mimso tamaño )
    public static void duplicar (int[] datos, int[] copia){
        for(int i=0; i<datos.length; i++){
            copia[i] = datos [i];
        }
    }
    // COPIA DE ARREGLO
    //IMPRIMIR ARREGLO

    public static void imprimir(int [] datos) {
        for (int i = 0; i < datos.length; i++) {
            System.out.print("[" + datos[i] + "]");
        }
        System.out.println("");
    }

    public static void selectionSort(int[] datos ){
        for (int i=0; i<datos.length; i++){
            int iMin = i;//EMPEIZA EL ALGORITMO, EL MINIMO ES EL PRIMER ELEMENTO
            for (int j=i+1; j<datos.length; j++){//Bucar la posicion del valor mas pequeño
                //COMPARAR
                //valor(j) vs valor (min)
                if(datos[j] < datos[iMin]){//COMPARO ACTUAL CONTRA EL MINIMO ACTUAL
                    iMin = j;

                }
            }
            //INTERCAMBIO
            if (i !=iMin) {
                //3 PASOS
                //RESPALDAR UN VALOR
                int iTemp = datos[i];
                //INTERCAMBIAR UN VALOR
                datos[i] = datos[iMin];
                //REPONER EL VALOR RESPALDAO
                datos[iMin] = iTemp;
            }
        }
    }
    public  static void insertionSort (int[] datos ) {
        for (int i = 1; i< datos.length; i++){
            int temp = datos[i]; //Valor a insertar
            int  insP = i;// posicion donde vamos a insertar
            for (int prev = (i-1); prev >= 0; prev--){
                if(datos[prev] > temp){
                    datos[insP] = datos[prev]; // movemos valor de prev a la posicion de insP
                    insP -- ; //retrocede una posicion
                }else{
                    break;
                }
            }
            //insetamos
            datos[insP] = temp;
        }

    }

    public static void buubleSort (int[] datos){
        for (int i = 0; i < datos.length; i++){//PASADAS
            for (int j = 0; j < (datos.length - 1); j++ ){// COMPARA E INTERCAMBIA
                if (datos [j] > datos [j +1]){// comparamos j vs j + 1
                    //intercambiamos
                    int temp = datos[j];
                    datos [j +1] = temp;
                }
            }
        }
    }
    //  QUICKSORT DE ARRANQUE
    public static void quickSort(int[] datos){
        quickSortRecu(datos, 0, datos.length -1);//quicksort a todo el arreglo
    }

    private static void quickSortRecu(int [] datos, int ini, int fin ){
        int iPivote; //inicio
        int too_big; // busca a los mas grandes que l pivote
        int too_small;// busca los mas pequeños que el pivote
        boolean stopBig = false;
        boolean stopSmall = false;
        // Controlar la recursividad:
        int tama = fin -ini + 1;
        if(tama >1){//¿Cuando si puedo realizar un quicksort?
            iPivote= ini;
            too_big = ini +1;
            too_small = fin;
            for(int i = ini +1; i<= fin ; i++){//numero de veces a recorrer
                if((datos[too_big] < datos[iPivote]) && (!stopBig)){//avanzo
                    too_big++;// avanzo
                }else{
                    stopBig=true; // me detengo cuando encuentre un numero mas grande
                }

                if((datos[too_small] >= datos[iPivote]) && (!stopSmall)){//retrocedo
                    too_small++; // retrocedo
                }else{
                    stopSmall=true; // me detengo cuando encuentre un numero mas pequeño
                }
                //ambos indices se detiene (swap)
                if(stopBig && stopSmall){
                    if(too_big < too_small){// intercambio SWAP
                        datos[too_big] = datos[too_small];
                        datos [too_small] = tama;
                        stopBig = false; // seguir avanzando
                        stopSmall = false; // seguir avanzando
                    }else
                        break;
                }

            }
            // intercambio el pivote
            int temp = datos[iPivote];
            datos[iPivote] = datos[too_small];
            datos [too_small] = temp;
            iPivote = too_small;
            // quicksort (izq)
            quickSortRecu(datos, ini , iPivote - 1);
            // quicksort (der)
            quickSortRecu(datos, iPivote + 1, fin);
        }
    }
}
