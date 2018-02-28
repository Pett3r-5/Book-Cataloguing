
public class NaoFiccao extends Livro{
	private String assunto;

	public NaoFiccao(String nome, String autor, int pgs, String editora, String assunto) {
		super(nome, autor, pgs, editora, tags);
		this.assunto = assunto;
		this.tags = new String[10];
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	
}
