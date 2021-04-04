package DAO;

import java.util.List;

public interface DaoInterface<T> {
    public int addData(T Data);
    public int delData(T Data);
    public int updateData(T Data);
    List<T> getAll();
}
