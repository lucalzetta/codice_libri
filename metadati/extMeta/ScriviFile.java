/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extMeta;

import static extMeta.extMP3.NOME_DIR;
import static extMeta.extMP3.NOME_FILE;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author luca
 */
public class ScriviFile 
{
private static String NOME_FILE_TO_WRITE;
private static String DIR_DEST;
private static String PREFIX;
    
public ScriviFile(String prefisso, String dir, String nome, String testo)
{
PREFIX = prefisso;    
NOME_FILE_TO_WRITE = prefisso + nome;
DIR_DEST = dir;
scrivi(testo);

}

private void scrivi(String testo)
{
String FileOut;
File f;
FileWriter fw;
BufferedWriter osw = null;
Titoli tit = new Titoli();
//StringBuilder sb = new StringBuilder(testo);
f = new File(tit.RimuoviEstensione(NOME_FILE));
FileOut = NOME_DIR + PREFIX + f + ".txt";
System.out.printf("Il file di output sarà: %s%n", FileOut);
int a = 0;
try
    {
        fw = new FileWriter(FileOut);
        osw = new BufferedWriter(fw);
        while (a < testo.length())
            {
                osw.write(testo.charAt(a));
                a ++;
            }
        osw.close();
    }
catch(IOException fff)
    {
        System.err.printf("File non trovato nel metodo controllaFiles della classe ControlloUTF: %s%n", fff);
    }
finally
    {
        try
            {
                if(osw != null) 
                    {
                        osw.close();
                    }
            }
        catch(IOException IOEint)
            {
                System.err.printf("Errore di chiusura dello stream nel metodo controllaFiles della classe ControlloUTF: %s%n", IOEint);
            }
        
    }
}
}
