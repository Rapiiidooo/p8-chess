import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Pierrick
 *
 */
public class Pion extends Piece {

	//Constructors
	public Pion() {
		super();
		this.nom="pion";
		if(this.couleur == 0)
			this.pi = new PieceImg (4, false);
		else
			this.pi = new PieceImg (4, true);
	}


	public Pion(Case yop) {
		super(yop);
		this.nom = "pion" ;
		if(this.couleur == 0)
			this.pi = new PieceImg (4, false);
		else
			this.pi = new PieceImg (4, true);
	}


	public Pion(int couleur, Case yop) {
		super(couleur, yop);
		this.nom="pion" ;
		if(this.couleur == 0)
			this.pi = new PieceImg (4, false);
		else
			this.pi = new PieceImg (4, true);
	}
	
	public void conversion(Pion timalchris){ 
    	Reine verteveste = new Reine(timalchris.getCouleur(),timalchris.getCase());
    	timalchris.getCase().setPiece(verteveste); 
	}
    



	
	@Override
	public ArrayList<Case> casesDisponibles(){ // renvoie une arraylist de cases dans laquelle doivent se trouver toutes les cases vers laquelle la pièce peut aller
		
		ArrayList<Case> casesRenvoyees = new ArrayList<Case>() ; //initialisation de l'arraylist
		
		//System.out.println(couleur);
		if(this.getCouleur() == 0){
			if(this.Nord()!=null){ // si la case au nord de celle dans laquelle se trouve la pièce existe...
				if(isAllie(this.Nord()) == -1){ // ... et si il n'y a pas une piece dedans ...
					if(yop.y == 6 && isAllie(this.Nord().Nord()) == -1)
						casesRenvoyees.add(this.Nord().Nord().getCase()); // ... alors on rajoute la case au nord de laquelle se trouve la pièce à l'arrayList
					casesRenvoyees.add(this.Nord().getCase());
				}
			}
			if(this.NW()!=null){ // idem pour case au nord-ouest mais piece enemi
				if(isAllie(this.NW()) == 0){
					casesRenvoyees.add(this.NW().getCase());
				}
			}
			if(this.NE()!=null){ // idem pour case au nord-est mais piece enemi
				if(isAllie(this.NE()) == 0){
					casesRenvoyees.add(this.NE().getCase());
				}
			}
		}
		else{
			if(this.Sud()!=null){ // si la case au nord de celle dans laquelle se trouve la pièce existe...
				System.out.println(yop.y);
				if(isAllie(this.Sud()) == -1){ // ... et si il n'y a pas une piece alliee dedans ...
					if(yop.y == 1 && isAllie(this.Sud().Sud()) == -1)
						casesRenvoyees.add(this.Sud().Sud().getCase()); // ... alors on rajoute la case au nord de laquelle se trouve la pièce à l'arrayList
					casesRenvoyees.add(this.Sud().getCase());
				}
			}
			if(this.SW()!=null){ // idem pour case au sud-ouest
				if(isAllie(this.SW()) == 0){
					casesRenvoyees.add(this.SW().getCase());
				}
			}
			if(this.SE()!=null){ // idem pour case au sud-est
				if(isAllie(this.SE()) == 0){
					casesRenvoyees.add(this.SE().getCase());
				}
			}
		}
		
		return casesRenvoyees ; //renvoie l'arraylist de cases ainsi remplie
	}

}
