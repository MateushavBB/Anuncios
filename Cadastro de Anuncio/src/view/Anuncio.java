package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.AnuncioDao;
import model.AnuncioModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Anuncio {

	private JFrame frame;
	private JTextField Nome_anuncio;
	private JTextField Cliente;
	private JTextField Data_inicio;
	private JTextField data_fim;
	private JTextField custo_diário;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anuncio window = new Anuncio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public Anuncio() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.GRAY);
		frame.setForeground(Color.BLUE);
		frame.setBounds(100, 100, 860, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		Nome_anuncio = new JTextField();
		Nome_anuncio.setBounds(122, 11, 121, 20);
		frame.getContentPane().add(Nome_anuncio);
		Nome_anuncio.setColumns(10);
		
		Cliente = new JTextField();
		Cliente.setBounds(122, 42, 121, 20);
		frame.getContentPane().add(Cliente);
		Cliente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome do an\u00FAncio");
		lblNewLabel.setBounds(10, 14, 102, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente");
		lblNewLabel_1.setBounds(10, 45, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		Data_inicio = new JTextField();
		Data_inicio.setBounds(405, 11, 86, 20);
		frame.getContentPane().add(Data_inicio);
		Data_inicio.setColumns(10);
		
		data_fim = new JTextField();
		data_fim.setBounds(405, 42, 86, 20);
		frame.getContentPane().add(data_fim);
		data_fim.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data In\u00EDcio");
		lblNewLabel_2.setBounds(338, 14, 79, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data Fim");
		lblNewLabel_3.setBounds(338, 45, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		custo_diário = new JTextField();
		custo_diário.setBounds(722, 11, 86, 20);
		frame.getContentPane().add(custo_diário);
		custo_diário.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Valor Di\u00E1rio");
		lblNewLabel_4.setBounds(639, 14, 73, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton Search = new JButton("Pesquisar");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Search.setBounds(50, 405, 100, 25);
		frame.getContentPane().add(Search);
		
		JButton Create = new JButton("Salvar");
		Create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnuncioModel anuncioModel = new AnuncioModel();
				AnuncioDao  anuncioDao = new AnuncioDao();
				
				if(Nome_anuncio.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "É preciso preencher o campo nome do anuncio!");
				}
				else if(Cliente.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "É preciso preencher o campo cliente!");
				}	
				else if(data_fim.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "É preciso preencher o campo data final!");
				}
				else if(Data_inicio.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "É preciso preencher o campo data inicial!");
				}
				else if(custo_diário.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "É preciso preencher o campo custo diário!");
				}else {
					anuncioModel.setNomeDoAnuncio(Nome_anuncio.getText());
					anuncioModel.setCliente(Cliente.getText());
					anuncioModel.setDataTermino(data_fim.getText());
					anuncioModel.setDataInicio(Data_inicio.getText());
					anuncioModel.setInvestimento(Double.parseDouble((custo_diário.getText())));
					
					anuncioDao.create(anuncioModel);
				}
			
		Create.setBounds(355, 391, 150, 50);
		frame.getContentPane().add(Create);
			
		JButton Edit = new JButton("Editar");
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Edit.setBounds(710, 405, 100, 25);
		frame.getContentPane().add(Edit);
}
		
				
				