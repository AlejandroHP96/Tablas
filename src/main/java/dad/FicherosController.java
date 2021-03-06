package dad;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.ResourceBundle;

import dad.model.Fichero;
import dad.model.TipoFichero;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.LocalDateTimeStringConverter;

public class FicherosController implements Initializable {

    // model

    private StringProperty ruta = new SimpleStringProperty();
    private ListProperty<Fichero> ficheros = new SimpleListProperty<>(FXCollections.observableArrayList());

    @FXML
    private BorderPane view;

    @FXML
    private TextField rutaText;

    @FXML
    private Button listarButton;

    @FXML
    private TableView<Fichero> ficherosTable;

    @FXML
    private TableColumn<Fichero, String> nombreColumn;

    @FXML
    private TableColumn<Fichero, Number> tamanoColumn;

    @FXML
    private TableColumn<Fichero, Boolean> ejecutableColumn;

    @FXML
    private TableColumn<Fichero, TipoFichero> tipoColumn;

    @FXML
    private TableColumn<Fichero, LocalDateTime> modificacionColumn;

    public FicherosController() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Ficheros.fxml"));
        loader.setController(this);
        loader.load();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // bindigns

        ruta.bindBidirectional(rutaText.textProperty());
        ficherosTable.itemsProperty().bind(ficheros);

        // cell value factories

        nombreColumn.setCellValueFactory((v -> v.getValue().nombreProperty()));
        tamanoColumn.setCellValueFactory((v -> v.getValue().tamanoProperty()));
        tipoColumn.setCellValueFactory((v -> v.getValue().tipoProperty()));
        modificacionColumn.setCellValueFactory((v -> v.getValue().ultimaModificacionProperty()));
        ejecutableColumn.setCellValueFactory((v -> v.getValue().ejecutableProperty()));

        //cell factories

        modificacionColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateTimeStringConverter()));
        ejecutableColumn.setCellFactory(CheckBoxTableCell.forTableColumn(ejecutableColumn));

        // initializing properties

        ruta.set(new File(".").getAbsolutePath());
        listarButton.fire();

    }

    public BorderPane getView() {
        return view;
    }

    @FXML
    void onListarAction(ActionEvent event) {
        ficheros.clear();
        // comprobamos si existe la ruta
        File f = new File(ruta.get());
        if (f.isDirectory()) {

            Arrays.asList(f.listFiles()).stream().map(file -> new Fichero(file)).forEach(ficheros::add);

        } else {

        }

        // los mostramos en la tabla

    }

    @FXML
    void onTablaClicked(MouseEvent event) {

    }

}