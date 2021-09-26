package abstracttest;

public class DohyungTest {

	public static void main(String[] args) {
		// 가로가 3이고 세로가 4인 사각형의 넓이는 12이고 둘레는 14입니다.
//		Rect r = new Rect();
//		r.setWidth(3);
//		r.setHeight(4);

		Rect r1 = new Rect(3, 4);
//		System.out.println("가로가 " + r1.getWidth() + "이고 세로가 " + r1.getHeight() + "인 사각형의 넓이는 " + r1.calcArea()
//				+ "이고 둘레는  " + r1.calcRound() + "입니다.");
		System.out.println(r1);

		Rect r2 = new Rect(5, 7);
//		System.out.println("가로가 " + r2.getWidth() + "이고 세로가 " + r2.getHeight() + "인 사각형의 넓이는 " + r2.calcArea()
//				+ "이고 둘레는  " + r2.calcRound() + "입니다.");
		System.out.println(r2);

		// 반지름이 4인 원의 넓이는 xx.xxx이고 둘레는 xx.xxx입니다.
		Circle c1 = new Circle(3);
		System.out.println(c1);

		Circle c2 = new Circle(4);
		System.out.println(c2);

//		Dohyung d1 = new Dohyung();
		Dohyung d1 = new Rect(4, 6);
		System.out.println("도형의 넓이는 " + d1.calcArea() + "이고 둘레는  " + d1.calcRound() + "입니다.");

		Rect r3 = (Rect) d1;
		System.out.println("가로가 " + r3.getWidth() + "이고 세로가 " + r3.getHeight() + "인 사각형의 넓이는 " + r3.calcArea()
				+ "이고 둘레는  " + r3.calcRound() + "입니다.");

//		Circle c3 = (Circle) d1; // ClassCastException 발생 (런타임 에러)
//		System.out.println(c3);

//		4.
		Dohyung d5 = new Dohyung() {

			@Override
			public double calcRound() {
				return 4 * 5;
			}

			@Override
			public double calcArea() {
				return 4 + 5;
			}
		};

		System.out.println(d5.calcArea() + " " + d5.calcRound());

		Dohyung d6 = new Dohyung() {

			@Override
			public double calcRound() {
				return 4 * 5;
			}

			@Override
			public double calcArea() {
				return 4 + 5;
			}
		};

		System.out.println(d6.calcArea() + " " + d6.calcRound());

	}

}
