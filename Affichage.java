import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.* ;
import javafx.stage.Stage;
import javafx.scene.input.*;
import javafx.scene.image.ImageView;


public class Affichage extends Application {
    
    
    Damier damier ;
    int joueur ;
    boolean ready ;
    Case caseSelectionnee ;
    Rectangle rectangleSelectionne ;
    boolean combo;
    
    Group rectangles = new Group();
    Group pions = new Group();
    //Group imagV = new Group();
    
    
    public Affichage(){
        this.damier=new Damier() ;
    }
    
    public Affichage(Damier damier){
        this.damier = damier ;
    }
 
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Damier d1 = new Damier() ;
        joueur=0;
            
           
           
           
        //initialisation
        d1.initialiser() ;
        
        ready = false ;
        Group root = new Group();
        Scene scene = new Scene(root, 400, 400, Color.WHITE);
        primaryStage.setScene(scene);
        
        
        
        
        /*Group rectangles = new Group();
        for (int i = 0; i < 10; i++) {
            for(int j=0 ; j<10 ; j++){
                Rectangle rectangle = new Rectangle(50, 50, Color.web("black", 0.05 + 0.10*((i+j)%2) ));
                //rectangle.setStrokeType(StrokeType.OUTSIDE);
                rectangle.setStroke(Color.web("black", 1));
                rectangle.setStrokeWidth(1);
                //rectangle.setLayoutX(100*(i%10));
                //rectangle.setLayoutY(100*(i/10));
                rectangle.setX(50*(j));
                rectangle.setY(50*(i));
                rectangles.getChildren().add(rectangle);
            }
        }
        
        
        
        Group pions = new Group();
        for (int i = 0; i < 10; i++) {
           for(int j = 0; j<10 ; j++){
               if(d1.getCase(j,i).getPiece().getCouleur() >= 0){
                   Circle pion = new Circle(20, Color.web("black", 1));
                   if(d1.getCase(j,i).getPiece().getCouleur() == 0){
                       pion.setFill(Color.WHITE);
                   }
                   //pion.setStrokeType(StrokeType.OUTSIDE);
                   pion.setStroke(Color.web("black", 1));
                   pion.setStrokeWidth(1);
                   pion.setCenterX(50*(j) + 25);
                   pion.setCenterY(50*(i) + 25);
                   pions.getChildren().add(pion);

               }
                    
           }
        }*/
        refresh(d1);
        
        combo = false;
        Group buttons = new Group();
        for (int y = 0; y < 8; y++) {
            for(int x=0 ; x<8 ; x++){
                Button btn = new Button() ;
                Case caseAssociee = d1.getCase(x, y) ;
                btn.setLayoutX(50*x);
                btn.setLayoutY(50*y);
                btn.setPrefSize(50, 50);
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(ready==false){
                            
                            
                            
                            if(d1.actionPossible( caseAssociee , joueur)){
                                caseSelectionnee = caseAssociee ;
                                ready = true ;
                                System.out.println(caseSelectionnee.getPiece().getNom());
                            }else{
                                //System.out.println("non");
                            }
                        }else{
                            
                            if(deplacementPossible(caseSelectionnee, caseAssociee)){
                                deplacer(caseSelectionnee, caseAssociee);
                                refresh(d1);
                            }
                            else{
                                System.out.println("deplacement impossible : la case  " + caseSelectionnee + " de coordonnees " + caseSelectionnee.getX()+", "+ caseSelectionnee.getY()+ " n'a pas acces a la case  " + caseAssociee + " de coordonnees " + caseAssociee.getX()+", "+ caseAssociee.getY() );
                                ready=false;
                            }
                            
                            
                            
                            /*if(d1.deplacementPossible(caseSelectionnee, caseAssociee, joueur)){
                                if(combo==true){
                                    System.out.println("vous devez attaquer");
                                }
                                else{
                                    d1.deplacer(caseSelectionnee, caseAssociee);
                                    refresh(d1);
                                    swap();
                                    ready=false;
                                }
                            }
                            else if(d1.attaquePossible(caseSelectionnee, caseAssociee,joueur)!=null){
                                //System.out.println("oui");
                                //System.out.println(d1.attaquePossible(caseSelectionnee, caseAssociee,joueur));
                                d1.attaquePossible(caseSelectionnee, caseAssociee,joueur).setPiece(new Piece());
                                d1.deplacer(caseSelectionnee, caseAssociee);
                                refresh(d1);
                                if(d1.isAttaquePossible(caseAssociee,joueur)){
                                    System.out.println("vous devez continuer d'attaquer");
                                    combo=true;
                                    caseSelectionnee = caseAssociee;
                                }
                                else{
                                    combo=false;
                                    swap();
                                    ready=false;
                                }
                            }
                            else{
                                if(combo==true){
                                    System.out.println("vous devez attaquer");
                                }
                                else{
                                    //System.out.println("non");
                                    ready=false;
                                }
                            }*/
                        }
                    }
                });
                btn.setVisible(false);
                buttons.getChildren().add(btn) ;
            }
        }
       
        
           
           
           /*Group circles = new Group();
           for (int i = 0; i < 30; i++) {
              Circle circle = new Circle(150, Color.web("white", 0.05));
              circle.setStrokeType(StrokeType.OUTSIDE);
              circle.setStroke(Color.web("white", 0.16));
              circle.setStrokeWidth(4);
              circles.getChildren().add(circle);
           }
           root.getChildren().add(circles);*/
           
           
        root.getChildren().add(rectangles);
        root.getChildren().add(buttons);
        root.getChildren().add(pions);
        primaryStage.show();
           
           
        
        

           //for (int i = 0; i < 10; i++) {for(int j = 0; j<10 ; j++){if(d1.getCase(j,i).getPiece().getCouleur() >= 0){Circle pion = new Circle(20, Color.web("black", 1));if(d1.getCase(j,i).getPiece().getCouleur() == 0){pion.setFill(Color.WHITE);}pion.setStroke(Color.web("black", 1));pion.setStrokeWidth(1);pion.setCenterX(50*(j) + 25);pion.setCenterY(50*(i) + 25);pions.getChildren().add(pion);}}}root.getChildren().add(pions);primaryStage.show();}
    
    }
    
    private void refresh(Damier d1){
        
        rectangles.getChildren().clear();
        //imagV.getChildren().clear();
        for (int y = 0; y < 8; y++) {
            for(int x=0 ; x<8 ; x++){
                //ImageView imageView = d1.getCase(x,y).getPiece().getImgView();
                Rectangle rectangle = new Rectangle(50, 50, Color.web("black", 0.10 + 0.35*((y+x)%2) ));
                //rectangle.setStrokeType(StrokeType.OUTSIDE);
                rectangle.setStroke(Color.web("black", 1));
                rectangle.setStrokeWidth(1);
                //rectangle.setLayoutX(100*(i%10));
                //rectangle.setLayoutY(100*(i/10));
                rectangle.setX(50*(x));
                rectangle.setY(50*(y));
                Case caseAssociee = d1.getCase(x, y) ;

                rectangle.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override                     
                    public void handle(MouseEvent event) {
                        if(ready==false){
                            
                            
                            
                            if(d1.actionPossible( caseAssociee , joueur)){
                                caseSelectionnee = caseAssociee ;
                                rectangleSelectionne = rectangle ;
                                ready = true ;
                                rectangle.setStroke(Color.web("white", 1));
                                rectangle.setFill(Color.web("yellow",0.20));
                                System.out.println(caseSelectionnee.getPiece().getNom());

                            }else{
                                //System.out.println("non");
                            }
                        }else{
                            
                            if(deplacementPossible(caseSelectionnee, caseAssociee)){
                                deplacer(caseSelectionnee, caseAssociee);
                                refresh(d1);
                            }
                            else{
                                System.out.println("deplacement impossible : la case  " + caseSelectionnee + " de coordonnees " + caseSelectionnee.getX()+", "+ caseSelectionnee.getY()+ " n'a pas acces a la case  " + caseAssociee + " de coordonnees " + caseAssociee.getX()+", "+ caseAssociee.getY() );
                                //System.out.println(rectangles.getChildren().get( (caseSelectionnee.getY()*8) + (caseSelectionnee.getX())));
                                rectangleSelectionne.setStroke(Color.web("black", 1));
                                //rectangles.getChildren().get( (caseSelectionnee.getY()*8) + (caseSelectionnee.getX())).setStroke(Color.web("black", 1));
                                ready=false;
                            }
                        }
                    }
                });
                /*
                imageView.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override                     
                    public void handle(MouseEvent event) {
                        if(ready==false){
                            if(d1.actionPossible( caseAssociee , joueur)){
                                caseSelectionnee = caseAssociee ;
                                rectangleSelectionne = rectangle ;
                                ready = true ;
                                rectangle.setStroke(Color.web("white", 1));
                                rectangle.setFill(Color.web("yellow",0.20));
                                System.out.println(caseSelectionnee.getPiece().getNom());
                            }else{
                                //System.out.println("non");
                            }
                        }else{
                            if(deplacementPossible(caseSelectionnee, caseAssociee)){
                                deplacer(caseSelectionnee, caseAssociee);
                                refresh(d1);
                            }
                            else{
                                System.out.println("deplacement impossible : la case  " + caseSelectionnee + " de coordonnees " + caseSelectionnee.getX()+", "+ caseSelectionnee.getY()+ " n'a pas acces a la case  " + caseAssociee + " de coordonnees " + caseAssociee.getX()+", "+ caseAssociee.getY() );
                                //System.out.println(rectangles.getChildren().get( (caseSelectionnee.getY()*8) + (caseSelectionnee.getX())));
                                rectangleSelectionne.setStroke(Color.web("black", 1));
                                //rectangles.getChildren().get( (caseSelectionnee.getY()*8) + (caseSelectionnee.getX())).setStroke(Color.web("black", 1));
                                ready=false;
                            }
                        }
                    }
                });
*/
                rectangles.getChildren().add(rectangle);
                //imagV.getChildren().add(imageView);
            }
        }
        //root.getChildren().add(rectangles);
        
        pions.getChildren().clear();
        for (int i = 0; i < 8; i++) {
           for(int j = 0; j<8 ; j++){
               if(d1.getCase(j,i).getPiece().getCouleur() >= 0){
                    ImageView imV = d1.getCase(j,i).getPiece().getImgView();
                    imV.setX(50*(j) + 4);
                    imV.setY(50*(i) + 4);
                /*
                   Circle pion = new Circle(20, Color.web("black", 1));
                   if(d1.getCase(j,i).getPiece().getCouleur() == 0){
                       pion.setFill(Color.WHITE);
                   }
                   //pion.setStrokeType(StrokeType.OUTSIDE);
                   pion.setStroke(Color.web("black", 1));
                   pion.setStrokeWidth(1);
                   pion.setCenterX(50*(j) + 25);
                   pion.setCenterY(50*(i) + 25);
                */
                   pions.getChildren().add(imV);

               }
                   
           }
        }
    }
    
    private void swap(){
        if(joueur==0)
            joueur = 1;
        else joueur = 0 ;
        System.out.println("au joueur " + joueur + " de jouer");
        
    }
    
    private boolean deplacementPossible(Case case1, Case case2){
        ArrayList<Case> casesRenvoyees = case1.getPiece().casesDisponibles() ;
        System.out.println(casesRenvoyees.toString());
        if(case2.getPiece().getCouleur()==joueur){
            return false ;
        }
        for(int i=0; i<casesRenvoyees.size() ; i++){
            if(casesRenvoyees.get(i).equal(case2)){
                return true ;
            }
        }
        return false ;
        
    }
    
    private void deplacer(Case case1, Case case2){
        case1.getPiece().setCase(case2);
        case2.setPiece(case1.getPiece());
        case1.setPiece(new Piece(case1));
        swap();
        ready=false;
    }
 
 public void main(String[] args) {
        System.out.println(this.damier.getCase(0,0).getPiece());
        launch(args);
    }
}