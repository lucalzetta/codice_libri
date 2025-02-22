package toc_adjust;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class InPtSTream 
{
/*********************************************************
*Qyesta classe,                                          *
*crea un inputstream basato su un file e ne restituisce  *
*il contenuto.                                           *
*********************************************************/
private final InputStream in;
private int[] dati;
private static String nomeFile;

public InPtSTream(String nomeFileCompleto)throws IOException
{
    nomeFile = nomeFileCompleto;
    in = new FileInputStream(nomeFile);
    getLength();
    mostraFile();
}

public InPtSTream(File nomeFileCompleto)throws IOException
{
    nomeFile = nomeFileCompleto.toString();
    in = new FileInputStream(nomeFile);
    getLength();
    mostraFile();
}

private void getLength()
{
int lunghezzaFile = 0;
boolean b = true;

try
    {
    while (b)
        {
            int dato = in.read();
            if(dato == -1) break;
            lunghezzaFile = lunghezzaFile +1;
        }
    dati = new int[lunghezzaFile];
    System.out.println("Il file " + nomeFile + " è lungo: " + lunghezzaFile + " byte.");
    }
catch(IOException ioe)
    {
        System.out.printf("Eccezione nella lettura ddel file: %s", ioe);
    }
}

private void mostraFile()
{
InputStream nf = null;
    
try
{
nf = new FileInputStream(nomeFile);    
    for (int i = 0; i < dati.length; i++) 
        {
            int datum = nf.read();
            if (datum == -1)break;
            dati[i] = datum;
        }
    for (int i = 0; i < dati.length; i++) 
        {
            char cara = (char)dati[i];
            System.out.printf("%s", cara);
        }
}
catch(IOException ioe)
{
        System.err.printf("Eccezione nella lettura del file nel metodo mostraFile: %s", ioe);
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

public StringBuilder stringFile()
{
/*******************************************************************************
*Questo metodo passa il contenuto di un file di testo ad uno STringBuilder per *
*poterlo in seguito modificare e ricopiare in un nuovo file modificato.        *
*******************************************************************************/
StringBuilder sb = new StringBuilder();
InputStream nf = null;
    
try
{
nf = new FileInputStream(nomeFile);    
    for (int i = 0; i < dati.length; i++) 
        {
            int datum = nf.read();
            if (datum == -1)break;
            dati[i] = datum;
        }
    for (int i = 0; i < dati.length; i++) 
        {
                    char cara = (char)dati[i];
                    sb.append(cara);
        }
}
catch(IOException ioe)
{
        System.out.printf("Eccezione nella lettura del file nel metodo stringFile: %s", ioe);
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
return sb;
}

}

