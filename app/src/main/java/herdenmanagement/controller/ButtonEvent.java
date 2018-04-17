package herdenmanagement.controller;
import android.view.View;

import herdenmanagement.model.RindMitRichtungsSinn;


/**
 *
 * ButtonEvent ist eine abstrakte Klasse und implementier das Interface {@link View.OnClickListener}.
 * Sie überlädt die {@link View.OnClickListener#onClick(View)} und schaut ob eine RindVieh einen Acker hat
 * und führt dann das eigentliche Event eines Buttons aus. Sie dient somit nur als Vorlage für
 * Erbente Klassen
 *<p>
 *Desweiteren enthält sie eine abstrakte Methode die in den Erbenten Klassen überschrieben wird.
 *<p>
 * Es besitz ein Attribut {@link #rindVieh} des Typs {@link RindMitRichtungsSinn}
 */
public abstract class ButtonEvent implements View.OnClickListener{

    /**
     *Rindvieh mit welchem geschaut wird ob es ein Acker hat, sowie später Aktion mit ausgeführt werden
     */
    RindMitRichtungsSinn rindVieh;

    /**
     * Hier wird das Rindvieh gesetz.
     * @param rindVieh
     */
    public ButtonEvent(RindMitRichtungsSinn rindVieh){ this.rindVieh = rindVieh; }

    public abstract void eventRindVieh();

    /**
     *Hier wird {@link View.OnClickListener#onClick(View)}  Methode aus dem {@link View.OnClickListener} überladen.
     * <p>
     * Es wird überprüft ob das {@link #rindVieh} einen Acker hat.
     * Die eigentlich Überprüfung findet hier statt {@link RindMitRichtungsSinn#hatAcker()}
     *
     * Danach wird das Eigentliche Buttonevent ausgeführt.
     */
    @Override
    public void onClick(View v) {
        if(rindVieh.hatAcker()){
            eventRindVieh();
        }
    }
}
