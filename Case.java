/**
 * 
 */

/**
 * @author Pierrick
 *
 */
public class Case {

	/**
	 * 
	 **/
	int x, y;
	Piece piece;
	Damier damier ;
	
	public Case() {
		this.x = 0 ;
		this.y = 0 ;
		this.piece=new Piece();
	}
	
	public Case(int x, int y, Damier damier) {
		this.x = x ;
		this.y = y ;
		this.piece = new Piece();
		this.damier = damier ;
	}
	
	//get et set
	
	public int getX(){
		return this.x ;
	}
	public int getY(){
		return this.y ;
	}
	public Piece getPiece(){
		return this.piece ;
	}
	public Damier getDamier(){
		return this.damier ;
	}

	
	public void setX(int x){
		this.x = x ;
	}
	public void setY(int y){
		this.y = y ;
	}
	public void setPiece(Piece piece){
		this.piece = piece ;
	}
	public void setDamier(Damier damier){
		this.damier=damier ;
	}

	//copie
	public Case copieCase(){
		Case nouvelleCase = new Case() ;
		nouvelleCase.setX(this.getX());
		nouvelleCase.setY(this.getY());
		nouvelleCase.setPiece(this.getPiece().copiePiece());
		return nouvelleCase ;
	}
	
	//equal
	public boolean equal(Case yop){
		if(yop==null){
			return false;
		}
		if(this.getX()==yop.getX() && this.getY()==yop.getY() && this.getPiece().equal(yop.getPiece())){
			return true;
		}
		return false;
	}
}
