/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toc_adjust;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 *
 * @author luca
 */
public class OutPtStream 
{
private final String NOME_FILE;
private final StringBuilder TESTO_GREZZO;

public OutPtStream(String nome_file)
{
this.NOME_FILE = nome_file;
TESTO_GREZZO = new StringBuilder("");
scrivi_file(NOME_FILE);
}

public OutPtStream(String nome_file, StringBuilder testo_grezzo)
{
this.NOME_FILE = nome_file;
TESTO_GREZZO = testo_grezzo;
scrivi_file(NOME_FILE);
}

private void scrivi_file(String nome_file)
{
OutputStream nf = null;
    
try
{
nf = new FileOutputStream(nome_file);    
    for (int i = 0; i < TESTO_GREZZO.length(); i++) 
        {
            int datum = TESTO_GREZZO.charAt(i);
            nf.write(datum);
        }

}
catch(IOException ioe)
{
        System.err.printf("Eccezione nella scrittura del file nel metodo scrivi_file() della classe OutPtStream(): %s", ioe);
}
finally
{
    if (nf != null)
        {
            try
                {
                    nf.close();
                }
            catch (IOException ioe)
                {
                    System.err.printf("Errore nel tentativo di chiusura dell'inputStream nel metodo MostraFile: %s", ioe);
                }
        }
}
}

}
