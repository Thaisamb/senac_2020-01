package view.aula10.exercicio2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.exercicio1.ClienteController;
import controller.exercicio1.TelefoneController;
import controller.exercicio1.ClienteController;
import model.vo.exercicio1.Cliente;

public class TelaInternaCadastroTelefone extends JInternalFrame {
	
	private JTextField txtCodPais;
	private JTextField txtDdd;
	private JTextField txtNumero;
	private JComboBox cbCliente;
	private JRadioButton rdbtnMovel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInternaCadastroTelefone frame = new TelaInternaCadastroTelefone();
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
	public TelaInternaCadastroTelefone() {
		setClosable(true);
		setTitle("Cadastro Telefone");
		setBounds(100, 100, 450, 323);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(165dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblCodPais = new JLabel("Código país (*):");
		getContentPane().add(lblCodPais, "4, 4, left, default");
		
		txtCodPais = new JTextField();
		getContentPane().add(txtCodPais, "6, 4, fill, default");
		txtCodPais.setColumns(10);
		
		JLabel lblDdd = new JLabel("DDD (*) :");
		getContentPane().add(lblDdd, "4, 8, left, default");
		
		txtDdd = new JTextField();
		getContentPane().add(txtDdd, "6, 8, fill, default");
		txtDdd.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero (*) :");
		getContentPane().add(lblNumero, "4, 12, left, default");
		
		txtNumero = new JTextField();
		getContentPane().add(txtNumero, "6, 12, fill, default");
		txtNumero.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Dono (*) :");
		getContentPane().add(lblNewLabel_3, "4, 16, left, default");
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}

		});
		
		ClienteController clienteControl = new ClienteController();
		ArrayList<Cliente> clientes = clienteControl.listarTodosOsClientes();
		final JComboBox cbCliente = new JComboBox(clientes.toArray());
		cbCliente.setSelectedIndex(-1);
		getContentPane().add(cbCliente, "6, 16, fill, default");
		
		final JRadioButton rdbtnMovel = new JRadioButton("É um telefone móvel?");
		getContentPane().add(rdbtnMovel, "6, 18");
		getContentPane().add(btLimpar, "4, 20");
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController control = new TelefoneController();
				control.salvar((Cliente)cbCliente.getSelectedItem(), txtCodPais.getText(), txtDdd.getText(), txtNumero.getText(), rdbtnMovel.isSelected());
			}
		});
		getContentPane().add(btnNewButton, "6, 20, default, fill");

	}
	
	private void limpar() {
		this.txtCodPais.setText("");
		this.txtDdd.setText("");
		this.txtNumero.setText("");
		this.cbCliente.setSelectedIndex(-1);
		this.rdbtnMovel.setSelected(false);		
	}

}
