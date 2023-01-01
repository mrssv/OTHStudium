
public class Route extends GameVars {

	public Route(String status) {
		super(status);
		// TODO Auto-generated constructor stub
	}

	public Route addNew() {
		icon = '.';
		return new Route("route");
	}

	public Route addNew(String str) {
		icon = '.';
		return new Route(str);
	}
}
