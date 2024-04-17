package model.exceptions;

public class DomainException extends RuntimeException {// (Atent) runTimeException não é obrigatoriamente tratavel
	
	private static final long serialVersionUID = 1L;	//o Exception e RuntimeException é serializable, por isto devemos declarar este valor de verção o 1
	
	public DomainException(String msg) {
		super(msg);
	}
}
