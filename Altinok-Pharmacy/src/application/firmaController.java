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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class firmaController implements Initializable{

	String sql="";
	int idm=0;
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	
	 public firmaController() throws SQLException {
		baglanti=VeritabaniUtil.Baglan();
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> eczaneNo;

    @FXML
    private TableColumn<?, ?> firmaNo;

    @FXML
    private TextField textfirmaadi;

    @FXML
    private TableColumn<?, ?> firmaAdi;

    @FXML
    private TextField texteczaneno;

    @FXML
    private ComboBox<String> comboeczaneno;
    
    @FXML
    private TableView<firma> firmatab;

    @FXML
    private TextField textfirmano;

    @FXML
    void eklebutton_click(ActionEvent event) {
    	sql="insert into ilacfirma(firmaAdi,eczaneNo) values(?,?)";
        
    	try {
	    	sorguIfadesi=baglanti.prepareStatement(sql);
	    	
	    	sorguIfadesi.setString(1, textfirmaadi.getText().trim());
	    	sorguIfadesi.setString(2, comboeczaneno.getSelectionModel().getSelectedItem().toString().trim());
	          
	    	
	    	
	    	sorguIfadesi.executeUpdate();
	    	    
			DegerleriGetir(firmatab);

    	} catch (Exception e) {
    		System.out.println(e.getMessage().toString());
    	}
    }

    @FXML
    void silbutton_click(ActionEvent event) {
    	sql="delete from ilacfirma where  firmaAdi=? and eczaneNo=?";
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			
	    	sorguIfadesi.setString(1, textfirmaadi.getText().trim());
	    	sorguIfadesi.setString(2,comboeczaneno.getSelectionModel().getSelectedItem().toString().trim());    
			sorguIfadesi.executeUpdate();
			
			DegerleriGetir(firmatab);
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());		}
    }

    @FXML
    void guncellebutton_click(ActionEvent event) {
    	sql="update ilacfirma set firmaAdi=? , eczaneNo=? where firmaNo=?";
    	
   	 	try {
   	 		sorguIfadesi=baglanti.prepareStatement(sql);
	   	 	sorguIfadesi.setString(1, textfirmaadi.getText().trim());
	    	sorguIfadesi.setString(2,comboeczaneno.getSelectionModel().getSelectedItem().toString().trim());  
	    	sorguIfadesi.setString(3, textfirmano.getText().trim());
	    	
	    	sorguIfadesi.executeUpdate();
	    	DegerleriGetir(firmatab);
	   	} 
   	 	catch (Exception e) {
   	 	System.out.println(e.getMessage().toString());	   	
   	 	}
    }

    @FXML
    void temizlebutton_click(ActionEvent event) {
    	textfirmano.setText(null);
    	textfirmaadi.setText(null);
    	comboeczaneno.setPromptText("Eczane Seçiniz");
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
    
    
    public void DegerleriGetir(TableView<firma> firmatab) {
    	sql="select * from ilacfirma";
    	ObservableList<firma> kayitlarListe=FXCollections.observableArrayList();
    	try {
				sorguIfadesi=baglanti.prepareStatement(sql);
				ResultSet getirilen=sorguIfadesi.executeQuery();
				while(getirilen.next()) {
				kayitlarListe.add(new firma(getirilen.getInt("firmaNo"),getirilen.getString("firmaAdi"),getirilen.getInt("eczaneNo")));
			}		
				firmaNo.setCellValueFactory(new PropertyValueFactory<>("firmaNo"));
				firmaAdi.setCellValueFactory(new PropertyValueFactory<>("firmaAdi"));
				eczaneNo.setCellValueFactory(new PropertyValueFactory<>("eczaneNo"));
				
				firmatab.setItems(kayitlarListe);

		} catch (Exception e) {
	   	 	System.out.println(e.getMessage().toString());	   	
		}
    }
    @FXML
    void firmatab_click(MouseEvent event) {
    	firma kayitlar=new firma();
    	kayitlar= (firma) firmatab.getItems().get(firmatab.getSelectionModel().getSelectedIndex());
   
    	textfirmano.setText(Integer.toString(kayitlar.getFirmaNo()));
    	textfirmaadi.setText(kayitlar.getFirmaAdi());
    	comboeczaneno.setPromptText(Integer.toString(kayitlar.getEczaneNo()));
    }
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
    	sql="SELECT eczaneNo FROM eczane ";
		try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			while(getirilen.next()) {
					comboeczaneno.getItems().addAll(getirilen.getString("eczaneNo")); 
			}
		} catch (Exception e) {
	   	 	System.out.println(e.getMessage().toString());	   	
		}
    	
    	DegerleriGetir(firmatab);
   		
   		
		
		
   		
   	}
}















