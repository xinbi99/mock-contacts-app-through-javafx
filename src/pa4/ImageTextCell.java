/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;




public class ImageTextCell extends ListCell<Contacts> {
    private VBox vbox = new VBox(4.0); // 8 points of gap between controls
    private ImageView thumbImageView; // initially empty
    private Label label = new Label();

// constructor configures VBox, ImageView and Label
public ImageTextCell() {
    vbox.setAlignment(Pos.CENTER); // center VBox contents horizontally

    thumbImageView.setPreserveRatio(false);
    thumbImageView.setFitHeight(100.0); // thumbnail 100 points tall
    vbox.getChildren().add(thumbImageView); // attach to Vbox

    label.setWrapText(true); // wrap if text too wide to fit in label
    label.setTextAlignment(TextAlignment.CENTER); // center text
    vbox.getChildren().add(label); // attach to VBox

    setPrefWidth(USE_PREF_SIZE); // use preferred size for cell width
}

// called to configure each custom ListView cell
@Override
protected void updateItem(Contacts item, boolean empty) {
    // required to ensure that cell displays properly
    super.updateItem(item, empty);
    if (empty || item == null) {
        setGraphic(null); // don't display anything
        }
    else {
        // set ImageView's thumbnail image
        thumbImageView.setImage(new Image(item.getImage()));
        label.setText(item.getFullName()); // configure Label's text
        setGraphic(vbox); // attach custom layout to ListView cell
        }
    }
}
