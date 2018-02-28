import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceGrafica extends JFrame implements ActionListener{
	private JPanel painel;
	private JLabel ibagem;
	private JButton[] botoes;
	private JLabel titulo;
	private JTextField[] input;
	private JLabel[] inputDescricao;
	private JLabel divisao;
	private JLabel divisao2;
	private JButton[] tipos;
	int tipo = 0;
	String tipoParametro = "";
	private JButton b;
	int guarda = 0;
	
	public InterfaceGrafica() {
		Metodos m = new Metodos();	
		painel = new JPanel();
		
		
		Font f1 = new Font("Myriad Pro", Font.PLAIN,18);
		Font f4 = new Font("Myriad Pro Cond", Font.PLAIN,18);
		Font f2 = new Font("Bodoni MT", Font.PLAIN,43);
		Font f3 = new Font("Myriad Pro Cond", Font.PLAIN,21);
		
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
			painel.add(input[i]);
			input[i].setFont(f1);
			input[i].setBackground(new Color(198, 221, 247));
			input[i].addActionListener(this);
			contPosicaoHorizontal++;
		}
		
		JButton[] botoes = new JButton[5];
		
		
		
		divisao = new JLabel("_______________________");
		divisao.setBounds(490,337,3700,300);
		painel.add(divisao);
		divisao.setFont(f3);
		divisao.setForeground(new Color(100, 0, 150));
		
		
		divisao2 = new JLabel("_______________________");
		divisao2.setBounds(490,620,3700,300);
		painel.add(divisao2);
		divisao2.setFont(f3);
		divisao2.setForeground(new Color(100, 0, 150));
		
		contPosicaoVertical = 0;
		contPosicaoHorizontal = 0;
		
		for(int i = 0; i<botoes.length; i++) {
			if(contPosicaoHorizontal == 2) {
				contPosicaoVertical++;
				contPosicaoHorizontal = 0;
			}
			botoes[i] = new JButton();
			botoes[i].setBounds(300+(320*contPosicaoHorizontal),540+(70*contPosicaoVertical),300,60);
			painel.add(botoes[i]);
			botoes[i].setFont(f3);
			//botoes[i].setForeground(new Color(198, 221, 247));
			botoes[i].setForeground(new Color(100, 100, 150));
			botoes[i].setBackground(new Color(148, 195, 224));
			botoes[i].addActionListener(new ActionListener() { 
		 		 public void actionPerformed(ActionEvent e) { 
		 			
		 			if(e.getSource() == botoes[0]) {
		 				String variavelTipo = "";
		 				int v = 0;
		 				
		 				for(int i = 0; i<input.length; i++){
		 					if(input[i].equals("") ||(tipo != 1 && tipo != 2 && tipo != 3)){
		 						JOptionPane.showMessageDialog(null,"Algum campo vazio");
		 						break;
		 					}
		 					else{
		 						if(tipo == 1) 
			 						variavelTipo = "ficcao";
			 					else if(tipo == 2)
			 						variavelTipo = "nao ficcao";
			 					else if(tipo == 3)
			 						variavelTipo = "quadrinho";
			 					System.out.println("tipo:"+tipoParametro);
			 					try{
			 						if(input[2].equals(""))
			 							throw new CampoNumeroVazioException();
			 						m.cadastraNovoProduto(input[0].getText(), input[1].getText(), Integer.parseInt(input[2].getText()), input[3].getText(), input[4].getText(),variavelTipo, tipoParametro);
			 					}catch(java.lang.NumberFormatException e2){
			 						JOptionPane.showMessageDialog(null,"Campo de número de páginas vazio");
			 					}
			 					
			 					JOptionPane.showMessageDialog(null, m.getFiccao());
			 					break;
		 					}
		 					
		 				}
		 				
		 				
		 				
		 			}
		 				
		 			else if(e.getSource() == botoes[1]) {

		 				String [] nomes = m.listarLivros("");
		 				String [] nomesSemTxt = new String[nomes.length];
		 				
		 				for(int i = 0; i<nomes.length; i++) {
		 					nomesSemTxt[i] = nomes[i].replace(".txt","");
		 				}
		 				
		 				JOptionPane.showMessageDialog(null, nomesSemTxt);
		 			}
		 			
		 			else if(e.getSource() == botoes[2]) {
		 				String nomePraRemover = JOptionPane.showInputDialog(null, "Digite o nome do livro:");
		 				if(m.removerLivro(nomePraRemover) == -1)
		 					JOptionPane.showMessageDialog(null, "Livro não encontrado");
		 				else 
		 					JOptionPane.showMessageDialog(null, "Livro "+nomePraRemover+" removido");
		 			}
		     		
		 			else if(e.getSource() == botoes[3]) {
		 				
		 				
		 				
		 				if(guarda == 0){
		 					String valor = JOptionPane.showInputDialog(null, "Digite o nome do livro a ser alterado:");
		 					m.procuraLivro(valor);

		 					if(m.procuraLivro(valor) == -1)
		 						JOptionPane.showMessageDialog(null, "Livro não encontrado");
		 					else {
		 						
		 						input[0].setText(valor);
		 						guarda++;
		 				
		 						
		 						/*
		 						input[1].setText(m.setarNomes(valor)[1]);
			 					input[2].setText(""+m.setarNomes(valor)[2]);
			 					input[3].setText(m.setarNomes(valor)[3]);
			 					input[4].setText(m.setarNomes(valor)[5]);
			 					*/
			 					
		 					}
		 				}
		 				else if(guarda>0){
		 					for(int i = 1; i<input.length; i++) {
		 						if(!input[i].equals(""))
		 							m.alteraProduto(input[0].getText(),input[i].getText(),i);
		 					}
		 					guarda = 0;
		 				}
		 					/*
		 					for(int i = 0; i<m.getQuadrinhos().length; i++) {
		 						if(valor.equalsIgnoreCase(m.getQuadrinhos()[i].getNome())) {
		 							guarda = i;
		 							for(int j = 0; j<m.getQuadrinhos().length; j++) {
			 							conct = conct+";"+m.getQuadrinhos()[guarda].getTags()[j];
			 									}
		 						}
		 					}
		 					for(int i = 0; i<m.getFiccao().length; i++) {
		 						if(valor.equalsIgnoreCase(m.getFiccao()[i].getNome())) {
		 							guarda = i;
		 							for(int j = 0; j<m.getFiccao().length; j++) {
			 							conct = conct+";"+m.getFiccao()[guarda].getTags()[j];
			 									}
		 						}
		 					}
		 					for(int i = 0; i<m.getNaoFiccao().length; i++) {
		 						if(valor.equalsIgnoreCase(m.getNaoFiccao()[i].getNome())) {
		 							guarda = i;
		 							for(int j = 0; j<m.getNaoFiccao().length; j++) {
			 							conct = conct+";"+m.getNaoFiccao()[guarda].getTags()[j];
			 									}
		 						}
		 					}
		 					
		 					
		 					
		 					input[1].setText(m.getQuadrinhos()[guarda].getAutor());
		 					input[2].setText(""+m.getQuadrinhos()[guarda].getPgs());
		 					input[3].setText(m.getQuadrinhos()[guarda].getEditora());
		 					input[4].setText(conct);
		 					*/
		 					
		 					/*
		 					input[0].setText(valor);
		 					JButton b = new JButton();
		 					b.setBounds(700,540,300,60);
		 					painel.add(b);
		 					b.addActionListener(new ActionListener() { 
		 				 		 public void actionPerformed(ActionEvent e) { 
		 					
		 					if(e.getSource() == b) {
		 						String valorDois = input[0].getText();
		 						if(valorDois.equalsIgnoreCase(valor))
		 							input[0].setText("");
		 						for(int i = 0; i<input.length; i++) {
		 							if(!input[i].getText().equalsIgnoreCase(""))
		 								m.modificaLivro(valor, input[i].getText(), i);
		 						}
		 					}
		 					
		 				 		 }});
		 				
		 					*/
		 						
		 				
		 				
		 			}
		 			
		 			else if(e.getSource() == botoes[4]){
		 				String troca = input[0].getText().replaceAll(" ", "-");
		 				String aa = "http://www.buscape.com.br/search/"+troca;
		 				
		 				
		 				
		 				
		 				try {
		 			        Desktop.getDesktop().browse(new URL(aa).toURI());
		 			    } catch (Exception e3) {
		 			        e3.printStackTrace();
		 			    }
		 			}
		   		} 
		 	});
			contPosicaoHorizontal++;
		}
		
		JLabel ibagem =new JLabel(new ImageIcon("icone2.png"));
		painel.add(ibagem);
		ibagem.setBounds(560,60,100,110);
		
		
		
		
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
			painel.add(inputDescricao[i]);
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
		
		botoes[0].setText("Cadastrar Livro");
		botoes[1].setText("Listar os livros já cadastrados");
		botoes[2].setText("Remover livro (por nome)");
		botoes[3].setText("Atualizar informações do livro");
		botoes[4].setText("Pesquisar Preço");
		
		
		titulo = new JLabel("Catalogação de Livros");
		titulo.setBounds(420,60,400,300);
		titulo.setFont(f2);
		painel.add(titulo);
		titulo.setForeground(new Color(100, 0, 150));
		
		
		JButton[] tipos = new JButton[3];
		
		for(int i = 0; i<tipos.length; i++) {
			tipos[i] = new JButton("");
			tipos[i].setBounds(620+(100*i),425,90, 35);
			painel.add(tipos[i]);
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
		
		tipos[0].setText("Ficção");
		tipos[1].setText("Não ficção");
		tipos[2].setText("Quadrinho");
		
		painel.setLayout(null);
		
		/*
		blackline = BorderFactory.createLineBorder(Color.black);
		raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		empty = BorderFactory.createEmptyBorder();
		*/
		
		/*
		JPanel novo = new JPanel();
		novo.setBounds(300, 500, 700, 300);
		novo.setBackground(null);
		novo.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		painel.add(novo);
		*/
		
		this.add(painel); 
		painel.setBackground(new Color(78, 242, 152));
		this.setTitle("Catalogação");
		this.setResizable(false); 
		this.setSize(1200, 900);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		//this.setVisible(false);
		
		
		
		
		
		
	}
}
