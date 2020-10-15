package Buscas;
import java.util.LinkedList;
import Buscas.Inter;

public class Mapa implements Inter{
	
    	public Estado estadoInicial;
	public Estado objetivo;
        
	public String NomeEstadoInicial;
	public String NomeObjetivo;
		
	public Estado Arad = new Estado();
	public Estado Timissoara = new Estado();
	public Estado Zerind = new Estado();
	public Estado Sibiu = new Estado();
	public Estado Lugoj = new Estado();
	public Estado Oradea = new Estado();
	public Estado Fagaras = new Estado();
	public Estado Rimnieu_Vilcea = new Estado();
	public Estado Pitesti = new Estado();
	public Estado Bucareste = new Estado();
	public Estado Mehadia = new Estado();
	public Estado Dobreta = new Estado();
	public Estado Craiova = new Estado();
	public Estado Giurgiu = new Estado();
	public Estado Urziceni = new Estado();
	public Estado Hirsova = new Estado();
	public Estado Eforie = new Estado();
	public Estado Vaslui = new Estado();
	public Estado Iasi = new Estado();
	public Estado Neamt = new Estado();
	
	public LinkedList<Estado> mapa = new LinkedList<Estado>();
	
	public Mapa(String NomeEstadoInicial, String NomeObjetivo) {
		
		super();
		this.linkarestados();
		this.iniciarmapa();
		this.NomeEstadoInicial = NomeEstadoInicial;
		this.NomeObjetivo = NomeObjetivo;
		this.estadoInicial = verificaEstadoInicial(NomeEstadoInicial);
		this.objetivo = verificaObjetivo(NomeObjetivo);
		
	}
	
	@Override
	public void linkarestados () {
		
		Arad.nome = "Arad";
		Arad.acoes.add(Sibiu);
		Arad.acoes.add(Zerind);
		Arad.acoes.add(Timissoara);
		
		Timissoara.nome = "Timissoara";
		Timissoara.acoes.add(Arad);
		Timissoara.acoes.add(Lugoj);
		
		Oradea.nome = "Oradea";
		Oradea.acoes.add(Zerind);
		Oradea.acoes.add(Sibiu);
		
		Zerind.nome = "Zerind";
		Zerind.acoes.add(Oradea);
		Zerind.acoes.add(Arad);
		Zerind.acoes.add(Sibiu);
		
		Sibiu.nome = "Sibiu";
		Sibiu.acoes.add(Fagaras);
		Sibiu.acoes.add(Rimnieu_Vilcea);
		Sibiu.acoes.add(Oradea);
		Sibiu.acoes.add(Arad);
		
		Fagaras.nome = "Fagaras";
		Fagaras.acoes.add(Bucareste);
		Fagaras.acoes.add(Sibiu);
		
		Bucareste.nome = "Bucareste";
		Bucareste.acoes.add(Urziceni);
		Bucareste.acoes.add(Fagaras);
		Bucareste.acoes.add(Pitesti);
		Bucareste.acoes.add(Giurgiu);
		
		Lugoj.nome = "Lugoj";
		Lugoj.acoes.add(Timissoara);
		Lugoj.acoes.add(Mehadia);
		
		Mehadia.nome = "Mehadia";
		Mehadia.acoes.add(Dobreta);
		Mehadia.acoes.add(Lugoj);
		
		Dobreta.nome = "Dobreta";
		Dobreta.acoes.add(Craiova);
		Dobreta.acoes.add(Mehadia);
		
		Craiova.nome = "Craiova";
		Craiova.acoes.add(Pitesti);
		Craiova.acoes.add(Rimnieu_Vilcea);
		Craiova.acoes.add(Dobreta);
		
		Pitesti.nome = "Pitesti";
		Pitesti.acoes.add(Bucareste);
		Pitesti.acoes.add(Rimnieu_Vilcea);
		Pitesti.acoes.add(Craiova);
		
		Rimnieu_Vilcea.nome = "Rimnieu_Vilcea";
		Rimnieu_Vilcea.acoes.add(Pitesti);
		Rimnieu_Vilcea.acoes.add(Craiova);
		Rimnieu_Vilcea.acoes.add(Sibiu);
		
		Giurgiu.nome = "Giurgiu";
		Giurgiu.acoes.add(Bucareste);
		
		Urziceni.nome = "Urziceni";
		Urziceni.acoes.add(Hirsova);
		Urziceni.acoes.add(Vaslui);
		Urziceni.acoes.add(Bucareste);
		
		Eforie.nome = "Eforie";
		Eforie.acoes.add(Hirsova);
		
		Vaslui.nome = "Vaslui";
		Vaslui.acoes.add(Urziceni);
		Vaslui.acoes.add(Iasi);
		
		Iasi.nome = "Iasi";
		Iasi.acoes.add(Neamt);
		Iasi.acoes.add(Vaslui);
		
		Neamt.nome = "Neamt";
		Neamt.acoes.add(Iasi);
		
		Hirsova.nome = "Hirsova";
		Hirsova.acoes.add(Eforie);
		Hirsova.acoes.add(Urziceni);
		
	}
	
	public void iniciarmapa() {
		
		this.mapa.add(Arad);
		this.mapa.add(Zerind);
		this.mapa.add(Timissoara);
		this.mapa.add(Sibiu);
		this.mapa.add(Lugoj);
		this.mapa.add(Oradea);
		this.mapa.add(Fagaras);
		this.mapa.add(Rimnieu_Vilcea);
		this.mapa.add(Bucareste);
		this.mapa.add(Pitesti);
		this.mapa.add(Craiova);
		this.mapa.add(Mehadia);
		this.mapa.add(Dobreta);
		this.mapa.add(Giurgiu);
		this.mapa.add(Urziceni);
		this.mapa.add(Hirsova);
		this.mapa.add(Eforie);
		this.mapa.add(Vaslui);
		this.mapa.add(Iasi);
		this.mapa.add(Neamt);
	}
	
	@Override
	public LinkedList<Estado> funcaoSucessora(Estado estado) {
		return estado.acoes;
	}
	
	@Override
	public boolean testeDeObjetivo (Estado estadoAtual) {
		if (estadoAtual.equals(this.objetivo))
			return true;
		return false;
	}
	
	@Override
	public Estado verificaEstadoInicial (String estadoInicial) {
		for (int i=0; i<mapa.size(); i++) {
			if (estadoInicial.equals(mapa.get(i).nome)) {
				return mapa.get(i);
			}
		}
		System.err.println("Não foi encontrado");
		return null;
	}
	
	@Override
	public Estado verificaObjetivo (String objetivo) {
		for (int i=0; i<mapa.size(); i++) {
			if (objetivo.equals(mapa.get(i).nome)) {
				return mapa.get(i);
			}
		}
		System.err.println("Não foi encontrado");
		return null;
	}

	@Override
	public Estado getEstadoInicial() {
		return this.estadoInicial;
	}

	@Override
	public Estado getObejetivo() {
		return this.objetivo;
	}

	@Override
	public String getNomeEstadoInicial() {
		return this.NomeEstadoInicial;
	}

	@Override
	public String getNomeObjetivo() {
		return this.NomeObjetivo;
	}	
}