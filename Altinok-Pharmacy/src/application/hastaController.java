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

public class hastaController implements Initializable{

	String sql="";
	int idm=0;
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	
	 public hastaController() throws SQLException {
			baglanti=VeritabaniUtil.Baglan();
		}
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<hasta> hastatab;

    
    @FXML
    private TableColumn<?, ?> hastaNo;

    @FXML
    private TextField texthastaadi;

    @FXML
    private TextField texthastano;

    @FXML
    private TextField texthastadogtarih;

    @FXML
    private Label lbl_snc;

    @FXML
    private TableColumn<?, ?> hastaAdi;

    @FXML
    private TableColumn<?, ?> hastaDogTarih;

    
    @FXML
    void eklebutton_click(ActionEvent event) {
    	sql="insert into hasta(hastaAdi,hastaDogTarih) values(?,?)";
        
    	try {
	    	sorguIfadesi=baglanti.prepareStatement(sql);
	    	
	    	sorguIfadesi.setString(1, texthastaadi.getText().trim());
	    	sorguIfadesi.setString(2,texthastadogtarih.getText().trim());
	          
	    	
	    	
	    	sorguIfadesi.executeUpdate();
	    	    
			DegerleriGetir(hastatab);

    	} catch (Exception e) {
    		lbl_snc.setText(e.getMessage().toString());
    	}
    	
    }

    @FXML
    void silbutton_click(ActionEvent event) {
    	sql="delete from hasta where  hastaAdi=? and hastaDogTarih=?";
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			
	    	sorguIfadesi.setString(1, texthastaadi.getText().trim());
	    	sorguIfadesi.setString(2,texthastadogtarih.getText().trim());    
			sorguIfadesi.executeUpdate();
			
			lbl_snc.setText("Silme islemi basarýlý");
			DegerleriGetir(hastatab);
		} catch (Exception e) {
			lbl_snc.setText(e.getMessage().toString());
		}
    }

    @FXML
    void guncbutton_click(ActionEvent event) {
    	
    	
    	sql="update hasta set hastaAdi=? , hastaDogTarih=? where hastaNo=?";
   	 	try {
   	 		sorguIfadesi=baglanti.prepareStatement(sql);
	   		sorguIfadesi.setString(1, texthastaadi.getText().trim());
	    	sorguIfadesi.setString(2, texthastadogtarih.getText().trim());
	    	sorguIfadesi.setString(3, texthastano.getText().trim());
	    	
	    	sorguIfadesi.executeUpdate();
	    	lbl_snc.setText("Güncelleme iþlemi baþarýlý");
	    	DegerleriGetir(hastatab);
	   	} 
   	 	catch (Exception e) {
	   	lbl_snc.setText(e.getMessage().toString());
	   	}
 
    }

    @FXML
    void temizlebutton_click(ActionEvent event) {
	    	texthastano.setText(null);
	    	texthastaadi.setText(null);
	    	texthastadogtarih.setText(null);
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
    
    @FXML
    void hastatab_click(MouseEvent event) {
    	hasta kayitlar=new hasta();
    	kayitlar= (hasta) hastatab.getItems().get(hastatab.getSelectionModel().getSelectedIndex());
   
    	texthastano.setText(Integer.toString(kayitlar.getHastaNo()));
    	texthastaadi.setText(kayitlar.getHastaAdi());
    	texthastadogtarih.setText(kayitlar.getHastaDogTarih());
    	
    }
    
    
    public void DegerleriGetir(TableView<hasta> hastatab) {
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
   
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
   		DegerleriGetir(hastatab);
   	}
  
}
