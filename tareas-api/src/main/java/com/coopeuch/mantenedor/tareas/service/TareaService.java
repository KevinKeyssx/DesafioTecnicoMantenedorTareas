package com.coopeuch.mantenedor.tareas.service;

import java.util.ArrayList;
import java.util.List;

import com.coopeuch.mantenedor.tareas.data.TareaDTO;
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
        return fillListTareas(tareaAll);
    }

    @Override
    public void save(TareaDTO tareaDTO) {
        log.info("STARTING - save");
        iTarea.save(fillTarea(tareaDTO));
        log.info("FINISHING - save");
    }

    @Override
    public void deleteById(Long identificador) {
        log.info("STARTING - deleteById");
        try {
            
            iTarea.deleteById(identificador);
            log.info("FINISHING - deleteById");
        } catch (Exception e) {
            log.info("ERROR - deleteById" + e.getMessage());
        }
    }

    private TareaEntity fillTarea(TareaDTO tareaDTO) {
        log.info("STARTING - fillTarea");

        if (tareaDTO == null) {
            return null;
        }

        log.info("FINISHING - fillTarea");

        return new TareaEntity(
            tareaDTO.getIdentificador(),
            tareaDTO.getDescripcion(),
            tareaDTO.getFechaCreacion(),
            tareaDTO.getVigente()
        );
    }

    private List<TareaDTO> fillListTareas(List<TareaEntity> listTarea) {
        log.info("STARTING - fillListTareas");

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

        log.info("FINISHING - fillListTareas");
        return listTareaDTO;
    }

}