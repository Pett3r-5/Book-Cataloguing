
public class Ficcao extends Livro{
	private String genero;

	public Ficcao(String nome, String autor, int pgs, String editora, String genero) {
		super(nome, autor, pgs, editora, tags);
		this.genero = genero;
		this.tags = new String[10];
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
