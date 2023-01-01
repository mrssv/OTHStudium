
import java.util.Scanner;

public class Game {
	Scanner sc;
	Control control;
	Map map;
	Point size;
	Hamster hamster;

	public void run() {
		init();
		showIntro();
		Point size = new Point(12, 12);
		map.setMap(size);
		hamster.enterMap(map);
		control.launchControl(hamster);

	}

	public void init() {
		sc = new Scanner(System.in);
		control = new Control();
		hamster = new Hamster("hamster");
		map = new Map(hamster);
	}

	private void showIntro() {
		String[] intro = {
				"Welcome to the game! A nice hamster Mr. Cookie lost in a maze. Help him to collect all grains and find a way out! Good luck!" };
		for (String text : intro) {
			printSlow(text, 30);
			delay(200);
		}
		System.out.println(" ");
		System.out.println(" ");
	}

	private void printSlow(String text, int msec) {
		if (text.length() > 0) {
			for (int i = 0; i < text.length(); i++) {
				System.out.print(text.charAt(i));
				delay(msec);
			}
		}
	}

	private void delay(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
