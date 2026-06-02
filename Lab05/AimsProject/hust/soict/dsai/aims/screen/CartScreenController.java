package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.dsai.aims.store.Store;
import javax.swing.JFrame;

public class CartScreenController {
    private Cart cart;
    private Store store;
    private JFrame frame;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label lblTotal;

    public CartScreenController(Cart cart, Store store, JFrame frame) {
        this.cart = cart;
        this.store = store;
        this.frame = frame;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            }
        );

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        lblTotal.setText(String.format("%.2f $", cart.totalCost()));
        cart.getItemsOrdered().addListener((ListChangeListener<Media>) c -> {
            lblTotal.setText(String.format("%.2f $", cart.totalCost()));
        });
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            ((Playable) media).play();
            // Show dialog
            javax.swing.JOptionPane.showMessageDialog(null, "Playing: " + media.toString());
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        System.out.println("Order placed!");
        cart.getItemsOrdered().clear();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        new StoreScreen(store, cart);
        frame.dispose();
    }

    @FXML
    void btnAddBookPressed(ActionEvent event) {
        new AddBookToStoreScreen(store, cart);
        frame.dispose();
    }

    @FXML
    void btnAddCDPressed(ActionEvent event) {
        new AddCompactDiscToStoreScreen(store, cart);
        frame.dispose();
    }

    @FXML
    void btnAddDVDPressed(ActionEvent event) {
        new AddDigitalVideoDiscToStoreScreen(store, cart);
        frame.dispose();
    }

    void showFilteredMedia(String newValue) {
        if (newValue == null || newValue.isEmpty()) {
            tblMedia.setItems(cart.getItemsOrdered());
        } else {
            // Placeholder for filter logic
        }
    }
}
