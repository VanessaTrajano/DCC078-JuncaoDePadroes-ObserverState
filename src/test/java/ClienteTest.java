import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
    @Test
    void deveNotificarUmCliente() {
        Pedido pedido = new Pedido(9836, "Mousepad");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(pedido);
        pedido.enviarAtualizacaoDeEstado();
        assertEquals("Cliente 1, seu pedido Pedido{codigo=9836, produto='Mousepad', estado='Aguardando Pagamento'} teve o status atualizado", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Pedido pedido = new Pedido(9836,  "Mousepad");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(pedido);
        cliente2.acompanhar(pedido);
        pedido.enviarAtualizacaoDeEstado();
        assertEquals("Cliente 1, seu pedido Pedido{codigo=9836, produto='Mousepad', estado='Aguardando Pagamento'} teve o status atualizado", cliente1.getUltimaNotificacao());
        pedido.confirmarPagamento();
        pedido.enviarAtualizacaoDeEstado();
        assertEquals("Cliente 2, seu pedido Pedido{codigo=9836, produto='Mousepad', estado='Preparando Pedido'} teve o status atualizado", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Pedido pedido = new Pedido(9836,  "Mousepad");
        Cliente cliente = new Cliente("Cliente 1");
        pedido.enviarAtualizacaoDeEstado();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientePedidoA() {
        Pedido pedidoA = new Pedido(9836, "Mousepad");
        Pedido pedidoB = new Pedido(9836, "Mousepad");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(pedidoA);
        cliente2.acompanhar(pedidoB);
        pedidoA.enviarAtualizacaoDeEstado();
        assertEquals("Cliente 1, seu pedido Pedido{codigo=9836, produto='Mousepad', estado='Aguardando Pagamento'} teve o status atualizado", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}
