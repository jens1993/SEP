package sample;
import java.util.Date;
import java.util.Timer;
import java.util.Vector;

public class Spieler {
	private int _iD;
	private String _vName;
	private String _nName;
	private String _gDatum;
	private int _spielerID;
	private java.util.Vector<Spielklasse[]> _spielklasse;
	private java.util.Vector<int[]> _ranglistenpunkte;
	private char _geschlecht;
	private Verein _verein;
	private float _meldeGebuehren;
	private int _anzahlSiege = 0;
	private int _anzahlNiederlagen = 0;
	private int _gewonneneSaetze = 0;
	private int _verloreneSaetze = 0;
	private int _erspieltePunkte = 0;
	private int _zugelassenePunkte = 0;
	private Timer _verfuegbar;
	private int _mattenSpiele = 0;
	private int _extSpielerID;
	private int _aktuellesSpiel;
	public Vector<Spielklasse> _unnamed_Spielklasse_ = new Vector<Spielklasse>();
	public Vector<Spiel> _unnamed_Spiel_ = new Vector<Spiel>();
	public Verein _unnamed_Verein_;


	//agDatum muss noch auf Date geändert werden, Jens , int aRanglistenpunkte

	public static void spielerHinzufuegen(String aVName, String aNName, String aGDatum, int aSpielerID, int rang_re, int rang_rd,int rang_rm, boolean rm, boolean rw) {


		System.out.println("Klappt");
		System.out.println("Vorname: "+aVName+""+" Nachname: "+aNName+""+" GD: "+aGDatum+""+" Spielerid: "+aSpielerID+""+" Mann: "+rm+" Frau"+rw+"Punkte"+rang_re+"-"+rang_rd+"-"+rang_rm);
	}

	public void spielerLoeschen(int aSpielerID) {
		throw new UnsupportedOperationException();
	}

	public void spielerBearbeiten(Object aSpielerID) {
		throw new UnsupportedOperationException();
	}

	public void meldeFormularimportieren() {
		throw new UnsupportedOperationException();
	}

	public static void spielerHinzufueger() {
	}
}