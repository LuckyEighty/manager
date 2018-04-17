package herdenmanagement.controller;

import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import herdenmanagement.model.Acker;
import herdenmanagement.model.AckerMitSchwarzemLoch;
import herdenmanagement.model.Position;
import herdenmanagement.model.RindMitRichtungsSinn;

/**
 *
 * ButtonEventOnOffRind implementier das Interface {@link View.OnClickListener}.
 * Sie überlädt die {@link View.OnClickListener#onClick(View)} und lässt RindVieh von einen Acker
 * verschwienden.

 * Es besitz ein Attribut {@link #rindVieh} des Typs {@link RindMitRichtungsSinn}
 * und {@link #acker} des Typs {@link AckerMitSchwarzemLoch}
 */
public class ButtonEventOnOffRind implements View.OnClickListener {
    RindMitRichtungsSinn rindVieh;
    AckerMitSchwarzemLoch acker;

    /**
     * Hier wird das Rindvieh und Acker gesetz.
     * @param rindVieh
     * @param acker
     */
    public ButtonEventOnOffRind(RindMitRichtungsSinn rindVieh, AckerMitSchwarzemLoch acker) {
        this.rindVieh = rindVieh;
        this.acker = acker;
    }

    /**
     *Hier wird {@link View.OnClickListener#onClick(View)}  Methode aus dem {@link View.OnClickListener} überladen.
     * <p>
     * Es wird überprüft ob der Button ein Instane von {@link ToggleButton} ist.
     * danach geschaut ob der Button Aktiviert wurde und setzt das Rind auf dem Acker
     * oder Entfernt es.
     */
    @Override
    public void onClick(View v) {
        if(v instanceof ToggleButton){
            if(((ToggleButton) v).isChecked()){
                acker.lassRindWeiden(rindVieh);
                rindVieh.setzePosition(new Position(0,0));
            } else {
                if(acker.getViecher().contains(rindVieh)){
                    acker.schwarzesLochfrisstKuh(rindVieh);
                }
            }
        }
    }
}
