package myprojectdemo.web.model.dao;

import java.util.List;

public interface genericDao {

	<E> E insert(E e);
	<E> List<E> display(E e);
	
	<E> E delete(E e);//del record
	long dele(String ta,String na,int id);//del record parent nd child model
	
	<E> E get(int id,E r);//update
}
