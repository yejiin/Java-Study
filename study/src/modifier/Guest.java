package modifier;

public class Guest {

	static int cnt;
	String name;

	public Guest(String name) {
		this.name = name;
	}

	public static void visit() {
		cnt++;
	}
}
