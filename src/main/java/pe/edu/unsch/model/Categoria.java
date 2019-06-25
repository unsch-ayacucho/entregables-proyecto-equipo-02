package pe.edu.unsch.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="categoria")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_categoria;
	private String nombre;
	private int estado;
	private int subcategoria;
	
	private List<Producto> producto;
	
	private List<Categoria> listar_categoria;

	public Categoria() {
		this.producto = new ArrayList<>();
	}

	
	@Id
	@Column(name="id_categoria",unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	@Column(name="nombre",length=50)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name="estado")
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Column(name="subcategoria")
	public int getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(int subcategoria) {
		this.subcategoria = subcategoria;
	}

	@JsonIgnoreProperties(value={"categoria","hibernateLazyInitializer","handler"}, allowSetters=true)
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.ALL)
	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	@OneToMany
	@JoinColumn(name = "subcategoria", referencedColumnName = "id_categoria")
	public List<Categoria> getListar_categoria() {
		return listar_categoria;
	}

	public void setListar_categoria(List<Categoria> listar_categoria) {
		this.listar_categoria = listar_categoria;
	}
	
	
}
