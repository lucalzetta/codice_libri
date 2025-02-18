/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toc_adjust;

import java.io.File;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luca
 */
public class ListFiles 
{
/*****************************************************************************
*Questa classe crrea un array dei file presenti nella directory da lavorare. *
*****************************************************************************/    
private final String DIR;
private static File[] LF;
private static List<File> LSF;
private static int GCONTER;
/**/

public ListFiles(String direct)
{
DIR = direct;
LSF = new ArrayList();
loopper(DIR);
stampa();
}

private void loopper(String dire)
{
File linea;
String lista = "";
int x = 0;
File dir = new File(dire);
LF = new File[(dir.listFiles()).length];
LF = dir.listFiles();
int entrate = LF.length;
System.out.println("Classe ListFiles, metodo loopper, lunghezza dell'array LF[]: " + entrate);

//aggiungiamo tutti gli elementi della directory di partenza.
while (x < LF.length)
    {
        linea = (LF[x]);
        if(!LSF.contains(linea))
            {
                for(int r = 0; r < 80; r++)
                    {
                        System.out.printf("A");
                    }
                System.out.printf("%nDal metodo loopper, aggiunta all'arrayList di :%n%s%n", linea.toString());
                LSF.add(linea);
                lista = lista + linea.toString() + "\n";
                if(linea.isDirectory())
                    {
                        lf(linea.toString());
                    }
            }
        x++;
        GCONTER++;
    }

/*x = 0;
//poi cerchiamo le directory e le passiamo a lf()
while (x < LF.length)
    {
        linea = (LF[x]);
        if(linea.isDirectory())
            {
                System.out.printf("%nDal metodo loopper, chiamata di lf(), valore dell'argomento : %s%n", linea.toString());
                lf(linea.toString());
            }
    }*/
}

private String lf(String dire)
{
String lista = "";
File linea = new File(dire);
File[] linea_a = new File[linea.listFiles().length];
linea_a = linea.listFiles();
int x = 0;

while (x < linea_a.length)
    {
        linea = (linea_a[x]);
        lista = lista + linea.toString() + "\n";
        if(!LSF.contains(linea))
            {
            for(int r = 0; r < 80; r++)
                    {
                        System.out.printf("B");
                    }

                System.out.printf("%nDal metodo lf, aggiunta all'ArrayList di :%n%s%n", linea.toString());
                LSF.add(linea);
            if(linea.isDirectory())
                {
                    System.out.printf("%nDal metodo lf, chiamata di loopper(), valore dell'argomento : %s%n", linea.toString());
                    loopper(linea.toString());
                }
            }
        x++;
        GCONTER++;
    }

System.out.printf("%nDal metodo lf, chiamata di loopper() ALLA fine del ciclo, valore dell'argomento : %s%n", dire);
loopper(DIR);

//System.out.printf("Dal metodo lf:%n%s", lista);
return lista;
}

private void stampa()
{
Iterator i = LSF.iterator();
String ris;
int w = 0;

System.out.printf("Fine della classe, stampa di prova per la "
        + "lettura del risultato dell'elaborazione.%n");
for(int r = 0; r < 80; r++)
    {
        System.out.printf("C");
    }

System.out.printf("%nTotale cicli svolti: %d%n", GCONTER);

while(i.hasNext())
{
System.out.printf("%nRiga %d%n%s", w,i.next());
w++;
}

}
}
