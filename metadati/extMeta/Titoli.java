package extMeta;

/**
 *
 * @author luca
 */
public class Titoli 
{
private static String PERCORSO_FILE_ORIGINE_LIBRO;
private static String PERCORSO_FILE_FINE_LIBRO;

    /**
     *
     */
    public Titoli()
{
PERCORSO_FILE_ORIGINE_LIBRO = "";
PERCORSO_FILE_FINE_LIBRO = "";
}

/*metodi per l'impostazione delle variabili
-------------------------------------------*/

    /**
     *
     * @param percorso_file_origine_libro
     */


public void setpPathOrigin(String percorso_file_origine_libro)
{
this.PERCORSO_FILE_ORIGINE_LIBRO = percorso_file_origine_libro;
}

    /**
     *
     * @param percorso_file_fine_libro
     */
    public void setPathDest(String percorso_file_fine_libro)
{
this.PERCORSO_FILE_FINE_LIBRO = percorso_file_fine_libro;
}

/*metodi per la consegna delle variabili
******************************************/

    /**
     *
     * @return
     */
    public String getpPathOrigin()
{
return this.PERCORSO_FILE_ORIGINE_LIBRO;
}

    /**
     *
     * @return
     */
    public String getPathDest()
{
return this.PERCORSO_FILE_FINE_LIBRO;
}

    /**
     *
     * @param nome_file
     * @return
     */
    public String RimuoviEstensione(String nome_file)
{
StringBuilder sb = new StringBuilder();
int punto_punto;

sb.append(nome_file);

if(sb.lastIndexOf(".") != -1)
    {
        punto_punto = sb.lastIndexOf(".");
        sb.delete(punto_punto, sb.length());
    }

nome_file = sb.toString();

return nome_file;
}
}
