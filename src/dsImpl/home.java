package dsImpl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnArray = new JButton("Array");
		btnArray.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame arrayFrame = new array();
				arrayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				arrayFrame.setSize(new queue().getSize());
				arrayFrame.setVisible(true);
			}
		});
		btnArray.setBounds(97, 189, 185, 68);
		contentPane.add(btnArray);
		
		JButton btnStack = new JButton("Stack");
		btnStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame stackFrame = new stack();
				stackFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				stackFrame.setSize(new queue().getSize());
				stackFrame.setVisible(true);
			}
		});
		btnStack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnStack.setBounds(329, 191, 185, 65);
		contentPane.add(btnStack);
		
		JButton btnQueue = new JButton("Queue");
		btnQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame qFrame = new queue();
				qFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				qFrame.setVisible(true);
			}
		});
		btnQueue.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnQueue.setBounds(97, 300, 185, 65);
		contentPane.add(btnQueue);
		
		JButton btnCircularQ = new JButton("Circular Queue");
		btnCircularQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame cqFrame = new cqueue();
				cqFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				cqFrame.setVisible(true);
			}
		});
		btnCircularQ.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCircularQ.setBounds(196, 411, 242, 68);
		contentPane.add(btnCircularQ);
		
		JButton btnLinkedList = new JButton("LinkedList");
		btnLinkedList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame llFrame = new linkedlist();
				llFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				llFrame.setSize(new queue().getSize());
				llFrame.setVisible(true);
			}
		});
		btnLinkedList.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLinkedList.setBounds(329, 298, 185, 68);
		contentPane.add(btnLinkedList);
		
		JLabel lblNewLabel = new JLabel("Choose Data Structure");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(97, 74, 372, 65);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Java\\dsImpl\\img\\premium_photo-1678565869434-c81195861939.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 986, 631);
		contentPane.add(lblNewLabel_1);
	}
}
