package h3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * 通用型遙控器
 * 以相依IRemoteControllable來執行通用動作
 * 以swing作為遙控器的面板介面呈現
 * @author TDYu
 */
public class RemoteController extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	/* 相依一個通用介面型抽象的 IRemoteControllable */
	private IRemoteControllable remoteControllable;
	/* 4 buttons for 4 actions */
	private JButton powerOn = new JButton("powerOn");
	private JButton powerOff = new JButton("powerOff");
	private JButton increase = new JButton("increase");
	private JButton decrease = new JButton("decrease");
	/* text area to show information like a screen */
	private JTextArea textArea = new JTextArea("");
	/* JFrame title */
	private String frameTitle;
	
	/**
	 * Constructor
	 * @param remoteControllable
	 * @param frameTitle for new frame
	 */
	public RemoteController(IRemoteControllable remoteControllable, String frameTitle) {
		/* 連結真實的remoteControllable */
		this.remoteControllable = remoteControllable;
		
		this.frameTitle = frameTitle;
		
		/* add action listener to all components */
		this.addListener();
		
		/* JFram base setting */
		this.baseFrameSetting();
		
		/* add components to frame */
		this.addComponents();
	}
	
	/**
	 * add action listener to all components
	 * and set action command
	 */
	private void addListener() {
		/* add action listener to powerOn button and add action command */
		this.powerOn.addActionListener(this);
		this.powerOn.setActionCommand("powerOn");
		
		/* add action listener to powerOff button and add action command */
		this.powerOff.addActionListener(this);
		this.powerOff.setActionCommand("powerOff");
		
		/* add action listener to increase button and add action command */
		this.increase.addActionListener(this);
		this.increase.setActionCommand("increase");
		
		/* add action listener to decrease button and add action command */
		this.decrease.addActionListener(this);
		this.decrease.setActionCommand("decrease");
	}
	
	/**
	 * JFram base setting
	 */
	private void baseFrameSetting() {
		// new frame
		this.getContentPane().setLayout(null);
		// set size
		this.setSize(500, 600);
		// set title
		this.setTitle(frameTitle);
		// set background color
		this.getContentPane().setBackground(Color.GRAY);
		// set default close operation
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		/* let frame be visible */
		this.setVisible(true);
	}
	
	/**
	 * add components to frame
	 */
	private void addComponents() {
		// add power-on button on the left center
		this.getContentPane().add(powerOn);
		this.powerOn.setText("ON");
		this.powerOn.setBounds(10, 280, 100, 30);
		// add power-off button on the right center
		this.getContentPane().add(powerOff);
		this.powerOff.setText("OFF");
		this.powerOff.setBounds(370, 280, 100, 30);
		// add increase button on the top center
		this.getContentPane().add(increase);
		this.increase.setText("＋");
		this.increase.setBounds(190, 20, 100, 30);
		// add text area on the center
		this.getContentPane().add(textArea);
		this.textArea.setBounds(140, 120, 200, 300);
		this.textArea.setBackground(Color.BLACK);
		this.textArea.setFont(new java.awt.Font("Dialog", 1, 20));
		this.textArea.setAlignmentX(LEFT_ALIGNMENT);;
		// add decrease button on the bottom center
		this.getContentPane().add(decrease);
		this.decrease.setText("－");
		this.decrease.setBounds(190, 490, 100, 30);
	}
	
	/**
	 * power on
	 */
	public void on() {
		// 透過相依的remoteControllable執行
		String state = remoteControllable.on();
		// let background of text area be black. like open the screen
		this.textArea.setBackground(Color.WHITE);
		// set text area to show current state
		this.textArea.setText(state);
	}
	
	/**
	 * power off
	 */
	public void off() {
		// 透過相依的remoteControllable執行
		String state = remoteControllable.off();
		// let background of text area be black. like close the screen
		this.textArea.setBackground(Color.BLACK);
		// set text area to show current state
		this.textArea.setText(state);
	}
	
	/**
	 * increase some value
	 */
	public void up() {
		// 透過相依的remoteControllable執行
		String state = remoteControllable.up();
		// set text area to show current state
		this.textArea.setText(state);
	}
	
	/**
	 * decrease some value
	 */
	public void down() {
		// 透過相依的remoteControllable執行
		String state = remoteControllable.down();
		// set text area to show current state
		this.textArea.setText(state);
	}

	/**
	 * Deal with action event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == "powerOn") {
			this.on();
		} else if (event.getActionCommand() == "powerOff") {
			this.off();	
		} else if (event.getActionCommand() == "increase") {
			this.up();
		} else if (event.getActionCommand() == "decrease") {
			this.down();
		}
	}
}
