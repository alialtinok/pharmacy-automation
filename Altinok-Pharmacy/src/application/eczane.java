package application;


public class eczane {
	private int eczaneNo;
	private String eczaneAdi;
	private int personelNo;
	
	
	eczane(){
		
	}
	
	eczane(int eczaneNo,String eczaneAdi,int personelNo){
		this.eczaneNo=eczaneNo;
		this.eczaneAdi=eczaneAdi;
		this.personelNo=personelNo;
		
	}
	


	public int getEczaneNo() {
		return eczaneNo;
	}
	public void setEczaneNo(int eczaneNo) {
		this.eczaneNo = eczaneNo;
	}
	public String getEczaneAdi() {
		return eczaneAdi;
	}
	public void setEczaneAdi(String eczaneAdi) {
		this.eczaneAdi= eczaneAdi;
	}
	public int getPersonelNo() {
		return personelNo;
	}
	public void setPersonelNo(int personelNo) {
		this.personelNo = personelNo;
	}

   
}