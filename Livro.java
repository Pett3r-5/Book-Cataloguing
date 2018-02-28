
public abstract class Livro {
	protected String nome;
	protected String escritor;
	protected int pgs;
	protected String editora;
	protected static String[] tags;
	
	public Livro(String nome, String autor, int pgs, String editora, String[] tags) {
		this.nome = nome;
		this.escritor = autor;
		this.pgs = pgs;
		this.editora = editora;
		this.tags = tags;
	}
	
	public Livro(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return escritor;
	}

	public void setAutor(String autor) {
		this.escritor = autor;
	}

	public int getPgs() {
		return pgs;
	}

	public void setPgs(int pgs) {
		this.pgs = pgs;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	
	
	public String[] getTags() {
		return tags;
	}

	public void setTags(String tags, int i) {
		this.tags[i] = tags;
	}

	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", autor=" + escritor + ", pgs=" + pgs + ", editora=" + editora + "]";
	}
	
	
	
}
