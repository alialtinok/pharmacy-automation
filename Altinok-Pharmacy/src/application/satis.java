package application;

public class satis {
	private int satisNo;
	private int ilacNo;
	private String ilacAdi;
	private Double ilacFiyati;
	private int hastaNo;
	private String hastaAdi;
	satis(){
		
	}
	
	satis(int satisNo,int ilacNo,String ilacAdi,Double ilacFiyati,int hastaNo,String hastaAdi){
		this.satisNo=satisNo;
		this.ilacNo=ilacNo;
		this.ilacAdi=ilacAdi;
		this.ilacFiyati=ilacFiyati;
		this.hastaNo=hastaNo;
		this.hastaAdi=hastaAdi;
		
	}
	
	public int getSatisNo() {
		return satisNo;
	}
	public void setSatisNo(int satisNo) {
		this.satisNo = satisNo;
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
	public int getHastaNo() {
		return hastaNo;
	}
	public void setHastaNo(int hastaNo) {
		this.hastaNo = hastaNo;
	}
	public String getHastaAdi() {
		return hastaAdi;
	}
	public void setHastaAdi(String hastaAdi) {
		this.hastaAdi = hastaAdi;
	}
   
	
	
}
