package view.exercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;

import controller.exercicio1.ClienteController;
import controller.exercicio1.EnderecoController;
import model.vo.exercicio1.Endereco;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaCadastroCliente {

	private JFrame frmCadastroDeCliente;
	private JTextField txtNomeCliente;
	private JTextField txtSobrenome;
	private JTextField txtCpf;
	private JComboBox<Endereco> cboxEnderecos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente window = new TelaCadastroCliente();
					window.frmCadastroDeCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroCliente() {
		initialize();
	}

	private void initialize() {
		frmCadastroDeCliente = new JFrame();
		frmCadastroDeCliente.setTitle("Cadastro de Cliente ");
		frmCadastroDeCliente.setBounds(100, 100, 450, 200);
		frmCadastroDeCliente.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmCadastroDeCliente.getContentPane().setLayout(null);

		JLabel lblNomeCliente = new JLabel("Nome* :");
		lblNomeCliente.setBounds(10, 11, 46, 14);
		frmCadastroDeCliente.getContentPane().add(lblNomeCliente);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(96, 8, 168, 20);
		frmCadastroDeCliente.getContentPane().add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		JLabel lblSobreNome = new JLabel("Sobrenome *:");
		lblSobreNome.setBounds(10, 51, 80, 14);
		frmCadastroDeCliente.getContentPane().add(lblSobreNome);

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(96, 48, 168, 20);
		frmCadastroDeCliente.getContentPane().add(txtSobrenome);
		txtSobrenome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF*:");
		lblCpf.setBounds(271, 11, 31, 14);
		frmCadastroDeCliente.getContentPane().add(lblCpf);

		MaskFormatter maskCpf;
		try {
			maskCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(maskCpf);
			txtCpf.setBounds(312, 8, 104, 20);
			frmCadastroDeCliente.getContentPane().add(txtCpf);
			txtCpf.setColumns(10);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		JLabel lblEndereco = new JLabel("Endere\u00E7o*:");
		lblEndereco.setBounds(10, 88, 67, 14);
		frmCadastroDeCliente.getContentPane().add(lblEndereco);

		EnderecoController controleEnd = new EnderecoController();
		ArrayList<Endereco> listaEnderecos = controleEnd.consultarTodos();
		final JComboBox<Endereco> cboxEnderecos = new JComboBox<Endereco>();
		DefaultComboBoxModel model = new DefaultComboBoxModel(listaEnderecos.toArray());
		cboxEnderecos.setModel(model);
		cboxEnderecos.setBounds(78, 88, 346, 22);
		frmCadastroDeCliente.getContentPane().add(cboxEnderecos);

		JButton btnSalvar = new JButton("Salvar");
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController controle = new ClienteController();
				String mensagem = controle.salvar(txtNomeCliente.getText(), txtSobrenome.getText(), txtCpf.getText(),
						(Endereco) cboxEnderecos.getSelectedItem());
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		
		btnSalvar.setBounds(78, 127, 89, 23);
		frmCadastroDeCliente.getContentPane().add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}

		});
		btnLimpar.setBounds(256, 127, 89, 23);
		frmCadastroDeCliente.getContentPane().add(btnLimpar);
	}

	private void limparCampos() {

		this.txtNomeCliente.setText("");
		this.txtSobrenome.setText("");
		this.txtCpf.setText("");
		
		this.cboxEnderecos.setSelectedIndex(-1);

	}

}
