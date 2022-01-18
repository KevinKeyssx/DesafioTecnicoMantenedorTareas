package com.coopeuch.mantenedor.tareas.repository;

import java.util.List;

import com.coopeuch.mantenedor.tareas.entity.TareaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITareaRepository extends JpaRepository<TareaEntity, Long> {

    public List<TareaEntity> findAll();

}