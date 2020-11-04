
public class CompteBancari {


	// ATRIBUTS
	private float saldo;
	private String nomCompteBancari;

	// MÈTODES
	//Constructor
	public CompteBancari(String compteBancari, float saldo) {
		this.nomCompteBancari = compteBancari;
		this.saldo = saldo;
	}
	
	public String getNomCompteBancari() {
		return nomCompteBancari;
	}


	public float carregarSaldo() {
		return saldo;
	}

	private void desarSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void ingressa(float diners, Semafor s, int tempsEspera) throws InterruptedException {
		float aux;

		s.sendWait();
		aux = carregarSaldo();
		Thread.sleep(tempsEspera);
		aux = aux + diners;
		saldo = aux;
		desarSaldo(saldo);
		s.sendSignal();
	}

	public void treu(float diners, Semafor s, int tempsEspera) throws InterruptedException {
		float aux;
		s.sendWait();
		aux = carregarSaldo();
		Thread.sleep(tempsEspera);
		aux = aux - diners;
		saldo = aux;
		desarSaldo(saldo);
		s.sendSignal();
	}
}
