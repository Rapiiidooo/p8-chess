import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage; 

public class PieceImg
{
    private Image image_blanc = new Image("Blanc.png");
    private Image image_noir = new Image("Noir.png");
    private ImageView iv = new ImageView();
    private boolean noir;
    
    private int i;

    // 0 = Tour // 1 = CAVALIER // 2 = FOU // 3 = REINE // 4 = PION // 5 = Roi      >>>>> BLANC
    // 0 = Tour // 1 = CAVALIER // 2 = FOU // 3 = ROI   // 4 = PION // 5 = REINE    >>>>> NOIR

    public PieceImg (int i, boolean noir)
    {
        this.noir = noir;
        if(noir == false)
            iv.setImage(image_blanc);
        else
            iv.setImage(image_noir);
        this.i = i;
        init();
    }
    void init ()
    {
        int j = 0;
        while(this.i > 0)
        {
            j+= 100;
            this.i--;
        }
        //Rectangle2D toto = new Rectangle2D (xd, yd, xf, yf);
        Rectangle2D viewportRect = new Rectangle2D(j, 0, 100, 100);
        iv.setViewport(viewportRect);
        iv.setFitWidth(40);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        iv.setCache(true);
    }
    ImageView   getImgView ()               {return this.iv;}
    void        setImgView (ImageView iv)   {this.iv = iv;}
}