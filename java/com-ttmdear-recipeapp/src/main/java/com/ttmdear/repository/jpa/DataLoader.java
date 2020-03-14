package com.ttmdear.repository.jpa;

import com.ttmdear.repository.jpa.domain.Email;
import com.ttmdear.repository.jpa.domain.Phone;
import com.ttmdear.repository.jpa.domain.Tag;
import com.ttmdear.repository.jpa.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
public class DataLoader implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private final EntityManager entityManager;

    public DataLoader(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // // Recipe recipe = new Recipe();
        User user = new User();
        user.setFirstName("Paweł");
        user.setLastName("Kowalski");

        user.setEmail(new Email(){{setValue("pawel.kowalski@gmail.com");}});

        user.getPhones().add(new Phone(){{setValue("980-098-098");}});
        user.getPhones().add(new Phone(){{setValue("987-090-345");}});
        user.getPhones().add(new Phone(){{setValue("345-234-545");}});

        // Tags
        Tag tagActive = new Tag();
        tagActive.setValue("Active");

        Tag tagAdmin = new Tag();
        tagAdmin.setValue("Admin");

        entityManager.persist(tagActive);
        entityManager.persist(tagAdmin);

        user.getTags().add(tagActive);
        user.getTags().add(tagAdmin);

        entityManager.persist(user);

        // Change and update user

        user.setFirstName("Paweł Jan");

        entityManager.persist(user);
    }
}
