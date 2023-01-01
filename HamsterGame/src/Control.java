import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Control {

	public void launchControl(Hamster hamster)   {

		System.out.println("W: move up");
		System.out.println("S: move down");
		System.out.println("A: move right");
		System.out.println("D: move left");
		System.out.println("Q: quit");

		JFrame jframe = new JFrame();
		jframe.requestFocus();
		jframe.setAlwaysOnTop(true);
		jframe.setLayout(new BorderLayout());
		jframe.setVisible(true);
		jframe.setSize(new Dimension(200, 200));
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(new JLabel("<html>W: move up<br>S: move down<br>A: move right<br>D: move left</html>"),
				BorderLayout.CENTER);
		jframe.setVisible(true);
		jframe.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					hamster.goUp();
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					hamster.goDown();
				}
				if (e.getKeyCode() == KeyEvent.VK_A) {
					hamster.goLeft();
				}
				if (e.getKeyCode() == KeyEvent.VK_D) {
					hamster.goRight();
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
	}
}