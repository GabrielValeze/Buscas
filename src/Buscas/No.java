package Buscas;
import Buscas.Estado;

public class No {
	
	public Estado estado;
	public Estado acao;
	public No pai;
	public Integer profundidade;
	public Integer custoCaminho;
	
	public No(Estado estado){
		super();
		this.estado = estado;
	}
	
		
}