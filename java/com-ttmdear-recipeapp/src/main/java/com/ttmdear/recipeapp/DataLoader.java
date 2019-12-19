package com.ttmdear.recipeapp;

import com.ttmdear.recipeapp.domain.Email;
import com.ttmdear.recipeapp.domain.Phone;
import com.ttmdear.recipeapp.domain.Recipe;
import com.ttmdear.recipeapp.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
public class DataLoader implements CommandLineRunner {

    private final EntityManager entityManager;

    public DataLoader(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("Write data");

        // Recipe recipe = new Recipe();
        User user = new User();
        user.setFirstName("Paweł");
        user.setLastName("Kowalski");

        Email email = new Email();
        email.setValue("pawel.kowalski@gmail.com");
        // email.setEmailUserId("foot-123");
        // email.setEmailUserIssuer("issuer-123");

        user.setEmail(email);

        Phone phone = new Phone();
        phone.setValue("722397244");

        user.getPhones().add(phone);

        entityManager.persist(phone);
        entityManager.persist(email);
        entityManager.persist(user);
    }
}
