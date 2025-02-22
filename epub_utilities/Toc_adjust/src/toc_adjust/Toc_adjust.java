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
    //args = new String[3];
//il contenuto del primo argomento è controllato dallo script EpubUtils.sh, il terzo è
//fornito senza intervento dell'utente come percorso di partenza. Va impostato un controllo
//sul secondo argomento.

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
    
