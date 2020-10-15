package Buscas;
import java.util.LinkedList;

public class CustoUniforme{
	
	public No no;
	public int profundidadegeral = -1;
	Inter interfac;
	LinkedList<No> canto = new LinkedList<No>();
	LinkedList<Estado> visitados = new LinkedList<Estado>();
	
	public void CustoUniforme (Inter interfac) {
		
		this.interfac = interfac;
		this.canto.add(new No(interfac.getEstadoInicial()));
		
		while (true) {
			if (this.canto.isEmpty()) {
				System.err.println("Canto vazia");
				return;
			}

			this.no = this.canto.removeFirst();
			no.profundidade = ++profundidadegeral;
			visitados.add(no.estado);
			
			if (interfac.testeDeObjetivo(no.estado)) {
				mostrarCaminho(no);
				System.out.println("----------");
				System.err.println("Cheguei");
				System.out.println("----------");
				return;
			}
			
			LinkedList<No> expandidos = expandir(no);
			
			for (int i=0; i<expandidos.size(); i++) {
				if (!this.visitados.contains(expandidos.get(i).estado)) {
					this.canto.addFirst(expandir(no).get(i));
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
			s.profundidade = no.profundidade+1;
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
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("Inicio: "+this.interfac.getNomeEstadoInicial());
		System.out.println("Destino: "+this.interfac.getNomeObjetivo());
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		for (int i=0; i<caminho.size(); i++) {
			if (i+1<caminho.size()) {
				System.out.println(caminho.get(i).estado.nome+" =>> "+caminho.get(i+1).estado.nome);
			}
		}
		System.out.println("Profundidade: "+no.profundidade);
		
	}
	
	public static void main(String[] args) {
		
		CustoUniforme agente = new CustoUniforme();
		
		Mapa problema = new Mapa("Eforie", "Oradea");
				
		agente.CustoUniforme(problema);
	}

}
