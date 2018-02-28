
public class CampoNumeroVazioException extends NumberFormatException {
	private String mensagem;
	
	public CampoNumeroVazioException(){
		this.mensagem = mensagem;
	}
	
	public CampoNumeroVazioException(String mensagem){
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "CampoNumeroVazioException [mensagem=" + mensagem + "]";
	}
	
	
}
