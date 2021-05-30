package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AnasayfaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_ilacislem;

    @FXML
    private Button btn_ilacsatis;

    @FXML
    private Button btn_hasta;

    @FXML
    private Button btn_firma;

    @FXML
    private Button btn_eczane;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_geri;



    @FXML
    void btn_eczane_Click(ActionEvent event) throws IOException {
    	Stage stg=new Stage();
    	stg.setTitle("ECZANE");
  		AnchorPane root= (AnchorPane)FXMLLoader.load(getClass().getResource("eczane.fxml"));
  		stg.setScene(new Scene(root,932,766));
		stg.getIcons().add(new Image("file:img/icon.png"));
  		stg.show();
  		((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void btn_firma_Click(ActionEvent event) throws IOException {
    	Stage stg=new Stage();
    	stg.setTitle("FÝRMA");
  		AnchorPane root= (AnchorPane)FXMLLoader.load(getClass().getResource("firma.fxml"));	
  		stg.setScene(new Scene(root,932,766));
		stg.getIcons().add(new Image("file:img/icon.png"));
  		stg.show();
  		((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void btn_geri_Click(ActionEvent event) throws IOException{
    	Stage stg=new Stage();
    	stg.setTitle("ECZANE");
  		AnchorPane root= (AnchorPane)FXMLLoader.load(getClass().getResource("admin.fxml"));
  		stg.setScene(new Scene(root,400,400));
		stg.getIcons().add(new Image("file:img/icon.png"));
  		stg.show();
  		((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
   
    

    @FXML
    void btn_hasta_Click(ActionEvent event) throws IOException {
    	Stage stg=new Stage();
    	stg.setTitle("HASTA");
  		AnchorPane root= (AnchorPane)FXMLLoader.load(getClass().getResource("hasta.fxml"));	
  		stg.setScene(new Scene(root,932,766));
		stg.getIcons().add(new Image("file:img/icon.png"));
  		stg.show();
  		((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void btn_ilacislem_Click(ActionEvent event) throws IOException {
    	Stage stg=new Stage();
    	stg.setTitle("ÝLAÇ DÜZENLE");
  		AnchorPane root= (AnchorPane)FXMLLoader.load(getClass().getResource("ilacduzenle.fxml"));
  		stg.setScene(new Scene(root,932,766));
		stg.getIcons().add(new Image("file:img/icon.png"));
  		stg.show();
  		((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void btn_ilacsatis_Click(ActionEvent event) throws IOException {
    	Stage stg=new Stage();
    	stg.setTitle("ÝLAÇ SATIÞ");
  		AnchorPane root= (AnchorPane)FXMLLoader.load(getClass().getResource("ilacsatis.fxml"));
  		stg.setScene(new Scene(root,932,766));
		stg.getIcons().add(new Image("file:img/icon.png"));
  		stg.show();
  		((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void btn_cikis_Click(ActionEvent event) {
    	System.exit(0);
    }
    

    @FXML
    void initialize() {
        assert btn_ilacislem != null : "fx:id=\"btn_ilacislem\" was not injected: check your FXML file 'Anasayfa.fxml'.";
        assert btn_ilacsatis != null : "fx:id=\"btn_ilacsatis\" was not injected: check your FXML file 'Anasayfa.fxml'.";
        assert btn_hasta != null : "fx:id=\"btn_hasta\" was not injected: check your FXML file 'Anasayfa.fxml'.";
        assert btn_firma != null : "fx:id=\"btn_firma\" was not injected: check your FXML file 'Anasayfa.fxml'.";
        assert btn_eczane != null : "fx:id=\"btn_eczane\" was not injected: check your FXML file 'Anasayfa.fxml'.";
        assert btn_geri != null : "fx:id=\"btn_geri\" was not injected: check your FXML file 'Anasayfa.fxml'.";
        assert btn_cikis != null : "fx:id=\"btn_cikis\" was not injected: check your FXML file 'Anasayfa.fxml'.";

    }
}
