package application;


public class personel {
	private int personelNo;
	private String personelAdi;
	private int personelMaas;

	
	personel(){
		
	}
	

	personel(int personelNo,String personelAdi,int personelMaas){
		this.personelNo=personelNo;
		this.personelAdi=personelAdi;
		this.personelMaas=personelMaas;


		
	}
	


	public int getPersonelNo() {
		return personelNo;
	}
	public void setPersonelNo(int personelNo) {
		this.personelNo = personelNo;
	}
	public String getPersonelAdi() {
		return personelAdi;
	}
	public void setPersonelAdi(String personelAdi) {
		this.personelAdi= personelAdi;
	}
	public int getPersonelMaas() {
		return personelMaas;
	}
	public void setPersonelMaas(int personelMaas) {
		this.personelMaas = personelMaas;
	}
	
   
}