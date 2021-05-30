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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ilacduzenleController implements Initializable{

	String sql="";
	int idm=0;
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	
	 public ilacduzenleController() throws SQLException {
			baglanti=VeritabaniUtil.Baglan();
	}
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textilacno;

    @FXML
    private TextField textilacadi;

    @FXML
    private TableColumn<?, ?> firmaNo;

    @FXML
    private Label lbl_snc;

    @FXML
    private ComboBox<String> combofirmano;
    
    @FXML
    private TableColumn<?, ?> ilacNo;

    @FXML
    private TableColumn<?, ?> ilacFiyati;

    @FXML
    private TextField textilacfiyati;

    @FXML
    private TableView<ilacduzenle> ilactab;

    @FXML
    private TableColumn<?, ?> ilacAdi;

    @FXML
    private TextField textfirmano;

    @FXML
    void ilactab_click(MouseEvent event) {
		ilacduzenle kayitlar=new ilacduzenle();
    	kayitlar= (ilacduzenle) ilactab.getItems().get(ilactab.getSelectionModel().getSelectedIndex());
   
    	textilacno.setText(Integer.toString(kayitlar.getIlacNo()));
    	textilacadi.setText(kayitlar.getIlacAdi());
    	textilacfiyati.setText(Double.toString(kayitlar.getIlacFiyati()));
    	combofirmano.setPromptText(Integer.toString(kayitlar.getFirmaNo()));
    }

    @FXML
    void eklebutton_click(ActionEvent event) {
    	sql="insert into ilacduzenle(ilacAdi,ilacFiyati,firmaNo) values(?,?,?)";
        
    	try {
	    	sorguIfadesi=baglanti.prepareStatement(sql);
	    	
	    	sorguIfadesi.setString(1, textilacadi.getText().trim());
	    	sorguIfadesi.setString(2, textilacfiyati.getText().trim());
	    	sorguIfadesi.setString(3, combofirmano.getSelectionModel().getSelectedItem().toString().trim());
	          
	    	
	    	
	    	sorguIfadesi.executeUpdate();
	    	    
			DegerleriGetir(ilactab);

    	} catch (Exception e) {
    		lbl_snc.setText(e.getMessage().toString());
    	}
    }

    @FXML
    void silbutton_click(ActionEvent event) {
    	sql="delete from ilacduzenle where  ilacAdi=? and ilacFiyati=? and firmaNo=?";
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			
	    	sorguIfadesi.setString(1, textilacadi.getText().trim());
	    	sorguIfadesi.setString(2, textilacfiyati.getText().trim());    
	    	sorguIfadesi.setString(3, combofirmano.getSelectionModel().getSelectedItem().toString().trim());
			sorguIfadesi.executeUpdate();
			
			lbl_snc.setText("Silme islemi basarýlý");
			DegerleriGetir(ilactab);
		} catch (Exception e) {
			lbl_snc.setText(e.getMessage().toString());
		}
    }

    @FXML
    void guncbutton_click(ActionEvent event) {
    	sql="update ilacduzenle set ilacAdi=? , ilacFiyati=?, firmaNo=? where ilacNo=?";
   	 	try {
   	 		sorguIfadesi=baglanti.prepareStatement(sql);
	   	 	sorguIfadesi.setString(1, textilacadi.getText().trim());
	    	sorguIfadesi.setString(2, textilacfiyati.getText().trim());    
	    	sorguIfadesi.setString(3, combofirmano.getSelectionModel().getSelectedItem().toString().trim());
	    	sorguIfadesi.setString(4, textilacno.getText().trim());
	    	
	    	sorguIfadesi.executeUpdate();
	    	lbl_snc.setText("Güncelleme iþlemi baþarýlý");
	    	DegerleriGetir(ilactab);
	   	} 
   	 	catch (Exception e) {
	   	lbl_snc.setText(e.getMessage().toString());
	   	}
    }

    @FXML
    void temizlebutton_click(ActionEvent event) {
    	textilacno.setText(null);
    	textilacadi.setText(null);
    	textilacfiyati.setText(null);
    	combofirmano.setPromptText("Firma Seçiniz");
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
    
    
    public void DegerleriGetir(TableView<ilacduzenle> ilactab) {
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
   		
    	sql="SELECT firmaNo FROM ilacduzenle ";
		try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			while(getirilen.next()) {
					combofirmano.getItems().addAll(getirilen.getString("firmaNo")); 
			}
		} catch (Exception e) {
			lbl_snc.setText(e.getMessage().toString());
		}
    	
    	DegerleriGetir(ilactab);
   		
   		
   		
   	}

}
