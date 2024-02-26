package github.com.JoaoBraga1996.msavaliadordecredito.ex;

public class ErroComunicacaoMicroServicesException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private int status;

	public ErroComunicacaoMicroServicesException(String msg, int status) {
		super(msg);
		this.status = status;
	}

	public int getStatus() {
		return status;
	}


	

}
