package sk.stuba.fei.uim.vsa.dao;

public class DaoClassNotInitializedException extends RuntimeException {

    public DaoClassNotInitializedException(String className) {
        super("Dao class " + className + " is not initialized correctly. You must at least once call 'init' method");
    }
}
