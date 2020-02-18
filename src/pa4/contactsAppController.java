/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import java.awt.image.BufferedImage;
import javafx.scene.control.ListCell;
import javafx.util.Callback;
import javax.imageio.ImageIO;
public class contactsAppController {

    @FXML    private Button onSaveClick;
    @FXML    private Button onDeleteClick;
    @FXML    private TextField lastNameField;
    @FXML    private TextField firstNameField;
    @FXML    private TextField emailField;
    @FXML    private TextField phoneField;
    @FXML    private TextField addressField;
    @FXML    private ImageView contactsImageView;
    @FXML    private ListView<Contacts> contactsListView;
    private String imagePath = "";
    private Boolean addMode = false;
    private final ObservableList<Contacts> cList = FXCollections.observableArrayList();
    public void initialize(){
        cList.add(new Contacts("Tom","Hanks","tomhanks@","484","idk", "images/tomhanks.jpg"));
        cList.add(new Contacts("Jennifer","Lopez","jlo@","484","idk", "images/jenniferlopez.jpg"));
        cList.add(new Contacts("Tom", "Cruise", "tomcruise@", "484", "idk", "images/tomcruise.jpg"));

        contactsListView.setItems(cList);
        contactsListView.getSelectionModel().selectedItemProperty().
            addListener((ObservableValue<? extends Contacts> ov, Contacts oldValue, Contacts newValue) -> {
                contactsImageView.setImage(new Image(newValue.getImage()));
                imagePath = contactsListView.getSelectionModel().getSelectedItem().getImage();
                firstNameField.setText(newValue.getFirstName());
                lastNameField.setText(newValue.getLastName());
                emailField.setText(newValue.getEmail());
                phoneField.setText(newValue.getPhone());
                addressField.setText(newValue.getAddress());
        });
//        contactsListView.setCellFactory(new Callback<ListView<Contacts>, ListCell<Contacts>>() {      
//            @Override
//            public ListCell<Contacts> call(ListView<Contacts> contactsListView){
//                return new ImageTextCell();      
//                }   
//            }
//        );
    }
    @FXML
    void onAddClick(ActionEvent event) {
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear(); 
        phoneField.clear(); 
        addressField.clear();
        contactsImageView.setImage(null);
        imagePath = "";
        addMode = true;
    }

    @FXML
    void onDeleteClick(ActionEvent event) {
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear(); 
        phoneField.clear(); 
        addressField.clear();
        contactsImageView.setImage(null);
        cList.remove(contactsListView.getSelectionModel().getSelectedItem());
    }

    @FXML
    void onSaveClick(ActionEvent event) {
        if (firstNameField.getText().isEmpty() && lastNameField.getText().isEmpty()) {
            System.out.println("The person must have a first name or last name!");
        }
        else if(addMode == false){
            contactsListView.getSelectionModel().getSelectedItem().setFirstName(firstNameField.getText());
            contactsListView.getSelectionModel().getSelectedItem().setLastName(lastNameField.getText());
            contactsListView.getSelectionModel().getSelectedItem().setEmail(emailField.getText());
            contactsListView.getSelectionModel().getSelectedItem().setPhone(phoneField.getText());
            contactsListView.getSelectionModel().getSelectedItem().setAddress(addressField.getText());
            contactsListView.getSelectionModel().getSelectedItem().setImage(imagePath);
            addMode = false;
        }
        else {
            cList.add(new Contacts(firstNameField.getText(),lastNameField.getText(),
                    emailField.getText(),phoneField.getText(),addressField.getText(),
                    imagePath));
            addMode = false;
        }
    }

    @FXML
    void onImageClick(MouseEvent event) {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(null);
            try {
                BufferedImage bufferedImage = ImageIO.read(selectedFile);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                contactsImageView.setImage(image);
            } catch (IOException ex) {
                Logger.getLogger(contactsAppController.class.getName()).log(Level.SEVERE, null, ex);
            }
            imagePath = "images/" + selectedFile.getName(); 
            System.out.println(imagePath);
    }

    @FXML
    void onExportClick(ActionEvent event) {
        System.out.println("Export!");
    }

    @FXML
    void onImportClick(ActionEvent event) {
        System.out.println("Import!");
    }
    
}
