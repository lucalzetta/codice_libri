/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toc_adjust;

/**
 *
 * @author luca
 */
public class Elabora_stringhe 
{
private static StringBuilder ORIGINE;
private StringBuilder ESITO;

public Elabora_stringhe()
{
ORIGINE = new StringBuilder("");
ESITO  = new StringBuilder();
}

public Elabora_stringhe(StringBuilder sb)
{
ORIGINE = new StringBuilder(sb);
ESITO  = new StringBuilder();
}

public StringBuilder a_capo()
{
int conter = 0;
char c;

while(conter < ORIGINE.length())
{
if(conter < 3)
    {
        System.out.println("La stringa origine è lunga: " + ORIGINE.length() + " byte.");
    }    
c = ORIGINE.charAt(conter);
ESITO.append(c);
//System.out.println("La variabile conter vale: " + conter + " il carattere in questa posizione è: " + c);
if((c == '>'))
    {
        ESITO.append('\n');
    }

if((c == '<') & (conter > 1))
    {
//        ESITO.append('\n');
//        ESITO.insert((conter) , '\n');
    }
conter ++;
}

System.out.println("La stringa finale è lunga: " + ESITO.length() + " byte.");
return ESITO;
}

}
