import java.util.ArrayList;

public class Reine extends Piece {


	
	public Reine() {
		super();
		this.nom="reine";
		if(this.couleur == 0)
			this.pi = new PieceImg (3, false);
		else
			this.pi = new PieceImg (5, true);
	}


	public Reine(Case yop) {
		super(yop);
		this.nom = "reine" ;
		if(this.couleur == 0)
			this.pi = new PieceImg (3, false);
		else
			this.pi = new PieceImg (5, true);
	}


	public Reine(int couleur, Case yop) {
		super(couleur, yop);
		this.nom="reine" ;
		if(this.couleur == 0)
			this.pi = new PieceImg (3, false);
		else
			this.pi = new PieceImg (5, true);
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
		
		timal=this.NW();
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
