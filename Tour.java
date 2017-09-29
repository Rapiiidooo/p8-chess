import java.util.ArrayList;

public class Tour extends Piece {


	
	public Tour() {
		super();
		this.nom="tour";
		if(this.couleur == 0)
			this.pi = new PieceImg (0, false);
		else
			this.pi = new PieceImg (0, true);
		
	}


	public Tour(Case yop) {
		super(yop);
		this.nom = "tour" ;
		if(this.couleur == 0)
			this.pi = new PieceImg (0, false);
		else
			this.pi = new PieceImg (0, true);
	}


	public Tour(int couleur, Case yop) {
		super(couleur, yop);
		this.nom="tour" ;
		if(this.couleur == 0)
			this.pi = new PieceImg (0, false);
		else
			this.pi = new PieceImg (0, true);
	}
	
	
	@Override
	public ArrayList<Case> casesDisponibles(){ 
		

		ArrayList<Case> casesRenvoyees = new ArrayList<Case>() ;
		 
		Piece timal=this.Nord();
		while(timal!=null && isAllie(timal)!=1){	    													 
		    if(isAllie(timal)==0){
			    casesRenvoyees.add(timal.getCase());
			    break;
		    }
		    casesRenvoyees.add(timal.getCase());	
		    timal = timal.Nord();
	    }
		
		timal=this.Sud();
	    while(timal!=null && isAllie(timal)!=1){	    													 
		    if(isAllie(timal)==0){
			    casesRenvoyees.add(timal.getCase());
			    break;
		    }
		    casesRenvoyees.add(timal.getCase());	
		    timal = timal.Sud();
	    }
	    
	    timal=this.Est();
	    while(timal!=null && isAllie(timal)!=1){	    													 
		    if(isAllie(timal)==0){
			    casesRenvoyees.add(timal.getCase());
			    break;
		    }
		    casesRenvoyees.add(timal.getCase());	
		    timal = timal.Est();
	    }
	    
	    timal=this.Ouest();
		while(timal!=null && isAllie(timal)!=1){	    													 
		    if(isAllie(timal)==0){
			    casesRenvoyees.add(timal.getCase());
			    break;
		    }
		    casesRenvoyees.add(timal.getCase());	
		    timal = timal.Ouest();
	    }

        return casesRenvoyees ;
    }
}