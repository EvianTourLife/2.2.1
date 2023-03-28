package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
      //sessionFactory.getCurrentSession().save(car);

   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }


   @Override
   @SuppressWarnings("unchecked")
   public List <User> getUserByCar(String model, int series){
      Query <User> list = sessionFactory.getCurrentSession()
              .createQuery("from User user where user.carId.model = :model and user.carId.series = :series", User.class)
               .setParameter("model", model).setParameter("series", series);
      //return  query.setMaxResults(1).getResultStream().findFirst().orElse(new User());
      return list.getResultList().isEmpty() ?  Collections.emptyList() : list.getResultList();
   }

}
