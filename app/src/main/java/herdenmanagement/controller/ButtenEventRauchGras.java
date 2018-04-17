package herdenmanagement.controller;


import herdenmanagement.model.RindMitRichtungsSinn;


/**
 *ButtonEventGebeMilch erben alle Eigenschaften der Klasse {@link ButtonEvent}.
 *
 * Es überlädt die Methode {@link ButtonEvent#eventRindVieh()} und führt weiter Aktion aus
 * welche mit dem {@link ButtonEvent#rindVieh} gemacht werden sollen.
 */

public class ButtenEventRauchGras extends ButtonEvent {

    /**
     * Setzt das Rindviehs wobei es den geerbeten Constructor aufruft.
     *
     * @param rindVieh mit welcher eine Aktion getätigt wird.
     */
    public ButtenEventRauchGras(RindMitRichtungsSinn rindVieh){ super(rindVieh); }

    /**
     * Überlädt die Methode {@link ButtonEvent#eventRindVieh()} aus der geerbten Klasse {@link ButtonEvent}.
     * und lässt das Rind Grass rauchen.
     */
    @Override
    public void eventRindVieh() { this.rindVieh.raucheGras(); }
}
