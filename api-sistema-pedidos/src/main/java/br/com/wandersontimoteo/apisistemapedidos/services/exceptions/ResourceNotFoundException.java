package br.com.wandersontimoteo.apisistemapedidos.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionLONG = 1L;

    public ResourceNotFoundException(Object id) {
        super("Recurso não encontrado. Id: " + id);
    }
}
