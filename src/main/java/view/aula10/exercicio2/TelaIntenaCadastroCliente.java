package view.aula10.exercicio2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.exercicio1.ClienteController;
import controller.exercicio1.EnderecoController;
import model.vo.exercicio1.Endereco;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaIntenaCadastroCliente extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCpf;
	private JComboBox cbEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaIntenaCadastroCliente frame = new TelaIntenaCadastroCliente();
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
	public TelaIntenaCadastroCliente() {
		setClosable(true);
		setTitle("Cadastro Cliente");
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
		
		JLabel lblNome = new JLabel("Nome (*):");
		getContentPane().add(lblNome, "4, 4, left, default");
		
		txtNome = new JTextField();
		getContentPane().add(txtNome, "6, 4, fill, default");
		txtNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome (*) :");
		getContentPane().add(lblSobrenome, "4, 8, left, default");
		
		txtSobrenome = new JTextField();
		getContentPane().add(txtSobrenome, "6, 8, fill, default");
		txtSobrenome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF (*) :");
		getContentPane().add(lblCpf, "4, 12, left, default");
		
		txtCpf = new JTextField();
		getContentPane().add(txtCpf, "6, 12, fill, default");
		txtCpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Endereço (*) :");
		getContentPane().add(lblNewLabel_3, "4, 16, left, default");
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}

		});
		
		EnderecoController endControl = new EnderecoController();
		ArrayList<Endereco> enderecos = endControl.consultarTodos();
		final JComboBox cbEndereco = new JComboBox(enderecos.toArray());
		cbEndereco.setSelectedIndex(-1);
		getContentPane().add(cbEndereco, "6, 16, fill, default");
		getContentPane().add(btLimpar, "4, 20");
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController control = new ClienteController();
				control.salvar(txtNome.getText(), txtSobrenome.getText(), txtCpf.getText(),(Endereco)cbEndereco.getSelectedItem());
			}
		});
		getContentPane().add(btnNewButton, "6, 20, default, fill");

	}
	private void limpar() {
		this.txtNome.setText("");
		this.txtSobrenome.setText("");
		this.txtCpf.setText("");
		this.cbEndereco.setSelectedIndex(-1);
		
	}

}
