
public abstract class GameVars {

	String status;
	char icon;

	public GameVars(String status) {
		this.status = status;

		if (status.equals("wall"))
			icon = '#';
		else if (status.equals("route"))
			icon = '.';
		else if (status.equals("hamster"))
			icon = 'v';
		else if (status.equals("corn"))
			icon = 'o';
		else if (status.equals("exit"))
			icon = 'X';
		else
			icon = 'N';
	}

	public void print() {
		System.out.print(icon + " ");
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public char getIcon() {
		return icon;
	}

	public void setIcon(char icon) {
		this.icon = icon;
	}

}
