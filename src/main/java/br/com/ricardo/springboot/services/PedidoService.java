package br.com.ricardo.springboot.services;

import br.com.ricardo.springboot.domain.enums.EstadoPagamento;
import br.com.ricardo.springboot.domain.model.ItemPedido;
import br.com.ricardo.springboot.domain.model.PagamentoComBoleto;
import br.com.ricardo.springboot.domain.model.Pedido;
import br.com.ricardo.springboot.repositories.ItemPedidoRepository;
import br.com.ricardo.springboot.repositories.PagamentoRepository;
import br.com.ricardo.springboot.repositories.PedidoRepository;
import br.com.ricardo.springboot.services.exceptions.ObjetctNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private BoletoService boletoService;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    public Pedido find(Integer id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);

        return obj.orElseThrow(() -> new ObjetctNotFoundException("Objeto não encontrado! Id:"
                + id
                + ", Tipo: " + Pedido.class.getName()));
    }

    @Transactional
    public Pedido insert(Pedido obj) {

        obj.setId(null);

        obj.setInstante(new Date());

        obj.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);

        obj.getPagamento().setPedido(obj);

        if (obj.getPagamento() instanceof PagamentoComBoleto) {

            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();

            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());

        }

        obj = pedidoRepository.save(obj);

        pagamentoRepository.save(obj.getPagamento());

        for (ItemPedido ip : obj.getItens()) {

            ip.setDesconto(0.0);

            ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());

            ip.setPedido(obj);

        }

        itemPedidoRepository.saveAll(obj.getItens());

        return obj;

    }
}
