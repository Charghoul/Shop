package persistence;


import model.ExcArtikelAlreadyExists;

public interface Procdure<T> {

	void doItTo(T argument) throws PersistenceException, ExcArtikelAlreadyExists;

}
