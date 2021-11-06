package Automatas;

import javax.swing.*;

public class DFAtwo {
    public static String Delta(String q, char a){
        String p = null;

        if(q.equals("q0") && a == '0'){
            p = "q1";
            System.out.println("q1");
        } else if(q.equals("q0") && a == '1'){
            p = "q0";
            System.out.println("q0");
        } else if(q.equals("q1") && a == '0'){
            p = "q2";
            System.out.println("q2");
        } else if(q.equals("q1") && a == '1'){
            p = "q0";
            System.out.println("q0");
        } else if(q.equals("q2") && a == '0'){
            p = "q3";
            System.out.println("q3");
        } else if(q.equals("q2") && a == '1'){
            p = "q0";
            System.out.println("q0");
        } else if(q.equals("q3") && a == '1'){
            p = "q3";
            System.out.println("q3");
        } else if(q.equals("q3") && a == '0'){
            p = "q3";
            System.out.println("q3");
        }
        return p;
    }

    public static String deltaIterativa(String q, String w){
        String p = "";
        int i = 0;

        while (i<w.length()){
            p = Delta(q, w.charAt(i));
            q = p;
            i++;
        }
        return p;
    }

    public static boolean Valida(String w){
        boolean val = false;
        String p = deltaIterativa("q0",w);

        if (p.equals("q3")){
            val = true;
        }
        return val;
    }
    public static void Comprueba(String w){
        if (Valida(w)){
            System.out.println(w+" es valida");
        } else {
            System.out.println(w+" no es valida");
        }
    }

    public static void main(String[] args) {
        String w = JOptionPane.showInputDialog(null, "Ingrese la cadena w: ");
        System.out.println("L = {w | w tiene secuencias de 000}");
        System.out.println("w = " + w);
        System.out.println("Recorrido :");
        DFAtwo Objeto = new DFAtwo();
        Objeto.Comprueba(w);
    }
}
