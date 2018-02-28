import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InterfaceLoja extends JFrame implements ActionListener{
	private JPanel painel;
	private JButton[] tipos;
	int tipo = 0;
	String tipoParametro = "";
	
	public InterfaceLoja() {
		painel = new JPanel();
		
		painel.setLayout(null);
		
		
		JButton[] tipos = new JButton[3];
		
		for(int i = 0; i<tipos.length; i++) {
			tipos[i] = new JButton("");
			tipos[i].setBounds(620+(100*i),425,90, 35);
			painel.add(tipos[i]);
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
		
		
		
		this.add(painel); 
		painel.setBackground(new Color(78, 242, 152));
		this.setTitle("Biblioteca");
		this.setResizable(false); 
		this.setSize(1200, 900);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
