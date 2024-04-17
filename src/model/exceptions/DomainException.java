package model.exceptions;

public class DomainException extends Exception {// (Atent) runTimeException não é obrigatoriamente tratavel o contrario vale para Exception
	
	private static final long serialVersionUID = 1L;	//o Exception é serializable, por isto devemos declarar este valor de verção o 1
	
	public DomainException(String msg) {
		super(msg);
	}
}
