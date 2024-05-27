package com.uni9.projectecommerceuni9.service;

import com.uni9.projectecommerceuni9.enums.StatusCarrinho;
import com.uni9.projectecommerceuni9.mapper.CarrinhoMapper;
import com.uni9.projectecommerceuni9.mapper.LivroMapper;
import com.uni9.projectecommerceuni9.mapper.PedidoMapper;
import com.uni9.projectecommerceuni9.model.CarrinhoModel;
import com.uni9.projectecommerceuni9.model.ItemCarrinho;
import com.uni9.projectecommerceuni9.model.LivroModel;
import com.uni9.projectecommerceuni9.model.dto.CarrinhoRecordDTO;
import com.uni9.projectecommerceuni9.model.dto.LivroRecordDto;
import com.uni9.projectecommerceuni9.repository.CarrinhoRepository;
import com.uni9.projectecommerceuni9.repository.ItemCarrinhoRepository;
import com.uni9.projectecommerceuni9.repository.LivroRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

  @Autowired LivroRepository livroRepository;

  @Autowired ItemCarrinhoRepository itemCarrinhoRepository;

  @Autowired CarrinhoMapper carrinhoMapper;

  @Autowired CarrinhoRepository carrinhoRepository;

  public CarrinhoRecordDTO saveItem(CarrinhoRecordDTO carrinhoDTO) {
    CarrinhoModel carrinho = carrinhoMapper.dtoToModel(carrinhoDTO);

    if (carrinho.getStatusCarrinho() == null) {
      carrinho.setStatusCarrinho(StatusCarrinho.TEM_CARRINHO.getStatusCarrinho());
    }

    if (carrinho.getValorTotal() == null){
        carrinho.setValorTotal(0D);
    }

    carrinho
        .getItens()
        .forEach(
            salvaItem -> {
              ItemCarrinho itemCarrinho = new ItemCarrinho();
//              itemCarrinho.setCarrinhoId(salvaItem.getCarrinhoId());
              itemCarrinho.setLivroId(salvaItem.getLivroId());
              itemCarrinho.setQuantidade(salvaItem.getQuantidade());
              carrinho.setCliente(carrinhoDTO.clienteId());
//              itemCarrinhoRepository.save(itemCarrinho);
              carrinho.setValorTotal(calculaValorTotal(carrinho, salvaItem.getLivroId(), salvaItem.getQuantidade()));
            });

    carrinhoRepository.save(carrinho);

    return carrinhoMapper.modelToDto(carrinho);
  }

  public Double calculaValorTotal(CarrinhoModel carrinhoModel, LivroModel livroModel, Integer quantidade){
    LivroModel livro = livroRepository.buscaLivroPorId(livroModel.getId());
    Double valorTotal = carrinhoModel.getValorTotal() + (livro.getPreco() * quantidade);
    return valorTotal;
  }


  public void addItemCarrinho(List<ItemCarrinho> itemCarrinhoList) {
    itemCarrinhoList.forEach(
        salvaItem -> {
          //          salvaItem.
        });
  }

  public List<LivroModel> addLivros(List<LivroRecordDto> livros) {
    List<LivroModel> livroList = new ArrayList<>(livros.size());
    livros.forEach(
        salvaLivro -> {
          LivroModel pegaLivro = pegaLivro(salvaLivro.id());
          livroList.add(pegaLivro);
        });
    return livroList;
  }

  private LivroModel pegaLivro(Long id) {
    return livroRepository.buscaLivroPorId(id);
  }
}
