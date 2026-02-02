
import javax.swing.*;
import java.awt.*;

public class SimonGameUI extends JFrame {

    private SimonButton[] buttons = new SimonButton[4];
    private GameLogic logic = new GameLogic();
    private ScoreManager scoreManager = new ScoreManager();

    private JLabel scoreLabel = new JLabel("Score: 0");
    private JLabel timerLabel = new JLabel("Time: 120s");

    private Timer timer;
    private int timeLeft = 120;

    public SimonGameUI() {
        setTitle("Simon Game");
        setSize(400, 450);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel top = new JPanel();
        top.add(scoreLabel);
        top.add(timerLabel);

        JPanel grid = new JPanel(new GridLayout(2,2));
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

        for(int i=0;i<4;i++){
            buttons[i] = new SimonButton(i, colors[i]);
            int id = i;
            buttons[i].addActionListener(e -> handleClick(id));
            grid.add(buttons[i]);
        }

        add(top, BorderLayout.NORTH);
        add(grid, BorderLayout.CENTER);

        startGame();
        setVisible(true);
    }

    private void setButtonsEnabled(boolean enabled) {
        for (SimonButton b : buttons) {
            b.setEnabled(enabled);
        }
    }

    private void startGame() {
        logic.reset();
        timeLeft = 120;
        startTimer();
        nextRound();
    }

    private void startTimer() {
        timer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Time: " + timeLeft + "s");
            if(timeLeft <= 0){
                timer.stop();
                endGame();
            }
        });
        timer.start();
    }

    private void nextRound() {
        logic.nextRound();
        scoreLabel.setText("Score: " + logic.getScore());
        showPattern();
    }

    private void showPattern() {
        setButtonsEnabled(false);

        new Thread(() -> {
            try {
                Thread.sleep(500);
                for(Integer i : logic.getPattern()){
                    buttons[i].flash();
                    Thread.sleep(300);
                }
            } catch(Exception e){}

            SwingUtilities.invokeLater(() -> setButtonsEnabled(true));
        }).start();
    }

    private void handleClick(int id) {
        if(!logic.checkInput(id)){
            endGame();
            return;
        }
        if(logic.roundComplete()){
            nextRound();
        }
    }

    private void endGame() {
        timer.stop();
        setButtonsEnabled(false);
        scoreManager.addScore(logic.getScore());

        String msg = "Game Over!\nScore: " + logic.getScore() + "\nTop Scores:\n";
        int rank = 1;
        for(Integer s : scoreManager.getTopScores()){
            msg += rank++ + ". " + s + "\n";
        }

        JOptionPane.showMessageDialog(this, msg);
        startGame();
    }
}
