package com.mirayr.br.scleanapi;

import com.mirayr.br.scleanapi.models.Cliente;
import com.mirayr.br.scleanapi.models.Pedido;
import com.mirayr.br.scleanapi.repository.ClienteRepository;
import com.mirayr.br.scleanapi.repository.PedidoRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import net.bytebuddy.dynamic.loading.ClassLoadingStrategy.Configurable;

@SpringBootApplication
public class ScleanapiApplication {

	public static void main(String[] args) {
		// SpringApplication.run(ScleanapiApplication.class, args);
		ConfigurableApplicationContext configurableApplicationContext = 
		SpringApplication.run(ScleanapiApplication.class, args);

		ClienteRepository clienteRepository = configurableApplicationContext.getBean(ClienteRepository.class);
		
		PedidoRepository pedidoRepository = configurableApplicationContext.getBean(PedidoRepository.class);

		Cliente queila = clienteRepository.findById(47); // Queila
		Cliente flair2 = clienteRepository.findById(30); // Flair
 

		
		Pedido pedido1 = new Pedido("1999-02-02");
		Pedido pedido2 = new Pedido("2020-02-02");
		Pedido pedido3 = new Pedido("2020-02-02");
		Pedido pedido4 = new Pedido("2020-02-02");
		// List<Pedido> pedidos = Arrays.asList(pedido1, pedido2, pedido3, pedido4);
		System.out.println("Nome do Cliente " + flair2.getNome());
		// flair2.setPedidos(pedidos);
		flair2.setPedido(pedido1);
		flair2.setPedido(pedido2);
		flair2.setPedido(pedido3);
		flair2.setPedido(pedido4);

		clienteRepository.save(flair2);

		for (Pedido pedido : flair2.getPedidos()){
			System.out.println("Nome: " + pedido.getCliente().getNome() +  "  Data do Pedido: " + pedido.getDataPedido()+" Id do pedido "+ pedido.getId());
			if (pedido.getId() == 98){
				System.out.println("Encontrei o pedido 98");
				// pedidoRepository.delete(pedido);
			}
		}
		
	}

}
