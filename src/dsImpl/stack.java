package dsImpl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class stack extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField stack;
	private JTextField element;
	private JTextField size;
	private int arr[];
	private int top = -1;
	
	public  void displayStack() {
		String s = "";
		for (int i = top; i >= 0; i--) {
			s += arr[i] + " ";
		}
		stack.setText(s);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stack frame = new stack();
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
	public stack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 235, 227));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stack implementation");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(57, 10, 410, 80);
		contentPane.add(lblNewLabel);
		
		JButton btnPop = new JButton("Pop()");
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				arr[top] = 0;
				
				if (top == -1) {
					stack.setText("Stack is empty");
				}
				else
				{
					top--;
					displayStack();
				}
					
			}
		});
		btnPop.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPop.setBounds(334, 356, 133, 38);
		contentPane.add(btnPop);
		
		JButton btnPush = new JButton("Push()");
		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ele = Integer.parseInt(element.getText());
				top++;
				if (top > arr.length - 1) {
					stack.setText("Stack is full, cannot insert element");
					top--;
				}
				else {
					
					arr[top] = ele;
					displayStack();
				}
				
				}
		});
		btnPush.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPush.setBounds(63, 356, 141, 38);
		contentPane.add(btnPush);
		
		stack = new JTextField();
		stack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		stack.setBounds(57, 270, 410, 38);
		contentPane.add(stack);
		stack.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Stack ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(57, 236, 122, 24);
		contentPane.add(lblNewLabel_1);
		
		element = new JTextField();
		element.setFont(new Font("Tahoma", Font.PLAIN, 18));
		element.setBounds(161, 160, 96, 28);
		contentPane.add(element);
		element.setColumns(10);
		
		size = new JTextField();
		size.setFont(new Font("Tahoma", Font.PLAIN, 18));
		size.setColumns(10);
		size.setBounds(161, 106, 96, 28);
		contentPane.add(size);
		
		JLabel lblNewLabel_1_1 = new JLabel("Size");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(57, 110, 84, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Element");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(57, 164, 84, 24);
		contentPane.add(lblNewLabel_1_2);
		
		JButton addsize = new JButton("Add Size");
		addsize.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addsize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sz = Integer.parseInt(size.getText());
				if (sz <= 0) {
					stack.setText("Enter valid size ");
					size.setText("");
				} else {
					arr = new int[sz];
					stack.setText("stack created of size " + sz);
				}
				size.setEditable(false);
			}
		});
		addsize.setBounds(340, 106, 127, 28);
		contentPane.add(addsize);
		
		JButton resetBtn = new JButton("Reset");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				top = -1;
				stack.setText("");
				size.setText("");
				element.setText("");
				size.setEditable(true);
			}
		});
		resetBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resetBtn.setBounds(340, 160, 127, 28);
		contentPane.add(resetBtn);
	}
}
