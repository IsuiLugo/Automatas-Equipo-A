//Ejercicio 2.6, figura 2.11
package Automatas;

import javax.swing.*;

public class NFA {

    static String w = JOptionPane.showInputDialog(null, "Ingrese la cadena");

    //Método para determinar el estado delta
    public static String Estado(String q, char a){
        String p = "";

        //Transiciones delta
        if(q.equals("q0") && a == '0'){
            for (int i = 0; i<w.toCharArray().length;i++){
                if (w.charAt(i)+1 == '0'){
                    p = "q3";
                } else {
                    p = "q1";
                }
            }
        } else if (q.equals("q0") && a == '1'){
            for (int i = 0; i<w.toCharArray().length;i++){
                if(w.charAt(i)+1 == '1'){
                    p = "q1";
                } else {
                    p = "q3";
                }
            }
        } else if (q.equals("q1") && a == '1'){
            p = "q2";
        } /*else if (q.equals("q1") && a == '0'){
            p = "";
            System.out.println("Vacio");
        }*/ else if (q.equals("q2") && a == '0'){
            p = "q2";
        } else if (q.equals("q2") && a == '1'){
            p = "q2";
        } else if (q.equals("q3") && a == '0'){
            p = "q4";
        }/* else if (q.equals("q3") && a == '1'){
            p = "";
            System.out.println("Vacio");
        }*/ else if (q.equals("q4") && a == '0'){
            p = "q4";
        } else if (q.equals("q4") && a == '1'){
            p = "q4";
        }

        return p;
    }

    //Método que itera el estado delta, donde q es el estado inicial la cadena
    public static String iteraDelta(String q, String w){
        String p = null;
        for (int i = 0; i<w.length(); i++){
            p = Estado(q, w.charAt(i));
            q = p;
        }
        return p;
    }

    //Método que valida si el simbolo esta en estado final
    public static boolean ValidaEstado(String w){
        boolean val = false;
        String p = iteraDelta("q0",w);
        if (p.equals("q2") || p.equals("q4")){
            val = true;
        }
        return val;
    }

    //Método que comprueba la si el estado es final o no
    public static void Comprueba(String w){
        if (ValidaEstado(w)){
            System.out.println("Es valida");
        } else {
            System.out.println("No es valida");
        }
    }

    public static void main(String[] args) {
        NFA objeto = new NFA();
        objeto.Comprueba(w);


    }
}
