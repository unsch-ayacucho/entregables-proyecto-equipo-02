package app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="detalle_pedido")
public class Detalle_Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_detalle_pedido;
	private int cantidad;
	private String fecha;
	
	private Pedido pedido;
	private Producto producto;
	
	@Id
	@Column(name="id_detalle_pedido", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_detalle_pedido() {
		return id_detalle_pedido;
	}
	public void setId_detalle_pedido(int id_detalle_pedido) {
		this.id_detalle_pedido = id_detalle_pedido;
	}
	
	@Column(name="cantidad",length=50)
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Column(name="fecha")
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	@JsonIgnoreProperties({"detalle_pedido","hibernateLazyInitializer","handler"})
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_pedido")
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties(value={"detalle_pedido","hibernateLazyInitializer","handler"}, allowSetters=true)
	@JoinColumn(name = "id_producto")
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
