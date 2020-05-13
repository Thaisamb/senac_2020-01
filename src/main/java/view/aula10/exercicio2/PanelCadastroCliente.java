package view.aula10.exercicio2;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.exercicio1.ClienteController;
import controller.exercicio1.EnderecoController;
import model.vo.exercicio1.Endereco;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PanelCadastroCliente extends JPanel {
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCpf;
	private JComboBox cbEndereco;

	/**
	 * Create the panel.
	 */
	public PanelCadastroCliente() {
		setToolTipText("");
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("30px"),
				ColumnSpec.decode("100px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("30px"),
				RowSpec.decode("24px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(7dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(10dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNome = new JLabel("Nome (*):");
		add(lblNome, "2, 2, left, center");
		
		txtNome = new JTextField();
		add(txtNome, "4, 2, fill, default");
		txtNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome (*) :");
		add(lblSobrenome, "2, 4, left, default");
		
		txtSobrenome = new JTextField();
		add(txtSobrenome, "4, 4, fill, default");
		txtSobrenome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF (*) :");
		add(lblCpf, "2, 6, left, default");
		
		txtCpf = new JTextField();
		add(txtCpf, "4, 6, fill, default");
		txtCpf.setColumns(7);
		
		JLabel lblEndereco = new JLabel("Endereço (*) :");
		add(lblEndereco, "2, 8, left, default");
		
		EnderecoController endControl = new EnderecoController();
		ArrayList<Endereco> enderecos = endControl.consultarTodos();
		
		final JComboBox cbEndereco = new JComboBox(enderecos.toArray());
		cbEndereco.setSelectedIndex(-1);
		
		add(cbEndereco, "4, 8, fill, default");
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		add(btnLimpar, "2, 12, right, default");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController control = new ClienteController();
				control.salvar(txtNome.getText(), txtSobrenome.getText(), txtCpf.getText(),(Endereco)cbEndereco.getSelectedItem());
			}
		});
		add(btnSalvar, "4, 12, center, default");

	}
	
	private void limpar() {
		this.txtNome.setText("");
		this.txtSobrenome.setText("");
		this.txtCpf.setText("");
		this.cbEndereco.setSelectedIndex(-1);
		
	}

}
