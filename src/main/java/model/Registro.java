package model;

public class Registro {
	private Long id;
	private String nombre;
	private String contranesa;
	private String rol;
	private int permisos_id;

	public Registro() {
		super();
	}

	public Registro(Long id, String nombre, String contranesa, String rol, int permisos_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contranesa = contranesa;
		this.rol = rol;
		this.permisos_id = permisos_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContranesa() {
		return contranesa;
	}

	public void setContranesa(String contranesa) {
		this.contranesa = contranesa;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getPermisos_id() {
		return permisos_id;
	}

	public void setPermisos_id(int permisos_id) {
		this.permisos_id = permisos_id;
	}

}
