package modifier;

public class Store {

	public static void main(String[] args) {

		System.out.println("손님 방문.");
		Guest.visit();
		System.out.println("가게 방문자 수 : " + Guest.cnt);

		System.out.println("손님 방문.");
		Guest.visit();
		System.out.println("가게 방문자 수 : " + Guest.cnt);

		System.out.println("손님 방문.");
		Guest.visit();
		System.out.println("가게 방문자 수 : " + Guest.cnt);

//		Guest g1 = new Guest("Kim");
//		Guest g2 = new Guest("Lee");
//		Guest g3 = new Guest("Park");
//
//		System.out.println(g1.name + "님 방문.");
//		g1.visit();
//		System.out.println("가게 방문자 수 : " + g1.cnt);
//
//		System.out.println(g1.name + "님 방문.");
//		g1.visit();
//		System.out.println("가게 방문자 수 : " + g1.cnt);
//
//		System.out.println(g2.name + "님 방문.");
//		g2.visit();
//		System.out.println("가게 방문자 수 : " + g2.cnt);
//
//		System.out.println(g3.name + "님 방문.");
//		g3.visit();
//		System.out.println("가게 방문자 수 : " + g3.cnt);

	}
}
