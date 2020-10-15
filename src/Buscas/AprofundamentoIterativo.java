package Buscas;

public class AprofundamentoIterativo{
    
        Inter problema;
	public int profundidade = 0;
	
	public void ProfundidadeIterativa (Inter problema){
		ProfundidadeLimitada x = new ProfundidadeLimitada();
		x.interfac = problema;
		x.buscaEmProfundidadeLimitada(problema, this.profundidade);
		boolean achou = x.encontrou;
		
		while (!achou){ //Roda enquanto não encontrada o destino.
			
			ProfundidadeLimitada aux = new ProfundidadeLimitada();
			aux.buscaEmProfundidadeLimitada(problema, ++this.profundidade);
			achou = aux.encontrou;
			System.gc(); // Coletor de lixo.
		}
	}
	
	public static void main (String[] args){
		
		AprofundamentoIterativo y = new AprofundamentoIterativo();
		Mapa problema = new Mapa("Oradea", "Iasi");
		y.ProfundidadeIterativa(problema);
		
	}
	
}
