import java.util.ArrayList;
import javafx.scene.image.ImageView;

/**
 * 
 */

/**
 * @author Pierrick
 *
 */
public class Piece{
	
	

	//variables
	public int couleur;
	public Case yop ;
	public String nom ;
	public PieceImg pi ;

	
	//constructeurs
	public Piece(){
		this.couleur = -1;
	}
	public Piece(Case yop){
		this.couleur = -1;
		this.yop=yop ;
	}
	
	public Piece(int couleur, Case yop){
		this.couleur = couleur ;
		this.yop = yop ;
	}
	
	//get et set
	

	public int getCouleur(){
		return this.couleur ;
	}
	
	public void setCouleur(int couleur){
		this.couleur = couleur;
	}
	public Case getCase(){
		return this.yop ;
	}
	
	public void setCase(Case yop){
		this.yop = yop;
	}
	public String getNom(){
		return this.nom ;
	}
	public void setNom(String nom){
		this.nom = nom ;
	}
	public ImageView getImgView (){
		return this.pi.getImgView();
	}
	public void setImgView (ImageView pi){
		this.pi.setImgView(pi);
	}
	
	//copie
	public Piece copiePiece(){
		Piece nouvellePiece = new Piece() ;
		nouvellePiece.setCouleur(this.getCouleur());
		return nouvellePiece ;
	}
	
	//equal
	
	public boolean equal(Piece piece){
		if(this.couleur==piece.getCouleur()){
			return true ;
		}
		return false;
	}
	
	//deplacement
	public ArrayList<Case> casesDisponibles(){
		
		ArrayList<Case> casesRenvoyees = new ArrayList<Case>() ;
		
		
		return casesRenvoyees ;
	}
	
	
	
	
	public Piece Nord(){
		if(this.getCase().getDamier().Nord(this.getCase())==null){
			return null ;
		}
		return this.getCase().getDamier().Nord(this.getCase()).getPiece() ;
	}
	public Piece Sud(){
		if(this.getCase().getDamier().Sud(this.getCase())==null){
			return null ;
		}
		return this.getCase().getDamier().Sud(this.getCase()).getPiece() ;
	}
	public Piece Ouest(){
		if(this.getCase().getDamier().Ouest(this.getCase())==null){
			return null ;
		}
		return this.getCase().getDamier().Ouest(this.getCase()).getPiece() ;
	}
	public Piece Est(){
		if(this.getCase().getDamier().Est(this.getCase())==null){
			return null ;
		}
		return this.getCase().getDamier().Est(this.getCase()).getPiece() ;
	}
	public Piece NW(){
		if(this.getCase().getDamier().NW(this.getCase())==null){
			return null ;
		}
		return this.getCase().getDamier().NW(this.getCase()).getPiece() ;
	}
	public Piece NE(){
		if(this.getCase().getDamier().NE(this.getCase())==null){
			return null ;
		}
		return this.getCase().getDamier().NE(this.getCase()).getPiece() ;
	}
	public Piece SW(){
		if(this.getCase().getDamier().SW(this.getCase())==null){
			return null ;
		}
		return this.getCase().getDamier().SW(this.getCase()).getPiece() ;
	}
	public Piece SE(){
		if(this.getCase().getDamier().SE(this.getCase())==null){
			return null ;
		}
		return this.getCase().getDamier().SE(this.getCase()).getPiece() ;
	}
	
	
	
	
	
	//
	public int isAllie(Piece piece){
		if(piece.getCouleur()==-1){
			return -1;
		}
		if(piece.getCouleur()==this.couleur){
			return 1;
		}
		return 0;
	}

	
	

}
