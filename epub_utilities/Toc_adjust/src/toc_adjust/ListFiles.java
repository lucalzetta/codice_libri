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


public ListFiles(String direct)
{
DIR = direct;
LSF = new ArrayList();
System.out.println("Invocazione del loopper() con l'argomento: " + DIR);
loopper(DIR);
//stampa();
}

private void loopper(String dire)
{
File linea;
String lista = "";
int x = 0;
File dir = new File(dire);
LF = new File[(dir.listFiles()).length];
LF = dir.listFiles();

//aggiungiamo la directory di partenza.
linea = new File(DIR);
LSF.add(linea);
//aggiungiamo tutti gli elementi della directory di partenza.
while (x < LF.length)
    {
        linea = (LF[x]);
        if(!LSF.contains(linea))
            {
/*                for(int r = 0; r < 80; r++)
                    {
                        System.out.printf("A");
                    }
                System.out.printf("%nDal metodo loopper, aggiunta all'arrayList di :%n%s%n", linea.toString());*/
                LSF.add(linea);
                lista = lista + linea.toString() + "\n";
                //SE L'Elemento è una directory passiamo il controllo a lf()
                if(linea.isDirectory())
                    {
                        lf(linea.toString());
                    }
            }
        x++;
        GCONTER++;
    }
}

private void lf(String dire)
{
File linea = new File(dire);
File[] linea_a = new File[linea.listFiles().length];
linea_a = linea.listFiles();
String old_dir;
int x = 0;

while (x < linea_a.length)
    {
        linea = (linea_a[x]);
        if(!LSF.contains(linea))
            {
/*            for(int r = 0; r < 80; r++)
                    {
                        System.out.printf("B");
                    }

                System.out.printf("%nDal metodo lf, aggiunta all'ArrayList di :%n%s%n", linea.toString());*/
                LSF.add(linea);
            if(linea.isDirectory())
                {
                    loopper(linea.toString());
                }
            }
        x++;
        GCONTER++;
    }
//a questo punto bisogna ridiscendere il ramo già ispezionato e riprendere il controllo
//sui rami non ancora percorsi
old_dir = linea.getParent();
linea = new File(old_dir);

old_dir = linea.getParent();

if(old_dir.contains(DIR))
    {
       loopper(old_dir);
    }
}

private void stampa()
{
Iterator i = LSF.iterator();
int w = 0;

//System.out.printf("%nTotale cicli svolti: %d%n", GCONTER);

while(i.hasNext())
{
    if(i.hasNext())
        {
            System.out.printf("%nRiga %d%n%s", w, i.next());
        }
w++;
}
}

public List<File> get_tree_dir()
{
return LSF;
}

}
