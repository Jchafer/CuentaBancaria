
public class CaixerBanc {
	//mètodes
		//private float diners;
		private CompteBancari compteBancari;
		private Semafor semafor;
		private int tempsAccio;
		
		//Constructor
		public CaixerBanc(CompteBancari p_cta, int p_temps, Semafor p_mutex) {
			compteBancari = p_cta;
			//diners = p_diners;
			tempsAccio = p_temps;
			semafor = p_mutex;
		}
		
		void ingressar(float diners) throws InterruptedException {
			System.out.println("Ingressant "+ diners);
			this.compteBancari.ingressa(diners, semafor, tempsAccio);
		}
		
		void treure(float diners) throws InterruptedException {
			System.out.println("Traguent -"+ diners);
			this.compteBancari.treu(diners, semafor, tempsAccio);
		}
		
		void mostrarSaldo() {
			System.out.println("Saldo actual del compte bancari "+ compteBancari.getNomCompteBancari() +": " +compteBancari.carregarSaldo());
		}
		
		
		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			
			Semafor s = new Semafor(1);
			
			CompteBancari cb = new CompteBancari("compteSuissa", 1000);
			
			CaixerBanc c1 = new CaixerBanc(cb, 2, s);
			c1.mostrarSaldo();
			c1.ingressar(100);
			c1.treure(300);
			c1.mostrarSaldo();
			
			CaixerBanc c2 = new CaixerBanc(cb, 2, s);
			c2.mostrarSaldo();
			c2.treure(200);
			c2.ingressar(700);
			c2.mostrarSaldo();
			
			// Prueba
			

		}
}
