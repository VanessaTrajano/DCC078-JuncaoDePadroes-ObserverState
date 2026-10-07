package org.example;

import java.util.Observable;

public class Pedido extends Observable {
    private PedidoEstado estado;
    private Integer codigo;
    private String produto;

    public Pedido(Integer codigo, String produto) {
        this.codigo = codigo;
        this.produto = produto;
        this.estado = PedidoEstadoAguardandoPagamento.getInstance();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public void enviarAtualizacaoDeEstado() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo=" + codigo +
                ", produto='" + produto +
                "', estado='" + estado.getEstado() +
                "'}";
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public boolean confirmarCompra() {
        return estado.confirmarCompra(this);
    }

    public boolean confirmarPagamento() {
        return estado.confirmarPagamento(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public boolean enviar() {
        return estado.enviar(this);
    }

    public boolean entregar() {
        return estado.entregar(this);
    }
}