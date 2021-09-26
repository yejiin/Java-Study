package abstracttest.instance;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class NewAbstractTest extends Frame implements WindowListener {
	Button b = new Button("push!!");
	Checkbox c = new Checkbox();
	Label l = new Label();

	public NewAbstractTest() {
		super("Has A Test!!");
		setLayout(new FlowLayout());
		setBackground(Color.CYAN);
//		b.setLabel("push!!");
		add(b);
		add(c);
		setSize(300, 400);
		setLocation(300, 200);
		setVisible(true);

//		WindowListener wl = new NewAbstractTest();
//		this.addWindowListener(wl);
		this.addWindowListener(this);
	}

	public static void main(String[] args) {
		new NewAbstractTest(); // 익명으로 객체 생성
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) { // 이것만 사용
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
