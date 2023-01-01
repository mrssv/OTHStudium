
public class Map {
	public GameVars[][] map;
	public Hamster hamster;

	public Map(Hamster hamster) {
		this.hamster = hamster;
	}

	public Point setStartPos(Point startPos, Hamster hamster) {
		GameVars cellBackup = map[startPos.getX()][startPos.getY()];
		map[startPos.getX()][startPos.getY()] = hamster;
		printMap();
		map[startPos.getX()][startPos.getY()] = cellBackup;
		return startPos;
	}

	public Point setPos(Point nextPos, Point currPos, GameVars object) {
		GameVars cellBackup = map[nextPos.getX()][nextPos.getY()];
		map[nextPos.getX()][nextPos.getY()] = object;
		printMap();
		map[nextPos.getX()][nextPos.getY()] = cellBackup;
		currPos.clone(nextPos);
		return currPos;
	}

	public boolean isBound(Point cellToCheck) {
		try {
			if (cellToCheck.getX() < 0 || cellToCheck.getX() > map.length) {
				return true;
			}
			if (cellToCheck.getY() < 0 || cellToCheck.getY() > map[0].length) {
				return true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {

			return true;
		}
		return false;
	}

	public void setMap(Point size) {
		char[][] rawMap = { 
				{ '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
				{ '#', '.', '0', '.', '#', '.', '0', '.', '.', '.', '.', '#' },
				{ '#', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#' },
				{ '#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#' },
				{ '#', '0', '.', '.', '.', '#', '#', '#', '.', '#', '.', 'x' },
				{ '#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#' },
				{ '#', '.', '0', '#', '.', '#', '.', '#', '.', '#', '.', '#' },
				{ '#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#' },
				{ '#', '.', '.', '.', '0', '.', '.', '.', '.', '#', '.', '#' },
				{ '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#' },
				{ '#', '0', '.', '.', '.', '.', '.', '#', '.', '.', '0', '#' },
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } 
				};

		map = new GameVars[size.getX()][size.getY()];
		for (int i = 0; i < map.length; i++) {
			for (int k = 0; k < map[i].length; k++) {
				if (rawMap[i][k] == 'v')
					map[i][k] = hamster;
				if (rawMap[i][k] == 'x')
					map[i][k] = new Brick("exit");
				if (rawMap[i][k] == '#')
					map[i][k] = new Brick("wall");
				if (rawMap[i][k] == '0')
					map[i][k] = new Corn("corn");
				if (rawMap[i][k] == '.')
					map[i][k] = new Route("route");
			}
		}
	}

	public boolean checkCell(Point cellToCheck, GameVars object) {
		if (map[cellToCheck.getX()][cellToCheck.getY()].equals(object)) {
			return true;
		} else
			return false;
	}

	public int isWall(Point cellToCheck) {

		if (isBound(cellToCheck))
			return 0;
		if (map[cellToCheck.getX()][cellToCheck.getY()].getStatus().equals("wall"))
			return 1;
		else
			return 2;

	}

	public boolean isCorn(Point cellToCheck) {
		if (map[cellToCheck.getX()][cellToCheck.getY()].getStatus().equals("corn")) {
			return true;
		} else
			return false;
	}

	public Corn getCorn(Point pos) {
		if (map[pos.getX()][pos.getY()] instanceof Corn) {
			Corn takenCorn = (Corn) map[pos.getX()][pos.getY()];
			map[pos.getX()][pos.getY()] = new Route("route");
			return takenCorn;
		}
		return null;
	}

	public void printMap() {
		for (int i = 0; i < map.length; i++) {
			for (int k = 0; k < map[i].length; k++) {
				map[i][k].print();
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
}
