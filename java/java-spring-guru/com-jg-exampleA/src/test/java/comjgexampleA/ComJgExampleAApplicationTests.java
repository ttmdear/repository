package comjgexampleA;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SpringBootTest
class ComJgExampleAApplicationTests {

	@Test
	void contextLoads() {

	    Map<Object, String> map = new HashMap<>();

	    Person p1 = new Person("10", "Paweł");
		Person p2 = new Person("10", "Paweł");

	    map.put(p1, "1");

	    System.out.println("contain: " + map.containsKey(p1));
		System.out.println("contain: " + map.containsKey(p2));
	}

	public static class Person {
		private String id;
		private String name;

		public Person(String id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Person person = (Person) o;
			return Objects.equals(id, person.id) &&
					Objects.equals(name, person.name);
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, name);
		}
	}
}
