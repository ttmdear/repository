package com.ttmdear.repository.springtransactions.core.services;

import com.ttmdear.repository.springtransactions.core.domain.Engine;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Service
public class TransactionA {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private final EntityManager entityManagerTransaction;

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private final EntityManager entityManagerExtended;

    private final EntityManager entityManagerInject;

    private final UserService userService;
    private final UserPhoneService userPhoneService;
    private final UserRoleService userRoleService;
    private final UserGroupService userGroupService;
    private final TransactionB transactionB;

    public TransactionA(EntityManager entityManagerTransaction, EntityManager entityManagerExtended,
                        EntityManager entityManagerInject, UserService userService,
                        UserPhoneService userPhoneService, UserRoleService userRoleService,
                        UserGroupService userGroupService, TransactionB transactionB
    ) {
        this.entityManagerTransaction = entityManagerTransaction;
        this.entityManagerExtended = entityManagerExtended;
        this.entityManagerInject = entityManagerInject;
        this.userService = userService;
        this.userPhoneService = userPhoneService;
        this.userRoleService = userRoleService;
        this.userGroupService = userGroupService;
        this.transactionB = transactionB;
    }

    // @Transactional
    public void run() {
        // System.out.println(String.format("%s.entityManager: %s", this.getClass().getSimpleName(), TransactionSynchronizationManager.getCurrentTransactionName()));

        // Optional<User> user = transactionB.findById("24269ed1-d4fd-4235-b77a-5bdabda1b307");

        String id = "c420c8fd-6223-40a3-91a1-dd2b2a773941";

        Engine engineTransaction = entityManagerTransaction.find(Engine.class, id);
        Engine engineExtended = entityManagerExtended.find(Engine.class, id);
        Engine engineInject = entityManagerInject.find(Engine.class, id);

        transactionB.checkEntityManager(id, engineTransaction, engineExtended, engineInject);

        // transactionB.checkEntityManager(engine);

        // System.out.println("user.id:" + user.get().getId());
        // System.out.println("user.phones:" + user.get().getPhones().size());

        // Optional<User> userA = transactionB.findById("24269ed1-d4fd-4235-b77a-5bdabda1b307");

        // System.out.println("user.id:" + user.get().getId());
        // System.out.println("user.phones:" + user.get().getPhones().size());
        // System.out.println("isActualTransactionActive: " + TransactionSynchronizationManager.isActualTransactionActive());

        // User user = new User();

        // user.setFirstName("Paweł 123");
        // user.setLastName("Kowalski 123");

        // userService.save(user);

        // UserRole.UserRoleId userRoleId = new UserRole.UserRoleId();
        // userRoleId.setRole(Role.ADMIN);
        // userRoleId.setUser(user);

        // UserRole userRole = new UserRole();

        // userRole.setActive(true);
        // userRole.setUserRoleId(userRoleId);

        // userRoleService.save(userRole);

        // UserPhone userPhone = new UserPhone();
        // userPhone.setActive(true);
        // userPhone.setValue("980-234-345");
        // userPhone.setUser(user);

        // userPhoneService.save(userPhone);

        // // Groups
        // UserGroup userGroup = new UserGroup();
        // userGroup.setActiveFrom(new Date());
        // userGroup.setUserId(user.getId());
        // userGroup.setGroup(Group.CLIENT);

        // userGroupService.save(userGroup);

        // user.getRoles().add(userRole);
        // user.getPhones().add(userPhone);

        // userService.save(user);

        // // UserPhone userPhone = new UserPhone(user, PhoneType.HOME, true, "978-098-098");
        // // user.getPhones().add(userPhone);

        // // userPhoneService.save(userPhone);
    }
}
