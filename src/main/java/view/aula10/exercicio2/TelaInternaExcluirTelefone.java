package view.aula10.exercicio2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaInternaExcluirTelefone extends JInternalFrame {
	private JTextField txtCodPais;
	private JTextField txtDdd;
	private JTextField txtNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInternaExcluirTelefone frame = new TelaInternaExcluirTelefone();
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
	public TelaInternaExcluirTelefone() {
		setTitle("Exclusão de telefone");
		setClosable(true);
		setBounds(100, 100, 300, 172);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCodPais = new JLabel("Código País:");
		GridBagConstraints gbc_lblCodPais = new GridBagConstraints();
		gbc_lblCodPais.anchor = GridBagConstraints.WEST;
		gbc_lblCodPais.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodPais.gridx = 1;
		gbc_lblCodPais.gridy = 1;
		getContentPane().add(lblCodPais, gbc_lblCodPais);
		
		txtCodPais = new JTextField();
		GridBagConstraints gbc_txtCodPais = new GridBagConstraints();
		gbc_txtCodPais.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodPais.gridx = 2;
		gbc_txtCodPais.gridy = 1;
		getContentPane().add(txtCodPais, gbc_txtCodPais);
		txtCodPais.setColumns(10);
		
		JLabel lblDdd = new JLabel("DDD:");
		GridBagConstraints gbc_lblDdd = new GridBagConstraints();
		gbc_lblDdd.anchor = GridBagConstraints.WEST;
		gbc_lblDdd.insets = new Insets(0, 0, 5, 5);
		gbc_lblDdd.gridx = 1;
		gbc_lblDdd.gridy = 2;
		getContentPane().add(lblDdd, gbc_lblDdd);
		
		txtDdd = new JTextField();
		GridBagConstraints gbc_txtDdd = new GridBagConstraints();
		gbc_txtDdd.insets = new Insets(0, 0, 5, 5);
		gbc_txtDdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDdd.gridx = 2;
		gbc_txtDdd.gridy = 2;
		getContentPane().add(txtDdd, gbc_txtDdd);
		txtDdd.setColumns(10);
		
		JLabel lblNum = new JLabel("Número:");
		GridBagConstraints gbc_lblNum = new GridBagConstraints();
		gbc_lblNum.anchor = GridBagConstraints.WEST;
		gbc_lblNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblNum.gridx = 1;
		gbc_lblNum.gridy = 3;
		getContentPane().add(lblNum, gbc_lblNum);
		
		txtNum = new JTextField();
		GridBagConstraints gbc_txtNum = new GridBagConstraints();
		gbc_txtNum.insets = new Insets(0, 0, 5, 5);
		gbc_txtNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNum.gridx = 2;
		gbc_txtNum.gridy = 3;
		getContentPane().add(txtNum, gbc_txtNum);
		txtNum.setColumns(10);
		
		JButton btExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btExcluir = new GridBagConstraints();
		gbc_btExcluir.insets = new Insets(0, 0, 5, 5);
		gbc_btExcluir.gridx = 2;
		gbc_btExcluir.gridy = 5;
		getContentPane().add(btExcluir, gbc_btExcluir);

	}

}
