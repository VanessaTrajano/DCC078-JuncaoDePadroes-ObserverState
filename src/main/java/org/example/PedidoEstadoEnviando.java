package org.example;

public class PedidoEstadoEnviando extends PedidoEstado {
    private PedidoEstadoEnviando() {};
    private static PedidoEstadoEnviando instance = new PedidoEstadoEnviando();
    public static PedidoEstadoEnviando getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedido Enviado";
    }

    @Override
    public boolean cancelar(Pedido pedido){
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }

    @Override
    public boolean entregar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }
}
