package herdenmanagement.controller;

import android.view.View;

import herdenmanagement.model.RindMitRichtungsSinn;
import herdenmanagement.model.Rindvieh;


/**
 *ButtonEventGebeMilch erben alle Eigenschaften der Klasse {@link ButtonEvent}.
 *
 * Es überlädt die Methode {@link ButtonEvent#eventRindVieh()} und führt weiter Aktion aus
 * welche mit dem {@link ButtonEvent#rindVieh} gemacht werden sollen.
 */
public class ButtonEventGeheRunter extends ButtonEvent {


    /**
     * Setzt das Rindviehs wobei es den geerbeten Constructor aufruft.
     *
     * @param rindVieh mit welcher eine Aktion getätigt wird.
     */
    public ButtonEventGeheRunter(RindMitRichtungsSinn rindVieh) { super(rindVieh); }

    /**
     * Überlädt die Methode {@link ButtonEvent#eventRindVieh()} aus der geerbten Klasse {@link ButtonEvent}.
     * und lässt das Rind sich nach Süden drehen und danach ein Feld nach vorn.
     */
    @Override
    public void eventRindVieh() {
        this.rindVieh.setRichtung(Rindvieh.RichtungsTyp.SUED);
        this.rindVieh.geheVor();
    }

}
