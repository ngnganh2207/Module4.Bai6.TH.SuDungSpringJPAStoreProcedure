package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class CustomerRepository implements ICustomerRepository{
    //Chưa hiểu
    @PersistenceContext
    private EntityManager em;
    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        String sql="CALL Insert_Customer(:firstName,:lastName)";
        Query query=em.createNativeQuery(sql);
        query.setParameter("firstName",customer.getFirstName());
        query.setParameter("lastName",customer.getLastName());
        //trả về 0-> k cập nhật được, trả về >0 thì cập nhật được.
        return query.executeUpdate()==0;
    }

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query= em.createQuery("select c from Customer c",Customer.class);
        return query.getResultList();
    }
}
