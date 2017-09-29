/* Documentation tag for Doxygen
 */

/*! \mainpage PLEGAT Documentation
 *
 * \section intro_sec Introduction
 *
 * This is the Plegat documentation.
 *
 * \section install_sec Installation
 *
 * \subsection tools_subsec Tools required&#58;
 * - Java Runtime Environment &#40;JRE&#41; 1.4.2 or later &#40;<small><a href="http&#58;//java.sun.com/">Java Web Site etc etc...
 *
 * \subsection running Running the program
 * In a command window, etc etc...
 *
 * \section copyright Copyright and License
 * This license applies to etc etc...
 *
 * <BR><BR>
 *
 */



import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

	/**
	 * @param args
	 */
	public static void main (String[] args) {
		Damier d1 = new Damier() ;
		//Case c1 = new Case(1,0) ;
		//Case c2 = new Case(2,0) ;
		//Piece p1 = new Piece(0) ;
		
		//c1.setPiece(p1) ;
		//d1.setCase(1, 0, c1) ;
		//d1.setCase(2, 0, c2);
		
		//System.out.println("woh") ;
		//System.out.println(d1.getCase(1, 0).getPiece().getCouleur()) ;
		//System.out.println(d1.getCase(2, 0).getPiece().getCouleur()) ;
		
		d1.initialiser() ;

		for (int i = 0; i < 10; i++) {
	    	   for(int j = 0; j<10 ; j++){
	    		   //System.out.println(d1);
	    		   //System.out.println(d1.getCase(j,i));
	    		   //System.out.println(d1.getCase(j,i).getPiece());
	    		   //System.out.println(d1.getCase(j,i).getPiece().getCouleur()) ;
	    	   }
	       }
		Stage primaryStage = null ;
		Affichage a1 = new Affichage(d1) ;
		a1.main(args);
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
