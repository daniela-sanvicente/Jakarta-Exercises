package unam.diplomado.pixup.colonia.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.colonia.domain.*;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;
import unam.diplomado.pixup.colonia.repository.MunicipioRepository;

import java.util.Optional;

@Stateless
public class ColoniaServiceImpl implements ColoniaService {

    @Inject
    private ColoniaRepository coloniaRepository;
    @Inject
    private MunicipioRepository municipioRepository;

    @Override
    public Colonia obtenerColoniaPorId(Integer id) {
        Optional<Colonia> colonia = coloniaRepository.findById(id);
        if (colonia.isPresent()) {
            return colonia.get();
        }
        throw new ColoniaNotFoundException(id);
    }

    @Override
    public Colonia crearColonia(Colonia colonia) {
        Optional<Colonia> coloniaExistente =
                coloniaRepository.findByCpAndNombre(colonia.getCp(), colonia.getNombre());
        if (coloniaExistente.isEmpty()) {
            Optional<Municipio> municipioExistente =
                    municipioRepository.findById(colonia.getMunicipio().getId());
            if (municipioExistente.isEmpty()) {
                throw new MunicipioNotFoundException(colonia.getMunicipio().getId());
            }
            colonia.setMunicipio(municipioExistente.get());
            return coloniaRepository.saveOrUpdate(colonia);
        }
        throw new ColoniaAlreadyExistsException(colonia.getCp(), colonia.getNombre());
    }

    @Override
    public Colonia actualizarColonia(Colonia colonia) {
        Optional<Colonia> coloniaExistente =
                coloniaRepository.findById(colonia.getId());
        if (coloniaExistente.isPresent()) {
            Colonia coloniaActualizar = coloniaExistente.get();
            Optional<Municipio> municipioExistente =
                    municipioRepository.findById(colonia.getMunicipio().getId());
            if (municipioExistente.isEmpty()) {
                throw new MunicipioNotFoundException(colonia.getMunicipio().getId());
            }
            coloniaActualizar.setMunicipio(municipioExistente.get());
            coloniaActualizar.setNombre(colonia.getNombre());
            coloniaActualizar.setCp(colonia.getCp());
            return coloniaRepository.saveOrUpdate(coloniaActualizar);
        }
        throw new ColoniaNotFoundException(colonia.getId());
    }

    @Override
    public void eliminarColoniaPorId(Integer id) {
        /*
        Optional<Colonia> colonia=coloniaRepository.findById(id);
        if (colonia. isPresent()){
        coloniaRepository.delete(colonia.get());}

         */
        coloniaRepository.findById(id)
                .ifPresent(colonia -> coloniaRepository.delete(colonia));
    }

}

