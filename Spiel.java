import java.awt.EventQueue;

public class Spiel {
	
	private GUI gui;
	private TimerClass timer;
	private Figur figur;
	private Pfeil[] pfeil;
	private BallFeld ballFeld;

	private boolean geladen;
	private int pfeilNr;
	private int score;
	
	public static void main(String[] args) {
		new Spiel();
	}
	
	public Spiel() {
		Spiel spiel = this;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui = new GUI(1050,600,spiel);
					gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		timer = new TimerClass(spiel);
		timer.einstellen(20);
		figur = new Figur(100, 120, 150);
		ballFeld = new BallFeld();
		pfeil = new Pfeil[10];
		for(int i=0;i<pfeil.length;i++) {
			pfeil[i] = new Pfeil(50, 400+10*i);
		}
	}
	
	public void empfZeitereignis() {
		verwalteBaelle();
		bewegePfeile();
		aktualisiereBild();
	}
	
	private void verwalteBaelle() {
		int z;
		z = (int) (Math.random()*500);
		
		if(z % 20 == 0) {
			ballFeld.starteBall(z);
			score += ballFeld.bewegeBaelle();
		}
	}
	
	public void starteNeuesSpiel() {
		
	}
	
	public void laden() {
		
	}
	
	public void schliessen() {
		
	}
	
	public void auf_Figur() {
		figur.auf();
	}
	
	public void ab_Figur() {
		figur.ab();
	}
	
	private void aktualisiereBild() {
		
	}
	
	private void bewegePfeile() {
		pfeil[pfeilNr].bewegen();
		ballFeld.pruefeTreffer(pfeil[pfeilNr].getPosX(), pfeil[pfeilNr].getPosY());
	}
}
