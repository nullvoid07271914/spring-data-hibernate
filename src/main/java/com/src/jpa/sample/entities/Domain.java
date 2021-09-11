package com.src.jpa.sample.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass
public class Domain {

	@CreationTimestamp
	@Column(name = "DATE_SAVED", updatable = false)
	private LocalDate dateSaved;

	@CreationTimestamp
	@Temporal(TemporalType.TIME)
	@Column(name = "TIME_SAVED", updatable = false)
	private Date timeSaved;

	public LocalDate getDateSaved() {
		return dateSaved;
	}

	public void setDateSaved(LocalDate dateSaved) {
		this.dateSaved = dateSaved;
	}

	public Date getTimeSaved() {
		return timeSaved;
	}

	public void setTimeSaved(Date timeSaved) {
		this.timeSaved = timeSaved;
	}

}
