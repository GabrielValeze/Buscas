package Buscas;
import java.util.Collections;
import java.util.LinkedList;

public class Profundidade {
	
	public No no;
	public int profundidadegeral = -1;
	
	Inter interfac;
	
	LinkedList<No> canto = new LinkedList<No>();
	
	public void Profundidade (Inter problema) {
		
		this.interfac = problema;
		this.canto.add(new No(problema.getEstadoInicial()));
		
		while (true) {
			if (this.canto.isEmpty()) {
				System.err.println("Canto não encontrado");
				return;
			}
				
			this.no = this.canto.removeFirst();
			no.profundidade = ++profundidadegeral;
									
			if (problema.testeDeObjetivo(no.estado)) {
				mostrarCaminho(no);
				System.out.println("xxxxxxxx");
				System.err.println("Cheguei!");
				System.out.println("xxxxxxxx");
				return;
			}
			
			for (int i=0; i<expandir(this.no).size(); i++)
				this.canto.addFirst(expandir(no).get(i));
		}
		
	}
	
	public LinkedList<No> expandir (No no) {
		
		LinkedList<No> sucessores = new LinkedList<No>();
		
		for (int i=0; i<interfac.funcaoSucessora(no.estado).size(); i++) {
			No s = new No(interfac.funcaoSucessora(no.estado).get(i));
			s.estado = interfac.funcaoSucessora(no.estado).get(i);
			s.pai = no;
			s.acao = interfac.funcaoSucessora(no.estado).get(i);
			s.profundidade = profundidadegeral+1;
			sucessores.addFirst(s);
		}
		Collections.shuffle(sucessores); 
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
				System.out.println(caminho.get(i).estado.nome+" --> "+caminho.get(i+1).estado.nome);
			}
		}		
		System.out.println("Profundidade: "+caminho.size());
	}
	
	public static void main(String[] args) {
		
		Profundidade agente = new Profundidade();		
		Mapa problema = new Mapa("Arad", "Bucareste");
		agente.Profundidade(problema);
	}
	
}
