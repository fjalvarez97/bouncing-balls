import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> balls;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        balls = new ArrayList<>();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int ballsNumber)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        Random numRandom = new Random();
        // crate and show the balls

        for (int i = 0; i < ballsNumber; i++){
            int diameter = numRandom.nextInt(40)+5;
            int red = numRandom.nextInt(256);
            int green = numRandom.nextInt(256);
            int blue = numRandom.nextInt(256);
            int posX = numRandom.nextInt(300);
            int posY = numRandom.nextInt(250);
            Color color = new Color (red, green, blue);
            BouncingBall ball = new BouncingBall(posX, posY, diameter, color, ground, myCanvas);
            ball.draw();   
            balls.add(ball);
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50); 
            // small delay
            for (int i=0; i < ballsNumber ; i++){ 
                balls.get(i).move();
            }
            // stop once ball has travelled a certain distance on x axis
            for (int i=0; i <ballsNumber ; i++) {
                if(balls.get(i).getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
