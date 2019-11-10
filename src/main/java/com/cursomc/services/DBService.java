package com.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cursomc.dominio.Categoria;
import com.cursomc.dominio.Cidade;
import com.cursomc.dominio.Cliente;
import com.cursomc.dominio.Endereco;
import com.cursomc.dominio.Estado;
import com.cursomc.dominio.ItemPedido;
import com.cursomc.dominio.Pagamento;
import com.cursomc.dominio.PagamentoComBoleto;
import com.cursomc.dominio.PagamentoComCartao;
import com.cursomc.dominio.Pedido;
import com.cursomc.dominio.Produto;
import com.cursomc.dominio.enums.Perfil;
import com.cursomc.dominio.enums.StatusPagamento;
import com.cursomc.dominio.enums.TipoCliente;
import com.cursomc.repositories.CategoriaRepository;
import com.cursomc.repositories.CidadeRepository;
import com.cursomc.repositories.ClienteRepository;
import com.cursomc.repositories.EnderecoRepository;
import com.cursomc.repositories.EstadoRepository;
import com.cursomc.repositories.ItemPedidoRepository;
import com.cursomc.repositories.PagamentoRepository;
import com.cursomc.repositories.PedidoRepository;
import com.cursomc.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private BCryptPasswordEncoder pe;

	public void instanciateDataBase() throws ParseException {
		
		 Categoria c1 = new Categoria("Informática");
		 Categoria c2 = new Categoria("Escritório");
		 Categoria c3 = new Categoria("Computador");
		 Categoria c4 = new Categoria("Esporte");
		 Categoria c5 = new Categoria("Natação");
		 Categoria c6 = new Categoria("Futebol");
		 Categoria c7 = new Categoria("Futsal");
		 Categoria c8 = new Categoria("Cama");
		 Categoria c9 = new Categoria("Escolar");
		 Categoria c10 = new Categoria("Limpesa");
		 Categoria c11 = new Categoria("Musica");
		 Categoria c12 = new Categoria("Material");
		 Categoria c13 = new Categoria("TESTE");
		 Categoria c14 = new Categoria("TESTE");
		 Categoria c15 = new Categoria("TESTE");
		 Categoria c16 = new Categoria("TESTE");
		 
		 Produto p1 = new Produto("Computador", 2000.00);
		 Produto p2 = new Produto("Impressora", 800.00);
		 Produto p3 = new Produto("Mouse", 80.00);
		 Produto p4 = new Produto("Mesa de escritório", 300.00);
		 Produto p5 = new Produto("Toalha", 50.00);
		 Produto p6 = new Produto("Colcha", 200.00);
		 Produto p7 = new Produto("TV true color", 1200.00);
		 Produto p8 = new Produto("Roçadeira", 800.00);
		 Produto p9 = new Produto("Abajour", 100.00);
		 Produto p10 = new Produto("Pendente", 180.00);
		 Produto p11 = new Produto("Shampoo", 90.00);
		 
		 c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		 c2.getProdutos().addAll(Arrays.asList(p2, p4));
		 c3.getProdutos().addAll(Arrays.asList(p5, p6));
		 c4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		 c5.getProdutos().addAll(Arrays.asList(p8));
		 c6.getProdutos().addAll(Arrays.asList(p9, p10));
		 c7.getProdutos().addAll(Arrays.asList(p11));
		 
		 p1.getCategorias().addAll(Arrays.asList(c1, c4));
		 p2.getCategorias().addAll(Arrays.asList(c1, c2, c4));
		 p3.getCategorias().add(c1);
		 p4.getCategorias().addAll(Arrays.asList(c2));
		 p5.getCategorias().addAll(Arrays.asList(c3));
		 p6.getCategorias().addAll(Arrays.asList(c3));
		 p7.getCategorias().addAll(Arrays.asList(c4));
		 p8.getCategorias().addAll(Arrays.asList(c5));
		 p9.getCategorias().addAll(Arrays.asList(c6));
		 p10.getCategorias().addAll(Arrays.asList(c6));
		 p11.getCategorias().addAll(Arrays.asList(c7));
		 
		 Estado e1 = new Estado("Minas Gerais");
		 Estado e2 = new Estado("São Paulo");
		 
		 Cidade cid1 = new Cidade("Uberlandia", e1);
		 Cidade cid2 = new Cidade("São Paulo", e2);
		 Cidade cid3 = new Cidade("Campinas", e2);
		 
		 e1.getCidades().add(cid1);
		 e2.getCidades().addAll(Arrays.asList(cid2, cid3));
		 
		 Cliente cli1 = new Cliente("Silva", "diego_sousa@outlook.com", "99944459432", TipoCliente.PESSOAFISICA, pe.encode("123"));
		 cli1.getTelefones().addAll(Arrays.asList("23494830293", "49483020399"));
		 
		 Cliente cli2 = new Cliente("Ana Costa", "anaa@outlook.com", "98351751014", TipoCliente.PESSOAFISICA, pe.encode("abc"));
		 cli2.addPerfil(Perfil.ADMIN);
		 cli2.getTelefones().addAll(Arrays.asList("995867121", "223454439"));
		 	
		 Endereco end1 = new Endereco("Rua x", "100", "", "Centro", "58884-000", cli1, cid1);
		 Endereco end2 = new Endereco("Rua y", "200", "", "Expedicionarios", "58123-000", cli1, cid2);
		 Endereco end3 = new Endereco("Rua y", "210", "", "Expedicionarios", "58123-000", cli1, cid2);
		 cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		 cli2.setEnderecos(Arrays.asList(end3));
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		 
		 Pedido ped1 = new Pedido(sdf.parse("30/09/2019 10:35"), cli1, end1);
		 Pedido ped2 = new Pedido(sdf.parse("01/10/2019 11:10"), cli1, end2);
		 
		 Pagamento pagto1 = new PagamentoComCartao(StatusPagamento.QUITADO, ped1, 6);
		 ped1.setPagamento(pagto1);
		 
		 Pagamento pagto2 = new PagamentoComBoleto(StatusPagamento.PENDENTE, ped2, 
				 sdf.parse("01/11/2019 10:33"),sdf.parse("01/10/2019 11:00"));
		 ped2.setPagamento(pagto2);
		 
		 cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		 cli1.setPedidos(Arrays.asList(ped1, ped2));
			
		 ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		 ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		 ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		 
		 ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		 ped2.getItens().add(ip3);
		 
		 categoriaRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16));
		 produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		 estadoRepository.saveAll(Arrays.asList(e1, e2));
		 cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		 clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		 enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		 pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		 pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		 itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
