package repo.spring5iocbeanfactory.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import repo.spring5iocbeanfactory.UserCreatedEvent;

@Component
public class Bootstrap implements CommandLineRunner, ApplicationContextAware, BeanFactoryAware,
    ApplicationEventPublisherAware {
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void run(String... args) throws Exception {
        NotificationService b1 = applicationContext.getBean(NotificationService.class);
        NotificationService b2 = applicationContext.getBean(NotificationService.class);
        NotificationService b3 = beanFactory.getBean(NotificationService.class);

        b1.setGroup("A");
        b2.setGroup("A");
        b3.setGroup("B");

        System.out.println(String.format("b1 %s", b1.getId()));
        System.out.println(String.format("b2 %s", b2.getId()));
        System.out.println(String.format("b3 %s", b3.getId()));

        applicationEventPublisher.publishEvent(new UserCreatedEvent(this));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
