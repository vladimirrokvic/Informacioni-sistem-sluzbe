package rs.ac.uns;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import rs.ac.uns.profesor.view.AbstractTableModelProfesori;
import rs.ac.uns.profesor.view.ProfesoriJTable;
import rs.ac.uns.student.view.AbstractTableModelStudent;
import rs.ac.uns.student.view.StudentJTable;

public class MainFrame extends JFrame{
	
	private JTable tabelaProfesora;
	private JTable tabelaStudent;
	public static JTabbedPaneMine tabbedPane;
	private static MainFrame instance = null;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	public MainFrame() {
		super();
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		setSize(3*dim.width/4,3*dim.height/4);
		setTitle("Studentska Služba");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		
	
		JPanel panel3=new JPanel();
		JLabel labela3=new JLabel("TODO: Prikaz entiteta sistema");
		panel3.add(labela3);
		
		MyMenuBar myMenu = new MyMenuBar(this);
		this.setJMenuBar(myMenu);
		StatusBar sBar = new StatusBar();
		this.add(sBar, BorderLayout.SOUTH);
		MyToolbar toolbar=new MyToolbar(this);
		this.add(toolbar,BorderLayout.NORTH);
		
		
		tabelaProfesora = new ProfesoriJTable();
		JScrollPane scrollPane = new JScrollPane(tabelaProfesora);
		tabelaStudent = new StudentJTable();
		JScrollPane scrollPane2 = new JScrollPane(tabelaStudent);
		
		
		
		tabbedPane=new JTabbedPaneMine();
		tabbedPane.addTab("Studenti", scrollPane2);
		this.azurirajPrikazStudenta(null, -1);
		tabbedPane.addTab("Profesori", scrollPane);
		this.azurirajPrikazProfesora(null, -1);
		tabbedPane.addTab("Predmeti", panel3);
		this.add(tabbedPane,BorderLayout.CENTER);
		
		validate();
	}
	
	public void azurirajPrikazProfesora(String akcija, int vrednost) {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) tabelaProfesora.getModel();
		model.fireTableDataChanged();
		validate();
	}
	public void azurirajPrikazStudenta(String akcija, int vrednost) {
		AbstractTableModelStudent model = (AbstractTableModelStudent) tabelaStudent.getModel();
		model.fireTableDataChanged();
		validate();
	}
}
