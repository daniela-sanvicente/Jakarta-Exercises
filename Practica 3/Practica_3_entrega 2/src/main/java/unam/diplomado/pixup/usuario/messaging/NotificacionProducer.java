package unam.diplomado.pixup.usuario.messaging;

import jakarta.ejb.Local;

@Local
public interface NotificacionProducer {

    boolean enviarNotificacionAltaUsuario(Integer idUsuario, String email);

}