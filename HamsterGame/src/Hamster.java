
public class Hamster extends GameVars {

	public Hamster(String status) {
		super(status);
	}

	private char up = '^';
	private char down = 'v';
	private char right = '>';
	private char left = '<';
	private String direction = new String();
	private int cornCounter = 0;
	Point currPos = new Point(0, 0);
	Point nextPos = new Point(0, 0);
	Point startPos = new Point(0, 1);
	Map map;

	public void enterMap(Map map) {
		this.map = map;
		map.setStartPos(startPos, this);
		currPos = startPos;
	}

	boolean checkWall(String direction) {
		endGame();
		if (map.isWall(nextPos) == 0) {
			nextPos.clone(currPos);
			System.out.println("Master, I can not go " + direction + "! This is the edge of my hamster world!");
			System.out.println(" ");
			return true;
		} else if (map.isWall(nextPos) == 1) {
			nextPos.clone(currPos);
			System.out.println(
					"Master, I can not go " + direction + " through the wall. I am just a tiny hamster, not a ghost! ");
			System.out.println(" ");
			return true;
		}
		return false;
	}

	public void goUp() {
		direction = "up";
		icon = up;
		nextPos.clone(currPos);
		nextPos.setX(currPos.getX() - 1);
		if (!checkWall(direction)) {
			if (checkCorn()) {
				pickupCorn();
			}
		}
		;
		currPos.clone(map.setPos(nextPos, currPos, this));
	}

	public void goDown() {
		icon = down;
		direction = "down";
		nextPos.clone(currPos);
		nextPos.setX(currPos.getX() + 1);
		if (!checkWall(direction)) {
			if (checkCorn()) {
				pickupCorn();
			}
		}
		;
		currPos.clone(map.setPos(nextPos, currPos, this));
	}

	public void goLeft() {
		icon = left;
		direction = "left";
		nextPos.clone(currPos);
		nextPos.setY(currPos.getY() - 1);
		if (!checkWall(direction)) {
			if (checkCorn()) {
				pickupCorn();
			}
		}
		;
		currPos.clone(map.setPos(nextPos, currPos, this));
	}

	public void goRight() {
		icon = right;
		direction = "rignt";
		nextPos.clone(currPos);
		nextPos.setY(currPos.getY() + 1);
		if (!checkWall(direction)) {
			if (checkCorn()) {
				pickupCorn();
			}
		}
		;
		currPos.clone(map.setPos(nextPos, currPos, this));
	}

	private boolean checkCorn() {
		if (map.isCorn(nextPos)) {
			return true;
		}
		return false;
	}

	private void pickupCorn() {
		if (map.getCorn(nextPos) instanceof Corn) {
			cornCounter++;
			System.out.println("Yummy-Yummy!");
			System.out.println("");
		} else {
			System.out.println("Phooey... it does not taste like a corn! It looks like I need new glasses, Master!");
		}
	}

	public void endGame() {
		if (map.map[currPos.getX()][currPos.getY()].getStatus().equals("exit")) {
			System.out.println("Hurray! I found exit from the maze and  gathered " + cornCounter + " grains!!");
			System.out.println(" ");
			System.exit(0);
		}
	}
}
