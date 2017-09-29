import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Pierrick
 *
 */
public class Roi extends Piece {


	//Constructors
	public Roi() {
		super();
		this.nom="roi";
		if(this.couleur == 0)
			this.pi = new PieceImg (5, false);
		else
			this.pi = new PieceImg (3, true);
	}


	public Roi(Case yop) {
		super(yop);
		this.nom = "roi" ;
		if(this.couleur == 0)
			this.pi = new PieceImg (5, false);
		else
			this.pi = new PieceImg (3, true);
	}


	public Roi(int couleur, Case yop) {
		super(couleur, yop);
		this.nom="roi" ;
		if(this.couleur == 0)
			this.pi = new PieceImg (5, false);
		else
			this.pi = new PieceImg (3, true);
	}
	
	
	@Override
	public ArrayList<Case> casesDisponibles(){ // renvoie une arraylist de cases dans laquelle doivent se trouver toutes les cases vers laquelle la pièce peut aller
		
		ArrayList<Case> casesRenvoyees = new ArrayList<Case>() ; //initialisation de l'arraylist
		
		
		if(this.Nord()!=null){ // si la case au nord de celle dans laquelle se trouve la pièce existe...
			if(isAllie(this.Nord()) != 1){ // ... et si il n'y a pas une piece alliee dedans ...
				casesRenvoyees.add(this.Nord().getCase()); // ... alors on rajoute la case au nord de laquelle se trouve la pièce à l'arrayList
			}
		}
		if(this.Sud()!=null){ // idem pour case au sud
			if(isAllie(this.Sud()) != 1){
				casesRenvoyees.add(this.Sud().getCase());
			}
		}
		if(this.Est()!=null){ // idem pour case a l'est
			if(isAllie(this.Est()) != 1){
				casesRenvoyees.add(this.Est().getCase());
			}
		}
		if(this.Ouest()!=null){ // idem pour case a l'Ouest
			if(isAllie(this.Ouest()) != 1){
				casesRenvoyees.add(this.Ouest().getCase());
			}
		}
		if(this.NW()!=null){ // idem pour case au nord-ouest
			if(isAllie(this.NW()) != 1){
				casesRenvoyees.add(this.NW().getCase());
			}
		}
		if(this.NE()!=null){ // idem pour case au nord-est
			if(isAllie(this.NE()) != 1){
				casesRenvoyees.add(this.NE().getCase());
			}
		}
		if(this.SW()!=null){ // idem pour case au sud-ouest
			if(isAllie(this.SW()) != 1){
				casesRenvoyees.add(this.SW().getCase());
			}
		}
		if(this.SE()!=null){ // idem pour case au sud-est
			if(isAllie(this.SE()) != 1){
				casesRenvoyees.add(this.SE().getCase());
			}
		}
		
		return casesRenvoyees ; //renvoie l'arraylist de cases ainsi remplie
	}

}
