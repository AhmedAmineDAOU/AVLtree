public abstract class NoeudAbstrait implements Comparable<NoeudAbstrait> {
	String key;
	//comparaison de deux noeuds abstraits
	public int compareTo(NoeudAbstrait o)
	{
		return this.key.compareTo(o.cle());
	}	
	//acces a la clé

	public int compareTo(String key)
	{
		return this.key.compareTo(key);
	}	
   

	public String cle()
	{
	return (key);
	}
	//renvoi d'une chaine de caractere
	abstract public String toString();
}
