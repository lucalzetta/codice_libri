/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toc_adjust;

import java.util.List;
import java.util.Iterator;
import java.io.IOException;
/**
 *
 * @author ubuntu
 */
public class passa_file 
{
/********************************************************************
*Questa classe riceve una lista di file come input e li passa alla  *
*classe OutPtStream() dopo averli fatti elaborare per la scrittura  *
*su un nuovo file.                                                  *
********************************************************************/
private static StringBuilder ST_BUID;
private final variabili VAR;

public passa_file(String file_in, StringBuilder testo_originale)
{
    /**
     Questo costruttore di default è stato usato per fare dei test su file
     singoli, il vero scopo di questa classe è ottenere una lista di file da
     elaborare in blocco. In seguito probabilmente questo costruttore potrà
     essere utile per la modifica della toc e del file delle note.*/
String nome_old_file;
String nome_new_file;
String ext;
int ind;
OutPtStream os;
ST_BUID = testo_originale;
VAR = new variabili();
String opz = VAR.get_opzione();
nome_old_file = file_in;
ind = nome_old_file.lastIndexOf(".");
ext = nome_old_file.substring(ind, nome_old_file.length());
nome_new_file = nome_old_file.substring(0, ind) + "(1)" + ext;
os = new OutPtStream(nome_new_file, ST_BUID);

}

public passa_file(List file_list)throws IOException
{
Iterator it = file_list.iterator();
String nome_old_file;
VAR = new variabili();
String opz = VAR.get_opzione();

while (it.hasNext())
{
nome_old_file = it.next().toString();
switch (opz)
    {
    case "-g":
        while (it.hasNext())
            {
                nome_old_file = it.next().toString();
                opz_xml(nome_old_file);
            }
        break;
    case "-t":
        opz_toc(nome_old_file);
        break;
    }
                    
}

}

private void opz_xml(String nome_file)throws IOException
{
InPtSTream IN;    
Elabora_stringhe ES;
StringBuilder SB;
OutPtStream os;

IN = new InPtSTream(nome_file);
SB = IN.stringFile();
ES = new Elabora_stringhe(SB);
SB = ES.a_capo();
SB = ES.a_capo_III(SB);
SB = ES.a_capo_II(SB);
os = new OutPtStream(nome_file, SB);
}

private void opz_toc(String nome_file)throws IOException
{
InPtSTream IN;    
Elabora_stringhe ES;
StringBuilder SB;
OutPtStream os;

IN = new InPtSTream(nome_file);
SB = IN.stringFile();
ES = new Elabora_stringhe(SB);
SB = ES.numera_toc(SB);
os = new OutPtStream(nome_file, SB);
}
}
