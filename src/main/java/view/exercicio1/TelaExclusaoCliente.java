package view.exercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;

import controller.exercicio1.ClienteController;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TelaExclusaoCliente {

	private JFrame frmExclusoDeCliente;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExclusaoCliente window = new TelaExclusaoCliente();
					window.frmExclusoDeCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaExclusaoCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExclusoDeCliente = new JFrame();
		frmExclusoDeCliente.setTitle("Exclus\u00E3o de Cliente Pelo CPF");
		frmExclusoDeCliente.setBounds(100, 100, 300, 150);
		frmExclusoDeCliente.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmExclusoDeCliente.getContentPane().setLayout(null);
		
		JLabel lblCpf = new JLabel("Digite o CPF do Cliente:");
		lblCpf.setBounds(20, 22, 138, 14);
		frmExclusoDeCliente.getContentPane().add(lblCpf);
		
		MaskFormatter maskCpf;
		try {
			maskCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(maskCpf);
			txtCpf.setBounds(158, 19, 104, 20);
			frmExclusoDeCliente.getContentPane().add(txtCpf);
			txtCpf.setColumns(10);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController controle = new ClienteController();
				String mensagem = controle.excluirPorCpf(txtCpf.getText());
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		btnExcluir.setBounds(100, 60, 89, 23);
		frmExclusoDeCliente.getContentPane().add(btnExcluir);
	}
}
