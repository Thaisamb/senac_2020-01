package view.exercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.exercicio1.ClienteController;
import controller.exercicio1.EnderecoController;
import controller.exercicio1.TelefoneController;
import model.vo.exercicio1.Cliente;
import model.vo.exercicio1.Endereco;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaCadastroTelefone {

	private JFrame frmCadastroDeTelefone;
	private JTextField txtCodigoPais;
	private JTextField txtNumTel;
	private JTextField txtDdd;
	private JRadioButton rdbMovel;
	private JComboBox<Cliente> cboxClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTelefone window = new TelaCadastroTelefone();
					window.frmCadastroDeTelefone.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroTelefone() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeTelefone = new JFrame();
		frmCadastroDeTelefone.setTitle("Cadastro de Telefone");
		frmCadastroDeTelefone.setBounds(100, 100, 380, 200);
		frmCadastroDeTelefone.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmCadastroDeTelefone.getContentPane().setLayout(null);

		JLabel lblCodigoPais = new JLabel("C\u00F3d. do  Pa\u00EDs*:");
		lblCodigoPais.setBounds(10, 11, 89, 14);
		frmCadastroDeTelefone.getContentPane().add(lblCodigoPais);

		txtCodigoPais = new JTextField();
		txtCodigoPais.setBounds(100, 8, 40, 20);
		frmCadastroDeTelefone.getContentPane().add(txtCodigoPais);
		txtCodigoPais.setColumns(10);

		JLabel lblNumTel = new JLabel("N\u00BA do Telefone*:");
		lblNumTel.setBounds(151, 53, 100, 14);
		frmCadastroDeTelefone.getContentPane().add(lblNumTel);

		txtNumTel = new JTextField();
		txtNumTel.setBounds(261, 50, 70, 20);
		frmCadastroDeTelefone.getContentPane().add(txtNumTel);
		txtNumTel.setColumns(10);

		JLabel lblDdd = new JLabel("DDD*:");
		lblDdd.setBounds(10, 50, 46, 14);
		frmCadastroDeTelefone.getContentPane().add(lblDdd);

		txtDdd = new JTextField();
		txtDdd.setBounds(100, 50, 40, 20);
		frmCadastroDeTelefone.getContentPane().add(txtDdd);
		txtDdd.setColumns(10);

		final JRadioButton rdbMovel = new JRadioButton("   Telefone m\u00F3vel");
		rdbMovel.setBounds(211, 7, 120, 23);
		frmCadastroDeTelefone.getContentPane().add(rdbMovel);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 82, 46, 14);
		frmCadastroDeTelefone.getContentPane().add(lblCliente);
		
		ClienteController controleCliente = new ClienteController();
		ArrayList<Cliente>listaClientes =controleCliente.listarTodosOsClientes();
		final JComboBox<Cliente> cboxClientes = new JComboBox<Cliente>();
		DefaultComboBoxModel model = new DefaultComboBoxModel(listaClientes.toArray());
		cboxClientes.setModel(model);
		cboxClientes.setBounds(90, 78, 241, 22);
		frmCadastroDeTelefone.getContentPane().add(cboxClientes);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController controle = new TelefoneController();

				String mensagem = controle.salvar((Cliente) cboxClientes.getSelectedItem(), txtCodigoPais.getText(),
						txtDdd.getText(), txtNumTel.getText(), rdbMovel.isEnabled());
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		btnSalvar.setBounds(137, 127, 89, 23);
		frmCadastroDeTelefone.getContentPane().add(btnSalvar);
	}

}
