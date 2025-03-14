/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toc_adjust;

import java.io.IOException;
import java.io.Console;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author luca
 */
public class EvalOpz 
{
/************************************************************************************
*Questa classe valuta le opzioni passate dalla riga di comando come primo argomento *
*quindi decide cosa fare.                                                           *
*Valuteremo se è il caso di inserire un exit status per terminare l'esecuzione.     *
************************************************************************************/
private static String OPZ;
private List LF;
private static StringBuilder SB;
private static InPtSTream IN;
private static OutPtStream OUT;
private static Elabora_stringhe ES;
private static passa_file PF;

public EvalOpz(String opz, String percorso)throws IOException
{
/*ATTENZIONE, la variabile percorso non garantisce la presenza del nome di un file valido
*gestire possibili errori.*/    
OPZ = opz;
scelta();
SB = new StringBuilder("");
//IN = new InPtSTream(percorso);
}

private void scelta()throws IOException
{
boolean accolta = false;
Console cs = System.console();
String opz;
String dir;
variabili vr = new variabili();
scegliXML sx;


while (accolta == false)
    {
        switch (OPZ)
            {
            case "-n":
                    System.out.println("Cercheremo di modificare la numerazione delle note!");
                    vr.set_opzione(OPZ);
                    accolta = true;
                    break;
            case "-t":
                    System.out.println("Cercheremo di modificare la numerazione dei capitoli "
                            + "presenti nella toc!");
                    vr.set_opzione(OPZ);
                    dir = vr.get_perc();
                    System.out.println("Invocazione di ListFiles() con l'argomento: " + dir);
                    ListFiles tf = new ListFiles(dir);
                    LF = new ArrayList();
                    LF = tf.get_tree_dir();
                    sx = new scegliXML(LF, "ncx");//crea una lista di tutti i file con estensione .ncx contenuti nella directory
                    //e nelle subdirectory (un solo file presunto.)
                    PF = new passa_file(sx.get_xml());
                    accolta = true;
                    break;
            case "-g":
                    System.out.println("Cercheremo di elaborare i file xml da presentare a git!");
                    vr.set_opzione(OPZ);
                    dir = vr.get_perc();
                    System.out.println("Invocazione di ListFiles() con l'argomento: " + dir);
                    ListFiles lf = new ListFiles(dir);
                    LF = new ArrayList();
                    LF = lf.get_tree_dir();
                    sx = new scegliXML(LF, "xml");//crea una lista di tutti i file con estensione .xml contenuti nella directory
                    //e nelle subdirectory.
                    sx.stampa();
                    PF = new passa_file(sx.get_xml());
                    accolta = true;
                    break;
            default:
                    opz = cs.readLine("%nInserire \'-n\' per modificare la numerazione delle note%n"
                + "\'-t\' per modificare la numerazione dei capitoli nella toc%n"
                + "\'-g\' per elaborare i file xml da  presentare a git%n");
                    OPZ = opz;
                    vr.set_opzione(OPZ);
                    break;

            }
    }
}

}
