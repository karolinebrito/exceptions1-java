package model.exceptions;

public class DomainException extends RuntimeException  {
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg); // repassando a mensagem para o construtor da superclasse
	}
	// permite instanciar a exceção personalizada passando uma mensagem pra ela como
	// argumento
}
