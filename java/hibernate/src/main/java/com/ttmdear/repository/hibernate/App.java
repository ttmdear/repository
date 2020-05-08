package com.ttmdear.repository.hibernate;


import com.ttmdear.repository.hibernate.core.domain.User;
import com.ttmdear.repository.hibernate.core.domain.UserStatus;
import com.ttmdear.repository.hibernate.core.domain.UserType;
import com.ttmdear.repository.hibernate.info.domain.Phone;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.*;
import java.util.function.Consumer;

public class App {
    private SessionFactory sessionFactory;
    private Random random = new Random();


    public static void main( String[] args ) {
        new App().run();

    }

    public void run() {
        initDatabase();

        fetchingByNativeQuery();
        fetchingByNamedNativeQuery();

        fetchingByNamedQuery();

        fetchingByQuery();

        // Criteria Builder
        fetchingByCriteriaBuilderEntity();
        fetchingByCriteriaBuilderField();
        fetchingByCriteriaBuilderFields();
        fetchingByCriteriaBuilderTupleQuery();
        fetchingByCriteriaBuilderMultiSelect();
        fetchingByCriteriaBuilderEntityWhere();

        // Load
        loadEntity();

        // refresh i merge
        testRefresh();
        testMerge();

        // Fetch byId
        fetchByIdReference();
        
        // Save
        testSaveEntity();

        // Entity instance
        testEntityInstance();

        runInSession(this::fetchingByCriteriaBuilderJoin);
        runInSession(this::fetchingByCriteriaBuilderGroup);

        // runInSession(this::fetchingByHQL);

        runInSession(this::testElementCollection);

        while(true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void testElementCollection(Session session) {
        System.out.println("testElementCollection");

        final String userId = UUID.randomUUID().toString();

        runInSession((sessionSave) -> {
            User user = createUser();
            user.setId(userId);

            sessionSave.save(user);
        });

        User user = session.get(User.class, userId);

        System.out.println(user);
    }

    private void fetchingByHQL(Session session) {
        System.out.println("fetchingByHQL");

        List<HQLResult> result = session.createQuery("" +
                "SELECT " +
                "    u.id,  " +
                "    count(p.value) as count " +
                "FROM User as u " +
                "JOIN Phone as p " +
                "GROUP BY u.id")
                .getResultList();

        System.out.println("result: " + result);
    }

    @Data
    private static class HQLResult {
        private String id;
        private Long count;

        public HQLResult(String id, Long count) {
            this.id = id;
            this.count = count;
        }
    }

    private void fetchingByCriteriaBuilderGroup(Session session) {
        System.out.println("fetchingByCriteriaBuilderGroup");

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<GroupResultDto> cq = cb.createQuery(GroupResultDto.class);

        Root<User> user = cq.from(User.class);
        Join<User, Phone> phones = user.join("phones");

        cq.multiselect(user.get("id"), cb.count(phones.get("value")).alias("numberOfPhones"));
        cq.groupBy(user.get("id"));

        List<GroupResultDto> result = session.createQuery(cq).getResultList();

        System.out.println("result: " + result);
    }

    // Criteria jest oznaczony jako depreciated
    // private void fetchingByCriteriaBuilderProjection(Session session) {
    //     System.out.println("fetchingByCriteriaBuilderProjection");

    //     CriteriaBuilder cb = session.getCriteriaBuilder();

    //     Criteria criteria = session.createCriteria()
    //     CriteriaQuery<User> cq = cb.createQuery(User.class);

    //     ProjectionList projection = Projections.projectionList();

    //     projection.add(Projections.property("id"));
    //     projection.add(Projections.property("firstName"));

    //     sele
    //     cq.setProjection(projection);
    //     crit.addOrder(org.hibernate.criterion.Order.asc(""));

    //     List<object[]> results = crit.list();

    //     System.out.println("result: " + result);
    // }

    @Data
    private static class GroupResultDto {
        private String id;
        private Long numberOfPhones;

        public GroupResultDto(String id, Long numberOfPhones) {
            this.id = id;
            this.numberOfPhones = numberOfPhones;
        }
    }

    private void fetchingByCriteriaBuilderJoin(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<User> userRoot = cq.from(User.class);
        Join<User, Phone> phonesJoin = userRoot.join("phones");

        cq.multiselect(
            userRoot.get("id"),
            userRoot.get("firstName"),
            userRoot.get("lastName"),
            phonesJoin.get("value")
        );

        List<Object[]> result = session.createQuery(cq).getResultList();

        for(Object[] row: result) {
            System.out.println("id: " + row[0]);
            System.out.println("firstName: " + row[1]);
            System.out.println("lastName: " + row[2]);
            System.out.println("phone: " + row[3]);
        }
    }

    private void testEntityInstance() {
        System.out.println("testEntityInstance");

        // Sesja 1
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = createUser();
        user.setFirstName("Dariusz");

        session.save(user);
        session.getTransaction().commit();

        // Pobieram użytkownika z sesji
        User userA = session.load(User.class, user.getId());

        System.out.println("user == userA: " + (user == userA));

        // Sesja 2
        Session session2 = sessionFactory.openSession();

        session2.load(user, user.getId());

        User userB = session2.load(User.class, user.getId());

        System.out.println("user == userB: " + (user == userB));

        session.close();
        session2.close();
    }

    private void testSaveEntity() {
        System.out.println("testSaveEntity");

        // Sesja 1
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = createUser();
        user.setFirstName("Dariusz");

        session.save(user);

        session.getTransaction().commit();
        session.close();

        // Sesja 2
        session = sessionFactory.openSession();
        session.beginTransaction();

        user.setFirstName("Jolanta");

        // session.load(user, user.getId());
        // session.save(user);

        session.saveOrUpdate(user);

        session.getTransaction().commit();
        session.close();
    }

    private void fetchByIdReference() {
        System.out.println("fetchByIdReference");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = createUser();

        session.persist(user);
        session.getTransaction().commit();
        session.close();

        // Get user refernce
        session = sessionFactory.openSession();

        User userReference = (User) session.byId(User.class).getReference(user.getId());

        System.out.println("userReference: " + userReference);

        session.close();
    }

    private void testMerge() {
        System.out.println("testMerge");

        // Sesja 1
        Session session = sessionFactory.openSession();

        User user = createUser();
        session.beginTransaction();

        user.setFirstName("Agnieszka");
        user.setLastName("Iksińska");

        session.persist(user);

        session.getTransaction().commit();
        session.close();

        // Sesja 2
        session = sessionFactory.openSession();
        session.beginTransaction();

        user.setLastName("Wrona");

        // Jeśli w sesji w danej sesji isnieie obiekt to zostanie wykorzystany i zwrócony,
        // jeśli nie istnieje, to zostanie pobrany i zwrócony.
        // Dane są od razu zapisane w bazie.
        User userMerged = (User) session.merge(user);

        session.getTransaction().commit();
        session.close();
    }

    private void testRefresh() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = createUser();
        user.setFirstName("Michał");

        session.persist(user);

        session.getTransaction().commit();
        session.close();

        // W ramach drugiej sesji inicj
        session = sessionFactory.openSession();

        user.setFirstName("Natalia");

        System.out.println("user: " + user);

        // Aktualizuje dane
        session.refresh(user);

        System.out.println("user: " + user);

        session.close();
    }

    private void loadEntity() {
        System.out.println("loadEntity");

        String userId = UUID.randomUUID().toString();
        String userIdLoad = UUID.randomUUID().toString();
        String userIdAfter = UUID.randomUUID().toString();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user;

        user = createUser();
        user.setId(userId);

        session.persist(user);

        user = createUser();
        user.setId(userIdLoad);

        session.persist(user);

        user = createUser();
        user.setId(userIdAfter);

        session.persist(user);

        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();

        // Fetch user
        // Pobranie przez Class<T>
        User userA = session.load(User.class, userId);

        // Pobranie przez ścieżke do encji
        User userB = (User) session.load("com.ttmdear.repository.hibernate.core.domain.User", userId);

        // Przekazanie obiektu do wypełnienia
        User userC = new User();

        session.load(userC, userIdLoad);

        // Użycie metody Session.get
        User userD = session.get(User.class, userId);
        User userE = (User) session.get("com.ttmdear.repository.hibernate.core.domain.User", userId);

        // Brak encji
        User userF = session.get(User.class, "123");
        User userG = session.load(User.class, "123");

        System.out.println("userA: " + userA);
        System.out.println("userB: " + userB);
        System.out.println("userC: " + userC);
        System.out.println("userD: " + userD);
        System.out.println("userE: " + userE);
        System.out.println("userF: " + userF);

        try {
            System.out.println("userG: " + userG);
        } catch (ObjectNotFoundException e) {
            System.out.println("userG: null");
        }

        User userH = session.get(User.class, userIdAfter);

        // Odwołanie się do sesji
        // userH.getPhones().size();

        // Wykorzystanie metody do inicjalizacji
        // Hibernate.initialize(userH.getPhones());

        session.close();

        session = sessionFactory.openSession();

        session.update(userH);

        System.out.println("userH: " + userH);
    }

    private void fetchingByNamedQuery() {
        System.out.println("fetchingByNamedQuery");

        EntityManager entityManager = sessionFactory.createEntityManager();

        Query query = entityManager.createNamedQuery("CORE_USER.ACTIVE_USERS");

        List<User> users = query.getResultList();

        System.out.println(users);

        entityManager.close();
    }

    private void fetchingByCriteriaBuilderTupleQuery() {
        System.out.println("fetchingByCriteriaBuilderTupleQuery");

        EntityManager entityManager = sessionFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Tuple> cq = cb.createTupleQuery();

        Root<User> userRoot = cq.from(User.class);

        cq.select(cb.tuple(
                userRoot.get("id"),
                userRoot.get("firstName")
        ));

        List<Tuple> values = entityManager.createQuery(cq).getResultList();

        for(Tuple row: values) {
            System.out.println("id: " + row.get(0, String.class));
            System.out.println("firstName: " + row.get(1, String.class));

            break;
        }
    }

    private void fetchingByCriteriaBuilderMultiSelect() {
        System.out.println("fetchingByCriteriaBuilderMultiSelect");

        EntityManager entityManager = sessionFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<User> userRoot = cq.from(User.class);

        cq.multiselect(
            userRoot.get("id"),
            userRoot.get("firstName")
        );

        List<Object[]> values = entityManager.createQuery(cq).getResultList();

        for(Object[] row: values) {
            System.out.println("id: " + row[0]);
            System.out.println("firstName: " + row[1]);

            break;
        }
    }

    private void fetchingByCriteriaBuilderFields() {
        System.out.println("fetchingByCriteriaBuilderFields");

        EntityManager entityManager = sessionFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        // Definiujemy jaki typ pola ma zostać zwrócony
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        // Tworzymy obiekt aby odwołac się do pola
        Root<User> userRoot = cq.from(User.class);

        // Wybieramy pole które ma zostać wybrane
        cq.select(cb.array(userRoot.get("firstName"), userRoot.get("lastName")));

        List<Object[]> values = entityManager.createQuery(cq).getResultList();

        for(Object[] value: values) {
            System.out.println("firstName: " + value[0]);
            System.out.println("lastName: " + value[1]);
        }

        entityManager.close();
    }

    private void fetchingByCriteriaBuilderField() {
        System.out.println("fetchingByCriteriaBuilderField");

        EntityManager entityManager = sessionFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        // Definiujemy jaki typ pola ma zostać zwrócony
        CriteriaQuery<String> cq = cb.createQuery(String.class);

        // Tworzymy obiekt aby odwołac się do pola
        Root<User> userRoot = cq.from(User.class);

        // Wybieramy pole które ma zostać wybrane
        cq.select(userRoot.<String>get("firstName"));

        String firstName = entityManager.createQuery(cq).getResultList().get(0);

        System.out.println(firstName);

        entityManager.close();
    }

    private void fetchingByNamedNativeQuery() {
        EntityManager entityManager = sessionFactory.createEntityManager();

        Query query = entityManager.createNamedQuery("USER_ALL");

        List<User> users = query.getResultList();

        System.out.println(users);

        entityManager.close();
    }

    private void fetchingByCriteriaBuilderEntity() {
        System.out.println("fetchingByCriteriaBuilder");
        EntityManager entityManager = sessionFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        // Pobranie encji
        CriteriaQuery<User> cqf = cb.createQuery(User.class);

        Root<User> userRoot = cqf.from(User.class);

        cqf.select(userRoot);

        // Expression expression = cb.equal(userRoot.get("id"), cb.literal("2fe48679-74cc-4581-b7aa-b6d4a795624d"));

        // cqf.where(expression);

        User user = entityManager.createQuery(cqf).getResultList().get(0);

        System.out.println(user);

        entityManager.close();
    }

    private void fetchingByCriteriaBuilderEntityWhere() {
        System.out.println("fetchingByCriteriaBuilderEntityWhere");
        EntityManager entityManager = sessionFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        // Pobranie encji
        CriteriaQuery<User> cqf = cb.createQuery(User.class);

        Root<User> userRoot = cqf.from(User.class);

        cqf.select(userRoot);

        Expression expression = cb.equal(userRoot.get("type"), UserType.CUSTOMER);

        cqf.where(expression);

        User user = entityManager.createQuery(cqf).getResultList().get(0);

        System.out.println(user);

        entityManager.close();
    }

    private void fetchingByQuery() {
        EntityManager entityManager = sessionFactory.createEntityManager();

        List<User> users = entityManager.createQuery("FROM User ", User.class).getResultList();

        System.out.println(users);

        entityManager.close();
    }

    private void fetchingByNativeQuery() {
        System.out.println("fetchingByNativeQuery");

        EntityManager entityManager = sessionFactory.createEntityManager();

        List<User> users = entityManager.createNativeQuery("SELECT * FROM CORE_USER", User.class).getResultList();
        List<User> usersB = entityManager.createNativeQuery("SELECT id, FIRST_NAME FROM CORE_USER", User.class).getResultList();
        Number number = (Number) entityManager.createNativeQuery("SELECT COUNT(*) FROM CORE_USER").getSingleResult();

        // System.out.println("users: " + users);
        System.out.println("usersB: " + usersB);
        System.out.println("number: " + number);

        entityManager.close();
    }

    private void initDatabase() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        // Init data
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(createUser(UserType.CUSTOMER));
        session.persist(createUser(UserType.ADMIN));
        session.persist(createUser(UserType.EMPLOYEE));

        session.getTransaction().commit();
        session.close();
    }

    private User createUser() {
        return createUser(getRandomUserType());
    }

    private User createUser(UserType userType) {
        User user = new User();
        user.setFirstName(String.format("Jan - %s", random.nextInt(100)));
        user.setLastName(String.format("Kowalki - %s", random.nextInt(100)));
        user.setType(userType);
        user.setStatus(getRandomUserStatus());

        Phone janPhoneA = new Phone();
        janPhoneA.setValue(String.format("%s-%s-%s", random.nextInt(999), random.nextInt(999), random.nextInt(999)));

        user.getPhones().add(janPhoneA);
        user.getPhones().add(janPhoneA);


        return user;
    }

    private UserType getRandomUserType() {
        List<UserType> elements = Arrays.asList(UserType.ADMIN, UserType.CUSTOMER, UserType.EMPLOYEE);

        return elements.get(random.nextInt(3));
    }

    private UserStatus getRandomUserStatus() {
        List<UserStatus> elements = Arrays.asList(UserStatus.ACTIVE, UserStatus.INACTIVE);

        return elements.get(random.nextInt(2));
    }

    private void runInSession(Consumer<Session> toRun) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        toRun.accept(session);

        session.getTransaction().commit();
        session.close();
    }
}
