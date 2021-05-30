package application;

public class ilacduzenle {
	private int ilacNo;
	private String ilacAdi;
	private Double ilacFiyati;
	private int firmaNo;

	ilacduzenle(){
		
	}
	
	ilacduzenle(int ilacNo,String ilacAdi,Double ilacFiyati, int firmaNo){
		this.ilacNo=ilacNo;
		this.ilacAdi=ilacAdi;
		this.ilacFiyati=ilacFiyati;
		this.firmaNo=firmaNo;

	}
	
	public int getIlacNo() {
		return ilacNo;
	}
	public void setIlacNo(int ilacNo) {
		this.ilacNo = ilacNo;
	}
	public String getIlacAdi() {
		return ilacAdi;
	}
	public void setIlacAdi(String ilacAdi) {
		this.ilacAdi = ilacAdi;
	}
	public Double getIlacFiyati() {
		return ilacFiyati;
	}
	public void setIlacFiyati(Double ilacFiyati) {
		this.ilacFiyati = ilacFiyati;
	}
	
	public int getFirmaNo() {
		return firmaNo;
	}
	public void setFirmaNo(int firmaNo) {
		this.firmaNo = firmaNo;
	}
	
	

}
