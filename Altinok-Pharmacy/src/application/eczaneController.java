package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.IsteMySQL.Util.VeritabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class eczaneController implements Initializable{

	
	String sql="";
	int idm=0;
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	
	 public eczaneController() throws SQLException {
			baglanti=VeritabaniUtil.Baglan();
		}
	
	 
	 
	@FXML
    private TableView<satis> satistab;

    @FXML
    private TableColumn<?, ?> satisNo;
	 
    @FXML
    private TableColumn<?, ?> ilacNo;
    
    @FXML
    private TableColumn<?, ?> ilacAdi;
    
    @FXML
    private TableColumn<?, ?> ilacFiyati;
    
    @FXML
    private TableColumn<?, ?> hastaNo;
    
    @FXML
    private TableColumn<?, ?> hastaAdi;
    
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<eczane, ?> eczaneNo;

    @FXML
    private TextField textpersoneladi;

    @FXML
    private TableColumn<eczane, ?> eczaneAdi;

    @FXML
    private TableColumn<?, ?> personelNo;

    @FXML
    private TableColumn<?, ?> personelMaas;

    @FXML
    private TableColumn<?, ?> personelAdi;


    @FXML
    private TextField textpersonelno;

    @FXML
    private TextField texteczaneno;

    @FXML
    private TableView<eczane> eczanetab;

    @FXML
    private TableView<personel> personeltab;

    @FXML
    private Label lbl_snc;
    
    @FXML
    private Label lbltoplam;

    @FXML
    private Label lblkasa;
    
    @FXML
    private TextField textpersonelmaas;

    @FXML
    void eklebutton_click(ActionEvent event) {
    	sql="insert into personel(personelAdi,personelMaas) values(?,?)";
        
    	try {
	    	sorguIfadesi=baglanti.prepareStatement(sql);
	    	
	    	sorguIfadesi.setString(1,textpersoneladi.getText().trim());
	    	sorguIfadesi.setString(2, textpersonelmaas.getText().trim());
	    
	    	
	    	
	    	sorguIfadesi.executeUpdate();
	    	    
			PersonelGetir(personeltab);

    	} catch (Exception e) {
    		lbl_snc.setText(e.getMessage().toString());
    	}
    }

    @FXML
    void silbutton_click(ActionEvent event) {
    	sql="delete from personel where  personelAdi=? and personelMaas=? and personelNo=?";
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			
	    	sorguIfadesi.setString(1, textpersoneladi.getText().trim());
	    	sorguIfadesi.setString(2, textpersonelmaas.getText().trim());   
	    	sorguIfadesi.setString(3, textpersonelno.getText().trim());  
			sorguIfadesi.executeUpdate();
			
			lbl_snc.setText("Silme islemi basarýlý");
			PersonelGetir(personeltab);
		} catch (Exception e) {
			lbl_snc.setText(e.getMessage().toString());
		}
    }

    @FXML
    void guncellebutton_click(ActionEvent event) {
    	sql="update personel set personelAdi=? ,personelMaas=? where personelNo=?";
   	 	try {
   	 		sorguIfadesi=baglanti.prepareStatement(sql);
	   		sorguIfadesi.setString(1, textpersoneladi.getText().trim());
	    	sorguIfadesi.setString(2, textpersonelmaas.getText().trim());
	    	sorguIfadesi.setString(3, textpersonelno.getText().trim());
	    	
	    	sorguIfadesi.executeUpdate();
	    	lbl_snc.setText("Güncelleme iþlemi baþarýlý");
	    	PersonelGetir(personeltab);
	   	} 
   	 	catch (Exception e) {
	   	lbl_snc.setText(e.getMessage().toString());
	   	}
    }

    @FXML
    void temizlebutton_click(ActionEvent event) {
    	textpersonelno.setText(null);
    	textpersoneladi.setText(null);
    	textpersonelmaas.setText(null);
    	texteczaneno.setText(null);
    }

    
    @FXML
    void personeltab_click(MouseEvent event) {
    	personel kayitlar=new personel();
    	kayitlar= (personel) personeltab.getItems().get(personeltab.getSelectionModel().getSelectedIndex());
   
    	textpersonelno.setText(Integer.toString(kayitlar.getPersonelNo()));
    	textpersoneladi.setText(kayitlar.getPersonelAdi());
    	textpersonelmaas.setText(Integer.toString(kayitlar.getPersonelMaas()));
    	
    						
    }
    
    
    @FXML
    void kasayenilebutton_click(ActionEvent event) {
    	sql="DELETE FROM ilacsatis";
    	
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			
			sorguIfadesi.executeUpdate();
			
			
			SatisGetir(satistab);
			lblkasa.setText("Kasa Sýfýrlandý");
			lbltoplam.setText("0"+" TL");
		} catch (Exception e) {
			lblkasa.setText(e.getMessage().toString());
		}
  
    }

    @FXML
    void exitbutton_click(ActionEvent event) {
    	System.exit(0);
    }
    @FXML
    void geridonbutton_click(ActionEvent event) throws IOException{
    	Stage stg=new Stage();
    	stg.setTitle("ECZANE");
  		AnchorPane root= (AnchorPane)FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
  		stg.setScene(new Scene(root,800,521));
		stg.getIcons().add(new Image("file:img/icon.png"));
  		stg.show();
  		((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    
    public void EczaneGetir(TableView<eczane> eczanetab) {
    	sql="select * from eczane";
    	ObservableList<eczane> kayitlarListe=FXCollections.observableArrayList();
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			while(getirilen.next()) {
				kayitlarListe.add(new eczane(getirilen.getInt("eczaneNo"),getirilen.getString("eczaneAdi"),getirilen.getInt("personelNo")));
			}		
			
			eczaneNo.setCellValueFactory(new PropertyValueFactory<>("eczaneNo"));
			eczaneAdi.setCellValueFactory(new PropertyValueFactory<>("eczaneAdi"));
			personelNo.setCellValueFactory(new PropertyValueFactory<>("personelNo"));
			
		
			eczanetab.setItems(kayitlarListe);
				lbl_snc.setText("Baðlantý Baþarýsýz");
			
		} catch (Exception e) {
				lbl_snc.setText(e.getMessage().toString());
		}
    }
    
    public void PersonelGetir(TableView<personel> personeltab) {
    	sql="select * from personel";
    	ObservableList<personel> kayitlarListe=FXCollections.observableArrayList();
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			while(getirilen.next()) {
				kayitlarListe.add(new personel(getirilen.getInt("personelNo"),getirilen.getString("personelAdi"),getirilen.getInt("personelMaas")));
			}		
			
				personelNo.setCellValueFactory(new PropertyValueFactory<>("personelNo"));
				personelAdi.setCellValueFactory(new PropertyValueFactory<>("personelAdi"));
				personelMaas.setCellValueFactory(new PropertyValueFactory<>("personelMaas"));
			
		
				personeltab.setItems(kayitlarListe);
				lbl_snc.setText("Baðlantý Baþarýsýz");
			
		} catch (Exception e) {
				lbl_snc.setText(e.getMessage().toString());
		}
    }
    
    
    public void SatisGetir(TableView<satis> satistab) {
    	sql="select * from ilacsatis";
    	ObservableList<satis> kayitlarListe=FXCollections.observableArrayList();
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			while(getirilen.next()) {
				kayitlarListe.add(new satis(getirilen.getInt("satisNo"),getirilen.getInt("ilacNo"),getirilen.getString("ilacAdi"),getirilen.getDouble("ilacFiyati"),getirilen.getInt("hastaNo"),getirilen.getString("hastaAdi")));
			}		
			
			satisNo.setCellValueFactory(new PropertyValueFactory<>("satisNo"));
			ilacNo.setCellValueFactory(new PropertyValueFactory<>("ilacNo"));
			ilacAdi.setCellValueFactory(new PropertyValueFactory<>("ilacAdi"));
			ilacFiyati.setCellValueFactory(new PropertyValueFactory<>("ilacFiyati"));
			hastaNo.setCellValueFactory(new PropertyValueFactory<>("hastaNo"));
			hastaAdi.setCellValueFactory(new PropertyValueFactory<>("hastaAdi"));
		
			satistab.setItems(kayitlarListe);
				lbl_snc.setText("Baðlantý Baþarýsýz");
			
		} catch (Exception e) {
				lbl_snc.setText(e.getMessage().toString());
		}
    }
    
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
   		EczaneGetir(eczanetab);
   		PersonelGetir(personeltab);
   		SatisGetir(satistab);
   		
   		sql="SELECT sum(ilacduzenle.ilacFiyati) FROM ilacduzenle INNER JOIN ilacsatis on ilacduzenle.ilacNo=ilacsatis.ilacNo";
    	try {
	    	sorguIfadesi=baglanti.prepareStatement(sql);
	    	ResultSet getirilen=sorguIfadesi.executeQuery();
	    	while(getirilen.next()) {
	    		lbltoplam.setText(Double.toString(getirilen.getDouble("sum(ilacduzenle.ilacFiyati)"))+" TL");
	    	}
    	} catch (Exception e) {
    		lbltoplam.setText(e.getMessage().toString());
    	}
    	
   	}
}
