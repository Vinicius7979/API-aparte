package com.teste.primeiro_exemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiro_exemplo.model.Produto;
import com.teste.primeiro_exemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	/**
	 * Metodo que retorna uma lista de produtos.
	 * 
	 * @return Lista os produtos.
	 */
	public List<Produto> obterTodos() {
		return produtoRepository.obterTodos();
	}

	/**
	 * Metodo que retorna o produto encontrado pelo seu Id.
	 * 
	 * @param id do produto que sera localizado.
	 * @return Retorna um produto caso seja encontrado.
	 */
	public Optional<Produto> obterPorId(Integer id) {
		return produtoRepository.obterPorId(id);
	}

	/**
	 * Metodo para adicionar produto na lista.
	 * 
	 * @param produto que será adicionado.
	 * @return Retorna um produto que foi adicionado.
	 */
	public Produto adicionar(Produto produto) {
		return produtoRepository.adicionar(produto);
	}

	/**
	 * Metodo para deletar o produto.
	 * 
	 * @param id do produto a ser deletado.
	 */
	public void deletar(Integer id) {
		produtoRepository.deletar(id);
	}

	/**
	 * Metodo para atualizar o produto da lista.
	 * 
	 * @param produto que sera atualizado
	 * @return Retorna o produto após atualizar a lista.
	 */
	public Produto atualizar(Integer id, Produto produto) {
		produto.setId(id);

		return produtoRepository.atualizar(produto);
	}

}
