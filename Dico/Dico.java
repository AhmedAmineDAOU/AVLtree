import java.io.*;
public class Dico  {
   
	ABR<StringDataa> Dictionnary;



	
 	public Dico(String filename){
		Dictionnary =new ABR<StringDataa> ((StringDataa)null);
		String line;
    		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
					Dictionnary.InsertionFeuille(new StringDataa(sCurrentLine,sCurrentLine));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
   


	
		
   public static void main(String[]args) throws IOException
		{
		Dico dictionnaire1=new Dico("francais.mots");
		Dico dictionnaire2=new Dico("anglais.mots");
		dictionnaire1.Dictionnary.fusion(dictionnaire2.Dictionnary);
		System.out.println(dictionnaire1.Dictionnary.toString());
		}



}
