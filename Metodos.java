import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Metodos {
	
	protected Ficcao[] ficcao;
	protected NaoFiccao[] naoFiccao;
	protected Quadrinho[] quadrinhos;
	
	public Metodos() {
		this.ficcao = new Ficcao[200];
		this.naoFiccao = new NaoFiccao[200];
		this.quadrinhos = new Quadrinho[200];
	}
	
	
	public void modificaLivro(String antigo, String mudanca, int i) {
		File f1 = new File(antigo+".txt");
		File f2;
		if(i == 0) {
			f2 = new File(mudanca+".txt");
			f1.renameTo(f2);
			f1 = f2;
			antigo = mudanca;
		}
		
		FileReader reader;
		try {
			reader = new FileReader(antigo+".txt");
			BufferedReader bf = new BufferedReader(reader);
			String line = bf.readLine();
			while(line != null) {
				String[] s= line.split(";");
				
				line.replace("s[i]", "mudanca");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	}
	
	
	
	public String[] setarNomes(String valor){
		File f = new File(valor+".txt");
		FileReader reader;
		String conct = "";
		String[] novo = new String[6];

		try {
			reader = new FileReader(valor+".txt");
			BufferedReader bf = new BufferedReader(reader);
			String line = bf.readLine();
			while(line != null) {
				String[] s= line.split(";");
				for(int i = 5; i< s.length; i++){
					conct = conct+";"+ s[i];
				}
				novo[0] = s[0];
				novo[1] = s[1];
				novo[2] = s[2];
				novo[3] = s[3];
				novo[5] = conct;
				
			}
			
			
			bf.close();
			
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return novo;
		
	}
	
	
	public void cadastraNovoProduto(String nome, String autor, int pgs, String editora, String tag, String tipo, String extra){
		
		File f = new File(nome+".txt");
		int marca = 0;
		
		if(tipo.equalsIgnoreCase("ficcao")) {
			for(int i = 0; i<this.ficcao.length; i++) {
				if(this.ficcao[i] == null) {
					this.ficcao[i] = new Ficcao(nome, autor, pgs, editora, extra);
					marca = i;
					break;
				}
			}
		}
		
		else if(tipo.equalsIgnoreCase("nao ficcao") || tipo.equalsIgnoreCase("nao-ficcao")) {
			for(int i = 0; i<this.naoFiccao.length; i++) {
				if(this.naoFiccao[i] == null) {
					this.naoFiccao[i] = new NaoFiccao(nome, autor, pgs, editora, extra);
					marca = i;
					break;
				}
			}
		}

		else if(tipo.equalsIgnoreCase("quadrinho")){
			for(int i = 0; i<this.quadrinhos.length; i++) {
				if(this.quadrinhos[i] == null) {
					this.quadrinhos[i] = new Quadrinho(nome, autor, pgs, editora, extra);
					marca = i;
					break;
				}
			}
		}
		
			
		
		int cont = 0;
		
		try {
			FileWriter fr = new FileWriter(f);
			fr.write(nome+";"+autor+";"+pgs+";"+editora+";"+extra+";"+tag+";");
			
			FileReader reader = new FileReader(nome+".txt");
			BufferedReader bf = new BufferedReader(reader);
			String line = bf.readLine();
			
			if(tipo.equalsIgnoreCase("ficcao")) {
			
				while(line != null){
				
					String[] s= line.split(";");
				
					ficcao[marca].setNome(s[0]);
					ficcao[marca].setAutor(s[1]);
					ficcao[marca].setPgs(Integer.parseInt(s[2]));
					ficcao[marca].setEditora(s[3]);
					for(int i = 4; i<s.length; i++){
						s[i].trim();
					}
					
					for(int i = 5; i<s.length; i++){
						this.ficcao[marca].setTags(s[i],cont);
						cont++;
					}
					line = bf.readLine();
				}
			}
			
			else if(tipo.equalsIgnoreCase("nao ficcao") || tipo.equalsIgnoreCase("nao-ficcao")) {
				
				while(line != null){
				
					String[] s= line.split(";");
				
					ficcao[marca].setNome(s[0]);
					ficcao[marca].setAutor(s[1]);
					ficcao[marca].setPgs(Integer.parseInt(s[2]));
					ficcao[marca].setEditora(s[3]);
					for(int i = 4; i<s.length; i++){
						s[i].trim();
					}
					
					for(int i = 5; i<s.length; i++){
						this.ficcao[marca].setTags(s[i],cont);
						cont++;
					}
					line = bf.readLine();
				}
			}
			
			else if(tipo.equalsIgnoreCase("quadrinho")) {
				
				while(line != null){
				
					String[] s= line.split(";");
				
					ficcao[marca].setNome(s[0]);
					ficcao[marca].setAutor(s[1]);
					ficcao[marca].setPgs(Integer.parseInt(s[2]));
					ficcao[marca].setEditora(s[3]);
					for(int i = 4; i<s.length; i++){
						s[i].trim();
					}
					
					for(int i = 5; i<s.length; i++){
						if(this.ficcao[marca].getTags()[i] == null) {
							this.ficcao[marca].setTags(s[i],cont);
							cont++;
						}
					}
					line = bf.readLine();
				}
			}
			
			fr.close();
			bf.close();
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(ficcao);
		
	}
	
	
	public void alteraProduto(String nome, String troca, int qual){
		
		File f = new File(nome+".txt");
		int marca = 0;
		
		/*
		if(tipo.equalsIgnoreCase("ficcao")) {
			for(int i = 0; i<this.ficcao.length; i++) {
				if(this.ficcao[i] == null) {
					this.ficcao[i] = new Ficcao(nome, autor, pgs, editora, extra);
					marca = i;
					break;
				}
			}
		}
		
		else if(tipo.equalsIgnoreCase("nao ficcao") || tipo.equalsIgnoreCase("nao-ficcao")) {
			for(int i = 0; i<this.naoFiccao.length; i++) {
				if(this.naoFiccao[i] == null) {
					this.naoFiccao[i] = new NaoFiccao(nome, autor, pgs, editora, extra);
					marca = i;
					break;
				}
			}
		}

		else if(tipo.equalsIgnoreCase("quadrinho")){
			for(int i = 0; i<this.quadrinhos.length; i++) {
				if(this.quadrinhos[i] == null) {
					this.quadrinhos[i] = new Quadrinho(nome, autor, pgs, editora, extra);
					marca = i;
					break;
				}
			}
		}
		*/
			
		
		int cont = 0;
		
		try {
			
			FileReader reader = new FileReader(nome+".txt");
			BufferedReader bf = new BufferedReader(reader);
			String line = bf.readLine();
			
			
			
				while(line != null){
				
					String[] s= line.split(";");
					if(qual != 2)
						line.replaceAll(s[qual], troca);
					else
						line.replaceAll(s[qual], ""+troca);
					/*
					ficcao[marca].setNome(s[0]);
					ficcao[marca].setAutor(s[1]);
					ficcao[marca].setPgs(Integer.parseInt(s[2]));
					ficcao[marca].setEditora(s[3]);
					for(int i = 4; i<s.length; i++){
						s[i].trim();
					}
					
					for(int i = 5; i<s.length; i++){
						this.ficcao[marca].setTags(s[i],cont);
						cont++;
					}
					line = bf.readLine();
					*/
				}
		
			
			
			
			
			bf.close();
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(ficcao);
		
	}
	
	
	
	public String[] listarLivros(String nome) {
		
		File f = new File(nome + ".txt");

		String dir = ".";
		
		File diretorio = new File(dir);

		
		String[] nomes = diretorio.list();
	
		
		String[] nomes2 = new String[compara(nomes, nome)];
		
		int cont2 = 0;
		for (int i = 0; i < nomes.length; i++) {
			if (nomes[i].contains(".txt")) {
				nomes2[cont2] = nomes[i];
				cont2++;
			}
		}
		
		
		return nomes2;
		
	}
	
	public int compara(String[] nomes, String nome){
		return compara(nomes, nome,0, 0);
	}
	
	private int compara(String[] nomes, String nome,int i, int cont){
		if(i< nomes.length-1 && nomes[i].contains(".txt"))
			return compara(nomes, nome,i+1, cont+1);
		else if(i< nomes.length-1 && !nomes[i].contains(".txt"))
			return compara(nomes, nome,i+1, cont);
		else if(i == nomes.length-1 && nomes[i].contains(".txt"))
			return cont+1;
		return cont;
	}
	
	
	public int removerLivro(String nome) {
		
				File f1 = new File(nome + ".txt");
				
				
				String dir = ".";
				
				File diretorio = new File(dir);

				
				String[] nomes = diretorio.list();
			
				int cont = 0;
				for (int i = 0; i<nomes.length; i++) {
					if (nomes[i].equalsIgnoreCase(nome+".txt")) {
						f1.delete();
						return 1;
					}
				}
				
				
				
				return -1;
				
			
	}
	
	
	
	
	public int procuraLivro(String nome) {
	
				File f1 = new File(nome + ".txt");
				
				
				String dir = ".";
				
				File diretorio = new File(dir);

				
				String[] nomes = diretorio.list();
			
				int cont = 0;
				for (int i = 0; i<nomes.length; i++) {
					if (nomes[i].equalsIgnoreCase(nome+".txt")) {
						return 1;
					}
				}
				
				
				
				return -1;
				
			
	}
	

	public Ficcao[] getFiccao() {
		return ficcao;
	}

	public void setFiccao(Ficcao[] ficcao) {
		this.ficcao = ficcao;
	}

	public NaoFiccao[] getNaoFiccao() {
		return naoFiccao;
	}

	public void setNaoFiccao(NaoFiccao[] naoFiccao) {
		this.naoFiccao = naoFiccao;
	}

	public Quadrinho[] getQuadrinhos() {
		return quadrinhos;
	}

	public void setQuadrinhos(Quadrinho[] quadrinhos) {
		this.quadrinhos = quadrinhos;
	}

	@Override
	public String toString() {
		return "Metodos [ficcao=" + Arrays.toString(ficcao) + ", naoFiccao=" + Arrays.toString(naoFiccao)
				+ ", quadrinhos=" + Arrays.toString(quadrinhos) + "]";
	}
	
	
}
