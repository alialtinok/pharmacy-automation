package application;

import java.net.URL;
import java.util.ResourceBundle; 

import javax.swing.JOptionPane;

import com.IsteMySQL.Util.VeritabaniUtil;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;

public class adminController {
	Connection baglanti = null;
    PreparedStatement sorguIfadesi =null;
    ResultSet getirilen =null;
    String sql;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbl_sonuc;

    @FXML
    private TextField txt_kullad;

    @FXML
    private TextField txt_sifre;

    @FXML
    private Button btn_login;

    @FXML
    private void btn_login_Click(ActionEvent event)  throws Exception{

    	sql="select * from login where kul_ad=? and sifre=?";
    	baglanti=VeritabaniUtil.Baglan();
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txt_kullad.getText().trim());
    		sorguIfadesi.setString(2, txt_sifre.getText().trim());
    		getirilen=sorguIfadesi.executeQuery();
          if(!getirilen.next())
          {
        	  	JOptionPane.showMessageDialog(null, "Kullanýcý Adý veya Þifre Hatalý !!!","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);    	
          }
          else 
          {
        	  	
        	  	Stage stg=new Stage();
        	  	stg.setTitle("ECZANE");
        		AnchorPane root= (AnchorPane)FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        		stg.setScene(new Scene(root,800,521));
        		
    			stg.getIcons().add(new Image("file:img/icon.png"));
        		stg.show();
        		
        		((Node)(event.getSource())).getScene().getWindow().hide();
        		
          }
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(null,e.getMessage().toString(),sql,JOptionPane.INFORMATION_MESSAGE);
    	}
    	
    }
    


    @FXML
    void initialize() {
        
    	
    }
}
