package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the participant database table.
 * 
 */
@Entity
public class Participant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_participat")
	private int idParticipat;

	private int age;

	private String gender;

	private String name;

	private String password;

	private int phone;

	private String username;

	//bi-directional many-to-one association to Presentation
	@OneToMany(mappedBy="participant")
	private List<Presentation> presentations;

	//bi-directional many-to-one association to ScoreMatrix
	@OneToMany(mappedBy="participant")
	private List<ScoreMatrix> scoreMatrixs;

	public Participant() {
	}

	public int getIdParticipat() {
		return this.idParticipat;
	}

	public void setIdParticipat(int idParticipat) {
		this.idParticipat = idParticipat;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Presentation> getPresentations() {
		return this.presentations;
	}

	public void setPresentations(List<Presentation> presentations) {
		this.presentations = presentations;
	}

	public Presentation addPresentation(Presentation presentation) {
		getPresentations().add(presentation);
		presentation.setParticipant(this);

		return presentation;
	}

	public Presentation removePresentation(Presentation presentation) {
		getPresentations().remove(presentation);
		presentation.setParticipant(null);

		return presentation;
	}

	public List<ScoreMatrix> getScoreMatrixs() {
		return this.scoreMatrixs;
	}

	public void setScoreMatrixs(List<ScoreMatrix> scoreMatrixs) {
		this.scoreMatrixs = scoreMatrixs;
	}

	public ScoreMatrix addScoreMatrix(ScoreMatrix scoreMatrix) {
		getScoreMatrixs().add(scoreMatrix);
		scoreMatrix.setParticipant(this);

		return scoreMatrix;
	}

	public ScoreMatrix removeScoreMatrix(ScoreMatrix scoreMatrix) {
		getScoreMatrixs().remove(scoreMatrix);
		scoreMatrix.setParticipant(null);

		return scoreMatrix;
	}

}