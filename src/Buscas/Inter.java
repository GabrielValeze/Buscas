package Buscas;

import java.util.LinkedList;

public interface Inter { // Interface que força as funções de busca.
	
	public void linkarestados();
	public LinkedList<Estado> funcaoSucessora(Estado estado);
	public boolean testeDeObjetivo(Estado estadoAtual);
	public Estado verificaEstadoInicial (String nomeEstadoInicial);
	public Estado verificaObjetivo (String nomeOjetivo);
	public Estado getEstadoInicial();
	public Estado getObejetivo();
	public String getNomeEstadoInicial();
	public String getNomeObjetivo();

}
