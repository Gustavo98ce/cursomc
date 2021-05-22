package com.gustavogadelha.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavogadelha.cursomc.domain.Categoria;
import com.gustavogadelha.cursomc.domain.Cidade;
import com.gustavogadelha.cursomc.domain.Cliente;
import com.gustavogadelha.cursomc.domain.Endereco;
import com.gustavogadelha.cursomc.domain.Estado;
import com.gustavogadelha.cursomc.domain.Produto;
import com.gustavogadelha.cursomc.domain.enums.TipoCliente;
import com.gustavogadelha.cursomc.repositories.CategoriaRepository;
import com.gustavogadelha.cursomc.repositories.CidadeRepository;
import com.gustavogadelha.cursomc.repositories.ClienteRepository;
import com.gustavogadelha.cursomc.repositories.EnderecoRepository;
import com.gustavogadelha.cursomc.repositories.EstadoRepository;
import com.gustavogadelha.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, " São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas",est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));

		
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com", "123455678",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("2222.2222","3333.3333"));
		
		Endereco e1 = new Endereco(null," Rua FLores ","300","Apto 303","Jardim", "38220834",cli1,c1);
		Endereco e2 = new Endereco(null," Avenida matos","105"," Sala 800","Centro", "1234342 ",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}
