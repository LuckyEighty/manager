package herdenmanagement.model;

/**
 * RindMitRichtungsSinn erben alle Eigenschaften der Klasse {@link Rindvieh}. Sie können sich also
 * genauso auf einem Acker bewegen.
 * <p>
 * RindeRMitRichtungsSinn können zusätzlich die Richtung setzen.
 * Dies ist wichtig da ich keine lust habe die ganzen Aktivitäts und Klassendiagramme des Rindviehs
 * zu erstellen, da die eigentlichen Methode {@link Rindvieh#setRichtung(RichtungsTyp)} im RindVieh unverständlicherweise protectet gesetz wurde.
 * <p>
 * RindeRMitRichtungsSinn können zusätzlich schauen ob sie einen Acker haben.
 * Dies ist wichtig da ich keine Lust habe die ganzen Aktivitäts- und Klassendiagramme des Rindviehs
 * zu erstellen, da die eigentlichen Methode {@link Rindvieh#gibAcker()} im RindVieh unverständlicherweise protectet gesetz wurde.
 * <p>
 * Es wird sichergestellt, dass die Kuh nicht über den Rand des Ackers hinaus gehen kann.
 * <p>
 * Im Muster Model View Controller sind Objekte dieser Klasse Bestandteil des Model.
 */
public class RindMitRichtungsSinn extends Rindvieh {
    /**
     * Setzt den Namen des Rindviehs, setzt den Status {@link StatusTyp#WARTET} und ruft
     * den geerbeten Constructor auf. Initial wird die Kuh zur Morgensonne ausgerichtet.
     *
     * @param name Name der Kuh
     */
    public RindMitRichtungsSinn(String name) {
        super(name);
    }


    /**
     * Setz die neue Bildrichtung in welche die Kuh schauen soll.
     * Dies ist eigentlich so nicht möglich da diese Funktion Protectet ist.
     * Die Eigentliche Ausführung erfolg durch {@link Rindvieh#setRichtung(RichtungsTyp)}
     *
     * @param richtung Richtung der Kuh
     */
    public void setRichtung(RichtungsTyp richtung){
        super.setRichtung(richtung);
    }

    /**
     * Prüft Prüft ob die Kuh einen Acker hat.
     *
     * Die Eigentliche Prüfung erfolg durch {@link Rindvieh#gibAcker()}
     *
     * @return true or false
     */
    public boolean hatAcker(){
        return gibAcker() != null;
    }

}
