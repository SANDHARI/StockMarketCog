package com.stock.market.company.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "company")
//@Getter
//@Setter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Company code can not be null or empty")
    private String code;

    @NotBlank(message = "Company name can not be null or empty")
    private String name;

    @NotBlank(message = "CEO name can not be null or empty")
    private String ceo;

    @DecimalMin(value = "10.0", inclusive = false, message = "Company turnover should be greater than 10Cr")
    private BigDecimal turnover;

    @NotBlank(message = "Website can not be null or empty")
    private String website;

    @NotBlank(message = "Stock Exchange can not be null or empty")
    private String stockExchange;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public BigDecimal getTurnover() {
		return turnover;
	}

	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(int id, @NotBlank(message = "Company code can not be null or empty") String code,
			@NotBlank(message = "Company name can not be null or empty") String name,
			@NotBlank(message = "CEO name can not be null or empty") String ceo,
			@DecimalMin(value = "10.0", inclusive = false, message = "Company turnover should be greater than 10Cr") BigDecimal turnover,
			@NotBlank(message = "Website can not be null or empty") String website,
			@NotBlank(message = "Stock Exchange can not be null or empty") String stockExchange, Date createdDate,
			Date updatedDate) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.ceo = ceo;
		this.turnover = turnover;
		this.website = website;
		this.stockExchange = stockExchange;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
    
    
    
    

}
