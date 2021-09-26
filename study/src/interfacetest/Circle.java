package interfacetest;

import java.text.DecimalFormat;
import java.text.Format;

public class Circle implements DohyungArea, DohyungRound {

	private int radius;

	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double calcRound() {
		return 2 * Math.PI * radius;
	}

	@Override
	public String toString() {
//		Format f = new DecimalFormat("000,000,000.00");
		Format f = new DecimalFormat("###,###,###.##");
		String area = f.format(calcArea());
		String round = f.format(calcRound());
		StringBuilder sb = new StringBuilder();
		sb.append("반지름이 ");
		sb.append(radius);
		sb.append("인 원의 넓이는 ");
		sb.append(area);
		sb.append("이고 둘레는 ");
		sb.append(round);
		sb.append("입니다.");
		return sb.toString();

	}

}
