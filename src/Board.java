import java.awt.*;
import javax.swing.*;

public class Board extends JPanel {

    int score;
    Image welcomeScreen = Toolkit.getDefaultToolkit().getImage("images/welcomeScreen.jpg");
    Image gameOver = Toolkit.getDefaultToolkit().getImage("images/gameOver.jpg");
    Image winnerWinnerChickenDinner = Toolkit.getDefaultToolkit().getImage("images/winnerWinnerChickenDinner.jpg");

    // Ghosts
    Image redGhost1 = Toolkit.getDefaultToolkit().getImage("images/ghost10.jpg");
    Image redGhost2 = Toolkit.getDefaultToolkit().getImage("images/ghost11.jpg");
    Image[] gRed = {redGhost1, redGhost2};

    Image orangeGhost1 = Toolkit.getDefaultToolkit().getImage("images/ghost20.jpg");
    Image orangeGhost2 = Toolkit.getDefaultToolkit().getImage("images/ghost21.jpg");
    Image[] gOrange = {orangeGhost1, orangeGhost2};

    Image blueGhost1 = Toolkit.getDefaultToolkit().getImage("images/ghost30.jpg");
    Image blueGhost2 = Toolkit.getDefaultToolkit().getImage("images/ghost31.jpg");
    Image[] gBlue = {blueGhost1, blueGhost2};

    Image pinkGhost1 = Toolkit.getDefaultToolkit().getImage("images/ghost40.jpg");
    Image pinkGhost2 = Toolkit.getDefaultToolkit().getImage("images/ghost41.jpg");
    Image[] gPink = {pinkGhost1, pinkGhost2};

    // Pac-Man
    Image pacmanInitial = Toolkit.getDefaultToolkit().getImage("images/pacman.jpg");
    Image pacmanLeft = Toolkit.getDefaultToolkit().getImage("images/pacmanleft.jpg");
    Image pacmanRight = Toolkit.getDefaultToolkit().getImage("images/pacmanright.jpg");
    Image pacmanUp = Toolkit.getDefaultToolkit().getImage("images/pacmanup.jpg");
    Image pacmanDown = Toolkit.getDefaultToolkit().getImage("images/pacmandown.jpg");
    Image[] pacmanImages = {pacmanLeft, pacmanRight, pacmanUp, pacmanDown};
    Pacman pacman = new Pacman(10*Componant.cellSize, 15*Componant.cellSize);
    // Ghosts

    Ghost ghost1 = new Ghost(10*Componant.cellSize, 8*Componant.cellSize);
    Ghost ghost2 = new Ghost(9*Componant.cellSize, 9*Componant.cellSize);
    Ghost ghost3 = new Ghost(11*Componant.cellSize, 9*Componant.cellSize);
    Ghost ghost4 = new Ghost(10*Componant.cellSize, 9*Componant.cellSize);


    boolean showWelcomeScreen;
    boolean balls[][];
    boolean states[][];
    int lives = 2;

    public void drawLives(Graphics g) {
        g.setColor(Color.YELLOW);
        for(int i=0; i<lives; i++) {
//            g.fillOval((Componant.cellSize + 5) * i + 15, Componant.max+10, Componant.cellSize, Componant.cellSize);
        g.drawImage(pacmanLeft, (Componant.cellSize+5)*i+15, Componant.max+10, null);
        }
    }

    Board() {
        showWelcomeScreen = true;
        balls = new boolean[Componant.cellSize][Componant.cellSize];
        states = new boolean[Componant.cellSize][Componant.cellSize];
        init();
    }

    public void init() {
        for (int i = 0; i < Componant.cellSize; i++) {
            for (int j = 0; j < Componant.cellSize; j++) {
                balls[i][j] = true;
                states[i][j] = true;
            }
        }

        balls[10][8] = false;
        balls[10][9] = false;
        balls[11][9] = false;
        balls[9][9] = false;
        balls[10][15] = false;
    }

    public void draw(Graphics g, int x, int y, int width, int height) {
        g.fillRect(x, y, width, height);

        for(int i=x/20; i<x/20 + width/20; i++) {
            for(int j=y/20; j< y/20 + height/20; j++) {
                balls[i][j] = false;
                states[i][j-1] = false;
            }
        }
    }

    public void drawBalls(Graphics g) {
        g.setColor(Color.YELLOW);
        for (int i = 1; i < Componant.cellSize; i++) {
            for (int j = 1; j < Componant.cellSize; j++) {
                if (balls[i][j]) {
                    g.fillOval(i * 20+8, j * 20+8, 4, 4);
                }
            }
        }
    }

    public void drawBoard(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(19, 19, 382, 382);

        g.setColor(Color.BLUE);
        draw(g, 40, 40, 60, 20);
        draw(g, 120, 40, 60, 20);
        draw(g, 200, 20, 20, 40);
        draw(g, 240, 40, 60, 20);
        draw(g, 320, 40, 60, 20);
        draw(g, 40, 80, 60, 20);
        draw(g, 160, 80, 100, 20);
        draw(g, 200, 80, 20, 60);
        draw(g, 320, 80, 60, 20);
        draw(g, 20, 120, 80, 60);
        draw(g, 320, 120, 80, 60);
        draw(g, 20, 200, 80, 60);
        draw(g, 320, 200, 80, 60);
        draw(g, 160, 160, 40, 20);
        draw(g, 220, 160, 40, 20);
        draw(g, 160, 180, 20, 20);
        draw(g, 160, 200, 100, 20);
        draw(g, 240, 180, 20, 20);
        draw(g, 120, 120, 60, 20);
        draw(g, 120, 80, 20, 100);
        draw(g, 280, 80, 20, 100);
        draw(g, 240, 120, 60, 20);
        draw(g, 280, 200, 20, 60);
        draw(g, 120, 200, 20, 60);
        draw(g, 160, 240, 100, 20);
        draw(g, 200, 260, 20, 40);
        draw(g, 120, 280, 60, 20);
        draw(g, 240, 280, 60, 20);
        draw(g, 40, 280, 60, 20);
        draw(g, 80, 280, 20, 60);
        draw(g, 320, 280, 60, 20);
        draw(g, 320, 280, 20, 60);
        draw(g, 20, 320, 40, 20);
        draw(g, 360, 320, 40, 20);
        draw(g, 160, 320, 100, 20);
        draw(g, 200, 320, 20, 60);
        draw(g, 40, 360, 140, 20);
        draw(g, 240, 360, 140, 20);
        draw(g, 280, 320, 20, 60);
        draw(g, 120, 320, 20, 60);

        repaint();

    }

    public void reset() {
        if(lives > 0) --lives;

        ghost1.x = 10*Componant.cellSize;
        ghost1.y = 8*Componant.cellSize;

        ghost1.x = 9*Componant.cellSize;
        ghost1.y = 9*Componant.cellSize;

        ghost1.x = 11*Componant.cellSize;
        ghost1.y = 9*Componant.cellSize;

        ghost1.x = 10*Componant.cellSize;
        ghost1.y = 9*Componant.cellSize;

        pacman.x = 10*Componant.cellSize;
        pacman.y = 15*Componant.cellSize;

//        Game.flag = true;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 420, 500);
        drawBoard(g);
        drawBalls(g);
        drawLives(g);

        Font font = new Font("Arial", Font.BOLD, 20);
        g.setFont(font);
        g.drawString("Score: " + score, Componant.max/2+50, Componant.max+30);

        g.drawImage(gRed[ghost1.index], ghost1.x, ghost1.y, null);
        g.drawImage(gBlue[ghost2.index], ghost2.x, ghost2.y, null);
        g.drawImage(gPink[ghost3.index],  ghost3.x, ghost3.y, null);
        g.drawImage(gOrange[ghost4.index], ghost4.x, ghost4.y, null);

        g.drawImage(pacmanImages[pacman.index], pacman.x, pacman.y, null);

        if (showWelcomeScreen) {
            g.drawImage(welcomeScreen, 0, 0, null);
        }
        if(lives==0) {
            g.drawImage(gameOver, 0, 0, null);
            font = new Font("Arial", font.BOLD, 30);
            g.setColor(Color.RED);
            g.drawString("Your Score: " + score, 220, 30);
        }
        if(check()) {
            g.drawImage(winnerWinnerChickenDinner, 0, 0, null);
        }
    }

    public boolean check() {
        for (int i = 1; i < Componant.cellSize; i++) {
            for (int j = 1; j < Componant.cellSize; j++) {
                if(balls[i][j]) return false;
            }
        }
        return true;
    }
}
