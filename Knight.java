import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Pierrick
 *
 */
public class Knight extends Piece {


	//Constructors
	public Knight() {
		super();
		this.nom="knight";
		if(this.couleur == 0)
			this.pi = new PieceImg (1, false);
		else
			this.pi = new PieceImg (1, true);
	}


	public Knight(Case yop) {
		super(yop);
		this.nom = "knight" ;
		if(this.couleur == 0)
			this.pi = new PieceImg (1, false);
		else
			this.pi = new PieceImg (1, true);
	}


	public Knight(int couleur, Case yop) {
		super(couleur, yop);
		this.nom="knight" ;
		if(this.couleur == 0)
			this.pi = new PieceImg (1, false);
		else
			this.pi = new PieceImg (1, true);
	}
	
	
	@Override
	public ArrayList<Case> casesDisponibles(){ // renvoie une arraylist de cases dans laquelle doivent se trouver toutes les cases vers laquelle la pièce peut aller
		
		ArrayList<Case> casesRenvoyees = new ArrayList<Case>() ; //initialisation de l'arraylist
		
		if(yop.y > 1 && yop.x < 7){
			if(this.Nord().NE()!=null){ // si la case au nord nord est de celle dans laquelle se trouve la pièce existe...
				if(isAllie(this.Nord().NE()) != 1){ // ... et si il n'y a pas une piece alliee dedans ...
					casesRenvoyees.add(this.Nord().NE().getCase()); // ... alors on rajoute la case au nord de laquelle se trouve la pièce à l'arrayList
				}
			}
		}
		if(yop.y > 1 && yop.x > 0){
			if(this.Nord().NW()!=null){ // idem
				if(isAllie(this.Nord().NW()) != 1){ // ... et si il n'y a pas une piece alliee dedans ...
					casesRenvoyees.add(this.Nord().NW().getCase()); // ... alors on rajoute la case au nord de laquelle se trouve la pièce à l'arrayList
				}
			}
		}
		if(yop.y < 6 && yop.x < 7){
			if(this.Sud().SE()!=null){ // idem pour case au sud
				if(isAllie(this.Sud().SE()) != 1){
					casesRenvoyees.add(this.Sud().SE().getCase());
				}
			}
		}
		if(yop.y < 6 && yop.x > 0){
			if(this.Sud().SW()!=null){ // idem pour case au sud
				if(isAllie(this.Sud().SW()) != 1){
					casesRenvoyees.add(this.Sud().SW().getCase());
				}
			}
		}
		if(yop.x < 6 && yop.y > 0){
			if(this.Est().NE()!=null){ // idem pour case a l'est
				if(isAllie(this.Est().NE()) != 1){
					casesRenvoyees.add(this.Est().NE().getCase());
				}
			}
		}
		if(yop.x < 6 && yop.y < 7){
			if(this.Est().SE()!=null){ // idem pour case a l'est
				if(isAllie(this.Est().SE()) != 1){
					casesRenvoyees.add(this.Est().SE().getCase());
				}
			}
		}
		if(yop.x > 1 && yop.y > 1){
			if(this.Ouest().NW()!=null){ // idem pour case a l'Ouest
				if(isAllie(this.Ouest().NW()) != 1){
					casesRenvoyees.add(this.Ouest().NW().getCase());
				}
			}
		}
		if(yop.x > 1 && yop.y < 7){
			if(this.Ouest().SW()!=null){ // idem pour case a l'Ouest
				if(isAllie(this.Ouest().SW()) != 1){
					casesRenvoyees.add(this.Ouest().SW().getCase());
				}
			}
		}

		return casesRenvoyees ; //renvoie l'arraylist de cases ainsi remplie
	}
}
