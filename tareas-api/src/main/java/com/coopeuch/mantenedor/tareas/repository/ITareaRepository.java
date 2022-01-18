package com.coopeuch.mantenedor.tareas.repository;

import com.coopeuch.mantenedor.tareas.entity.TareaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kevin Candia
 * 17-01-2022
 */
@Repository
public interface ITareaRepository extends JpaRepository<TareaEntity, Long> {

}