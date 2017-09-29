import java.util.ArrayList;

public class Fou extends Piece {


	
	public Fou() {
		super();
		this.nom="fou";
		if(this.couleur == 0)
			this.pi = new PieceImg (2, false);
		else
			this.pi = new PieceImg (2, true);
	}


	public Fou(Case yop) {
		super(yop);
		this.nom = "fou" ;
		if(this.couleur == 0)
			this.pi = new PieceImg (2, false);
		else
			this.pi = new PieceImg (2, true);
	}


	public Fou(int couleur, Case yop) {
		super(couleur, yop);
		this.nom="fou" ;
		if(this.couleur == 0)
			this.pi = new PieceImg (2, false);
		else
			this.pi = new PieceImg (2, true);
	}
	
	
	@Override
	public ArrayList<Case> casesDisponibles(){ 
		

		ArrayList<Case> casesRenvoyees = new ArrayList<Case>() ;
		 
		
		Piece timal=this.NW();
		while(timal!=null && isAllie(timal)!=1 ){	    													 
		    if(isAllie(timal)==0){
			    casesRenvoyees.add(timal.getCase());
			    break;
		    }
		    casesRenvoyees.add(timal.getCase());	
		    timal = timal.NW();
	    }
		
		timal=this.NE();
		while(timal!=null && isAllie(timal)!=1){	    													 
		    if(isAllie(timal)==0){
			    casesRenvoyees.add(timal.getCase());
			    break;
		    }
		    casesRenvoyees.add(timal.getCase());	
		    timal = timal.NE();
	    }
		
		timal=this.SW();
		while(timal!=null && isAllie(timal)!=1){	    													 
		    if(isAllie(timal)==0){
			    casesRenvoyees.add(timal.getCase());
			    break;
		    }
		    casesRenvoyees.add(timal.getCase());	
		    timal = timal.SW();
	    }
		
		timal=this.SE();
		while(timal!=null && isAllie(timal)!=1){	    													 
		    if(isAllie(timal)==0){
			    casesRenvoyees.add(timal.getCase());
			    break;
		    }
		    casesRenvoyees.add(timal.getCase());	
		    timal = timal.SE();
	    }
		
		return casesRenvoyees ; 
	}

}
