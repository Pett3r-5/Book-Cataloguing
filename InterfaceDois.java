import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceDois extends JFrame implements ActionListener{
	private JPanel painel2;
	private JButton botao;
	private JTextField[] input;
	private JLabel[] inputDescricao;
	private JButton[] tipos;
	int tipo = 0;
	String tipoParametro = "";
	
	public InterfaceDois(){
		painel2 = new JPanel();
		Metodos m = new Metodos();	
		
		
		
		
		
		Font f1 = new Font("Myriad Pro", Font.PLAIN,18);
		Font f4 = new Font("Myriad Pro Cond", Font.PLAIN,18);
		Font f2 = new Font("Bodoni MT", Font.PLAIN,43);
		Font f3 = new Font("Myriad Pro Cond", Font.PLAIN,21);
		
		
		
		JButton botao = new JButton();
		botao.setBounds(700,540,300,60);
		painel2.add(botao);
		botao.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				
				
				
			/*	
			if(e.getSource() == b) {
				String valorDois = input[0].getText();
				if(valorDois.equalsIgnoreCase(valor))
					input[0].setText("");
				for(int i = 0; i<input.length; i++) {
					if(!input[i].getText().equalsIgnoreCase(""))
						m.modificaLivro(valor, input[i].getText(), i);
				}
			}
			*/
			
		 		 }});
		
		int contPosicaoVertical = 0;
		int contPosicaoHorizontal = 0;
		
		JTextField[] input = new JTextField[5];
		for(int i = 0; i<input.length; i++) {
			if(contPosicaoHorizontal == 2) {
				contPosicaoVertical++;
				contPosicaoHorizontal = 0;
			}
			input[i] = new JTextField();
			input[i].setBounds(300+(320*contPosicaoHorizontal),285+(70*contPosicaoVertical),300,20);
			painel2.add(input[i]);
			input[i].setFont(f1);
			input[i].setBackground(new Color(198, 221, 247));
			input[i].addActionListener(this);
			contPosicaoHorizontal++;
		}
		
		contPosicaoVertical = 0;
		contPosicaoHorizontal = 0;
		JLabel[] inputDescricao = new JLabel[6];
		for(int i = 0; i<inputDescricao.length; i++) {
			if(contPosicaoHorizontal == 2) {
				contPosicaoVertical++;
				contPosicaoHorizontal = 0;
			}
			inputDescricao[i] = new JLabel("");
			inputDescricao[i].setBounds(300+(320*contPosicaoHorizontal),260+(70*contPosicaoVertical),300,20);
			painel2.add(inputDescricao[i]);
			inputDescricao[i].setFont(f1);
			inputDescricao[i].setForeground(new Color(100, 0, 100));
			contPosicaoHorizontal++;
		}
		
		inputDescricao[0].setText("Título:");
		inputDescricao[1].setText("Escritor:");
		inputDescricao[2].setText("Número de páginas:");
		inputDescricao[3].setText("Editora:");
		inputDescricao[4].setText("Tags(separar por ponto-e-vírgula):");
		inputDescricao[5].setText("Tipo:");
		
		JButton[] tipos = new JButton[3];
		
		for(int i = 0; i<tipos.length; i++) {
			tipos[i] = new JButton("");
			tipos[i].setBounds(620+(100*i),425,90, 35);
			painel2.add(tipos[i]);
			tipos[i].setFont(f4);
			tipos[i].setForeground(new Color(100, 0, 100));
			tipos[i].setBackground(new Color(198, 221, 247));
			tipos[i].addActionListener(new ActionListener() { 
		 		 public void actionPerformed(ActionEvent e) { 
		 			if(e.getSource() == tipos[0]) {
		 				tipo = 1;
		 				tipoParametro = JOptionPane.showInputDialog(null, "Digite o gênero do livro:");
		 				
		 			}
		 			
		 			else if(e.getSource() == tipos[1]) {
		 				tipo = 2;
		 				tipoParametro = JOptionPane.showInputDialog(null, "Digite o tipo de livro(ex.: acadêmico, turismo, biografia, etc):");
		 				
		 			}
		 			
		 			else if(e.getSource() == tipos[2]) {
		 				tipo = 3;
		 				tipoParametro = JOptionPane.showInputDialog(null, "Nome do desenhista/colorista:");
		 				
		 			}
		     		
		   		} 
		 	});
		}
		
		
		painel2.setLayout(null);
		
		this.add(painel2); 
		painel2.setBackground(new Color(78, 242, 152));
		this.setTitle("Biblioteca");
		this.setResizable(false); 
		this.setSize(1200, 900);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		tipos[0].setText("Ficção");
		tipos[1].setText("Não ficção");
		tipos[2].setText("Quadrinho");
		
		String valor = "deuses americanos";
		m.setarNomes(valor);
		
		
		
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
