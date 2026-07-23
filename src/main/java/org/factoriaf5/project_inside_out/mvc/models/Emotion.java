package org.factoriaf5.project_inside_out.mvc.models;

public enum Emotion {

    JOY("Alegría"),
    SADNESS("Tristeza"),
    ANGER("Ira"),
    DISGUST("Asco"),
    FEAR("Miedo"),
    ANXIETY("Ansiedad"),
    ENVY("Envidia"),
    SHAME("Vergüenza"),
    BOREDOM("Aburrimiento"),
    NOSTALGIA("Nostalgia");

    private String label;

    private Emotion(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
