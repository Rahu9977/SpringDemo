package myprojectdemo.web.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.ejb.criteria.expression.function.SubstringFunction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class genericDaoImp implements genericDao
{
	@PersistenceContext
	private EntityManager ee;
	
	@Transactional
	public <E> E insert(E e) {


		ee.merge(e);
		
		return e;
		//ee.remove(ee.merge(e));
		//ee.persist(e);
		//return e;
/*		return ee.merge(e);
*/
	}
	public <E> List<E> display(E e)
	{
		
		
	        String s = e.getClass().getName();
			String c = s.substring(s.lastIndexOf(".")+1);
			return ee.createQuery("from "+c+"").getResultList();
	}
	/*public <E> List<E> display(E e,String name,String asc) {
	
	List<E> list1 = null;
	
	String classname = e.getClass().getName();
	Query q = ee.createQuery(classname.substring(classname.lastIndexOf(".")+1) + "ORDER BY"+name+" "+asc+"");
	list1 = q.getResultList();
	return list1;
}*/

	
	@Transactional
	public <E> E delete(E e) {
		
		ee.remove(ee.merge(e));
		
		return e;
	}
	
	public long dele(String ta, String na, int id) {

		   Query query = ee.createQuery("DELETE FROM "
                +ta+ " where "+na+" = '"+id+"' ");
       
        long modifications=query.executeUpdate();
       
		return modifications;
	}
	
	public <E> E get(int id,E r) 
	{
		E f = null;
		f =(E) ee.find(r.getClass(),id);
		
		return f;
	}
	
	
}
