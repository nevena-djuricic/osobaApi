

public class Osoba {

	private String ime;
	private String prezime;
	private int godine;
	private String pol;
	
	public Osoba(String name, String surname, int age, String sex) {
		ime = name;
		prezime = surname;
		godine = age;
		pol = sex;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public int getGodine() {
		return godine;
	}
	
	public void setGodine(int godine) {
		this.godine = godine;
	}
	
	public String getPol() {
		return pol;
	}
	
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Osoba) {
			Osoba p = (Osoba) o;
			
			if(ime.equals(p.getIme()) && prezime.equals(p.getPrezime()) 
					&& godine == p.getGodine() && pol.equals(p.getPol())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Ime: " + ime + " Prezime: " + prezime + " Godine: " + godine + " Pol: " + pol;
	}
	
}
