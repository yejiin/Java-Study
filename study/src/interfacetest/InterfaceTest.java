package interfacetest;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class InterfaceTest extends Frame implements WindowListener, ActionListener {
	Button b = new Button("push!!");
	Checkbox c = new Checkbox();
	Label l = new Label();

	Random random = new Random();

	public InterfaceTest() {
		super("Has A Test!!");
		setLayout(new FlowLayout());
		setBackground(Color.CYAN);
//		b.setLabel("push!!");
		add(b);
		add(c);
		setSize(300, 400);
		setLocation(300, 200);
		setVisible(true);

		this.addWindowListener(this);
		b.addActionListener(this);
	}

	public static void main(String[] args) {
		new InterfaceTest(); // 익명으로 객체 생성
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 눌렀네???");
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);

		this.setBackground(new Color(r, g, b));
	}
}
