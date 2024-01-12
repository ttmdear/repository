package repo.java.lambda;

import java.util.List;
import java.util.stream.Collectors;

public class _Main {
    public static void main(String[] args) {
        case1();
        caseEvent();
        caseEventsCaller();
    }

    private static void caseEventsCaller() {
        run(List.of(1, 2, 3).stream()
            .map(integer -> (EventListener) event -> {
                System.out.printf("%s (%s) %n", event, integer);
            })
            .collect(Collectors.toList())
        );
    }

    private static void caseEvent() {
        attach(new EventListener() {
            @Override
            public void on(String event) {
                System.out.printf("event", event);
            }
        });

        attach(event -> System.out.printf("event%n", event));
    }

    private static void attach(EventListener eventListener) {
        eventListener.on("TEST");
    }

    private static void run(List<EventListener> eventListeners) {
        eventListeners.forEach(eventListener -> eventListener.on("TEST "));
    }

    private static void case1() {
        print(new IntProvider() {
            @Override
            public Integer get() {
                return 10;
            }
        });

        IntProvider intProvider = new IntProvider() {
            @Override
            public Integer get() {
                return 20;
            }
        };

        print(intProvider);

        IntProvider intProvider1 = () -> 30;
        print(intProvider1);

        print(() -> 40);
    }

    public static void print(IntProvider intProvider) {
        System.out.printf("values is %s%n", intProvider.get());
    }
}
