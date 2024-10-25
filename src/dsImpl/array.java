package dsImpl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class array extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField output;
	private JTextField size;
	private JTextField element;
	private JTextField index;
	private int[] arr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					array frame = new array();
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
	public array() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 241, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Array");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(330, 42, 146, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Size");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(82, 138, 113, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Element");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(82, 191, 152, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter Index");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(464, 191, 113, 29);
		contentPane.add(lblNewLabel_1_2);
		
		JButton insert = new JButton("Insert");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						
				
				int ele = Integer.parseInt(element.getText());
				int idx = Integer.parseInt(index.getText());
				
				if (idx < arr.length && idx >= 0) {
					output.setText("Element inserted at index " + idx);
					arr[idx] = ele;
					element.setText("");
					index.setText("");
				} else {
					output.setText("Invalid Index");
				}
			}
		});
		insert.setFont(new Font("Tahoma", Font.BOLD, 18));
		insert.setBounds(82, 259, 146, 29);
		contentPane.add(insert);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idx = Integer.parseInt(index.getText());
				
				if (idx < arr.length && idx >= 0) {
					if (arr[idx] == 0) {
						output.setText("No value found at the index");
					} 
					else {
						output.setText("Element " + arr[idx] + " deleted");
						arr[idx] = 0;
					}
				} else {
					output.setText("Invalid Index");
				}
			}
		});
		delete.setFont(new Font("Tahoma", Font.BOLD, 18));
		delete.setBounds(276, 259, 146, 29);
		contentPane.add(delete);
		
		JButton display = new JButton("Display");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText(Arrays.toString(arr));
			}
		});
		display.setFont(new Font("Tahoma", Font.BOLD, 18));
		display.setBounds(470, 259, 146, 29);
		contentPane.add(display);
		
		output = new JTextField();
		output.setEditable(false);
		output.setFont(new Font("Tahoma", Font.BOLD, 18));
		output.setBounds(252, 337, 325, 29);
		contentPane.add(output);
		output.setColumns(10);
		
		size = new JTextField();
		size.setFont(new Font("Tahoma", Font.BOLD, 18));
		size.setColumns(10);
		size.setBounds(225, 138, 91, 29);
		contentPane.add(size);
		
		element = new JTextField();
		element.setEditable(false);
		element.setFont(new Font("Tahoma", Font.BOLD, 18));
		element.setColumns(10);
		element.setBounds(225, 191, 91, 29);
		contentPane.add(element);
		
		index = new JTextField();
		index.setEditable(false);
		index.setFont(new Font("Tahoma", Font.BOLD, 18));
		index.setColumns(10);
		index.setBounds(587, 191, 91, 29);
		contentPane.add(index);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblOutput.setBounds(153, 333, 81, 37);
		contentPane.add(lblOutput);
		
		JButton addSize = new JButton("Add Size");
		addSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sz = Integer.parseInt(size.getText());
				arr = new int[sz];
				output.setText("Array of size " + sz + " created");
				element.setEditable(true);
				index.setEditable(true);
				size.setEditable(false);
			}
		});
		addSize.setFont(new Font("Tahoma", Font.BOLD, 18));
		addSize.setBounds(365, 138, 146, 29);
		contentPane.add(addSize);
	}
}
