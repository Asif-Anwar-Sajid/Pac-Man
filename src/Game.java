import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {

    Board board = new Board();
    Timer timer;
    char direction = 'L';
//    static boolean flag = true;
    Game() {
        JFrame frame = new JFrame();
        frame.setSize(420, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Pac-Man");
        frame.setVisible(true);
        frame.add(board, BorderLayout.CENTER);
        frame.addKeyListener(this);

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.ghost1.move();
                if(board.ghost1.getShape().intersects(board.pacman.getShape())) {
                    board.reset();
                }
                if(board.ghost2.getShape().intersects(board.pacman.getShape())) {
                    board.reset();
                }
                if(board.ghost3.getShape().intersects(board.pacman.getShape())) {
                    board.reset();
                }
                if(board.ghost4.getShape().intersects(board.pacman.getShape())) {
                    board.reset();
                }
                board.ghost2.move();
                board.ghost3.move();
                board.ghost4.move();

                board.ghost1.updateState(board.states);
                board.ghost2.updateState(board.states);
                board.ghost3.updateState(board.states);
                board.ghost4.updateState(board.states);

                board.pacman.move(direction);
                if(board.balls[(board.pacman.x)/20][(board.pacman.y)/20]) {
                    board.score += 2;
                }
                board.balls[(board.pacman.x)/20][(board.pacman.y)/20] = false;
                board.pacman.updateState(board.states);
            }
        });

        timer.start();
    }

    public static void main(String[] args) {
        Game g = new Game();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(board.showWelcomeScreen) {
            board.showWelcomeScreen = false;
            return;
        }

        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            direction = 'L';
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            direction = 'R';
        }
        else if(e.getKeyCode()==KeyEvent.VK_UP) {
            direction = 'U';
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
            direction = 'D';
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
