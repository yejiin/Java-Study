package modifier;

public class PointCardUser {

	public static void main(String[] args) {
		PointCard pc1 = new PointCard("Kim");
		PointCard pc2 = new PointCard("Lee");
		PointCard pc3 = new PointCard("Park");

		System.out.println(pc1.name + "님 커피구매.");
		pc1.visit();
		System.out.println("도장 수 : " + pc1.cnt);

		System.out.println(pc1.name + "님 커피구매.");
		pc1.visit();
		System.out.println("도장 수 : " + pc1.cnt);

		System.out.println(pc2.name + "님 커피구매.");
		pc2.visit();
		System.out.println("도장 수 : " + pc2.cnt);

		System.out.println(pc3.name + "님 커피구매.");
		pc3.visit();
		System.out.println("도장 수 : " + pc3.cnt);

	}
}
