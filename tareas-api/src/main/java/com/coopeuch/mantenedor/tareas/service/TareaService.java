package com.coopeuch.mantenedor.tareas.service;

import java.util.ArrayList;
import java.util.List;

import com.coopeuch.mantenedor.tareas.dto.TareaDTO;
import com.coopeuch.mantenedor.tareas.entity.TareaEntity;
import com.coopeuch.mantenedor.tareas.interfaces.ITarea;
import com.coopeuch.mantenedor.tareas.repository.ITareaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

/**
 * @author Kevin Candia
 * @date 17-01-2022
 */
@Log4j2
@Service
public class TareaService implements ITarea {

    @Autowired
	private ITareaRepository iTarea;

    @Override
    public List<TareaDTO> findAll() {
        log.info("STARTING - findAllTarea");
        var tareaAll = iTarea.findAll();
        log.info("FINISHING - findAllTarea");;
        return fillTarea(tareaAll);
    }

    private List<TareaDTO> fillTarea(List<TareaEntity> listTarea) {
        log.info("STARTING - fillTarea");
        if (listTarea == null || listTarea.size() == 0) {
            return null;
        }

        var listTareaDTO = new ArrayList<TareaDTO>();

        for (var tareaEntity : listTarea) {
            listTareaDTO.add(new TareaDTO(
                tareaEntity.getIdentificador(),
                tareaEntity.getDescripcion(),
                tareaEntity.getFechaCreacion(),
                tareaEntity.getVigente()
            ));
        }
        log.info("FINISHING - fillTarea");
        return listTareaDTO;
    }
}