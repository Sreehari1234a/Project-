import javax.swing.JFrame;

public class ParticipantFrame extends JFrame {

    public ParticipantFrame() {
        setTitle("Participant Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }

    public static void main(String[] args) {
       
            new ParticipantFrame().setVisible(true);
    
    }
}
