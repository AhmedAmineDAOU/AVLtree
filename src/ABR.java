import java.util.Scanner;
import java.util.*;
import java.io.*;
//import static org.junit.Assert.*;

//import org.junit.Test;




public class ABR < T extends NoeudAbstrait > {


    T info;
    ABR < T > pere;
    ABR < T > gauche;
    ABR < T > droit;
    int height;
    public ABR(T objet) {
        info = objet;
        gauche = droit = pere = null;
    }
    

    public ABR(ABR < T > A) {
        this.info = A.info;
        this.pere = A.pere;
        this.gauche = A.gauche;
        this.droit = A.droit;

    }

    public void InsertionFeuille(T y) {
        ABR < T > x = this; 
        ABR < T > Y = new ABR < T > (y);
        if(this.info==null)
		{this.info=y;return;}
        this.pere = null;

        while (x != null) {
            this.pere = x;

            if (Y.info.compareTo(x.info) < 0)
                x = x.gauche;
            else {
                x = x.droit;
            }
        }
        Y.pere = this.pere;
        if (Y.pere == null) {
            this.info = Y.info;
            this.pere = Y.pere;
            this.gauche = Y.gauche;
            this.droit = Y.droit;
        } else {

            if (Y.info.compareTo(Y.pere.info) < 0) {
                Y.pere.gauche = Y;
            } else if (Y.info.compareTo(Y.pere.info) > 0) {

                Y.pere.droit = Y;
            }
        }
    }
    @Override
    public String toString(){
            if(this.info == null)
                    return "vide";
            return affiche(this);
    }
    public String affiche(ABR<T> root){
            if(root == null)
                    return "";                
            return affiche(root.gauche) + root.info.toString() + affiche(root.droit);
    }

	
    public T Minimum() {
        ABR < T > tmp = this;
        while (tmp.gauche != null) {
            tmp = tmp.gauche;
        }
        return tmp.info;

    }

    public T Maximum() {
        ABR < T > tmp = this;
        while (tmp.droit != null) {
            tmp = tmp.droit;
        }
        return tmp.info;

    }

	public static int getHeight(ABR node) {
 		if (node == null) return -1;

		else return 1 + Math.max(getHeight(node.gauche), getHeight(node.droit));
		}
	 public   int Hauteur() {

      		return getHeight(this);

        }

    public ABR < T > Recherche(String cle) {
        ABR < T > tmp = this;
        while (tmp != null && tmp.info.compareTo(cle) != 0) {

            if (tmp.info.compareTo(cle) > 0) {
                tmp = tmp.gauche;
            } else {
                tmp = tmp.droit;
            }

        }
        return tmp;
    }
    


    public ABR < T > deplacer(ABR < T > u, ABR < T > v) {
        if (u.pere == null) {
            return (v);
        } else {
            if (u == u.pere.gauche)
                u.pere.gauche = v;
            else
                u.pere.droit = v;
        }
        if (v != null)
            v.pere = u.pere;

        return this;
    }

    public ABR < T > MinimumA() {
        ABR < T > tmp = this;
        while (tmp.gauche != null) {
            tmp = tmp.gauche;
        }
        return tmp;

    }
    public ABR < T > MaximumA() {
        ABR < T > tmp = this;
        while (tmp.droit != null) {
            tmp = tmp.droit;
        }
        return tmp;

    }


    public ABR<T> Suppression(ABR<T> x ){
        if(x == null)
                return this;
        ABR<T> tmp = Recherche(x.info.cle() );
        if(tmp == null)
                return null;
        if(tmp.gauche != null){
                ABR<T> max = tmp.gauche.MaximumA();
                tmp.info = max.info;
                if(max.pere != tmp)
                        max.pere.droit = max.gauche;
                else
                        max.pere.gauche = max.gauche;
        }
        else if(tmp.droit != null){
                ABR<T> min = tmp.droit.MinimumA();
                tmp.info = min.info;
                if(min.pere != tmp)
                        min.pere.gauche = min.droit;
                else
                        min.pere.droit = min.droit;
        }
        else{
                if(tmp.pere==tmp.droit)
                        tmp.pere.droit = null;
                else if(tmp.pere==tmp.gauche )
                        tmp.pere.gauche = null;
                else{ 
                        tmp.info = null;
                }        
        }
        return this;
}
    public Boolean egal(T a, T b) {
        if (a.compareTo(b) == 0)
            return true;
        else return false;

    }
    public Boolean Equivalent(ABR < T > root2) {
        return Equivalentt(this, root2);
    }
    public Boolean Equivalentt(ABR < T > root1, ABR < T > root2) {
        // Shortcut for reference equality; also handles equals(null, null)

        if (root1 == null && root2 == null) {
           // System.out.println("*****");
            return true;
        }
        if (root1 == null || root2 == null) {
           // System.out.println("*****");
            return false;
        }
        return root1.info.compareTo(root2.info) == 0 &&
            Equivalentt(root1.gauche, root2.gauche) &&
            Equivalentt(root1.droit, root2.droit);
    }
    public Boolean ContenuDans(ABR < T > root2) {
        return ContenuDanss(root2, this);
    }
    public boolean ContenuDanss(ABR < T > root1, ABR < T > root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (Equivalentt(root1, root2) == true)
            return true;
        return ContenuDanss(root1.gauche, root2) ||
            ContenuDanss(root1.droit, root2);

    }
	public void fusion(ABR<T> root2){
	       fusionn(this,root2);
	}
    public ABR<T> fusionn(ABR<T>root1,ABR<T> root2){
	if(root1==null&& root2!=null)
	return root2;
	if (root2==null&& root1!=null)
	return root1;


	if (root2 != null && root1!=null && root2.info.compareTo(root1.info )!=0) {
            fusionn(root1,root2.gauche);
 	    root1.InsertionFeuille(root2.info);
            fusionn(root1,root2.droit);
	return root1;
       }
	 return root1;
	
	}

    public ABR<T> RotationDroite(){
        if(this.gauche == null){
                return this;
        }
        ABR<T> G = this.gauche;
        this.gauche = G.droit;
        G.droit.pere = this;
        G.droit = this;
        G.droit.pere = G;
        return G;
} 
    public ABR<T> RotationGauche(){
        if(this.droit == null) 
                return this;
        ABR<T> D = this.droit;
        this.droit = D.gauche;
        D.gauche.pere = this;
        D.gauche = this;
        D.gauche.pere = D;
        return D;
}
	
	
	public ABR<T> RotationGaucheDroite(){
		this.gauche.RotationGauche();
		this.RotationDroite();
		return this;
	}

	public ABR<T> RotationDroiteGauche(){
		this.droit.RotationDroite();
		this.RotationGauche();	
		return this;
	}

	public int d()
	{	
		int g=getHeight(this.gauche);
		int d=getHeight(this.droit);
		
		return g-d;
	}
	public ABR<T> reequilibrer(){
		
		if(this.d()==2 && this.gauche.d()==1)
		 	return this.RotationDroite();

		else if(this.d()==-2 && this.droit.d()==-1)
			return this.RotationGauche();

		else if(this.d()==2 && this.gauche.d()==-1)
			return this.RotationGaucheDroite();

		else if(this.d()==-2 && this.droit.d()==1)
			return this.RotationDroiteGauche();
		return this;
		
		
	}
	
	
	public ABR<T> InsertionFeuilleEquilibre(T x){
		return insert(x,this);
		
	}
	 public ABR<T> insert (T x, ABR<T> t) {
		    if (t == null)
		      t = new ABR<T> (x);
		    else if (x.compareTo (t.info) < 0){
		      t.gauche = insert(x, t.gauche);
		      
		      if (getHeight (t.gauche) - getHeight (t.droit) == 2){
		        if (x.compareTo (t.gauche.info) < 0){
		          t = t.RotationGauche ();
		        }
		        else {
		          t = t.RotationDroiteGauche();
		        }
		      }
		    }
		    else if (x.compareTo (t.info) > 0){
		      t.droit = insert (x, t.droit);
		      
		      if ( getHeight (t.droit) - getHeight (t.gauche) == 2)
		        if (x.compareTo (t.droit.info) > 0){
		          t = t.RotationDroite();
		        }
		        else{
		          t = t.RotationGaucheDroite();
		        }
		    }
		
		    
		    t.height = Math.max (getHeight (t.gauche), getHeight (t.droit)) + 1;
		    return t;
		}
	
	

   public static void main(String[] args) {
	/*System.out.println("*******************");
		System.out.println("Test  : insererFeuilleEtAffichageEntier ");
		
		/* Création d'un arbre contenant des entiers 
		ABR<IntData> a1 = new ABR<IntData>(new IntData(1,"id0")); 

		a1.InsertionFeuille(new IntData(0,"id1"));
		a1.InsertionFeuille(new IntData(2,"id2"));
		a1.InsertionFeuille(new IntData(4,"id3"));
		a1.InsertionFeuille(new IntData(1,"id4"));
		a1.InsertionFeuille(new IntData(3,"id5"));

		/* Test du contenu de l'arbre 
		System.out.println(a1.toString());
		//assertEquals("1, 0, 2, 4, 1, 3, ", a1.toString());*/
 		
    }





}
