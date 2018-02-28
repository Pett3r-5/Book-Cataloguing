
public class Quadrinho extends Livro {
	private String desenhista;

	public Quadrinho(String nome, String autor, int pgs, String editora, String desenhista) {
		super(nome, autor, pgs, editora, tags);
		this.desenhista = desenhista;
		this.tags = new String[10];
	}

	public String getDesenhista() {
		return desenhista;
	}

	public void setDesenhista(String desenhista) {
		this.desenhista = desenhista;
	}
	
	
}
