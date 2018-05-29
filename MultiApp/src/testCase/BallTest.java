package testCase;

import junit.framework.TestCase;
import modelo.Ball;


public class BallTest extends TestCase{
	private Ball ball;
	private void setupEscenario1() {
		ball =new Ball(250, 300);
		ball.setA(190);
		ball.mover(500, 400, 500, 400);
	}
	
	public void testMover() {
		setupEscenario1();
		
		assertTrue(ball.getDireccionY()==1);
	}
}
