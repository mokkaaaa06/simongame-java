
import javax.swing.*;
import java.awt.*;

public class SimonButton extends JButton {

    private int id;
    private Color color;

    public SimonButton(int id, Color color) {
        this.id = id;
        this.color = color;
        setBackground(color);
        setOpaque(true);
        setBorderPainted(false);
    }

    public void flash() {
        try {
            setBackground(Color.WHITE);
            Thread.sleep(300);
            setBackground(color);
        } catch(Exception e){}
    }

    public int getId() {
        return id;
    }
}
