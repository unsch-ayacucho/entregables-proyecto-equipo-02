package app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="pedido")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id_pedido;
	
	private Cliente cliente;
	
	private List<Detalle_Pedido> detalle_pedido;

	public Pedido() {
		this.detalle_pedido = new ArrayList<>();
	}
	
	@Id
	@Column(name="id_pedido",unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties(value={"pedido","hibernateLazyInitializer","handler"}, allowSetters=true)
	@JoinColumn(name = "id_cliente")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@JsonIgnoreProperties(value={"pedido","hibernateLazyInitializer","handler"}, allowSetters=true)
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "pedido", cascade = CascadeType.ALL)
	public List<Detalle_Pedido> getDetalle_pedido() {
		return detalle_pedido;
	}

	public void setDetalle_pedido(List<Detalle_Pedido> detalle_pedido) {
		this.detalle_pedido = detalle_pedido;
	}

	

	
	
}
