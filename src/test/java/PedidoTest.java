import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {
    Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido(123, "Cafeteira");
    }

    // Pedido - aguardando pagamento

    @Test
    public void naoDeveConfirmarCompraPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertFalse(pedido.confirmarCompra());
    }

    @Test
    public void deveConfirmarPagamentoPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertTrue(pedido.confirmarPagamento());
        assertEquals(PedidoEstadoPreparando.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveCancelarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveFicarEnviadoPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertFalse(pedido.enviar());
    }

    @Test
    public void naoDeveEntregarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertFalse(pedido.entregar());
    }

    // Pedido - preparando

    @Test
    public void naoDeveConfirmarCompraPedidoPreparando() {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        assertFalse(pedido.confirmarCompra());
    }

    @Test
    public void naoDevePrepararPedidoPreparando() {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        assertFalse(pedido.confirmarPagamento());
    }

    @Test
    public void deveCancelarPedidoPreparando() {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveEnviarPedidoPreparando() {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        assertTrue(pedido.enviar());
        assertEquals(PedidoEstadoEnviando.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEntregarPedidoPreparando() {
        pedido.setEstado(PedidoEstadoPreparando.getInstance());
        assertFalse(pedido.entregar());
    }

    // Pedido cancelada

    @Test
    public void naoDeveConfirmarCompraPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.confirmarCompra());
    }

    @Test
    public void naoDeveConfirmarPagamentoPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.confirmarPagamento());
    }

    @Test
    public void naoDeveCancelarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.cancelar());
    }

    @Test
    public void naoDeveEnviarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.enviar());
    }

    @Test
    public void naoDeveEntregarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.entregar());
    }

    // Pedido enviando

    @Test
    public void naoDeveConfirmarCompraPedidoEnviando() {
        pedido.setEstado(PedidoEstadoEnviando.getInstance());
        assertFalse(pedido.confirmarCompra());
    }

    @Test
    public void naoDeveConfirmarPagamentoPedidoEnviando() {
        pedido.setEstado(PedidoEstadoEnviando.getInstance());
        assertFalse(pedido.confirmarPagamento());
    }

    @Test
    public void deveCancelarPedidoEnviando() {
        pedido.setEstado(PedidoEstadoEnviando.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveFicarEnviandoPedidoEnviando() {
        pedido.setEstado(PedidoEstadoEnviando.getInstance());
        assertFalse(pedido.enviar());
    }

    @Test
    public void deveEntregarPedidoEnviando() {
        pedido.setEstado(PedidoEstadoEnviando.getInstance());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    // Pedido entregue

    @Test
    public void naoDeveConfirmarCompraPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.confirmarCompra());
    }

    @Test
    public void naoDeveConfirmarPagamentoPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.confirmarPagamento());
    }

    @Test
    public void naoDeveCancelarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.cancelar());
    }

    @Test
    public void naoDeveEnviarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.enviar());
    }

    @Test
    public void naoDeveEntregarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.entregar());
    }
}