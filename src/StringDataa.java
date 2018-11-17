	public class StringDataa extends NoeudAbstrait {

	String info;

	public StringDataa(String x,String cle){
		info=x;
		key=cle;
	}
	public StringDataa(String x){
		info=x;
		key=x;
	}
	
	public String toString(){
	return (info.toString()+", ");}
	
}
