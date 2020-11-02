package com.mirayr.br.scleanapi;

import java.util.Arrays;
import java.util.List;

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

		Cliente cliente = clienteRepository.findById(47);

		Pedido pedido1 = new Pedido("1999-09-22");
		Pedido pedido2 = new Pedido("2020-07-18");
		Pedido pedido3 = new Pedido("2020-03-25");
		List<Pedido> pedidos = Arrays.asList(pedido1, pedido2, pedido3);
		System.out.println("Nome do Cliente " + cliente.getNome());
		cliente.setPedidos(pedidos);
		clienteRepository.save(cliente);
	}

}
