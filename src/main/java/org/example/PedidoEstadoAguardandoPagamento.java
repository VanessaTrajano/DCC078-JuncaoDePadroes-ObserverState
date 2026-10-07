package org.example;

public class PedidoEstadoAguardandoPagamento extends PedidoEstado {
    private PedidoEstadoAguardandoPagamento() {};
    private static PedidoEstadoAguardandoPagamento instance = new PedidoEstadoAguardandoPagamento();
    public static PedidoEstadoAguardandoPagamento getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Aguardando Pagamento";
    }

    @Override
    public boolean cancelar(Pedido pedido){
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }

    @Override
    public boolean confirmarPagamento(Pedido pedido) {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        return true;
    }
}
