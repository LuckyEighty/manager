package herdenmanagement.model;
/**
 * AckerMitSchwarzenLich erben alle Eigenschaften der Klasse {@link Acker}. Er kann also
 * also alles was ein Acker auch kann. AckerMitSchwarzenLöcher können zusätzlich Kühe durch ihre enorme Gravitität fressen.
 * Sie verschwienden damit aus dem derzeitigen Raum-Zeit-Kontinuum und befinden entweder in einer neuen Dimension,
 * haben eine Zeitreise gemacht oder wegitieren in einem Wurmloch vor sich hin.
 *
 * Dies ist wichtig da ich keine Lust habe die ganzen Aktivitäts- und Klassendiagramme des {@link Acker}
 * zu erstellen, da es diese fantastische noch nicht gibt.
 * <p>
 * Es wird sichergestellt, dass die Kuh nicht über den Rand des Ackers hinaus gehen kann.
 * <p>
 * Im Muster Model View Controller sind Objekte dieser Klasse Bestandteil des Model.
 */
public class AckerMitSchwarzemLoch extends Acker {
    /**
     * Erstellt einen neuen Acker und erzeugt die Listen für Gras, Eimer und Rinder.
     *
     * @param spalten Anzahl der Spalten
     * @param zeilen  Anzahl der Zeilen
     */
    public AckerMitSchwarzemLoch(int spalten, int zeilen) {
        super(spalten, zeilen);
    }


    /**
     * Man kann damit Küher vom Acker entfernen und sie aus dem jetztigen Raum-Zeit-Kontinuum verbannen.
     *
     * @param rindvieh Zu prüfende Position
     * @return true, wenn die Kuhentfernt wurd.
     */
    public boolean schwarzesLochfrisstKuh(Rindvieh rindvieh){
        if(getViecher().contains(rindvieh)){
            getViecher().remove(rindvieh);
            informiereBeobachter(PROPERTY_VIECHER, rindvieh, null);
            rindvieh.setzeAcker(null);
            return true;
        }
        return false;
    }
}
