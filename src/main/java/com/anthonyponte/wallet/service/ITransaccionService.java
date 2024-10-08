/** template created by jowsnunez --> https://www.github.com/JowsNunez * */
package com.anthonyponte.wallet.service;

import org.springframework.stereotype.Service;

/**
 * @author Anthony Ponte <anthonyponte.com>
 * @param <T>
 */
@Service
public interface ITransaccionService<T> {
  Iterable<T> getAll();

  T getById(Integer id);

  T create(T entity);

  void delete(Integer id);

  Iterable<T> getAll(Integer id);
}
