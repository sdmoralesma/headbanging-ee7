package com.smorales.headbanging.presentation.model;

import com.smorales.headbanging.business.entity.Participant;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ParticipantModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Participant participant;

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
