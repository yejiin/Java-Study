package abstracttest;

public class Rect extends Dohyung {

	private int width;
	private int height;

	public Rect(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

//	public void setWidth(int width) {
//		this.width = width;
//	}

	public int getHeight() {
		return height;
	}

	// public void setHeight(int height) {
//		this.height = height;
//	}

	@Override
	public double calcArea() {
		return width * height;
	}

	@Override
	public double calcRound() {
		return 2 * (width + height);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("가로가 ");
		sb.append(width);
		sb.append("이고 세로가 ");
		sb.append(height);
		sb.append("인 사각형의 넓이는 ");
		sb.append(calcArea());
		sb.append("이고 둘레는 ");
		sb.append(calcRound());
		sb.append("입니다.");
		return sb.toString();

	}

}
