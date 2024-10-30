/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface IDAO<T> {
    public List<T> getAll();

    public void add(T t);

    public void update(T t);

    public void delete(int id);

    public T getById(int id);
}