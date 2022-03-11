package com.example.market.persistence.entity;

import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "compras")
public class Compra {

    @Id //Llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Se crea una mas por producto
    @Column(name = "id_compra") //Como se llama diferente en la BD, se tiene que definir
    private Integer idCompra;

    @Column(name="id_cliente")
    private Integer idCliente;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false) //Mediante esto, no se actualizan ni
    //insertan cliente
    private  Cliente cliente;

    @OneToMany(mappedBy = "producto")
    private List<ComprasProducto> productos;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
