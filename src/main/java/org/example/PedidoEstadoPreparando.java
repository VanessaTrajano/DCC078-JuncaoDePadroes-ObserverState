package org.example;

public class PedidoEstadoPreparando extends PedidoEstado {
    private PedidoEstadoPreparando() {};
    private static PedidoEstadoPreparando instance = new PedidoEstadoPreparando();
    public static PedidoEstadoPreparando getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Preparando Pedido";
    }

    @Override
    public boolean cancelar(Pedido pedido){
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }

    @Override
    public boolean enviar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEnviando.getInstance());
        return true;
    }
}
