
public class Brick extends GameVars {

	public Brick(String status) {
		super(status);
		// TODO Auto-generated constructor stub
	}

	public Brick addNew() {
		icon = '#';
		return new Brick("wall");
	}

	public Brick addNew(String str) {
		icon = '#';
		return new Brick(str);
	}
}
