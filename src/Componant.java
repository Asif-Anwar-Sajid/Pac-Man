import java.awt.*;
import java.sql.PreparedStatement;

public class Componant {
    int index = 0;
    boolean states[][];
    static int cellSize = 20;
    static int max = 400;
    static int speed = 4;

    char direction;
    int x, y;
//    int lastX, lastY;
//
//    int xBall, yBall;
//    int last_xBall, last_yBall;

    Componant() {
        this.states = new boolean[20][20];

        for(int i=0; i<20; i++) {
            for(int j=0; j<20; j++) {
                this.states[i][j] = false;
            }
        }
    }

    public void updateState(boolean[][] UpdateStates) {
        for(int i=0; i<20; i++) {
            for(int j=0; j<20; j++) {
                this.states[i][j] = UpdateStates[i][j];
            }
        }
    }

    public boolean isValid(int x, int y) {
        if(x >= cellSize && x < max && y >= cellSize && y < max && states[x/20][y/20-1]) {
            return true;
        }
        return false;
    }

    public Rectangle getShape() {
        return new Rectangle(x, y, 20, 20);
    }
}
