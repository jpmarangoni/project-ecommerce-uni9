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
import com.uni9.projectecommerceuni9.repository.CarrinhoRepository;
import com.uni9.projectecommerceuni9.repository.LivroRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

  @Autowired CarrinhoRepository carrinhoRepository;

  @Autowired LivroRepository livroRepository;

  @Autowired CarrinhoMapper carrinhoMapper;

  @Autowired PedidoMapper pedidoMapper;

  @Autowired LivroMapper livroMapper;


  public CarrinhoRecordDTO saveItemPedido(CarrinhoRecordDTO carrinhoDTO) {
    CarrinhoModel carrinhoModel = carrinhoMapper.dtoToModel(carrinhoDTO);
    if (carrinhoModel.getStatusCarrinho() == null) {
      carrinhoModel.setStatusCarrinho(StatusCarrinho.TEM_CARRINHO.getStatusCarrinho());
      carrinhoModel.setLivros(addLivros(carrinhoDTO.livros()));
      carrinhoModel.setQuantidade(carrinhoDTO.quantidade());
      CarrinhoModel pedido = carrinhoRepository.save(carrinhoModel);
      return carrinhoMapper.modelToDto(pedido);
    }
    CarrinhoModel carrinho = carrinhoRepository.save(carrinhoModel);
    return carrinhoMapper.modelToDto(carrinho);
  }

  public List<CarrinhoModel> saveItem(List<CarrinhoRecordDTO> carrinhoListDTO, PedidoRecordDTO pedidoDTO) {
    List<CarrinhoModel> carrinhoList = carrinhoMapper.dtoToModelList(carrinhoListDTO);
    List<CarrinhoModel> itemList = new ArrayList<>(carrinhoListDTO.size());
    PedidoModel pedido = pedidoMapper.dtoToModel(pedidoDTO);
    carrinhoList.forEach(
        salvaItem -> {
          if (salvaItem.getStatusCarrinho() == null) {
            salvaItem.setStatusCarrinho(StatusCarrinho.TEM_CARRINHO.getStatusCarrinho());
            salvaItem.setLivros(addLivros(livroMapper.modelToDtoList(salvaItem.getLivros())));
            salvaItem.setPedido(pedido);
            CarrinhoModel item = carrinhoRepository.save(salvaItem);
            itemList.add(item);
          } else {
            CarrinhoModel carrinho = carrinhoRepository.save(salvaItem);
            itemList.add(carrinho);
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
