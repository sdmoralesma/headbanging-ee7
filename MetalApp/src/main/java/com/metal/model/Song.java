package com.metal.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

/**
 * The persistent class for the song database table.
 * 
 */
@Entity
@Table(name = "song")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Song.findAll", query = "SELECT s FROM Song s"),
		@NamedQuery(name = "Song.findByIdSong", query = "SELECT s FROM Song s WHERE s.idSong = :idSong"),
		@NamedQuery(name = "Song.findByTitle", query = "SELECT s FROM Song s WHERE s.title = :title"),
		@NamedQuery(name = "Song.findByIdArtist", query = "SELECT s FROM Song s WHERE s.idArtist = :idArtist"),
		@NamedQuery(name = "Song.findByIdGender", query = "SELECT s FROM Song s WHERE s.idGender = :idGender") })
public class Song implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_song", unique = true, nullable = false)
	private int idSong;

	@Column(name = "id_artist", nullable = false)
	private int idArtist;

	@Column(name = "id_gender", nullable = false)
	private int idGender;

	@Column(nullable = false, length = 100)
	private String title;

	// bi-directional many-to-one association to Presentation
	@OneToMany(mappedBy = "song")
	private List<Presentation> presentations;

	// bi-directional many-to-one association to Artist
	@ManyToOne
	@JoinColumn(name = "id_artist1")
	private Artist artist;

	// bi-directional many-to-one association to Gender
	@ManyToOne
	@JoinColumn(name = "id_gender1")
	private Gender gender;

	// bi-directional many-to-one association to SongMatrix
	@OneToMany(mappedBy = "song")
	private List<SongMatrix> songMatrixs;

	public Song() {
	}

	public int getIdSong() {
		return this.idSong;
	}

	public void setIdSong(int idSong) {
		this.idSong = idSong;
	}

	public int getIdArtist() {
		return this.idArtist;
	}

	public void setIdArtist(int idArtist) {
		this.idArtist = idArtist;
	}

	public int getIdGender() {
		return this.idGender;
	}

	public void setIdGender(int idGender) {
		this.idGender = idGender;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Presentation> getPresentations() {
		return this.presentations;
	}

	public void setPresentations(List<Presentation> presentations) {
		this.presentations = presentations;
	}

	public Presentation addPresentation(Presentation presentation) {
		getPresentations().add(presentation);
		presentation.setSong(this);

		return presentation;
	}

	public Presentation removePresentation(Presentation presentation) {
		getPresentations().remove(presentation);
		presentation.setSong(null);

		return presentation;
	}

	public Artist getArtist() {
		return this.artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<SongMatrix> getSongMatrixs() {
		return this.songMatrixs;
	}

	public void setSongMatrixs(List<SongMatrix> songMatrixs) {
		this.songMatrixs = songMatrixs;
	}

	public SongMatrix addSongMatrix(SongMatrix songMatrix) {
		getSongMatrixs().add(songMatrix);
		songMatrix.setSong(this);

		return songMatrix;
	}

	public SongMatrix removeSongMatrix(SongMatrix songMatrix) {
		getSongMatrixs().remove(songMatrix);
		songMatrix.setSong(null);

		return songMatrix;
	}

	@Override
	public String toString() {
		return "Song [idSong=" + idSong + ", idArtist=" + idArtist + ", idGender=" + idGender + ", title=" + title
				+ ", presentations=" + presentations + ", artist=" + artist + ", gender=" + gender + ", songMatrixs="
				+ songMatrixs + "]";
	}
	
	

}