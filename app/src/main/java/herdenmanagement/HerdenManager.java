package herdenmanagement;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import de.ba.herdenmanagement.R;
import herdenmanagement.controller.ButtenEventFressGrass;
import herdenmanagement.controller.ButtenEventRauchGras;
import herdenmanagement.controller.ButtonEventGebeMilch;
import herdenmanagement.controller.ButtonEventGeheHoch;
import herdenmanagement.controller.ButtonEventGeheLinks;
import herdenmanagement.controller.ButtonEventGeheRechts;
import herdenmanagement.controller.ButtonEventGeheRunter;
import herdenmanagement.controller.ButtonEventOnOffRind;
import herdenmanagement.model.Acker;
import herdenmanagement.model.Position;
import herdenmanagement.model.Rindvieh;
import herdenmanagement.model.*;
import herdenmanagement.view.AckerView;

/**
 * Die Klasse dient der Orginisation von Rinderherden. Hierzu werden auf einem {@link Acker}
 * Objekte der Klase {@link herdenmanagement.model.Eimer} und {@link herdenmanagement.model.Gras}
 * positioniert. Objekte der Klasse {@link Rindvieh} könen sich auf einem Acker bewegen
 * und das Gras fressen oder rauchen. Steht auf der aktuellen Position einer Kuh ein Eimer,
 * kann diese auch gemolken werden.
 * <p>
 * Mit einer {@link AckerView} wird ein erzeugter Acker auch grafisch angezeigt.
 * Auf diesem können Instanzen von {@link Rindvieh}, {@link herdenmanagement.model.Eimer} und
 * {@link herdenmanagement.model.Gras} eingefügt werden.
 * <p>
 * Im Muster Model View Controller (MVC) entsprechen Objekte dieser Klasse dem Controller.
 * {@link Acker}, {@link Rindvieh}, {@link herdenmanagement.model.Eimer} und
 * {@link herdenmanagement.model.Gras} bilden im MVC Muster das Model. Im Muster Observer
 * stellen sie die beobachtbaren Objekte dar. Die eigentliche grafische Darstellung des Models
 * erfolgt in den View-Klassen des MVC Musters (also zum Beispiel in der Klasse
 * {@link herdenmanagement.view.RindviehView}. Diese View-Klassen sind gleichzeit Beobachter
 * gemäß des Observer Muster. Wenn man also Veränderungen an einer Kuh vornimmt, wird diese
 * Ihre Beaobachter informieren und diese passen ihre grafische Darstellung an.
 * <p>
 * Die Klasse verknüpft im Wesentlichen einen {@link Acker} (= Model im MVC Muster) mit seiner
 * {@link AckerView} (= View im MVC Muster). Da sie diese und andere Vorgänge
 * (insbesondere Änderungen auf Acker) organisiert, ist sie der Controller im MVC Muster.
 */
public class HerdenManager {

    /**
     * Acker, auf dem nach Herzenslust geackert werden kasnn.
     */
    private AckerMitSchwarzemLoch acker;

    /**
     * Rindvieh, dass wirklich gern auf dem Acker steht und lustige Geräusche macht.
     */
    private RindMitRichtungsSinn vera;

    /**
     * Aufruf zur Erzeugung eines HerdenManagers.
     * Diese Methode lässt zum Beispiel Gras wachsen und stellt Eimer auf.
     * Die Einrichtung des Ackers wird nicht animiert dargestellt.
     *
     * @param mainActivity Hauptaktivität der App
     */
    public void richteAckerEin(MainActivity mainActivity) {
        // Die View, die die Acker Elememnte anzeigen kann, wird in der Datei
        // res/activity_main.xml optisch ausgerichtet und in der App platziert
        AckerView ackerView = (AckerView) mainActivity.findViewById(R.id.acker_view);

        // Acker erzeugen
        acker = new AckerMitSchwarzemLoch(5, 7);

        // AckerView mit Acker verknüpfen
        ackerView.setAcker(acker);

        // Acker befüllen
        acker.lassGrasWachsen(new Position(1, 1));
        acker.stelleEimerAuf(new Position(2, 2));
        acker.lassGrasWachsen(new Position(2, 4));
        acker.lassGrasWachsen(new Position(2, 5));
        acker.lassGrasWachsen(new Position(3, 2));
        acker.lassGrasWachsen(new Position(3, 4));
    }

    /**
     * Hier wird eine Herde gemanagt. Und zwar professionell. Das bedeutet vor allem,
     * dass Rinder bewegt und zum Fressen angehalten werden. Natürlich können Sie danach
     * Milch geben!
     * <p>
     * Die Aktionen dieser Methoden werden animiert und nacheinander dargestellt. Man kann in der
     * App also die Reihenfolge der Aktionen sehen (anders als die Aktionen in
     * {@link #richteAckerEin(MainActivity)}.
     *
     * @param mainActivity Hauptaktivität
     */
    public void manageHerde(final MainActivity mainActivity) {
        vera = new RindMitRichtungsSinn("Vera Vollmilch");



        Button btnRindOnOff = (Button) mainActivity.findViewById(R.id.buttonOnOffRind);
        btnRindOnOff.setOnClickListener(new ButtonEventOnOffRind(vera, acker));


        ImageButton btnGeheRechts = (ImageButton) mainActivity.findViewById(R.id.imageButtonRight);
        btnGeheRechts.setOnClickListener(new ButtonEventGeheRechts(vera));

        ImageButton btnGeheLinks = (ImageButton) mainActivity.findViewById(R.id.imageButtonLeft);
        btnGeheLinks.setOnClickListener(new ButtonEventGeheLinks(vera));

        ImageButton btnGeheHoch = (ImageButton) mainActivity.findViewById(R.id.imageButtonUp);
        btnGeheHoch.setOnClickListener(new ButtonEventGeheHoch(vera));

        ImageButton btnGeheRunter = (ImageButton) mainActivity.findViewById(R.id.imageButtonDown);
        btnGeheRunter.setOnClickListener(new ButtonEventGeheRunter(vera));

        Button btnRauchGras = (Button) mainActivity.findViewById(R.id.buttonRauchGras);
        btnRauchGras.setOnClickListener(new ButtenEventRauchGras(vera));

        Button btnFressGras = (Button) mainActivity.findViewById(R.id.buttonFresseGras);
        btnFressGras.setOnClickListener(new ButtenEventFressGrass(vera));

        Button btnGebeMilch = (Button) mainActivity.findViewById(R.id.buttonGebeMilch);
        btnGebeMilch.setOnClickListener(new ButtonEventGebeMilch(vera));
    }
}
