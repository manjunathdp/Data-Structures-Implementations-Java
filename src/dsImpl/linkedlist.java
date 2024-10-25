package dsImpl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class linkedlist extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField element;
	private JTextField output;
	private LinkedList<Integer> linkedlist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					linkedlist frame = new linkedlist();
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
	public linkedlist() {
		linkedlist = new LinkedList<Integer>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 227, 227));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LinkedList Implmentation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(267, 53, 358, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterElement = new JLabel("Enter element");
		lblEnterElement.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterElement.setBounds(71, 143, 145, 39);
		contentPane.add(lblEnterElement);
		
		element = new JTextField();
		element.setFont(new Font("Tahoma", Font.PLAIN, 18));
		element.setBounds(267, 146, 205, 39);
		contentPane.add(element);
		element.setColumns(10);
		
		JButton btnNewButton = new JButton("Insert First");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ele = Integer.parseInt(element.getText());
				insertAtFront(ele);
				element.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(267, 229, 152, 48);
		contentPane.add(btnNewButton);
		
		JButton btnInsertLast = new JButton("Insert Last");
		btnInsertLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ele = Integer.parseInt(element.getText());
				insertAtLast(ele);
			}
		});
		btnInsertLast.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsertLast.setBounds(473, 229, 152, 48);
		contentPane.add(btnInsertLast);
		
		JButton btnDeleteFirst = new JButton("Delete First");
		btnDeleteFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteFront();
			}
		});
		btnDeleteFirst.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeleteFirst.setBounds(267, 304, 152, 48);
		contentPane.add(btnDeleteFirst);
		
		JButton btnDeleteLast = new JButton("Delete Last");
		btnDeleteLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteLast();
			}
		});
		btnDeleteLast.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeleteLast.setBounds(473, 304, 152, 48);
		contentPane.add(btnDeleteLast);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display();
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplay.setBounds(377, 377, 152, 48);
		contentPane.add(btnDisplay);
		
		output = new JTextField();
		output.setFont(new Font("Tahoma", Font.BOLD, 18));
		output.setEditable(false);
		output.setColumns(10);
		output.setBounds(267, 456, 358, 39);
		contentPane.add(output);
	}
	
	public void insertAtFront(int data) {
		linkedlist.addFirst(data);
		output.setText("Element " + data + " inserted at front");
	}
	
	public void insertAtLast(int data) {
		linkedlist.addLast(data);
		output.setText("Element " + data + " inserted at last");
	}
	
	public void deleteFront() {
		if (linkedlist.isEmpty()) {
			output.setText("Linked List is empty");
		} else {
			int element = linkedlist.removeFirst();
			output.setText("Element " + element + " deleted from linked list");
		}
	}
	
	public void deleteLast() {
		if (linkedlist.isEmpty()) {
			output.setText("Linked List is empty");
		} else {
			int element = linkedlist.removeLast();
			output.setText("Element " + element + " deleted from linked list");
		}
	}
	
	public void display() {
		if (linkedlist.isEmpty()) {
			output.setText("Linked List is empty");
		} else {
			String res = "";
			int sz = linkedlist.size();
			for (int i = 0; i < sz; i++) {
				res += linkedlist.get(i) + " => ";
			}
			res += "null";
			output.setText(res);
		}
	}
}
