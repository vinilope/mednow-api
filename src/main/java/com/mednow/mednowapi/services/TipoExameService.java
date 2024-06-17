package com.mednow.mednowapi.services;

import com.mednow.mednowapi.models.TipoExame;
import com.mednow.mednowapi.repositories.TipoExameRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Builder
public class TipoExameService {

    private TipoExameRepository tipoExameRepository;

    public TipoExame inserirTipoExame(TipoExame tipoexame) {
        return tipoExameRepository.save(tipoexame);
    }

    public List<TipoExame> getAllTipoExames() {
        return tipoExameRepository.findAll();
    }

    public TipoExame getTipoExameById(Integer id) {
        return tipoExameRepository.findById(id).orElse(null);
    }

    public void deleteTipoExameById(Integer id) {
        tipoExameRepository.deleteById(id);
    }
}