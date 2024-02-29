package unam.diplomado.pixup.disco.service;

import jakarta.ejb.Local;
import unam.diplomado.pixup.disco.domain.Disco;

@Local
public interface DiscoService {
    Disco registrarDisco(Disco disco);
}
