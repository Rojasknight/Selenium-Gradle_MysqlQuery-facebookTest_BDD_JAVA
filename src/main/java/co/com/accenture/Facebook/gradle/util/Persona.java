package co.com.accenture.Facebook.gradle.util;

import java.util.ArrayList;

public class Persona {

	ArrayList<String> nombreArrayList = new ArrayList<String>();

	public ArrayList<String> getNombres() {
		return this.nombreArrayList;
	}

	public void setNombre(String nombre) {

		this.nombreArrayList.add(nombre);

	}
}
