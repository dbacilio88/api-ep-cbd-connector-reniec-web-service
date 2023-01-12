package pe.mil.microservices.services;

public interface IGetReniecEntity<R, E> {

    R query(E entity);
}
