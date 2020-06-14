import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class Main extends JFrame {
	

	private JPanel contentPane;
	
	private Fraccion fraccion1 = new Fraccion(), fraccion2 = new Fraccion();
	private Racional manejoRacional = new Racional();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumerador = new JLabel("Fraccion");
		lblNumerador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumerador.setBounds(266, 147, 86, 56);
		contentPane.add(lblNumerador);
		
		JLabel lblDenominador = new JLabel("Flotante");
		lblDenominador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDenominador.setBounds(266, 213, 86, 32);
		contentPane.add(lblDenominador);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl1.setBounds(213, 35, 107, 52);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl2.setBounds(343, 35, 116, 52);
		contentPane.add(lbl2);
		
		JButton btnNewButton = new JButton("Cargar Datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String archivo1 = leer("archivo1.txt");
				String[] arr = archivo1.split("/");
				fraccion1 = new Fraccion(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
				
				String archivo2 = leer("archivo2.txt");
				String[] arr2 = archivo2.split("/");
				fraccion2 = new Fraccion(Integer.parseInt(arr2[0]), Integer.parseInt(arr2[1]));
				
				lbl1.setText(fraccion1.toString());
				lbl2.setText(fraccion2.toString());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(217, 281, 116, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblfraccion = new JLabel("");
		lblfraccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblfraccion.setBounds(362, 147, 73, 44);
		contentPane.add(lblfraccion);
		
		JLabel lblflotante = new JLabel("");
		lblflotante.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblflotante.setBounds(362, 202, 73, 36);
		contentPane.add(lblflotante);
		
		
		JButton btnNewButton_1 = new JButton("Sumar");
		btnNewButton_1.setBackground(new Color(95, 158, 160));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fraccion resultado = manejoRacional.sumar(fraccion1, fraccion2);
				lblfraccion.setText(resultado.toString());
				lblflotante.setText(resultado.obtenerFlotante(2));
			}
		});
		btnNewButton_1.setBounds(27, 48, 107, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnRestar = new JButton("Restar");
		btnRestar.setBackground(new Color(95, 158, 160));
		btnRestar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fraccion resultado = manejoRacional.restar(fraccion1, fraccion2);
				lblfraccion.setText(resultado.toString());
				lblflotante.setText(resultado.obtenerFlotante(3));
			}
		});
		btnRestar.setBounds(27, 111, 107, 39);
		contentPane.add(btnRestar);
		
		JButton btnMultiplicar = new JButton("Multiplicar");
		btnMultiplicar.setBackground(new Color(95, 158, 160));
		btnMultiplicar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fraccion resultado = manejoRacional.multiplicar(fraccion1, fraccion2);
				lblfraccion.setText(resultado.toString());
				lblflotante.setText(resultado.obtenerFlotante(4));
			}
		});
		btnMultiplicar.setBounds(27, 174, 107, 39);
		contentPane.add(btnMultiplicar);
		
		JButton btnDividir = new JButton("Dividir");
		btnDividir.setBackground(new Color(95, 158, 160));
		btnDividir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fraccion resultado = manejoRacional.dividir(fraccion1, fraccion2);
				lblfraccion.setText(resultado.toString());
				lblflotante.setText(resultado.obtenerFlotante(3));
			}
		});
		btnDividir.setBounds(27, 233, 107, 39);
		contentPane.add(btnDividir);
		
	}
	
	public static String leer(String nombre) {
		  File archivo=null;
		  FileReader fr=null;
		  BufferedReader br=null;
		  String cadena ="";
		  try {
			  archivo=new File(nombre);
			  fr=new FileReader (archivo);
			  br=new BufferedReader (fr);
			  String linea;
			  while ((linea= br.readLine()) !=null) {
				cadena+=linea;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null !=fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		  return cadena;
	}
}
