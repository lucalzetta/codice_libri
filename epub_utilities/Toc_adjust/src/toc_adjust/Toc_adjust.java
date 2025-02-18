/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package toc_adjust;

import java.io.IOException;
import java.io.File;
/**
 *
 * @author ubuntu
 */
public class Toc_adjust {

    public static void main(String[] args) throws IOException
    {
     /**
     * @param args the command line arguments
     */
    System.out.println("Hello World!\nIl primo argomento passato alla riga di comando è: " + args[0]
                        + "\nil secondo è: " + args[1] + "\nIl percorso su cui lavoriamo è: " + args[2]);
    String opz = args[0];
    String file_name = args[1];
    String percorso = args[2];
    String albero;
    StringBuilder sb;
    variabili var = new variabili();
    var.set_perc(percorso);
    var.set_file(file_name);
    var.set_file_file(file_name);
    var.set_perc_file(percorso);
    File perc_comp = var.get_file_file_complet();
    InPtSTream is = new InPtSTream(perc_comp);
    //is.mostraFile();
    Elabora_stringhe es = new Elabora_stringhe(is.stringFile());
    sb = es.a_capo();
    System.out.println(var.get_perc());
    ListFiles lf = new ListFiles(var.get_perc());
    System.out.println(sb.toString());
    }
}
    
