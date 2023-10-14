package br.com.wandersontimoteo.apisistemapedidos.services.exceptions;

public class DatabaseException extends RuntimeException {

    private static final long serialVersionLONG = 1L;

    public DatabaseException(String msg) {
        super(msg);
    }
}
