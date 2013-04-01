package com.metal.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.metal.ejb.ServiceAdminEJB;
import com.metal.model.Participant;
import com.metal.model.Song;

@WebService
@Stateless
public class Statistics implements StatisticsWs {

	@EJB
	ServiceAdminEJB adminEJB;

	// public List<Participant> getRatingParticipants() {

	@Override
	public Participant getRatingParticipants() {
		System.out.println("WS RatingParticipants");
		return adminEJB.findAllParticipants().get(0);
	}

	@Override
	public List<Song> getRatingSongs() {
		System.out.println("WS RatingSongs");
		return null;
	}

	@Override
	public Participant getRatingPerParticipant(@WebParam Participant participant) {
		System.out.println("WS RatingPerParticipant");
		return null;
	}

	@Override
	public String getCadena() {
		return "TEST";
	}
}
