package com.teste.primeiro_exemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiro_exemplo.model.Produto;

@Repository
public class ProdutoRepository {

	private List<Produto> produtos = new ArrayList<Produto>();
	private Integer ultimoId = 0;

	/**
	 * Metodo que retorna uma lista de produtos.
	 * 
	 * @return Lista os produtos.
	 */
	public List<Produto> obterTodos() {
		return produtos;
	}

	/**
	 * Metodo que retorna o produto encontrado pelo seu Id.
	 * 
	 * @param id do produto que sera localizado.
	 * @return Retorna um produto caso seja encontrado.
	 */
	public Optional<Produto> obterPorId(Integer id) {
		return produtos.stream().filter(produto -> produto.getId() == id).findFirst();
	}

	/**
	 * Metodo para adicionar produto na lista.
	 * 
	 * @param produto que será adicionado.
	 * @return Retorna um produto que foi adicionado.
	 */
	public Produto adicionar(Produto produto) {
		ultimoId++;

		produto.setId(ultimoId);
		produtos.add(produto);

		return produto;

	}

	/**
	 * Metodo para deletar o produto.
	 * 
	 * @param id do produto a ser deletado.
	 */
	public void deletar(Integer id) {
		produtos.removeIf(produto -> produto.getId() == id);
	}

	/**
	 * Metodo para atualizar o produto da lista.
	 * 
	 * @param produto que sera atualizado
	 * @return Retorna o produto após atualizar a lista.
	 */
	public Produto atualizar(Produto produto) {
		Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

		if (produtoEncontrado.isEmpty()) {
			throw new InputMismatchException("Produto não encontrado");
		}

		deletar(produto.getId());

		produtos.add(produto);

		return produto;
	}

}
