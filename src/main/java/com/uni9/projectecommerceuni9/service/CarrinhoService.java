package com.uni9.projectecommerceuni9.service;

import com.uni9.projectecommerceuni9.enums.StatusCarrinho;
import com.uni9.projectecommerceuni9.mapper.CarrinhoMapper;
import com.uni9.projectecommerceuni9.mapper.LivroMapper;
import com.uni9.projectecommerceuni9.mapper.PedidoMapper;
import com.uni9.projectecommerceuni9.model.CarrinhoModel;
import com.uni9.projectecommerceuni9.model.LivroModel;
import com.uni9.projectecommerceuni9.model.PedidoModel;
import com.uni9.projectecommerceuni9.model.dto.CarrinhoRecordDTO;
import com.uni9.projectecommerceuni9.model.dto.LivroRecordDto;
import com.uni9.projectecommerceuni9.model.dto.PedidoRecordDTO;
import com.uni9.projectecommerceuni9.repository.LivroRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

  @Autowired LivroRepository livroRepository;

  @Autowired CarrinhoMapper carrinhoMapper;

  @Autowired PedidoMapper pedidoMapper;

  @Autowired LivroMapper livroMapper;

  public List<CarrinhoModel> saveItem(
      List<CarrinhoRecordDTO> carrinhoListDTO, PedidoRecordDTO pedidoDTO) {
    List<CarrinhoModel> carrinhoList = carrinhoMapper.dtoToModelList(carrinhoListDTO);
    List<CarrinhoModel> itemList = new ArrayList<>(carrinhoListDTO.size());
    PedidoModel pedido = pedidoMapper.dtoToModel(pedidoDTO);
    carrinhoList.forEach(
        salvaItem -> {
          if (salvaItem.getStatusCarrinho() == null) {
            salvaItem.setStatusCarrinho(StatusCarrinho.TEM_CARRINHO.getStatusCarrinho());
            salvaItem.setLivros(addLivros(livroMapper.modelToDtoList(salvaItem.getLivros())));
            salvaItem.setCliente(pedido.getCliente());
            itemList.add(salvaItem);
          } else {
            itemList.add(salvaItem);
          }
        });
    pedido.setItensCarrinho(itemList);
    return itemList;
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
