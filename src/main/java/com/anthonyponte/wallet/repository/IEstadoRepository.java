package com.anthonyponte.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anthonyponte.wallet.entity.Estado;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, Integer> {
}