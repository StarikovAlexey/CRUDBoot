package service;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userdao) {
        this.userDao = userdao;
    }

    @Transactional(readOnly = true)
    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Transactional
    @Override
    public void addUser(User newUser) {
        userDao.addUser(newUser);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) { userDao.deleteUser(id); }

    @Transactional
    @Override
    public void updateUser(long id, User userForUpdate) {
        userDao.updateUser(id, userForUpdate);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }
}

