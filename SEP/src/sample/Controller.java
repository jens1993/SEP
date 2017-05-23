package sample;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.IOException;


public class Controller {

    /*
    public Controller()
    {
        try {

            System.out.println("Start");
            System.out.println(index_niveau);
            combo_niveau.getSelectionModel().select(index_niveau);
            System.out.println("h-"+index_niveau);

        comboBoxFill();
            //combo_niveau.getSelectionModel().select(index_niveau);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

    //static Niveau niveau_auswahl;
    //static int a;
    //static ObservableList<Niveau> test1;


    @FXML
    private RadioButton radio_gruppe;
    @FXML
    private RadioButton radio_gruppeMitE;
    @FXML
    private RadioButton radio_ko;
    @FXML
    private RadioButton radio_schweizer;

    private static int index_niveau=100;
    private static int index_diszipin=100;
    @FXML
    private void setNiveau_auswahl(ActionEvent event){
        //SingleSelectionModel niveau_auswahl = combo_niveau.getSelectionModel();
        //a = combo_niveau.getSelectionModel().getSelectedIndex();
        //System.out.println("hallo -----"+niveau_auswahl.toString());
        //combo_niveau.getSelectionModel().select(niveau_auswahl);
        //test1=combo_niveau.getItems().get(a);
        // System.out.println(test1.toString());
        //System.out.println(niveau_auswahl.toString());
        //System.out.println(a);
        //combo_niveau.setSelectionModel();
        index_niveau = combo_niveau.getSelectionModel().getSelectedIndex();
    }
    @FXML
    private void setDisziplin_auswahl(ActionEvent event){
        index_diszipin = combo_disziplin.getSelectionModel().getSelectedIndex();
    }

    @FXML
    private void klassenSwitch(ActionEvent event) throws IOException, InterruptedException {
        Stage stage;
        Parent root;

        //System.out.println(combo_niveau.getSelectionModel().getSelectedIndex());


       //niveau_auswahl = combo_niveau.getItems().get();
        //System.out.println(niveau_auswahl.toString());
        //System.out.println(combo_niveau.getValue());
        //combo_niveau.setValue(U9 );
        //System.out.println(niveau_auswahl.toString());
        if(radio_gruppeMitE.isSelected()) {
            stage = (Stage) radio_gruppeMitE.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("klasseHinzuGruppeMitKO.fxml"));

        }
        else if(radio_ko.isSelected()){
            stage=(Stage) radio_ko.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("klasseHinzuKO.fxml"));
        }
        else if(radio_schweizer.isSelected()){
            stage=(Stage) radio_schweizer.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("klasseHinzuSchweizer.fxml"));
        }
        else{
            stage=(Stage) radio_gruppe.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("klasseHinzuGruppe.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        wait(500);
        comboBoxFill();
    }

    @FXML
    private RadioButton radio_trostJa;
    @FXML
    private RadioButton radio_trostNein;
    @FXML
    private void trostSwitch(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;

        if(radio_trostNein.isSelected()){
            stage=(Stage) radio_trostNein.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("klasseHinzuKO.fxml"));
        }
        else{
            stage=(Stage) radio_trostJa.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("klasseHinzuKOmitTR.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);



        stage.show();

    }

    public void pressBtn_spieler(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("spielerHinzu.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            stage.setTitle("Spieler");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void pressBtn_klassen(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("klasseHinzuGruppe.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            stage.setTitle("Klassen");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void pressBtn_neuesTurnier(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("neuesTurnier.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            stage.setTitle("neues Turnier");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void pressBtn_turnierLaden (ActionEvent event) throws Exception {
        try {
            FileChooser fileChooser = new FileChooser();
            Stage stage = new Stage();
            fileChooser.setTitle("Turnier laden");


            FileChooser.ExtensionFilter textFilter = new FileChooser.ExtensionFilter("Textdateien", "*.txt");
            FileChooser.ExtensionFilter allFilter = new FileChooser.ExtensionFilter("Alle Dateien", "*.*");
            fileChooser.getExtensionFilters().add(textFilter);
            fileChooser.getExtensionFilters().add(allFilter);

            fileChooser.showOpenDialog(stage);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public  ComboBox<Niveau> combo_niveau = new ComboBox<>();


    @FXML
    public ComboBox<Disziplin> combo_disziplin = new ComboBox<>();
    @FXML
    public void comboBoxFill() throws IOException{
        try{
            combo_niveau.getItems().setAll(Niveau.values());
            combo_disziplin.getItems().setAll(Disziplin.values());
            combo_niveau.getSelectionModel().select(index_niveau);
            combo_disziplin.getSelectionModel().select(index_diszipin);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //combo_niveau.getSelectionModel().select(0);
        //combo_niveau.setItems( FXCollections.observableArrayList((E[]) Niveau.values()));
        //combo_disziplin.setItems(Disziplin.Herreneinzel);
    }



}
