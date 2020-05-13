package view.aula10.exercicio2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipalPaneis extends JFrame {

	private JPanel contentPane;
	private JPanel panelCadastroTelefone;
	private JPanel peqPanelCadastroCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalPaneis frame = new MenuPrincipalPaneis();
					frame.setExtendedState(MAXIMIZED_BOTH);
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
	public MenuPrincipalPaneis() {
		setTitle("Empresa Telefonia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setIcon(new ImageIcon(MenuPrincipalPaneis.class.getResource("/icones/User-Clients-icon - Copia.png")));
		menuBar.add(mnCliente);
		
		JMenuItem mnItemListar = new JMenuItem("Listar");
		mnCliente.add(mnItemListar);
		
		JMenuItem mnitemCadastrar = new JMenuItem("Cadastrar");
		mnitemCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					peqPanelCadastroCliente = new PanelCadastroCliente();
					setContentPane(peqPanelCadastroCliente);
					revalidate();
				
				
			}
		});
		mnCliente.add(mnitemCadastrar);
		
		JMenu mnitemTelefone = new JMenu("Telefone");
		mnitemTelefone.setIcon(new ImageIcon(MenuPrincipalPaneis.class.getResource("/icones/phone-icon.png")));
		menuBar.add(mnitemTelefone);
		
		JMenuItem mnitListatel = new JMenuItem("Listar");
		mnitListatel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnitListatel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mnitemTelefone.add(mnitListatel);
		
		JMenuItem mnitCadtel = new JMenuItem("Cadastrar");
		mnitCadtel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCadastroTelefone = new PanelCadastroTelefone();
				setContentPane(panelCadastroTelefone);
				revalidate();
			}
		});
		mnitCadtel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnitemTelefone.add(mnitCadtel);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
