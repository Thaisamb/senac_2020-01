package view.aula10.exercicio2;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.exercicio1.ClienteController;
import controller.exercicio1.TelefoneController;
import model.vo.exercicio1.Cliente;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCadastroTelefone extends JPanel {
	private JTextField txtCodPais;
	private JTextField txtDdd;
	private JTextField txtNum;
	

	/**
	 * Create the panel.
	 */
	public PanelCadastroTelefone() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblCodPais = new JLabel("Código País (*) :");
		add(lblCodPais, "4, 6, center, default");
		
		txtCodPais = new JTextField();
		add(txtCodPais, "8, 6, left, default");
		txtCodPais.setColumns(10);
		
		JLabel lblDdd = new JLabel(" DDD (*) :");
		add(lblDdd, "4, 8");
		
		txtDdd = new JTextField();
		add(txtDdd, "8, 8, left, default");
		txtDdd.setColumns(10);
		
		JLabel lblNumero = new JLabel("Número (*) :");
		add(lblNumero, "4, 10");
		
		txtNum = new JTextField();
		add(txtNum, "8, 10, left, default");
		txtNum.setColumns(10);
		
		final JRadioButton rdbtnMovel = new JRadioButton("Móvel");
		add(rdbtnMovel, "8, 12");
		
		JLabel lblDono = new JLabel("Dono :");
		add(lblDono, "4, 14");
		
		ClienteController controlCliente = new ClienteController();
		ArrayList<Cliente> clientes = controlCliente.listarTodosOsClientes();
		
		final JComboBox cbClientes = new JComboBox(clientes.toArray());
		cbClientes.setSelectedIndex(-1);
		add(cbClientes, "8, 14, fill, default");
		
		JButton btnLimpar = new JButton("Limpar");
		add(btnLimpar, "4, 18, default, fill");
		
		JButton btnSalvar = new JButton("Salvar\r\n");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController control = new TelefoneController();
				control.salvar((Cliente)cbClientes.getSelectedItem(), txtCodPais.getText(), txtDdd.getText(), txtNum.getText(), rdbtnMovel.isSelected());
			}
		});
		add(btnSalvar, "8, 18");
		

	}

}
