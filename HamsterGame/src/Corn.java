
public class Corn extends GameVars {

	public Corn(String status) {
		super(status);
		// TODO Auto-generated constructor stub
	}

	public Corn addNew() {
		icon = 'o';
		return new Corn("corn");
	
	}

	public Corn addNew(String str) {
		icon = 'o';
		return new Corn(str);
	}

}
