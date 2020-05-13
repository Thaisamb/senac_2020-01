package view.aula10.exercicio2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JEditorPane;
import java.awt.Insets;
import javax.swing.JSlider;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;

public class TelaInternaSobreAutor extends JInternalFrame {
	
	private ImageIcon fotoAutor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInternaSobreAutor frame = new TelaInternaSobreAutor();
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
	public TelaInternaSobreAutor() {
		setClosable(true);
		
		setBounds(100, 100, 540, 281);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JTextArea txtrAlbertEinsteinulm = new JTextArea();
		txtrAlbertEinsteinulm.setFont(new Font("Arial", Font.ITALIC, 15));
		txtrAlbertEinsteinulm.setBackground(SystemColor.inactiveCaption);
		txtrAlbertEinsteinulm.setText("     \r\n  Albert Einstein (1879- 1955) físico teórico \r\nalemão desenvolveu a teoria da relatividade geral,\r\npilar da física moderna ao lado da mecânica quân\r\ntica. Conhecido por sua fórmula de equivalência\r\nmassa-energia, E=mc² (chamada de \"a equação\r\nmais famosa do mundo\" . Obteve o Prêmio Nobel\r\nde Física de 1921 \"por suas contribuições à física \r\nteórica\" e, especialmente,por sua descoberta da\r\nlei do efeito fotoelétrico, que foi fundamental no\r\nestabelecimento da teoria quântica.\r\n\r\nFonte : https://pt.wikipedia.org/wiki/Albert_Einstein");
		getContentPane().add(txtrAlbertEinsteinulm);
		
		fotoAutor = new ImageIcon(getClass().getResource("/icones/Einstein.png"));
		JLabel lblImagem = new JLabel(fotoAutor);
		getContentPane().add(lblImagem);
		setTitle("Sobre Autor");

	}
}
