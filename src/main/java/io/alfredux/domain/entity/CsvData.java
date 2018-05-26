package io.alfredux.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "csvdata")
public class CsvData {

	@Id
	@Column(name="id")
	private String id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="accessToken")
	private String accessToken;
	
}
