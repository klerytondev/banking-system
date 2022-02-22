package br.com.kleryton.bankingsystem.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data

@Table(name = "TB_ACCOUNT")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nameOwner;
	@Column(nullable = false, unique = true)
	private Integer agencyCode;
	@Column(nullable = false, unique = true)
	private Integer accountCode;
	@Column(nullable = false, length = 1)
	private Integer verificationDigital;
	@Column(nullable = false, unique = true)
	private String register_id;
	@Column(nullable = false)
	private Cards card;

}
