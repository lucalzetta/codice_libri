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
private static StringBuilder ESITO;

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
    /**
     *Questo metodo inserisce di caratteri di nuova linea '\n' ad ogni 
     *occorrenza del simbolo di parentesi angolare chiusa '>'.*/
int conter = 0;
char c;

System.out.println("La stringa origine è lunga: " + ORIGINE.length() + " byte.");
//char[] test_char = new char[] {'t', 'e', 's', 't', 't', 't'};

while(conter < ORIGINE.length())
{
    c = ORIGINE.charAt(conter);
    ESITO.append(c);
    //System.out.println("La variabile conter vale: " + conter + " il carattere in questa posizione è: " + c);
    if((c == '>'))
        {
            ESITO.append('\n');
        }
conter ++;
}
//a_capo_II(ESITO);
System.out.println("La stringa finale è lunga: " + ESITO.length() + " byte.");
return ESITO;
}

public StringBuilder a_capo_II(StringBuilder origine)
{
     /**
     *Questo metodo rimuove icaratteri di nuova linea '\n' in eccesso*/
    
ORIGINE = origine;
String dest = "";
int conter = 0;
int del = 1;
int niuline = (int)'\n';
int rig = 0;
char c;
boolean nl = false;

//System.out.println("La stringa origine è lunga: " + ORIGINE.length() + " byte.");
//char[] test_char = new char[] {'t', 'e', 's', 't', 't', 't'};

while(conter < ORIGINE.length())
{    
    c = ORIGINE.charAt(conter);
/**
*Rimozione dei new line superflui*/
    while((c == '\n') & (conter < ORIGINE.length()))
        {
            if (!nl)
                {
                    dest = dest + c;
                    nl = true;
                }
            
            if(nl)
                {
                    del = del +1;
                }

            if ( conter < ORIGINE.length())
                {
                    conter ++;
                }
            if ( conter < ORIGINE.length())
                {
                    c = ORIGINE.charAt(conter);
                }
            rig ++;
        }
del = 0;    
nl = false;
//ESITO.append(c);
dest = dest + c;
conter ++;
}
ESITO = new StringBuilder(dest);

System.out.printf("Trovati %d caratteri di nuova linea alla riga %d%nLa Stringa ora è: %s%n", del, rig, dest);

return ESITO;
}

public StringBuilder a_capo_III(StringBuilder origine)
{
    /**
     *Questo metodo inserisce di caratteri di nuova linea '\n' ad ogni 
     *occorrenza del simbolo di parentesi angolare aperta '&lt;'.*/
ORIGINE = origine;
String dest = "";
int conter = 0;
int del = 0;
char c;

System.out.println("La stringa origine è lunga: " + ORIGINE.length() + " byte.");
//char[] test_char = new char[] {'t', 'e', 's', 't', 't', 't'};

while(conter < ORIGINE.length())
{
    c = ORIGINE.charAt(conter);
    //System.out.println("La variabile conter vale: " + conter + " il carattere in questa posizione è: " + c);
    if((c == '<'))
        {
            dest = dest + "\n";
            del = del + 1;
        }
dest = dest + c;
conter ++;
}

ESITO = new StringBuilder(dest);
System.out.println("Sono state riscontrate : " + (del + 1) + " occorrenze del carattere '<'.");
System.out.println("La stringa finale è lunga: " + ESITO.length() + " byte.");
return ESITO;
}
}
