package modifier;

public class PointCard {

	int cnt;
	String name;

	public PointCard(String name) {
		this.name = name;
	}

	public void visit() {
		cnt++;
	}
}
