package view.aula10.exercicio2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.exercicio1.TelefoneController;
import model.vo.exercicio1.Telefone;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaInternaListaTelefones extends JInternalFrame {
	private JTextField txtCodPais;
	private JTextField txtDdd;
	private JTextField txtNum;
	private JTable table;
	private String[] nomeColunas = { "Cod.País", "DDD", "Número", "Móvel" };
	private ArrayList<Telefone> telefones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInternaListaTelefones frame = new TelaInternaListaTelefones();
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
	public TelaInternaListaTelefones() {
		setClosable(true);
		setTitle("Lista de Telefones");
		setBounds(100, 100, 800, 348);
		getContentPane().setLayout(null);

		JLabel lblCodPais = new JLabel("Código do País: ");
		lblCodPais.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCodPais.setBounds(21, 55, 101, 14);
		getContentPane().add(lblCodPais);

		txtCodPais = new JTextField();
		txtCodPais.setBounds(21, 70, 86, 20);
		getContentPane().add(txtCodPais);
		txtCodPais.setColumns(10);

		JLabel lblDdd = new JLabel("DDD:");
		lblDdd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDdd.setBounds(21, 100, 46, 14);
		getContentPane().add(lblDdd);

		txtDdd = new JTextField();
		txtDdd.setBounds(21, 115, 86, 20);
		getContentPane().add(txtDdd);
		txtDdd.setColumns(10);

		JLabel lblNewLabel = new JLabel("Número:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(21, 145, 86, 14);
		getContentPane().add(lblNewLabel);

		txtNum = new JTextField();
		txtNum.setBounds(21, 160, 86, 20);
		getContentPane().add(txtNum);
		txtNum.setColumns(10);

		JButton btBuscar = new JButton("Buscar");
		btBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController controle = new TelefoneController();
				telefones = controle.listarTodos();
				limparTela();
				atualizarTela();
			}
		});
		btBuscar.setBounds(21, 11, 89, 23);
		getContentPane().add(btBuscar);

		table = new JTable();
		table.setBounds(132, 33, 642, 274);
		getContentPane().add(table);

	}
	
	private void limparTela() {
		table.setModel(new DefaultTableModel(new Object[][] { nomeColunas, }, nomeColunas));

	}

	private void atualizarTela() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (Telefone t : telefones) {

			Object[] linhaTabela = new Object[5];
			linhaTabela[0] = t.getCodigoPais();
			linhaTabela[1] = t.getDdd();
			linhaTabela[2] = t.getNumero();
			linhaTabela[3] = t.isMovel();
			linhaTabela[4] = t.isAtivo();

			model.addRow(linhaTabela);

		}

	}
}
