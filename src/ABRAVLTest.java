import static org.junit.Assert.*;

import org.junit.Test;

public class ABRAVLTest {
//	Remplacer TYPE1 par une classe issue de votre modélisation représentant une donnée entière	
	public class IntData extends IntDataa{
		public IntData(Integer donnee, String key) {
			super(donnee,key);
		}
	}
	
//	Remplacer TYPE2 par une classe issue de votre modélisation représentant une donnée sous forme de chaîne de caractères
	public class StringData extends StringDataa{
		public StringData(String donnee,String key) {
			super(donnee,key);
		}
		public StringData(String donnee) {
			super(donnee,donnee);
		}
	}
	

	@Test
	public void insererFeuilleEtAffichageEntier(){
		System.out.println("*******************");
		System.out.println("Test  : insererFeuilleEtAffichageEntier ");
		
		// Création d'un arbre contenant des entiers 
		ABR<IntData> a1 = new ABR<IntData>(new IntData(1,"id0")); 

		a1.InsertionFeuille(new IntData(0,"id1"));
		a1.InsertionFeuille(new IntData(2,"id2"));
		a1.InsertionFeuille(new IntData(4,"id3"));
		a1.InsertionFeuille(new IntData(1,"id4"));
		a1.InsertionFeuille(new IntData(3,"id5"));

		// Test du contenu de l'arbre 
		System.out.println(a1.toString());
		assertEquals("1, 0, 2, 4, 1, 3, ", a1.toString());
		
	}

	@Test
	public void insererFeuilleEtAffichageString(){
		System.out.println("*******************");
		System.out.println("Test  : insererFeuilleEtAffichageString ");
		// Création d'un arbre contenant des chaînes de caractères 
		ABR<StringData> a2 = new ABR<StringData>(new StringData("test","test"));

		a2.InsertionFeuille(new StringData("CERI","CERI1"));
		a2.InsertionFeuille(new StringData("alternance","alternance"));
		a2.InsertionFeuille(new StringData("M1","M1"));
		a2.InsertionFeuille(new StringData("CERI","CERI2"));
		a2.InsertionFeuille(new StringData("algorithmique","algorithmique"));
		a2.InsertionFeuille(new StringData("avancée","avancee"));

		// Test du contenu de l'arbre 
		System.out.println(a2.toString());
		assertEquals(a2.toString(), "CERI, CERI, M1, algorithmique, alternance, avancée, test, ");
		
	}
	
	@Test
	public void recherche(){
		System.out.println("*******************");
		System.out.println("Test  : recherche ");		
		ABR<IntData> a1 = new ABR<IntData>(new IntData(1,"id0")); 

		IntData de2 = new IntData(2,"id1");
		a1.InsertionFeuille(new IntData(0,"id2"));
		a1.InsertionFeuille(de2);
		a1.InsertionFeuille(new IntData(4,"id3"));
		a1.InsertionFeuille(new IntData(3,"id4"));

		// Recherche dans l'arbre, une donnée de clé "2" 
		assertEquals(a1.Recherche("id1").info, de2);
		System.out.println(de2.toString());
		// Recherche dans l'arbre, une donnée de clé "7" 
		assertEquals(a1.Recherche("id7"), null);
		
	}

	@Test
	public void minMax(){
		System.out.println("*******************");
		System.out.println("Test  : minMax ");
		ABR<IntData> a1 = new ABR<IntData>(new IntData(1,"id1")); 
	
		a1.InsertionFeuille(new IntData(2,"id2"));
		a1.InsertionFeuille(new IntData(4,"id3"));
		IntData objmin = new IntData(2,"id0");
		a1.InsertionFeuille(objmin);
		IntData objmax = new IntData(3,"id4");
		a1.InsertionFeuille(objmax);

		assertEquals(a1.Minimum().info, objmin.info);
		System.out.println("info min = " + objmin.toString());
		
		assertEquals(a1.Maximum().info, objmax.info);		
		System.out.println("info max = " + objmax.toString());		
	}

	
	@Test
	public void hauteur(){		
		System.out.println("*******************");
		System.out.println("Test  : Hauteur ");

		ABR<IntData> a1 = new ABR<IntData>(new IntData(1,"id1")); 
		assertEquals(a1.Hauteur(),0);		
		a1.InsertionFeuille(new IntData(0,"id0"));
		assertEquals(a1.Hauteur(), 1);
		a1.InsertionFeuille(new IntData(2,"id2"));
		assertEquals(a1.Hauteur(), 1);
		a1.InsertionFeuille(new IntData(4,"id4"));
		assertEquals(a1.Hauteur(), 2);
		a1.InsertionFeuille(new IntData(3,"id3"));
		assertEquals(a1.Hauteur(), 3);		
	}
	
	
	@Test
	public void suppression(){
		System.out.println("*******************");
		System.out.println("Test  : Suppression ");
		
		ABR<IntData> a1 = new ABR<IntData>(new IntData(1,"id1")); 
		a1.InsertionFeuille(new IntData(2,"id2"));
		a1.InsertionFeuille(new IntData(4,"id4"));
		a1.InsertionFeuille(new IntData(3,"id3"));
		
		System.out.println(a1.toString());
		
		ABR<IntData> x = a1.Recherche("id1");		
		a1 = a1.Suppression(x);		
		assertEquals("2, 3, 4, ", a1.toString());
		
		ABR<IntData> a2 = new ABR<IntData>(new IntData(10,"id10")); 
		a2.InsertionFeuille(new IntData(2,"id2"));
		a2.InsertionFeuille(new IntData(4,"id4"));
		a2.InsertionFeuille(new IntData(3,"id3"));
		
		x = a2.Recherche("id10");
		a2 = a2.Suppression(x);
		assertEquals("2, 3, 4, ", a2.toString());
		
		x = a2.Recherche("id42");
		a2 = a2.Suppression(x);
		assertEquals("2, 3, 4, ", a2.toString());
		
	}


	@Test
	public void equivalent(){		
		System.out.println("*******************");
		System.out.println("Test  : Equivalent ");

		ABR<IntData> a1 = new ABR<IntData>(new IntData(1,"id1")); 

		a1.InsertionFeuille(new IntData(2,"id2"));
		a1.InsertionFeuille(new IntData(4,"id2"));
		a1.InsertionFeuille(new IntData(3,"id3"));
		

		ABR<IntData> a2 = new ABR<IntData>(new IntData(4,"id4")); 

		a2.InsertionFeuille(new IntData(3,"id3"));
		a2.InsertionFeuille(new IntData(1,"id1"));
		a2.InsertionFeuille(new IntData(2,"id2"));
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		//assertTrue(a1.Equivalent(a2));
		
	}


	@Test
	public void contenueDans(){
		System.out.println("*******************");
		System.out.println("Test  : contenueDans ");
		
		ABR<IntData> a1 = new ABR<IntData>(new IntData(1,"id1")); 

		a1.InsertionFeuille(new IntData(2,"id2"));
		

		ABR<IntData> a2 = new ABR<IntData>(new IntData(4,"id4")); 

		a2.InsertionFeuille(new IntData(3,"id3"));
		a2.InsertionFeuille(new IntData(1,"id1"));
		a2.InsertionFeuille(new IntData(2,"id2"));
		
		assertTrue(a1.ContenuDans(a2));
		
	}
	
	@Test
	public void fusion(){
		System.out.println("*******************");
		System.out.println("Test  : Fusion ");

		ABR<IntData> a1 = new ABR<IntData>(new IntData(1,"id1")); 

		a1.InsertionFeuille(new IntData(2,"id2"));
		a1.InsertionFeuille(new IntData(4,"id4"));
		a1.InsertionFeuille(new IntData(3,"id3"));
		

		ABR<IntData> a2 = new ABR<IntData>(new IntData(4,"id4")); 

		a2.InsertionFeuille(new IntData(8,"id8"));
		a2.InsertionFeuille(new IntData(5,"id5"));
		a2.InsertionFeuille(new IntData(1,"id1"));
		
		a1.fusion(a2);
		
		assertEquals("1, 2, 3, 4, 5, 8, ", a1.toString());		
	}


	@Test
	public void rotationDroite(){
		System.out.println("*******************");
		System.out.println("Test  : Rotation Droite ");

		ABR<StringData> d = new ABR<StringData>(new StringData("d")); 
		d.InsertionFeuille(new StringData("b"));
		d.InsertionFeuille(new StringData("a"));
		d.InsertionFeuille(new StringData("c"));
		d.InsertionFeuille(new StringData("e"));

		Object b = d.Recherche("b"); 
				
		d.RotationDroite();
		
		assertEquals(d.pere, b);
		
		// Ajouter vos tests
		
	}
	
	@Test
	public void rotationGauche(){
		System.out.println("*******************");
		System.out.println("Test  : Rotation Gauche ");
		
		ABR<StringData> b = new ABR<StringData>(new StringData("b")); 
		b.InsertionFeuille(new StringData("a"));
		b.InsertionFeuille(new StringData("d"));
		b.InsertionFeuille(new StringData("c"));
		b.InsertionFeuille(new StringData("e"));

		Object d = b.Recherche("d"); 
		//System.out.println(b.toString());

		b.RotationGauche();
			
		//System.out.println(b.pere.toString());
		//System.out.println(d.toString());
		assertEquals(b.pere, d);
	}
	
	@Test
	public void rotationGaucheDroite(){
		System.out.println("*******************");
		System.out.println("Test  : Rotation Gauche Droite ");

		ABR<StringData> racine = new ABR<StringData>(new StringData("f"));
		
		racine.InsertionFeuille(new StringData("b"));
		racine.InsertionFeuille(new StringData("a"));
		racine.InsertionFeuille(new StringData("d"));
		racine.InsertionFeuille(new StringData("c"));
		racine.InsertionFeuille(new StringData("e"));
		racine.InsertionFeuille(new StringData("g"));
		
		int h1 = racine.Hauteur();
		
		racine.RotationGaucheDroite();
		racine = racine.pere;
		
		assertEquals(h1, racine.Hauteur() + 1);		
	}
	
	@Test
	public void rotationDroiteGauche(){
		System.out.println("*******************");
		System.out.println("Test  : Rotation Droite Gauche");

		ABR<StringData> racine = new ABR<StringData>(new StringData("b"));
		
		racine.InsertionFeuille(new StringData("a"));
		racine.InsertionFeuille(new StringData("f"));
		racine.InsertionFeuille(new StringData("d"));
		racine.InsertionFeuille(new StringData("c"));
		racine.InsertionFeuille(new StringData("e"));
		racine.InsertionFeuille(new StringData("g"));
		
		int h1 = racine.Hauteur();
		
		racine.RotationDroiteGauche();
		racine = racine.pere;
		
		assertEquals(h1, racine.Hauteur() + 1);	
	}


	
	@Test
	public void insertionFeuilleEquilibre(){
		System.out.println("*******************");
		System.out.println("Test  : insertionFeuilleEquilibre ");

		ABR<StringData> racine = new ABR<StringData>(new StringData("f")); 
		racine.InsertionFeuilleEquilibre(new StringData("e"));
		racine.InsertionFeuilleEquilibre(new StringData("d"));
		racine = racine.pere;
		//le probleme est la racine=racine.pere genere la segmentation fault
		
		racine.InsertionFeuilleEquilibre(new StringData("c"));
		racine.InsertionFeuilleEquilibre(new StringData("b"));		
		racine.InsertionFeuilleEquilibre(new StringData("a"));
		racine = racine.pere;
		
		ABR<StringData> f2 = new ABR<StringData>(new StringData("f")); 
		f2.InsertionFeuille(new StringData("e"));
		f2.InsertionFeuille(new StringData("d"));
		f2.InsertionFeuille(new StringData("c"));
		f2.InsertionFeuille(new StringData("b"));
		f2.InsertionFeuille(new StringData("a"));
		
		// Les arbres contiennent les même éléments
		assertEquals(racine.toString(), f2.toString());
		assertEquals(f2.Hauteur(), racine.Hauteur() + 3);	
	}

}

