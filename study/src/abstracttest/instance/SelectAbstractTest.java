package abstracttest.instance;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SelectAbstractTest extends Frame {
	Button b = new Button("push!!");
	Checkbox c = new Checkbox();
	Label l = new Label();

	public SelectAbstractTest() {
		super("Has A Test!!");
		setLayout(new FlowLayout());
		setBackground(Color.CYAN);
//		b.setLabel("push!!");
		add(b);
		add(c);
		setSize(300, 400);
		setLocation(300, 200);
		setVisible(true);

		this.addWindowListener(new WindowAdapter() { // WindowAdapter는 추상메서드가 없는 추상클래스 (의미상 추상클래스)

			@Override
			public void windowClosing(WindowEvent e) { // 오버라이딩. 반드시 모두 오버라이딩하는 게 아니라 하고 싶은 것만 오버라이딩
				System.out.println("창 닫는다!!!");
				System.exit(0);
			}

			@Override
			public void windowIconified(WindowEvent e) {
				System.out.println("창 내리갔다!!!");
			}
		});
	}

	public static void main(String[] args) {
		new SelectAbstractTest(); // 익명으로 객체 생성

	}

}
