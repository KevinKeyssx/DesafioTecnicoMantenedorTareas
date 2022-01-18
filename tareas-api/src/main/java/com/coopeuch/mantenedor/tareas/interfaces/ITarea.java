package com.coopeuch.mantenedor.tareas.interfaces;

import java.util.List;

import com.coopeuch.mantenedor.tareas.dto.TareaDTO;

/**
 * @author Kevin Candia
 * @date 17-01-2022
 */
public interface ITarea {

    public List<TareaDTO> findAll();

    public void save(TareaDTO tareaDTO);

    public void deleteById(TareaDTO tareaDTO);

}