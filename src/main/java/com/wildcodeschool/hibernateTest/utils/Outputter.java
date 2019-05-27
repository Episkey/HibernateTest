package com.wildcodeschool.hibernateTest.utils;


import com.wildcodeschool.hibernateTest.entities.User;
import com.wildcodeschool.hibernateTest.repositories.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("Wilder");

    @Autowired
    private UserDao userDao;

    @Override
    public void run(String... args) throws Exception {

        LOG.info("******************");
        LOG.info("Objects in DB : " + userDao.count());

        User user1 = new User("Joseph", "Staline", 19);
        LOG.info("******************");
        LOG.info(user1 + " has been created !");
        userDao.save(user1);
        LOG.info(user1 + " has been saved !");


        User user2 = new User("Igor", "Fedorovsky", 33);
        LOG.info("******************");
        LOG.info(user2 + " has been created !");
        userDao.save(user2);
        LOG.info(user2 + " has been saved !");

        User user3 = new User("Hitsigure", "kanzaki", 33);
        LOG.info("******************");
        LOG.info(user3 + " has been created !");
        userDao.save(user3);
        LOG.info(user3 + " has been saved !");

        User tempUser = userDao.findById(3L).get();
        LOG.info("******************");
        LOG.info("Second user's firstName is " + tempUser.getFirstName());
        LOG.info("Second user's lastName is " + tempUser.getLastName());
        LOG.info("Second user's age is " + tempUser.getAge());

        LOG.info("******************");
        LOG.info("Users in list are ");
        for (User myUser : userDao.findAll()) {
            LOG.info(myUser.toString());
        }

        userDao.deleteById(3L);
        LOG.info("******************");
        LOG.info("Users in list are deleted ");

        LOG.info("******************");
        LOG.info("Users in list are ");
        for (User myUser : userDao.findAll()) {
            LOG.info(myUser.toString());
        }
    }
}