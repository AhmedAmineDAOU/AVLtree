	public class IntDataa extends NoeudAbstrait {

	Integer info;

	public IntDataa(Integer x,String cle){
		info=x;
		key=cle;
	}
	
	/*public String toString(){
	return ("cle:"+key.toString()+" donnee:"+donnee.toString());
	}*/
	public String toString(){
	return (info.toString()+", ");}
	
}
