import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 
 */

/**
 * @author Pierrick
 *
 */
public class Damier{

	/**
	 * 
	 */
	
	//variables
	private Case[][] damier = new Case[8][8];
	
	
	//constructeurs
	public Damier() {
		for(int i=0 ; i<8 ; i++){
			for(int j=0 ; j<8 ; j++){
				this.damier[i][j]= new Case(j,i,this) ;
			}
		}
	}
	//get et set
	public Case getCase(int x, int y){
		return this.damier[y][x] ;
	}
	public void setCase(int x, int y, Case yop){
		this.damier[y][x] = yop ; ;
	}
	
	//copie
	public Damier copieDamier(){
		Damier nouveauDamier = new Damier() ;
		for(int i=0 ; i<8 ; i++){
			for(int j=0 ; j<8 ; j++){
				nouveauDamier.setCase(j,i, this.getCase(j,i).copieCase()) ;
			}
		}
		return nouveauDamier ;
	}
	
	//autre
	public void initialiser(){
		
		this.damier[0][0].setPiece(new Tour(1,this.getCase(0, 0))) ;
		this.damier[0][1].setPiece(new Knight(1,this.getCase(1, 0))) ;
		this.damier[0][2].setPiece(new Fou(1,this.getCase(2, 0))) ;
		this.damier[0][3].setPiece(new Reine(1,this.getCase(3, 0))) ;
		this.damier[0][4].setPiece(new Roi(1,this.getCase(4, 0))) ;
		this.damier[0][5].setPiece(new Fou(1,this.getCase(5, 0))) ;
		this.damier[0][6].setPiece(new Knight(1,this.getCase(6, 0))) ;
		this.damier[0][7].setPiece(new Tour(1,this.getCase(7, 0))) ;
		
		for(int x=0; x<8 ; x++){
			this.damier[1][x].setPiece(new Pion(1,this.getCase(x, 1))) ;
		}
		
		for(int y=2 ; y<6 ; y++){
			for(int x=0 ; x<8 ; x++){
				this.damier[y][x].setPiece(new Piece(this.getCase(x, y))) ;
			}
		}
		for(int x=0; x<8 ; x++){
			this.damier[6][x].setPiece(new Pion(0,this.getCase(x, 6))) ;
		}
		this.damier[7][0].setPiece(new Tour(0,this.getCase(0, 7))) ;
		this.damier[7][1].setPiece(new Knight(0,this.getCase(1, 7))) ;
		this.damier[7][2].setPiece(new Fou(0,this.getCase(2, 7))) ;
		this.damier[7][3].setPiece(new Roi(0,this.getCase(3, 7))) ;
		this.damier[7][4].setPiece(new Reine(0,this.getCase(4, 7))) ;
		this.damier[7][5].setPiece(new Fou(0,this.getCase(5, 7))) ;
		this.damier[7][6].setPiece(new Knight(0,this.getCase(6, 7))) ;
		this.damier[7][7].setPiece(new Tour(0,this.getCase(7, 7))) ;
		
	}
	
	public void deplacer(Case depart, Case arrivee){
		Piece temp = arrivee.getPiece() ;
		arrivee.setPiece(depart.getPiece());
		depart.setPiece(temp);
	}
	
	public void manger(Case yop){
		yop.setPiece(new Piece());
	}
	
	public Case Nord(Case yop){
		if(yop==null){
			return null;
		}
		if( (yop.getY()-1)<0){
			return null;
		}
		return this.getCase(yop.getX(), yop.getY()-1) ;
	}
	public Case Sud(Case yop){
		if(yop==null){
			return null;
		}
		if( (yop.getY()+1)>7){
			return null;
		}
		return this.getCase(yop.getX(), yop.getY()+1) ;
	}
	public Case Ouest(Case yop){
		if(yop==null){
			return null;
		}
		if( (yop.getX()-1)<0){
			return null;
		}
		return this.getCase(yop.getX()-1, yop.getY()) ;
	}
	public Case Est(Case yop){
		if(yop==null){
			return null;
		}
		if( (yop.getX()+1)>7){
			return null;
		}
		return this.getCase(yop.getX()+1, yop.getY()) ;
	}
	public Case NW(Case yop){
		if(yop==null){
			return null;
		}
		if( (yop.getX()-1)<0 || (yop.getY()-1)<0){
			return null;
		}
		return this.getCase(yop.getX()-1, yop.getY()-1) ;
	}
	public Case NE(Case yop){
		if(yop==null){
			return null;
		}
		if((yop.getX()+1)>7 || (yop.getY()-1)<0){
			return null;
		}
		return this.getCase(yop.getX()+1, yop.getY()-1) ;
	}
	public Case SW(Case yop){
		if(yop==null){
			return null;
		}
		if( (yop.getX()-1)<0 || (yop.getY()+1)>7){
			return null;
		}
		return this.getCase(yop.getX()-1, yop.getY()+1) ;
	}
	public Case SE(Case yop){
		if(yop==null){
			return null;
		}
		if((yop.getX()+1)>7 || (yop.getY()+1)>7){
			return null;
		}
		return this.getCase(yop.getX()+1, yop.getY()+1) ;
	}
	
	public boolean actionPossible(Case yop, int joueur){
		return yop.getPiece().getCouleur()==joueur ;
	}
	
	
	public boolean deplacementPossible(Case depart, Case arrivee, int joueur){
		if(arrivee.getPiece().getCouleur()==-1){
			if(joueur == 0){
				if( arrivee.equal(NW(depart)) || arrivee.equal(NE(depart)) ){
					return true;
				}
			}
			if(joueur == 1){
				if( arrivee.equal(SW(depart)) || arrivee.equal(SE(depart)) ){
					return true;
				}
			}
		}
		return false ;
	}
	
	public Case attaquePossible(Case depart, Case arrivee, int joueur){
				
		if(arrivee==null){
			return null;
		}
		
		int autreJoueur;
		if(joueur == 0){
			autreJoueur=1;
		}
		else{
			autreJoueur=0;
		}
		if(arrivee.getPiece().getCouleur()==-1){
			if(arrivee.equal(NW(NW(depart))) && NW(depart).getPiece().getCouleur()==autreJoueur){
				//System.out.println("retour nw");
				return NW(depart);
			}
			else if(arrivee.equal(SW(SW(depart))) && SW(depart).getPiece().getCouleur()==autreJoueur){
				//System.out.println("retour sw");
				return SW(depart);
			}
			else if(arrivee.equal(NE(NE(depart))) && NE(depart).getPiece().getCouleur()==autreJoueur){
				//System.out.println("retour ne");
				//System.out.println(NE(depart));
				return NE(depart);
			}
			else if(arrivee.equal(SE(SE(depart))) && SE(depart).getPiece().getCouleur()==autreJoueur){
				//System.out.println("retour se");
				return SE(depart);
			}
		}
		return null ;
	}
	
	public boolean isAttaquePossible(Case yop, int joueur){
		if( attaquePossible(yop, NW(NW(yop)), joueur) != null){
			return true;
		}
		else if( attaquePossible(yop, SW(SW(yop)), joueur) != null){
			return true;
		}
		else if( attaquePossible(yop, NE(NE(yop)), joueur) != null){
			return true;
		}
		else if( attaquePossible(yop, SE(SE(yop)), joueur) != null){
			return true;
		}
		return false;
	}
	
	public ArrayList<Case> allPions(int joueur){
		ArrayList<Case> tabCases = new ArrayList<Case>() ;
		for(int i=0 ; i<8 ; i++){
			for(int j=0 ; j<8 ; j++){
				if(this.getCase(j, i).getPiece().getCouleur()==joueur){
					tabCases.add(this.getCase(j, i)) ;
				}
			}
		}
		return tabCases;
		
	}
	
	public ArrayList<Case> isAttaquepossibleSomewhere(int joueur){
		ArrayList<Case> tabCases = allPions(joueur);
		int i=0;
		while(i<tabCases.size()){
			if(!isAttaquePossible(tabCases.get(i),joueur)){
				tabCases.remove(i);
			}
			else{
				i++;
			}
		}
		return tabCases;
		
	}

}
