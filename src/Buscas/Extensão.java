package Buscas;
import java.util.LinkedList;

public class Extensão {
	
	public No no;
	public int profunfidadeGeral = -1;
	
	Inter interfac;
	LinkedList<No> canto = new LinkedList<No>(); 
	LinkedList<Estado> explorados = new LinkedList<Estado>();
	
	public void extensao (Inter problema) {
		
		this.interfac = problema;
		this.canto.add(new No(problema.getEstadoInicial()));
		
		while (true) {
			if (this.canto.isEmpty()) {
				System.err.println("Canto vazio");
				return;
			}
				
			this.no = this.canto.removeFirst();
			no.profundidade = ++profunfidadeGeral;
			explorados.add(no.estado);
									
			if (problema.testeDeObjetivo(no.estado)) {
				mostrarCaminho(no);
				System.out.println("xxxxxxxx");
				System.err.println("Cheguei!");
				System.out.println("xxxxxxxx");
				return;
			}
			
			LinkedList<No> expandidos = expandir(no);
			
			for (int i=0; i<expandidos.size(); i++) {
				if (!this.explorados.contains(expandidos.get(i).estado)) {
					this.canto.addLast(expandir(no).get(i));
				}
			}
		}
		
	}
	
	public LinkedList<No> expandir (No no) {
		
		LinkedList<No> sucessores = new LinkedList<No>();
		
		for (int i=0; i<interfac.funcaoSucessora(no.estado).size(); i++) {
			No s = new No(interfac.funcaoSucessora(no.estado).get(i));
			s.estado = interfac.funcaoSucessora(no.estado).get(i);
			s.pai = no;
			s.acao = interfac.funcaoSucessora(no.estado).get(i);
			s.profundidade = profunfidadeGeral+1;
			sucessores.add(s);
		}
		return sucessores;
	}
	
	public void mostrarCaminho (No no) {
		
		No noAux = no;
		LinkedList<No> caminho = new LinkedList<No>();
				
		while (noAux != null) {
			caminho.addFirst(noAux);
			noAux = noAux.pai;
		}
		
		System.out.println("-----------------------------------");
		System.out.println("Inicio: "+this.interfac.getNomeEstadoInicial());
		System.out.println("Destino: "+this.interfac.getNomeObjetivo());
		System.out.println("-----------------------------------");
		
		for (int i=0; i<caminho.size(); i++) {
			if (i+1<caminho.size()) {
				System.out.println(caminho.get(i).estado.nome+" --> "+caminho.get(i+1).estado.nome);
			}
		}
		System.out.println("Profundidade: "+no.profundidade);
	}
	
	public static void main (String[] args) {
		
		Extensão x = new Extensão();		
		Mapa problema = new Mapa("Arad", "Iasi");
		x.extensao(problema);
		
		
	}

}
