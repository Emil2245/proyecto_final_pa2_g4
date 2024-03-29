package com.uce.edu.avanzada.budget_rent_a_car.repository.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "factura")
public class Factura {

	@Id
	@SequenceGenerator(name = "seq_factura", sequenceName = "seq_factura", allocationSize = 1)
	@GeneratedValue(generator = "seq_factura", strategy = GenerationType.SEQUENCE)
	@Column(name = "fact_id")
	private Integer id;

	@Column(name = "fact_iva")
	private BigDecimal iva;

	@Column(name = "fact_subtotal")
	private BigDecimal subtotal;

	@Column(name = "fact_total")
	private BigDecimal total;

	@Column(name = "fact_num_tarjeta")
	private String numTarjeta;

	@OneToOne(mappedBy = "factura")
	private Reserva reserva;

	@Override
	public String toString() {
		return "Factura{" +
				"id=" + id +
				", iva=" + iva +
				", subtotal=" + subtotal +
				", total=" + total +
				", numTarjeta='" + numTarjeta + '\'' +
				", reserva=" + reserva +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}
