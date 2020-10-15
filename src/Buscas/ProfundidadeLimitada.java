package Buscas;
import java.util.LinkedList;


public class ProfundidadeLimitada {
	
	public No no;
	public int profunfidadeGeral = -1;
	public boolean encontrou = false;
	
	Inter interfac;
	LinkedList<No> borda = new LinkedList<No>();
	LinkedList<Estado> explorados = new LinkedList<Estado>();
	
	public void buscaEmProfundidadeLimitada (Inter problema, int maxProfundidade) {
		
		this.interfac = problema;
		this.borda.add(new No(problema.getEstadoInicial()));
		
		while (true) {
			if (this.borda.isEmpty()) {
				this.encontrou = false;
				System.err.println("Canto não encontrado");
				return;
			}
				
			this.no = this.borda.removeFirst();
			no.profundidade = ++profunfidadeGeral;
			explorados.add(no.estado);
			
		
			if (this.no.profundidade == maxProfundidade) {
				this.encontrou = false;
				mostrarCaminho(no);
				return;
			}
			
			if (problema.testeDeObjetivo(no.estado)) {
				this.encontrou = true;
				mostrarCaminho(no);
				System.out.println("xxxxxxxxxxxxxxxxxxxxx");
				System.err.println("Cheguei!");
				System.out.println("xxxxxxxxxxxxxxxxxxxxx");
				return;
			}
			
			LinkedList<No> expandidos = expandir(no);
			
			for (int i=0; i<expandidos.size(); i++)
				if (!this.explorados.contains(expandidos.get(i).estado)) {
					this.borda.addFirst(expandir(no).get(i));
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
			sucessores.addFirst(s);
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
		System.out.println("xxxxxxxxxxxxxxx");
		System.out.println("Inicio: "+this.interfac.getNomeEstadoInicial());
		System.out.println("Destino: "+this.interfac.getNomeObjetivo());
		System.out.println("xxxxxxxxxxxxxxx");
		for (int i=0; i<caminho.size(); i++) {
			if (i+1<caminho.size()) {
				System.out.println(caminho.get(i).estado.nome+" --> "+caminho.get(i+1).estado.nome);
			}
		}
		System.out.println("Profundidade: "+no.profundidade);

		
	}
	
	public static void main (String[] args) {
		
		ProfundidadeLimitada agente = new ProfundidadeLimitada();
		Mapa problema = new Mapa("Arad", "Bucareste");		
		agente.buscaEmProfundidadeLimitada(problema, 10);

		
	}

}
