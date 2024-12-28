package extMeta;

import java.io.Console;
import java.io.File;

/**
 *
 * @author luca
 */
public class main
{

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws Exception
{
    Titoli ts;
    ControlloUTF cutf;
    String percorso;
    String documento;
    Console cons = System.console();
    File pt;
    File doc;
    
    ts = new Titoli();
    pt = new File("../../../FileAudio/");//percorso mint
    doc = new File("example_1.mp3");
    ts.setpPathOrigin(pt.toString() + "/");
    ts.setPathDest(pt.toString() + "/");
try
    {    
    percorso = cons.readLine("Inserire un percorso valido, percorso predefinito attuale:\n" + pt.toString() + "\n");
    if (percorso != null && !percorso.equals(""))
        {
            pt = new File(percorso);
        }
    
    ts.setpPathOrigin(pt.toString() + "/");
    ts.setPathDest(pt.toString() + "/");

    documento = cons.readLine("Inserire un nome di file valido, file predefinito attuale:\n" + doc.toString() + "\n");
    if (documento != null && !documento.equals(""))
        {
            doc = new File(documento);
        }
    }
catch(NullPointerException npe)
    {
        System.out.println(npe);
    }

    System.out.println("Il percorso selezionato è : " + pt.toString());
    System.out.println("Il file da lavorare è : " + doc.toString());
    
    //ts.setpPathOrigin("/home/luca/GDrive/Luca/LibriERiviste/luca_alzetta/metadati/InLavorazione/FileAudio/");
    //ts.setpPathOrigin(args[0]);
    //ts.setpPathOrigin("/home/luca/GDrive/Luca/LibriERiviste/luca_alzetta/metadati/InLavorazione/VecchieImmagini/");
    //ts.setpPathOrigin("/home/luca/GDrive/Luca/LibriERiviste/luca_alzetta/metadati/InLavorazione/FileODT/");
    //ts.setPathDest("/home/luca/GDrive/Luca/LibriERiviste/luca_alzetta/metadati/InLavorazione/FileAudio/");
    //ts.setPathDest(args[1]);
    //ts.setPathDest("/home/luca/GDrive/Luca/LibriERiviste/luca_alzetta/metadati/InLavorazione/VecchieImmagini/");
    //ts.setPathDest("/home/luca/GDrive/Luca/LibriERiviste/luca_alzetta/metadati/InLavorazione/FileODT/");

    /*A questo punto bisogna definire l'estensione del file e decidere il da farsi*/

    //cutf = new ControlloUTF(ts.getPathDest(), "RadioParadaise_2_sec.mp3");
    //cutf = new ControlloUTF(ts.getPathDest(), "18 - Brano 18.mp3");
    //System.out.println("Il file selezionato ha estensione: " + cutf.estensioneFile());
    //ControlloUTF cutf = new ControlloUTF(ts.getPathDest(), "meta.xml");
    //cutf = new ControlloUTF(ts.getPathDest(), args[2]);
    
    cutf = new ControlloUTF(ts.getPathDest(), doc.toString());    
    cutf.tornaMP3();
}
}
