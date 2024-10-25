package dsImpl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class cqueue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField size;
	private JTextField element;
	private JTextField output;
	private int[] arr;
	private int front, rear;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cqueue frame = new cqueue();
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
	public cqueue() {
		
		front = rear = -1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 601);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(236, 201, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Circular Queue Implementation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(285, 47, 313, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterSize = new JLabel("Enter size");
		lblEnterSize.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterSize.setBounds(63, 138, 118, 50);
		contentPane.add(lblEnterSize);
		
		JLabel lblEnterElement = new JLabel("Enter element");
		lblEnterElement.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterElement.setBounds(63, 235, 156, 50);
		contentPane.add(lblEnterElement);
		
		size = new JTextField();
		size.setFont(new Font("Tahoma", Font.PLAIN, 18));
		size.setBounds(255, 138, 173, 50);
		contentPane.add(size);
		size.setColumns(10);
		
		element = new JTextField();
		element.setFont(new Font("Tahoma", Font.PLAIN, 18));
		element.setEditable(false);
		element.setColumns(10);
		element.setBounds(255, 235, 173, 50);
		contentPane.add(element);
		
		output = new JTextField();
		output.setFont(new Font("Tahoma", Font.BOLD, 18));
		output.setColumns(10);
		output.setBounds(255, 352, 393, 50);
		contentPane.add(output);
		
		JButton btnNewButton = new JButton("Add size");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sz = Integer.parseInt(size.getText());
				arr = new int[sz];
				output.setText("Circular queue of size " + sz + " is created");
				size.setEditable(false);
				element.setEditable(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(513, 133, 135, 55);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				size.setText("");
				size.setEditable(true);
				element.setText("");
				element.setEditable(false);
				output.setText("");
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(513, 233, 135, 55);
		contentPane.add(btnReset);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ele = Integer.parseInt(element.getText());
				insert(ele);
				element.setText("");
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsert.setBounds(255, 440, 135, 55);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(426, 440, 135, 55);
		contentPane.add(btnDelete);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display();
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplay.setBounds(596, 440, 135, 55);
		contentPane.add(btnDisplay);
	}
	
	public void insert(int element) {
		int sz = Integer.parseInt(size.getText());
		if ((rear + 1) % sz == front) {
			output.setText("Circular Queue is full");
		} else {
			if (front == -1)
				front = 0;
			rear = (rear + 1) % sz;
			arr[rear] = element;
			output.setText("Element " + element + " inserted into circular queue");
		}
	}
	
	public void delete() {
		int sz = Integer.parseInt(size.getText());
		if (front == -1) {
			output.setText("Circular Queue is empty");
		} else {
			if (front == rear) {
				output.setText("Element " + arr[front] + " deleted from circular queue");
				front = rear = -1;
			} else {
				output.setText("Element " + arr[front] + " deleted from circular queue");
				front = (front + 1) % sz;
			}
		}
	}
	
	public void display() {
		int sz = Integer.parseInt(size.getText());	
		if (front == -1) {
			output.setText("Circular Queue is empty");
		} else {
			String res = "";
			int i = front;
			while (i != rear) {
				res += arr[i] + " ";
				i = (i + 1) % sz;
			}
			res += arr[rear];
			output.setText(res);
		}
	}
}
