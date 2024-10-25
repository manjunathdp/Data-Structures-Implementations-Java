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

public class queue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sizeField;
	private JTextField elementField;
	private JTextField resultField;
	private int[] que;
	private int front = -1;
	private int rear = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					queue frame = new queue();
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
	public queue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 601);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 233, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Queue Implementation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(285, 47, 331, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterSize = new JLabel("Enter size");
		lblEnterSize.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterSize.setBounds(63, 138, 118, 50);
		contentPane.add(lblEnterSize);
		
		JLabel lblEnterElement = new JLabel("Enter element");
		lblEnterElement.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterElement.setBounds(63, 235, 156, 50);
		contentPane.add(lblEnterElement);
		
		sizeField = new JTextField();
		sizeField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sizeField.setBounds(255, 138, 173, 50);
		contentPane.add(sizeField);
		sizeField.setColumns(10);
		
		elementField = new JTextField();
		elementField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		elementField.setColumns(10);
		elementField.setBounds(255, 235, 173, 50);
		contentPane.add(elementField);
		
		resultField = new JTextField();
		resultField.setFont(new Font("Tahoma", Font.BOLD, 18));
		resultField.setColumns(10);
		resultField.setBounds(255, 352, 393, 50);
		contentPane.add(resultField);
		
		JButton btnSize = new JButton("Add size");
		btnSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size = Integer.parseInt(sizeField.getText());
				if (size <= 0) {
					resultField.setText("Enter valid string");
					sizeField.setText("");
				} else {
					que = new int[size];
					resultField.setText("Queue created of size " + size);
				}
				sizeField.setEditable(false);
			}
		});
		btnSize.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSize.setBounds(513, 133, 135, 55);
		contentPane.add(btnSize);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sizeField.setText("");
				elementField.setText("");
				resultField.setText("");
				sizeField.setEditable(true);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(513, 233, 135, 55);
		contentPane.add(btnReset);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int element = Integer.parseInt(elementField.getText());
				int size = Integer.parseInt(sizeField.getText());
				if (rear == size - 1) {
					resultField.setText("Queue is full and element can't be inserted");
				} else {
					rear++;
					que[rear] = element;
					resultField.setText("Element " + element + " is added to the queue");
				}
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsert.setBounds(255, 440, 135, 55);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size = Integer.parseInt(sizeField.getText());
				if ((front == -1 && rear == -1) || front == size - 1) {
					resultField.setText("Queue is empty and delete is not possible");
				} else {
					front++;
					resultField.setText("Element " + que[front] + " is deleted from the queue");
					que[front] = 0;
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(426, 440, 135, 55);
		contentPane.add(btnDelete);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size = Integer.parseInt(sizeField.getText());
				if ((front == -1 && rear == -1) || front == size - 1) {
					resultField.setText("Queue is empty and display is not possible");
				} else {
					String res = "";
					for (int i = front + 1; i <= rear; i++) {
						res += que[i] + " ";
					}
					resultField.setText(res);
				}
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplay.setBounds(596, 440, 135, 55);
		contentPane.add(btnDisplay);
	}

}
