/** template created by jowsnunez --> https://www.github.com/JowsNunez * */
package com.anthonyponte.wallet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Anthony Ponte <anthonyponte.com>
 * @param <T>
 */
@Service
public interface ITipoService<T> {
  Iterable<T> getAll();

  T getById(Integer id);

  T create(T entity);

  void delete(Integer id);

  Page<T> getAll(Pageable pageable);
}
