package application;

public class hasta {
	private int hastaNo;
	private String hastaAdi;
	private String hastaDogTarih;

	hasta(){
		
	}
	
	hasta(int hastaNo,String hastaAdi,String hastaDogTarih){
		this.hastaNo=hastaNo;
		this.hastaAdi=hastaAdi;
		this.hastaDogTarih=hastaDogTarih;
		
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
	public String getHastaDogTarih() {
		return hastaDogTarih;
	}
	public void setHastaDogTarih(String hastaDogTarih) {
		this.hastaDogTarih = hastaDogTarih;
	}
	
   
	
	
}
