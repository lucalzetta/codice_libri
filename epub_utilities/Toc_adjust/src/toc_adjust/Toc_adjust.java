/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package toc_adjust;

import java.io.IOException;

/**
 *
 * @author Luca Alzetta
 */
public class Toc_adjust {

    public static void main(String[] args) throws IOException
    {
     /**
     * @param args the command line arguments
     */

    System.out.println("\nIl primo argomento passato alla riga di comando è: " + args[0]
                        + "\nil secondo è: " + args[1]);

    String opz = args[0];
    String percorso = args[1];
    
    variabili var = new variabili();
    var.set_perc(percorso);
    var.set_perc_file(percorso);
    var.set_opzione(opz);
    
    EvalOpz eo = new EvalOpz(opz, percorso);
    }
}
    
