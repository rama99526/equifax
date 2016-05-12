package springworld;

import org.springframework.stereotype.Component;

@Component("hellospringworld")
public class Hellospringworld {
	private String name;

	public void setName(String name) {
		this.name = name;

	}

	String sayHello() {
		return "Hello! " + name + ", " + "welcome to spring world";
	}
}
