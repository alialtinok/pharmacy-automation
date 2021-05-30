package application;


public class firma {
	private int firmaNo;
	private String firmaAdi;
	private int eczaneNo;
	
	
	firma(){
		
	}
	
	
	firma(int firmaNo,String firmaAdi,int eczaneNo){
		this.firmaNo=firmaNo;
		this.firmaAdi=firmaAdi;
		this.eczaneNo=eczaneNo;
		
	}
	

	public int getFirmaNo() {
		return firmaNo;
	}
	public void setFirmaNo(int firmaNo) {
		this.firmaNo = firmaNo;
	}
	public String getFirmaAdi() {
		return firmaAdi;
	}
	public void setFirmaAdi(String firmaAdi) {
		this.firmaAdi = firmaAdi;
	}
	public int getEczaneNo() {
		return eczaneNo;
	}
	public void setEczaneNo(int eczaneNo) {
		this.eczaneNo = eczaneNo;
	}

   
}