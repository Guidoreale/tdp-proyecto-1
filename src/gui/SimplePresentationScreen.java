package gui;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel lblLu;
	private JLabel lblSurname;
	private JLabel lblName;
	private JLabel lblCorreo;
	private JLabel lblGithub;
	private JTextField legajo;
	private JTextField apellido;
	private JTextField nombre;
	private JTextField mail;
	private JTextField txtUrl;
	private JLabel foto;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2022 :: Pantalla de presentaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane.setBounds(5, 5, 430, 182);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		lblLu = new JLabel("LU");
		lblLu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLu.setBounds(10, 11, 73, 20);
		tabInformation.add(lblLu);
		
		lblSurname = new JLabel("Apellido");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSurname.setBounds(10, 41, 73, 20);
		tabInformation.add(lblSurname);
		
		lblName = new JLabel("Nombre");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(10, 71, 73, 20);
		tabInformation.add(lblName);
		
		lblCorreo = new JLabel("E-mail");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCorreo.setBounds(10, 101, 73, 20);
		tabInformation.add(lblCorreo);
		
		lblGithub = new JLabel("Github URL");
		lblGithub.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGithub.setBounds(10, 131, 73, 20);
		tabInformation.add(lblGithub);
		
		legajo = new JTextField();
		legajo.setBounds(93, 11, 322, 20);
		legajo.setEditable(false);
		legajo.setText(Integer.toString(studentData.getId()));
		tabInformation.add(legajo);
		legajo.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(93, 41, 322, 20);
		apellido.setEditable(false);
		apellido.setText(studentData.getLastName());
		tabInformation.add(apellido);
		apellido.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(93, 71, 322, 20);
		nombre.setEditable(false);
		nombre.setText(studentData.getFirstName());
		tabInformation.add(nombre);
		nombre.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(93, 101, 322, 20);
		mail.setEditable(false);
		mail.setText(studentData.getMail());
		tabInformation.add(mail);
		mail.setColumns(10);
		
		txtUrl = new JTextField();
		txtUrl.setBounds(93, 131, 322, 20);
		txtUrl.setEditable(false);
		txtUrl.setText(studentData.getGithubURL());
		tabInformation.add(txtUrl);
		txtUrl.setColumns(10);
		contentPane.add(tabbedPane);
		
		foto = new JLabel("");
		foto.setBounds(445, 25, 131, 162);
		ImageIcon img = new ImageIcon(this.getClass().getResource(studentData.getPathPhoto()));
		
		int ancho = foto.getWidth();
		
		int alto = foto.getHeight();
		
		ImageIcon perfil = new ImageIcon(img.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		
		foto.setIcon(perfil);
		contentPane.add(foto);
		
		
		//seteo de la fecha.
		Calendar fecha = new GregorianCalendar();
		String anio = Integer.toString(fecha.get(Calendar.YEAR));
		int mesTemporal = fecha.get(Calendar.MONTH) + 1;
		String dia = Integer.toString(fecha.get(Calendar.DATE));
		String mes = Integer.toString(mesTemporal);
		
		String hora = Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
		String minutos = Integer.toString(fecha.get(Calendar.MINUTE));
		String segundos = Integer.toString(fecha.get(Calendar.SECOND));


		JLabel tiempo = new JLabel("Esta ventana fue generada el "+dia+"/"+mes+"/"+anio+" a las: "+hora+":"+minutos+":"+segundos);
		tiempo.setFont(new Font("Tahoma", Font.BOLD, 11));
		tiempo.setForeground(Color.BLACK);
		tiempo.setBounds(5, 184, 430, 27);
		contentPane.add(tiempo);
	}
}
