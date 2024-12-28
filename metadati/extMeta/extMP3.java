/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extMeta;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.EmptyStackException;

/**
 *
 * @author luca
 */
public class extMP3 
{
private static String RESPONSO;
private static String RESPONSO_COMPLETO;
public static String NOME_FILE;
public static String NOME_DIR = "";
private static String S_GREZZA;
private static String S_PULITA;
private static String S_CAMPI_PERSONALI;
private static String S_TRADOTTA;
private static String S_FORMATTATA;
private static int DIM_NOME_CAMPO;

    /**************************************************************************
     *Audacity, dopo il campo personalizzato definito come TXXX dagli standard*
     *ID3 v2.4, fa seguire la coppia di caratteri 'þÿ' all'inizio del nome    *
     *personalizzato del campo e alla sua fine. Verrà usato nel programma per *
     *individuare inizio e fine campo personalizzato.                         *
     *************************************************************************/
    public final String FINE_CAMPO = "þÿ";

    /**************************************************************************
     *A fine sezione dei metadati viene posta la coppia di caratteri ÿû.      *
     *************************************************************************/
    public final String FINE_TABELLA = "ÿû";

    /**
     *
     * @param nomeDir
     * @param nomeFile
     */
public extMP3(String nomeDir, String nomeFile)
{
/************************************************************************************
*Questo metodo ritorna i caratteri dell'intestazione anche sotto forma di interi per*
*un'analisi più dettagliata dell'intestazione dei file alla ricerca dei metadati.   *
************************************************************************************/
NOME_DIR = nomeDir;
NOME_FILE = nomeFile;

ScriviFile sf;

//System.out.printf("Directory:%s%nFile%s%n", NOME_DIR, NOME_FILE);

S_GREZZA = s_grezza();
sf = new ScriviFile("dati_grezzi_", NOME_FILE, NOME_DIR, S_GREZZA);
//System.out.printf("%s%nMassima dimensione di campo %d caratteri.%n", S_GREZZA,  DIM_NOME_CAMPO);

S_PULITA = s_pulita(S_GREZZA);
sf = new ScriviFile("dati_puliti_", NOME_FILE, NOME_DIR, S_PULITA);
System.out.printf("%s%nMassima dimensione di campo %d caratteri.%n", S_PULITA,  DIM_NOME_CAMPO);

S_CAMPI_PERSONALI = s_campi_personali(S_PULITA);
sf = new ScriviFile("campi_personali_", NOME_FILE, NOME_DIR, S_CAMPI_PERSONALI);
System.out.printf("%s%nMassima dimensione di campo %d caratteri.%n", S_CAMPI_PERSONALI,  DIM_NOME_CAMPO);

S_TRADOTTA = s_tradotta(S_CAMPI_PERSONALI);
sf = new ScriviFile("campi_tradotti_", NOME_FILE, NOME_DIR, S_TRADOTTA);
System.out.printf("%s%nMassima dimensione di campo %d caratteri.%n", S_TRADOTTA,  DIM_NOME_CAMPO);

S_FORMATTATA = s_formattata(S_TRADOTTA);
sf = new ScriviFile("campi_formattati_", NOME_FILE, NOME_DIR, S_FORMATTATA);
System.out.printf("%s%nMassima dimensione di campo %d caratteri.%n", S_FORMATTATA,  DIM_NOME_CAMPO);
}

private String s_grezza()
{

StringBuilder sb;
String fullNome ;
Character car;
int fineMeta;
int a ;
int c;

a = 0;
sb = new StringBuilder();
fullNome = NOME_DIR + NOME_FILE;
FileInputStream fr;
RESPONSO_COMPLETO = "";

try
    {
    fr = new FileInputStream(fullNome);
               
    while((c = fr.read()) != -1)
        {
            a ++;
            car = (char)c;
            sb.append(car);
        }
}
catch (FileNotFoundException fnfe)
    {
        System.err.println("File non trovato nel metodo s_grezza() della classe extMP3: " + fnfe);
    }
catch(IOException ioe)
    {
        System.err.println("Errore di I/O nel metodo s_grezza() della classe extMP3: " + ioe);
    }
                
                /****************************************************************
                *LA stringa così ottenuta contiene dei caratteri non stampabili *
                *per l'uso interno di Audacity o, del formato mp3. di seguito li*
                *sostituiremo con altri ammessi tra i caratteri stampabili ASCII*
                ****************************************************************/
                
                fineMeta = sb.indexOf(FINE_TABELLA);//Questa stringa si trova alla fine dei metadati inseriti 
                                                 //con Audacity 2.4.2
                
sb.delete(fineMeta, sb.length());
RESPONSO_COMPLETO = sb.toString();

return RESPONSO_COMPLETO;
}

private String s_pulita(String stringa_grezza)
{
StringBuilder sb;
Integer cInt;
int a ;

sb = new StringBuilder(stringa_grezza);
a = sb.length();

RESPONSO = "";
System.out.printf("La lunghezza dello StringBuilder è di %d caratteri%n"
                 + "il valore della variabile \'a\' è di %d%n", sb.length(), a);

 cInt = 0;
    while(cInt < a)
        {
            if(sb.charAt(cInt) < 32)
                {
                }
            else
                {
                    RESPONSO = RESPONSO + sb.charAt(cInt);
                }
                    
            cInt ++;
                    
        }
    RESPONSO_COMPLETO = tabella_campi(RESPONSO);
    System.out.println(RESPONSO_COMPLETO);
                
return RESPONSO_COMPLETO;
}

private String s_campi_personali(String stringa_pulita)
{
/**********************************************************************************
*Questo metodo si occupa della sostituzione dei nomi dei campi PERSONALIZZATI     *
*e della definizione della loro lunghezza per ottimizzare l'output.               *
*                                                                                 *
**********************************************************************************/   

int dim_c;
int fineMeta = 0;
int fineCampo;
int init_campo;
//String campo = "";
StringBuilder sb = new StringBuilder(stringa_pulita);

while((sb.indexOf("TXXX", fineMeta)) != -1)
                        {                
                            fineMeta = sb.indexOf("TXXX", fineMeta);//trovata la corrispondenza con un campo 
                                                                               //personalizzato la rimuoviamo e passiamo 
                                                                               //all'analisi del nome del campo definito
                                                                               //dall'utente.
                            init_campo = sb.indexOf(FINE_CAMPO,fineMeta);
                            fineCampo = sb.indexOf(FINE_CAMPO, fineMeta + 6);
                            //sostituiamo i caratteri di fine campo del programma con i 
                            //nostri personalizzati
                            sb.replace(fineCampo, fineCampo + FINE_CAMPO.length(), ": |||");
                            //aggiorniamo la dimensione del campo più lungo per 
                            //l'ottimizzazione dell'output
                            dim_c = fineCampo - init_campo;
                            if(dim_c > DIM_NOME_CAMPO)
                                {
                                    DIM_NOME_CAMPO = dim_c;
                                }
                            //Rimuoviamo i caratteri iniziali dei campi personalizzati
                            //assegnati dal programma
                            sb.replace(fineMeta, fineMeta + (4 + FINE_CAMPO.length()), "");
                            fineMeta +=1;
                        }
RESPONSO_COMPLETO = sb.toString();
return RESPONSO_COMPLETO;
}

private String s_tradotta(String stringa_pulita)
{
/**********************************************************************************
*Questo metodo si occupa della sostituzione dei nomi dei campi uniformati ID3 v2.4*
*Con altri selezionati dalla select nomi_campi_ita(), ma è possibile crearne di   *
*diverse a piacimento.                                                            *
**********************************************************************************/

StringBuilder sb;
String campo;
String testo;
Titoli tit = new Titoli();
int fineMeta = 0;
int dim_c;
int a ;

ArrayList<String> nc = this.nomi_campi_MP3();

sb = new StringBuilder(stringa_pulita);
a = sb.length();
RESPONSO = "";

for(int c = 0; c < nc.size(); c++)
    {
            
        campo = nc.get(c);
                
        while((sb.indexOf(campo, fineMeta)) != -1)
            {
                
                fineMeta = sb.indexOf(campo, fineMeta);
                testo = desc_campi_ita(campo);
                dim_c = testo.length();
                if (dim_c > DIM_NOME_CAMPO)
                    {
                        DIM_NOME_CAMPO = dim_c;
                    }
                sb.replace(fineMeta, fineMeta+4, testo);
                fineMeta +=1;
            }
            fineMeta = 0; //resettiamo fineMeta per un nuovo nome di campo.
    }

 RESPONSO_COMPLETO = sb.toString();
//System.out.println(RESPONSO_COMPLETO);               
return RESPONSO_COMPLETO;
}

private String s_formattata(String stringa_pulita)
{
/******************************************************************************
*Questo metodo ritorna la versione formattata della stringa finale raggiunta  *
*dopo la pulizia di tutti i caratteri accessorii.                             *
*Non può prescindere dall'impostazione del valore corretto di @param          *
*DIM_NOME_CAMPO, pertanto va invocato in successione con gli altri metodi     *
*secondo la prescrizione del metodo costruttore con parametri.                *
******************************************************************************/

StringBuilder sb = new StringBuilder(stringa_pulita);
int fine_campo = 0;
int init_campo;
int lung_campo;
int spazi;
String spazii;

init_campo = sb.indexOf("\n", fine_campo);

while(sb.indexOf(": |||", fine_campo) != -1)
    {
        spazii = "";
        fine_campo = sb.indexOf(": |||");
        lung_campo = fine_campo - init_campo;
        spazi = DIM_NOME_CAMPO - lung_campo;
        while (spazi > 0)
            {
                spazii = spazii + " ";
                spazi --;
            }
    
        sb.replace(fine_campo + 2, fine_campo + 5, spazii);
        init_campo = sb.indexOf("\n", fine_campo);
        fine_campo = fine_campo + 5;
    }
fine_campo = sb.indexOf(FINE_TABELLA);
if(fine_campo != -1)
    {
        sb.replace(fine_campo, sb.length(), "\n");
    }
RESPONSO_COMPLETO = sb.toString();
return RESPONSO_COMPLETO;
}

private String tabella_campi(String Responso)
{
/******************************************************************************
*Questo metodo suddivide il testo dei metadati in base al riscontro con i nomi*
*dei campi, alcuni dei campi, dello standard ID3 v2.4. Si avvale anche di una *
*PriorityQueue per definire le posizioni di inizio e fine dei campi.          *
******************************************************************************/

ArrayList<String> nc = nomi_campi_MP3();
ArrayList<Integer> a_campi;
Queue <Integer> q_campi = new PriorityQueue<>();
String risulta;
String campo;
Integer memo = 0;
Integer indice;
Integer indice_fine = 0;

a_campi = new ArrayList<>();
a_campi.add(memo);//inseriamo il limite iniziale della stringa tra i valori di inizio e fine campo
    
        for(int c = 0; c < nc.size(); c++)
            {
            
                campo = nc.get(c);
                
                while((Responso.indexOf(campo, memo)) != -1)
                        {
                
                            memo = Responso.indexOf(campo, memo);
                            a_campi.add(memo);
                            memo +=1;
                        }
                memo = 0; //resettiamo memo per un nuovo nome di campo.
            }


        //aggiungiamo il limite finale della stringa tra i valori di inizio e fine campo
memo = Responso.length();
a_campi.add(memo);

System.out.println(a_campi.toString());

q_campi.addAll(a_campi);

/*Ora estraiamo i campi riga per riga riferendoci agli indici memorizzati nella PriorityQueue*/ 

RESPONSO_COMPLETO = "";

indice = q_campi.poll();

while (indice_fine != null)
    {
        indice_fine = q_campi.poll();

        if(indice_fine != null)
            {
                RESPONSO_COMPLETO = RESPONSO_COMPLETO + Responso.substring(indice, indice_fine) + "\n";
                indice = indice_fine;
            }
    }

risulta = RESPONSO_COMPLETO;
return risulta;
}

private ArrayList<String> nomi_campi_MP3()
{
/*****************************************************************************
*In questa lista sono inseriti alcuni dei 74 identificatori di campi dello   *
*standard ID£ v2.4, l'elenco è liberamente espandibile.                      *
*****************************************************************************/
    
ArrayList <String> nc = new ArrayList<>();
    
nc.add("TCOM");
nc.add("TDAT");
nc.add("TIME");
nc.add("COMM");
nc.add("TPE1");
nc.add("TPE2");
nc.add("TCON");
nc.add("TYER");
nc.add("TIT1");
nc.add("TIT2");
nc.add("TIT3");
nc.add("TRCK");
nc.add("TALB");
nc.add("TPUB");
nc.add("TDRC");
nc.add("TXXX");

return nc;
}

private String desc_campi_ita(String acro)
{
    
/*******************************************************************************
*Questa 'select' traduce i nomi dei campi dello standard ID3 v2.4 in nomi      *
*descrittivi, è possibile modificarla o tradurla o duplicarla per ottenere     *
*degli putput diversi. I problemi di formattazione del testo ottenuto vengono  *
*risolti in una classe apposita.                                               *
*Si consiglia di sincronizzare questo metodo con il precedente ArrayList.      *
*La sequenza  ': |||' denota la fine del campo per la successiva formattazione.*
*******************************************************************************/
String desc = "";

switch (acro)
    {
    case "TCOM":
        desc = "Compositore: |||";
        break;
    case "TDAT":
        desc = "Data di esecuzione: |||";
        break;
    case "TIME":
        desc = "Durata del brano: |||";
        break;
    case "COMM":
        desc =  "Commento: |||";
        break;        
    case "TPE1":
        desc = "Prima voce, solista: |||";
        break;        
    case "TPE2":
        desc = "Orchestra, banda, coro di accompagnamento: |||";
        break;        
    case "TCON":
        desc = "Tipo di contenuto: |||";
        break;        
    case "TIT1":
        desc = "Titolo della collezione: |||";
        break;        
    case "TYER":
        desc = "Anno di produzione: |||";
        break;        
    case "TIT2":
        desc = "Titolo della traccia: |||";
        break;        
    case "TIT3":
        desc = "Sottotitolo o altra specificazione: |||";
        break;        
    case "TRCK":
        desc = "Numero d'ordine di riproduzione della traccia: |||";
        break;        
    case "TALB":
        desc = "Titolo dell'album, del video, dello show: |||";
        break;        
    case "TPUB":
        desc = "Editore: |||";
        break;        
    case "TDRC":
        desc = "Anno di produzione Audacity: |||";
        break;        
    case "TXXX":
        desc = "";
        break;        
}

return desc;
}

}