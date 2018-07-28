package v;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import m.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.GridLayout;
import javax.swing.JTextField;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;

public class JFCalculator extends JFrame{

	private JPanel JPnumbers = new JPanel();
	private Client client;
	private final JButton btnEqual = new JButton("+");
	private final JButton btnSubtract = new JButton("-");
	private final JButton btnDivide = new JButton("/");
	private final JButton btnMultiply = new JButton("x");
	private final JTextField tfX = new JTextField();
	private final JTextField tfY = new JTextField();
	private final JTextField tfResult = new JTextField();
	private final JLabel lblNmeroA = new JLabel("N\u00FAmero A");
	private final JLabel lblNmeroB = new JLabel("N\u00FAmero B");
	private final JLabel lblResultado = new JLabel("Resultado");
	
	public JFCalculator() {
		tfX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key = e.getKeyChar();
				if((key < '0' || key > '9') || (key >= 'A' && key <= 'Z')) {
					e.consume();
				}
			}
		});
		
		tfX.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tfX.setBounds(22, 33, 141, 112);
		tfX.setColumns(10);
		
			try {
				client = new Client();
			} catch (RemoteException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "SERVIDOR NO ENCONTRADO, INICIE EL SERVIDOR",JOptionPane.ERROR_MESSAGE);
				System.exit(ABORT);
			} catch (NotBoundException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "SE HA PERDIDO LA CONEXIÓN",JOptionPane.ERROR_MESSAGE);
				System.exit(ABORT);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "HA OCURRIDO UN ERROR.",JOptionPane.ERROR_MESSAGE);
				System.exit(ABORT);
			}
			
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(591, 351);
		getContentPane().setLayout(null);
		btnEqual.setFont(new Font("Tahoma", Font.PLAIN, 26));
	
		btnEqual.setBounds(355, 124, 97, 112);
		getContentPane().add(btnEqual);
		btnSubtract.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnSubtract.setBounds(464, 13, 97, 98);
		
		getContentPane().add(btnSubtract);
		btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnDivide.setBounds(355, 13, 97, 98);
		
		getContentPane().add(btnDivide);
		btnMultiply.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnMultiply.setBounds(464, 124, 97, 112);
		
		getContentPane().add(btnMultiply);
		
		getContentPane().add(tfX);
		tfY.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tfY.setColumns(10);
		tfY.setBounds(180, 33, 141, 112);
		
		getContentPane().add(tfY);
		
		setVisible(true);
		
		//createButtons();
		eventOperations(btnDivide);
		eventOperations(btnEqual);
		eventOperations(btnMultiply);
		eventOperations(btnSubtract);
		tfResult.setEditable(false);
		tfResult.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tfResult.setColumns(10);
		tfResult.setBounds(111, 179, 141, 112);
		
		getContentPane().add(tfResult);
		lblNmeroA.setBounds(22, 13, 97, 16);
		
		getContentPane().add(lblNmeroA);
		lblNmeroB.setBounds(195, 13, 97, 16);
		
		getContentPane().add(lblNmeroB);
		lblResultado.setBounds(155, 158, 97, 16);
		
		getContentPane().add(lblResultado);
				
	}

	
	private void eventOperations(JButton button) {
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String txt = button.getText();

				int x = Integer.parseInt(tfX.getText());
				int y = Integer.parseInt(tfY.getText());
				switch (txt) {
				case "+":
					try {
						String result = String.valueOf(client.getCalculator().equal(x, y));
						tfResult.setText(result);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
					
				case "-":
					try {
						String result = String.valueOf(client.getCalculator().sustract(x, y));
						tfResult.setText(result);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "x":
					try {
						String result = String.valueOf(client.getCalculator().multiply(x, y));
						tfResult.setText(result);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "/":
					try {
						String result = String.valueOf(client.getCalculator().divide(x, y));
						tfResult.setText(result);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;					
				default:
					break;
				}
			}
		});
	}

	/*private JButton newButton(String number) {
		JButton btn = new JButton(number);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtA.getText().length()==0) {
					txtA.setText(btn.getText());
				}else {
					txtA.setText(txtA.getText() + btn.getText());
				}
			}
		});
		 btn;
	}*/
	
	/* void createButtons() {
		for(int i=0 ; i < 10 ; i++) {
			JPnumbers.add(newButton(String.valueOf(i)));
		}
		JPnumbers.add(newButton("."));
		eventOperations(btnEqual);
		eventOperations(btnEquality);
		eventOperations(btnSubtract);
		eventOperations(btnMultiply);
		eventOperations(btnDivide);
		JPnumbers.updateUI();
	}*/
	
	/*private void operation(int x, String symbol) {
		try {
			client.getCalculator().equal(x);
			tfDigits.setText(tfDigits.getText() + String.valueOf(x) + symbol);
			txtA.setText(null);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	/*private void eventOperations(JButton btnEquality) {
		
		btnEquality.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String txt = btnEquality.getText();
				
				int x = Integer.parseInt(txtA.getText());
				switch (txt) {
				case "+":
					operation(x, "+");
					try {
						System.out.println(client.getCalculator().equal(x));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "-":
					operation(x, "-");
					break;
				case "x":
					operation(x, "x");
					break;
				case "/":
					operation(x, "/");
					break;
				case "=":
					try {
						txtA.setText(null);
						tfDigits.setText(null);
						client.getCalculator().equality();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				default:
					break;
				}
			}
		});
	}*/
}
