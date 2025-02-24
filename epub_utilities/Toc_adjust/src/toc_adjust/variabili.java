package toc_adjust;

import java.io.File;

public class variabili
{
private  static String PERCORSO;
private static String FILE;
private static File FILE_FILE;
private static File PERCORSO_FILE;
private static File FILE_COMPLETO_FP;
private static String OPZ;

public variabili()
{

}

public String get_perc()
{
return PERCORSO;
}

public File get_perc_file()
{
return PERCORSO_FILE;
}

public String get_file()
{
return FILE;
}

public File get_file_file()
{
return FILE_FILE;
}

public File get_file_file_complet()
{
this.FILE_COMPLETO_FP = new File(this.PERCORSO, this.FILE);    
return FILE_COMPLETO_FP;
}

public String get_opzione()
{
return OPZ;
}

/*************FINE DELLE IMPOSTAZIONI DELLE VARIABILI*****************/

/*************INIZIO DELLA LETTURA DELLE VARIABILI*****************/
public void set_perc(String percorso)
{
PERCORSO = percorso;
}

public void set_perc_file(String percorso)
{
PERCORSO_FILE  = new File( percorso);
}

public void set_file (String nome_file)
{
FILE = nome_file;
}

public void set_file_file (String nome_file)
{
FILE_FILE= new File(nome_file);
}

public void set_opzione(String opz)
{
OPZ = opz;
}

}

