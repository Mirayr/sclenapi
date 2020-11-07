package com.mirayr.br.scleanapi;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mirayr.br.scleanapi.models.Cliente;
import com.mirayr.br.scleanapi.models.Pedido;
import com.mirayr.br.scleanapi.models.Servico;
import com.mirayr.br.scleanapi.repository.ClienteRepository;
import com.mirayr.br.scleanapi.repository.PedidoRepository;
import com.mirayr.br.scleanapi.repository.ServicoRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// import net.bytebuddy.dynamic.loading.ClassLoadingStrategy.Configurable;

@SpringBootApplication
public class ScleanapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScleanapiApplication.class, args);
		// ConfigurableApplicationContext configurableApplicationContext = 
		// SpringApplication.run(ScleanapiApplication.class, args);

		// ClienteRepository clienteRepository = configurableApplicationContext.getBean(ClienteRepository.class);
		// PedidoRepository pedidoRepository = configurableApplicationContext.getBean(PedidoRepository.class);
		// ServicoRepository servicoRepository = configurableApplicationContext.getBean(ServicoRepository.class);

		// Cliente cliente_30 = clienteRepository.findById(30);

		// // Criando pedidos e salvando para um cliente
		// Pedido pedido1 = new Pedido("1999-02-02");
		// Pedido pedido2 = new Pedido("2020-02-02");
		// Pedido pedido3 = new Pedido("2020-02-02");
		// Pedido pedido4 = new Pedido("2020-02-02");

		// // Alternativo para salvar muitos pedidos
		// // List<Pedido> pedidos = Arrays.asList(pedido1, pedido2, pedido3, pedido4);
		// // cliente_30.setPedidos(pedidos);
		
		// cliente_30.setPedido(pedido1);
		// cliente_30.setPedido(pedido2);
		// cliente_30.setPedido(pedido3);
		// cliente_30.setPedido(pedido4);
		// clienteRepository.save(cliente_30);

		// // salvando serviços em um pedido
		
		// Servico servico_sofa_seco = servicoRepository.findById(8); // Limpeza de Sofa a seco
		// Servico servico_sofa = servicoRepository.findById(10);// Limpeza de Sofa
		// Set<Servico> servicos = new HashSet<Servico>();
		// servicos.add(servico_sofa_seco);
		// servicos.add(servico_sofa);

		// Pedido pedido111 = pedidoRepository.findById(111);//97, 111
		// pedido111.getServicos().add(servico_sofa_seco);
		// servico_sofa_seco.getPedidos().add(pedido111);
		// pedido111.getServicos().add(servico_sofa);
		// servico_sofa.getPedidos().add(pedido111);
		// pedidoRepository.save(pedido111);


		// // Mostra todos os clientes que tem pedidos e seus serviços
		// List<Cliente> all_clientes = clienteRepository.findAll();
		// for (Cliente cliente : all_clientes) {
		// 	for (Pedido pedido : cliente.getPedidos()){
		// 		System.out.println(" Nome Cliente no pedido pedido: " + pedido.getCliente().getNome() +  "  Data do Pedido: " + pedido.getDataPedido()+" Id do pedido "+ pedido.getId());
		// 		for(Servico servico : pedido.getServicos()){
		// 			System.out.println("Servicos solicitados: " + servico.getNome() );			
		// 		}
		// 	}
			
		// }
		
		
	}

}
