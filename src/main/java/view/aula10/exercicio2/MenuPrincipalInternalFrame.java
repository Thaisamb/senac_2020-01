package view.aula10.exercicio2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class MenuPrincipalInternalFrame extends JFrame {

	private JDesktopPane desktopPane;
	private TelaIntenaCadastroCliente janelaCadCliente;
	private TelaInternaSobreAutor janelaSobreAutor;
	private TelaInternaCadastroTelefone janelaCadTel;
	private TelaInternaExcluirTelefone janelaDelTel;
	private TelaInternaListaTelefones janelaListTel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalInternalFrame frame = new MenuPrincipalInternalFrame();
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
	public MenuPrincipalInternalFrame() {
		setTitle("Empresa de Telefonia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuCliente = new JMenu("Clientes");
		menuCliente.setIcon(
				new ImageIcon(MenuPrincipalInternalFrame.class.getResource("/icones/User-Clients-icon - Copia.png")));
		menuBar.add(menuCliente);

		JMenuItem mnitCadCliente = new JMenuItem("Cadastrar");
		mnitCadCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaCadCliente == null || !janelaCadCliente.isVisible()) {
					janelaCadCliente = new TelaIntenaCadastroCliente();
					desktopPane.add(janelaCadCliente);
					janelaCadCliente.show();
				}
			}
		});
		mnitCadCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnitCadCliente
				.setIcon(new ImageIcon(MenuPrincipalInternalFrame.class.getResource("/icones/folder-add-icon.png")));
		menuCliente.add(mnitCadCliente);

		JMenu menuTelefone = new JMenu("Telefones");
		menuTelefone.setIcon(new ImageIcon(MenuPrincipalInternalFrame.class.getResource("/icones/phone-icon.png")));
		menuBar.add(menuTelefone);

		JMenuItem mnitCadTel = new JMenuItem("Cadastrar\r\n");
		mnitCadTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaCadTel == null || !janelaCadTel.isVisible()) {
					janelaCadTel = new TelaInternaCadastroTelefone();
					desktopPane.add(janelaCadTel);
					janelaCadTel.show();
				}
			}
		});
		mnitCadTel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mnitCadTel.setIcon(new ImageIcon(MenuPrincipalInternalFrame.class.getResource("/icones/Button-Add-icon.png")));
		menuTelefone.add(mnitCadTel);

		JMenuItem mnitEditTel = new JMenuItem("Editar");
		mnitEditTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaCadTel == null || !janelaCadTel.isVisible()) {
					janelaCadTel = new TelaInternaCadastroTelefone();
					desktopPane.add(janelaCadTel);
					janelaCadTel.show();
				}
			}
		});
		mnitEditTel.setIcon(
				new ImageIcon(MenuPrincipalInternalFrame.class.getResource("/icones/system-software-update-icon.png")));
		mnitEditTel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		menuTelefone.add(mnitEditTel);

		JMenuItem mnitDelTel = new JMenuItem("Excluir");
		mnitDelTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaDelTel == null || !janelaDelTel.isVisible()) {
					janelaDelTel = new TelaInternaExcluirTelefone();
					desktopPane.add(janelaDelTel);
					janelaDelTel.show();
				}
			}
		});

		mnitDelTel.setIcon(new ImageIcon(MenuPrincipalInternalFrame.class.getResource("/icones/delete-icon.png")));
		mnitDelTel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		menuTelefone.add(mnitDelTel);

		JMenuItem mnitListTel = new JMenuItem("Listar");
		mnitListTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaListTel == null || !janelaListTel.isVisible()) {
					janelaListTel = new TelaInternaListaTelefones();
					desktopPane.add(janelaListTel);
					janelaListTel.show();
				}
			}
		});
		mnitListTel.setIcon(new ImageIcon(MenuPrincipalInternalFrame.class.getResource("/icones/checklist-icon.png")));
		mnitListTel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		menuTelefone.add(mnitListTel);

		JMenu menuSobre = new JMenu("Sobre");
		menuSobre.setIcon(new ImageIcon(MenuPrincipalInternalFrame.class.getResource("/icones/Button-Info-icon.png")));
		menuBar.add(menuSobre);

		JMenuItem miAutor = new JMenuItem("Autor");
		miAutor.setIcon(
				new ImageIcon(MenuPrincipalInternalFrame.class.getResource("/icones/iBooks-Author-icon-32p.png")));
		miAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (janelaSobreAutor == null || !janelaSobreAutor.isVisible()) {
					janelaSobreAutor = new TelaInternaSobreAutor();
					desktopPane.add(janelaSobreAutor);
					janelaSobreAutor.show();
				}

			}
		});

		menuSobre.add(miAutor);

		desktopPane = new JDesktopPane();

		desktopPane.setBackground(Color.GRAY);
		desktopPane.setBounds(5, 5, 1000, 800);
		getContentPane().add(desktopPane);
	}
}