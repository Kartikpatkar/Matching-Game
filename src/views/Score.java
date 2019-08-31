package views;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import static views.matchingGame.end;

public class Score extends JFrame{
    public JFrame secondFrame;
    public JLabel secondLabel;
    public Score(){
        /*SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long difference = date2.getTime() - date1.getTime();
        */
        this.secondFrame = new JFrame();
        this.secondLabel = new JLabel();
        this.secondFrame.setSize(300, 300);
        this.secondFrame.setLocation(1210,150);
        this.secondFrame.setVisible(true);
        this.secondFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      
        
    }
}
