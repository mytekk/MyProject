package pl.sdacademy.model;

public class Cat {

	String name;

	public Cat() {

	}

	public Cat(String name) {
		this.name = name;
	}

	public void voice() {
		System.out.println("Miau-miau!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
