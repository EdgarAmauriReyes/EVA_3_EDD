import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        // VAMOS A ORDENAR ARREGLOS(INT)
        int[] datos = new int[20];
        llenar(datos);
        imprimir (datos);
        selectionSort(datos);
        imprimir(datos);
        Scanner input = new Scanner (System.in);
        System.out.println(" Valor a buscar: ");
        int valor = input.nextInt();
        int iResu = binarySearch(datos, valor);
        System.out.println("El numero esta en la posicion" + iResu);

    }

    public static void imprimir(int [] datos) {
        for (int i = 0; i < datos.length; i++) {
            System.out.print("[" + datos[i] + "]");
        }
        System.out.println("");
    }

    //LLENADO DE ARREGLOS
    public static void llenar(int [] datos){
        for(int i=0; i<datos.length; i++){
            datos[i]= (int)(Math.random()*100);
        }
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

    public static int binarySearch(int[] datos,int valBuscar){
        return binarySearchRecu(datos, valBuscar, 0,datos.length -1);

    }

    private static int binarySearchRecu(int[] datos,int valBuscar,int ini, int fin ){
        int iMid , iResu;
        iMid = ini + ((fin - ini) / 2); // posicion a la mitad de la busqueda
        iResu = -1; //SI EL VALOR NO EXISTE, REGRESAMOS -1
         if(fin>= ini){// buscamos
             if(valBuscar == datos[iMid]){// el valor esta a la mitad
                 iResu = iMid; //aqui esta el valor, y lo regresamos
             }else if (valBuscar < datos[iMid]){// el valor no esta a la mitad, pero puede estar a la izquierda
                 //llamamos recursivamente a la busqueda binaria
                 iResu = binarySearchRecu(datos,valBuscar, ini , iMid - 1);
             }else { // no esta, pero puede estar a la der
                 iResu = binarySearchRecu(datos,valBuscar, iMid + 1, fin);
             }
         }// se detiene el proceso

        return iResu;
    }
}
