package javafx.bestenliste;

public class Rekord {


    private int Platz;
    private String Zeit;
    private String Spieler;
    private String Datum;

    Rekord(Integer platz, String zeit, String name, String datum) {
        this.Platz = platz;
        this.Zeit = zeit;
        this.Spieler = name;
        this.Datum = datum;
    }

    public int getPlatz() {
        return Platz;
    }

    public void setPlatz(int platz) {
        Platz = platz;
    }

    public String getSpieler() {
        return Spieler;
    }

    public void setSpieler(String fName) {
        Spieler = fName;
    }

    public String getZeit() {
        return Zeit;
    }

    public void setZeit(String fZeit) {
        Zeit = fZeit;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String fDatum) {
        Datum = fDatum;
    }


}
