package extMeta;

import java.util.TreeSet;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author luca
 */
public class ControlloUTF 
{
/*****************************************************************************
*Questa classe si occupa del controllo dei file di una directory che siano   *
*riconducibili a file di testo per scovare caratteri non ASCII ed            *
*eventualmente sostituirli con i rispetttivi caratteri UTF-8.                *
*****************************************************************************/
private static String RESPONSO;
private static String RESPONSO_COMPLETO;
private static String NOME_FILE;
private static TreeSet<String> NUOVI_NOMI;
private final String NOME_DIR;
private static StringBuilder SB;
private Character CHAR;
private String STRING;
private int[] CHARARR;
private Scanner SCANNER;

    /**
     *
     * @param nomeDir
     * @param nomeFile
     */
    public ControlloUTF(String nomeDir, String nomeFile)
{    
NOME_DIR = nomeDir;
NOME_FILE = nomeFile;
SB = new StringBuilder();
CHARARR = new int[1];
System.out.println(NOME_FILE);
System.out.println(NOME_DIR);
}

    /**
     *
     */
    public void controllaFiles()
{
int a = 0;
String nomeFile ;
String fullNome ;

        a += 1;
        nomeFile = NOME_FILE;
        fullNome = NOME_DIR + nomeFile;
        
        try
            {
                RESPONSO = RESPONSO + "Controllo del file " + NOME_FILE + " in " + NOME_DIR + "\n";
                RESPONSO = RESPONSO + "________________________________________________________" + "\n";
                SCANNER = new Scanner(new BufferedReader(new FileReader(fullNome)));
                while(SCANNER.hasNext())
                    {
                            a+=1;
                            //RESPONSO = RESPONSO + SCANNER.next() + " &&&&&&&&&ripetizione N° " + a + "\n";
                            RESPONSO = RESPONSO + SCANNER.next() + "\n";//output più compatto
                    }
                
                RESPONSO = RESPONSO + "________________________________________________________" + "\n";
                System.out.println(RESPONSO);
                
            }
        catch(IOException fff)
            {
                System.err.printf("File non trovato nel metodo controllaFiles della classe ControlloUTF: %s%n", fff);
            }

}

    /**
     *
     * @return
     */
    public String estensioneFile()
{
int a;
String ext;//contiene l'estensione del file
StringBuilder sb;

sb = new StringBuilder(NOME_FILE);
a = sb.lastIndexOf(".");
if (a != -1)
    {
        ext = sb.substring(a);
    }
else
    {
        System.out.println("Il nome del file non contiene estensioni valide!");
        ext = "";
        return ext;
    }

return ext;
}

    /**
     *
     */
public void tornaMP3()throws Exception
{
extMP3 MP;    
MP = new extMP3(NOME_DIR, NOME_FILE);
}

}

