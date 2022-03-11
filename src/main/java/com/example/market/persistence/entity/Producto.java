package com.example.market.persistence.entity;

import javax.persistence.*;

@Entity //Clase que mapea
@Table(name= "productos")
public class Producto {

    @Id //Llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Se crea una mas por producto
    @Column(name = "id_producto") //Como se llama diferente en la BD, se tiene que definir
    private Integer idProducto;

    private String nombre; //Como no se cambia, no se necesita column

    @Column(name="id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false) //Mediante esto, no se actualizan ni
    //insertan categorias
    private  Categoria categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
