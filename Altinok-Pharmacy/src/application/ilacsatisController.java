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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class ilacsatisController implements Initializable{

	
	String sql="";
	int idm=0;
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	
	public ilacsatisController() throws SQLException {
		baglanti=VeritabaniUtil.Baglan();
	}
	 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField texthastaadi;

   
   
   

    @FXML
    private TableView<ilacduzenle> ilactab; 

    
    @FXML
    private TableColumn<ilacduzenle, Integer> ilacNo;
   
    @FXML
    private TableColumn<ilacduzenle, String> ilacAdi;
    
    @FXML
    private TableColumn<ilacduzenle, Double> ilacFiyati;
    
    @FXML
    private TableColumn<ilacduzenle, Integer> firmaNo;

    @FXML
    private Label lbl_snc;

    @FXML
    private Label lblilacno;

    @FXML
    private Label lblilacadi;

    @FXML
    private Label lblilacfiyati;

    @FXML
    private Label lblhastadogtarih;

    @FXML
    private Label lblhastaadi;

    @FXML
    private Label lblhastano;

    @FXML
    private Label lblfirmano;

    @FXML
    private Label lblsatinal;

    @FXML
    private Button satinalbutton;
    
    @FXML
    private TableView<hasta> hastatab;
    
    @FXML
    private TableColumn<hasta, Integer> hastaNo;
    
    @FXML
    private TableColumn<hasta, String> hastaAdi;

    @FXML
    private TableColumn<hasta, String> hastaDogTarih;

    

    ObservableList<ilacduzenle> veriler2;
    
    ObservableList<hasta> veriler;
    @FXML
    void hastatab_click(ActionEvent event) {
    	
    }

    @FXML
    void ilactab_click(ActionEvent event) {
    	
    }
   
    
    @FXML
    void satinalbutton_click(ActionEvent event) {
    			hasta islem=new hasta();
    			
    			islem= (hasta) hastatab.getItems().get(hastatab.getSelectionModel().getSelectedIndex());

		    	lblhastano.setText("              Hasta No : "+ Integer.toString(islem.getHastaNo()));
		    	lblhastaadi.setText("             Hasta Adý : "+ islem.getHastaAdi());
		    	lblhastadogtarih.setText("Hasta Doðum Tarihi : "+ islem.getHastaDogTarih());

		    	
		    	ilacduzenle islem2=new ilacduzenle();

	        	islem2= (ilacduzenle) ilactab.getItems().get(ilactab.getSelectionModel().getSelectedIndex());  
    		
		    	lblilacno.setText("    Ýlaç No : "+ Integer.toString(islem2.getIlacNo()));
		    	lblilacadi.setText("   Ýlaç Adý : "+ islem2.getIlacAdi());
		    	lblilacfiyati.setText("Ýlaç Fiyatý : "+ Double.toString(islem2.getIlacFiyati()));
		    	lblfirmano.setText(" Firma No : "+Integer.toString(islem2.getFirmaNo()));
    		
		    	
		    	sql="insert into ilacsatis(ilacNo,ilacAdi,ilacFiyati,hastaNo,hastaAdi) values(?,?,?,?,?)";
		    	islem= (hasta) hastatab.getItems().get(hastatab.getSelectionModel().getSelectedIndex());
		    	islem2= (ilacduzenle) ilactab.getItems().get(ilactab.getSelectionModel().getSelectedIndex());  
	    		
		    	try {
			    	sorguIfadesi=baglanti.prepareStatement(sql);
			    	
			    	sorguIfadesi.setString(1, Integer.toString(islem2.getIlacNo()));
			    	sorguIfadesi.setString(2, islem2.getIlacAdi());
			    	sorguIfadesi.setString(3, Double.toString(islem2.getIlacFiyati()));
			    	sorguIfadesi.setString(4, Integer.toString(islem.getHastaNo()));
			    	sorguIfadesi.setString(5, islem.getHastaAdi());
			    	
			    	
			    	sorguIfadesi.executeUpdate();
			    	    
					HastaGetir(hastatab);
				
		    	} catch (Exception e) {
		    		lbl_snc.setText(e.getMessage().toString());
		    	}
		    	
		    			    	
		    	
		    	lblsatinal.setText("Satýn Alýndý");
    	
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
    
    
    public void HastaGetir(TableView<hasta> hastatab) {
    	sql="select * from hasta";
    	ObservableList<hasta> kayitlarListe=FXCollections.observableArrayList();
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			while(getirilen.next()) {
			kayitlarListe.add(new hasta(getirilen.getInt("hastaNo"),getirilen.getString("hastaAdi"),getirilen.getString("hastaDogTarih")));
			}		
				hastaNo.setCellValueFactory(new PropertyValueFactory<>("hastaNo"));
				hastaAdi.setCellValueFactory(new PropertyValueFactory<>("hastaAdi"));
				hastaDogTarih.setCellValueFactory(new PropertyValueFactory<>("hastaDogTarih"));
				
		
			hastatab.setItems(kayitlarListe);
				lbl_snc.setText("Baðlantý Baþarýsýz");
			
		} catch (Exception e) {
				lbl_snc.setText(e.getMessage().toString());
		}
    }
   
    public void IlacGetir(TableView<ilacduzenle> ilactab) {
    	sql="select * from ilacduzenle";
    	ObservableList<ilacduzenle> kayitlarListe=FXCollections.observableArrayList();
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			while(getirilen.next()) {
			kayitlarListe.add(new ilacduzenle(getirilen.getInt("ilacNo"),getirilen.getString("ilacAdi"),getirilen.getDouble("ilacFiyati"),getirilen.getInt("firmaNo")));
			}		
				ilacNo.setCellValueFactory(new PropertyValueFactory<>("ilacNo"));
				ilacAdi.setCellValueFactory(new PropertyValueFactory<>("ilacAdi"));
				ilacFiyati.setCellValueFactory(new PropertyValueFactory<>("ilacFiyati"));
				firmaNo.setCellValueFactory(new PropertyValueFactory<>("firmaNo"));
				
			
			ilactab.setItems(kayitlarListe);
				lbl_snc.setText("Baðlantý Baþarýsýz");
			
		} catch (Exception e) {
				lbl_snc.setText(e.getMessage().toString());
		}
    }
    
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
   		HastaGetir(hastatab);
   		IlacGetir(ilactab);
   	}
   
}
