package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

//    public UserDaoImpl() {
//    }
//
//    @Autowired
//    public UserDaoImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    public List<User> getAllUsers() {
        String hql = "select c from User c";
        return entityManager.createQuery(hql, User.class).getResultList();
    }

    @Override
    public void addNewUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User user) {
        User updatedUser = findById(id);
        updatedUser.setName(user.getName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setEmail(user.getEmail());
    }

//    @Override
//    public void updateUser(User user) {
//        entityManager.merge(user);
//    }

    @Override
    public void deleteUser(int id){
//        User user1 = entityManager.find(User.class, id);
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User findById(int id){
        return entityManager.find(User.class, id);
    }


}
