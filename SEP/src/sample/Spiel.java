package sample;

import java.util.Date;

public class Spiel {
	private int _iD;
	private int _spielID;
	private Spieler[] _heim;
	private Spieler[] _auswaerts;
	private String[] _ergebnis;
	private Date _aufrufZeit;
	private Spieler _schiedsrichter;
	private Feld _feld;
	private Spielstatus _status;
	public Spieler _unnamed_Spieler_;
	public Feld _unnamed_Feld_;

	public void spielzettelDrucken(int aSpielID) {
		throw new UnsupportedOperationException();
	}

	public void ergebnisEingeben(String[] aErgebnis) {
		throw new UnsupportedOperationException();
	}

	public void spielErstellen(int aSpielID) {
		throw new UnsupportedOperationException();
	}
}