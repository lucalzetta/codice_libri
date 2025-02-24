/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toc_adjust;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author ubuntu
 */
public class scegliXML 
{
private static List LF;
private static List NEW_LF;
private static int CONTATORE;
private final String SUFFISSO;

public scegliXML(List lst_files, String suffisso)
{
LF = lst_files;
SUFFISSO = "." + suffisso;
NEW_LF = new ArrayList<>();
scarta(SUFFISSO);
}

private void scarta(String suffix)
{
Iterator i = LF.iterator();
String nf;

while(i.hasNext())
{
    nf = i.next().toString();
    if(nf.endsWith(suffix))
        {
            NEW_LF.add(nf);
        }
CONTATORE ++;
}
}

public List get_xml()
{
return NEW_LF;
}

public void stampa()
{
Iterator i = NEW_LF.iterator();
int w = 0;

System.out.printf("%n");
for(int n = 0; n < 80; n++)
    {
    System.out.printf("X");
    }
System.out.printf("%nElenco dei file XML presenti nel prgetto.%n");
for(int n = 0; n < 80; n++)
    {
    System.out.printf("X");
    }

while(i.hasNext())
{
    if(i.hasNext())
        {
            System.out.printf("%nRiga %d%n%s", w, i.next());
        }
w++;
}
System.out.printf("%n");
}
}
