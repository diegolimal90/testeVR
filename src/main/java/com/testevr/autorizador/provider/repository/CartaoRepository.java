package com.testevr.autorizador.provider.repository;

import com.testevr.autorizador.provider.entity.CartaoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends CrudRepository<CartaoEntity, String> {


}
