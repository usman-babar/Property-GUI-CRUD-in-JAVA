package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {

	static boolean check = false;
	static int index = -1;

	@FXML
	private Button add;

	@FXML
	private Button search;

	@FXML
	private Button clearTable;

	@FXML
	private Button viewAllProperty;

	@FXML
	private Button addSelectedRowBTN;

	@FXML
	private TableColumn<PropertyClass, Integer> bathCol;

	@FXML
	private TextField bathField;

	@FXML
	private TextField typSearcheField;

	@FXML
	private Label bathLabel;

	@FXML
	private Label typeSearchLabel;

	@FXML
	private TableColumn<PropertyClass, Integer> bedCol;

	@FXML
	private TextField bedField;

	@FXML
	private Label bedLabel;

	@FXML
	private Label bedLabel1;

	@FXML
	private TableColumn<PropertyClass, String> countryCol;

	@FXML
	private TextField countryField;

	@FXML
	private Label countrylabel;

	@FXML
	private Button delete;

	@FXML
	private Label heading;

	@FXML
	private TableColumn<PropertyClass, Double> priceCol;

	@FXML
	private TextField priceField;

	@FXML
	private Label priceLabe;

	@FXML
	private TextField receptionField;

	@FXML
	private TableColumn<PropertyClass, Integer> receptionsCol;

	@FXML
	private TableColumn<PropertyClass, String> streetCol;

	@FXML
	private TextField streetField;

	@FXML
	private Label streetLabel;

	@FXML
	private TableView<PropertyClass> table = new TableView<PropertyClass>();

	@FXML
	private TableColumn<PropertyClass, String> townCol;

	@FXML
	private TextField townField;

	@FXML
	private Label townLabel;

	@FXML
	private TableColumn<PropertyClass, String> typeCol;

	@FXML
	private TextField typeField;

	@FXML
	private Label typeLabel;

	@FXML
	private Button update;

	@FXML
	private Button clear;

	public ObservableList<PropertyClass> p = FXCollections.observableArrayList();

	public ObservableList<PropertyClass> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		streetCol.setCellValueFactory(new PropertyValueFactory<PropertyClass, String>("Street"));
		townCol.setCellValueFactory(new PropertyValueFactory<PropertyClass, String>("Town"));
		countryCol.setCellValueFactory(new PropertyValueFactory<PropertyClass, String>("Country"));
		bedCol.setCellValueFactory(new PropertyValueFactory<PropertyClass, Integer>("Beds"));
		receptionsCol.setCellValueFactory(new PropertyValueFactory<PropertyClass, Integer>("Receptions"));
		bathCol.setCellValueFactory(new PropertyValueFactory<PropertyClass, Integer>("Baths"));
		typeCol.setCellValueFactory(new PropertyValueFactory<PropertyClass, String>("Type"));
		priceCol.setCellValueFactory(new PropertyValueFactory<PropertyClass, Double>("Price"));
		table.setItems(list);
	}

	@FXML
	void add(ActionEvent event) {

		if (check == false) {
			double price;
			try {
				price = Double.parseDouble(priceField.getText());
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Empty Field");
				alert.setHeaderText(null);
				alert.setContentText("Please fill price field.");

				// Show the dialog
				alert.showAndWait();
				return; // Prevent adding the row with invalid price
			}

			int beds;
			try {
				beds = Integer.parseInt(bedField.getText());
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Empty Field");
				alert.setHeaderText(null);
				alert.setContentText("Please fill bed field.");

				// Show the dialog
				alert.showAndWait();
				return; // Prevent adding the row with invalid price
			}

			int baths;
			try {
				baths = Integer.parseInt(bathField.getText());
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Empty Field");
				alert.setHeaderText(null);
				alert.setContentText("Please fill bath field.");

				// Show the dialog
				alert.showAndWait();
				return; // Prevent adding the row with invalid price
			}

			String type = typeField.getText();
			if (type.isEmpty()) {
				// Show an error dialog indicating that the type field is empty
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Parsing type");
				alert.setHeaderText(null);
				alert.setContentText("Type field is empty.");

				// Show the dialog
				alert.showAndWait();

				// Return to prevent adding the row with missing type
				return;
			}

			String country = countryField.getText();
			if (country.isEmpty()) {
				// Show an error dialog indicating that the country field is empty
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Parsing Country");
				alert.setHeaderText(null);
				alert.setContentText("Country field is empty.");

				// Show the dialog
				alert.showAndWait();

				// Return to prevent adding the row with missing type
				return;
			}

			int reception;
			try {
				reception = Integer.parseInt(receptionField.getText());
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Empty Field");
				alert.setHeaderText(null);
				alert.setContentText("Please fill reception field.");

				// Show the dialog
				alert.showAndWait();
				return; // Prevent adding the row with invalid price
			}

			String town = townField.getText();
			if (town.isEmpty()) {
				// Show an error dialog indicating that the town field is empty
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Parsing town");
				alert.setHeaderText(null);
				alert.setContentText("Town field is empty.");

				// Show the dialog
				alert.showAndWait();

				// Return to prevent adding the row with missing type
				return;
			}

			String street = streetField.getText();
			if (street.isEmpty()) {
				// Show an error dialog indicating that the town field is empty
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Parsing street");
				alert.setHeaderText(null);
				alert.setContentText("Street field is empty.");

				// Show the dialog
				alert.showAndWait();

				// Return to prevent adding the row with missing type
				return;
			}

			// String street, String town, int receptions, String country, String type, int
			// baths, int beds, double price
			PropertyClass object = new PropertyClass(street, town, reception, country, type.toLowerCase(), baths, beds, price);

			p.add(object);
			list.add(object);

			// Create an alert indicating that the property has been added
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Property Added");
			alert.setHeaderText(null);
			alert.setContentText("Property has been successfully added.");

			// Show the alert
			alert.showAndWait();

			clearRecords();

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Duplicate");
			alert.setHeaderText(null);
			alert.setContentText("Record already present in List.");

			// Show the dialog
			alert.showAndWait();
		}
	}

	@FXML
	void addSelectedRow(ActionEvent event) {

		// Check if a row is selected
		if (table.getSelectionModel().getSelectedItem() != null) {
			// Get the selected item (assuming YourDataType represents your row data)
			PropertyClass selectedItem = table.getSelectionModel().getSelectedItem();

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(selectedItem)) {
					index = i;
				}
			}

			streetField.setText(selectedItem.getStreet());
			receptionField.setText(String.valueOf(selectedItem.getReceptions()));
			townField.setText(selectedItem.getStreet());
			bedField.setText(String.valueOf(selectedItem.getBeds()));
			countryField.setText(selectedItem.getCountry());
			priceField.setText(String.valueOf(selectedItem.getPrice()));
			typeField.setText(selectedItem.getType());
			bathField.setText(String.valueOf(selectedItem.getBaths()));

			check = true;
		} else {
			// Handle case where no row is selected
			System.out.println("No row selected");
		}

	}

	@FXML
	void delete(ActionEvent event) {
		if (index != -1 && check == true) {

			list.remove(index);
			p.remove(index);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Record Deleted");
			alert.setHeaderText(null);
			alert.setContentText("Record deleted successfully.");
			// Show the alert
			alert.showAndWait();

			clearRecords();

			check = false;
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No Records Selected");
			alert.setHeaderText(null);
			alert.setContentText("Select the rocord first");

			// Show the alert
			alert.showAndWait();
		}
	}

	@FXML
	void update(ActionEvent event) {

		if (index != -1 && check == true) {

			try {
				PropertyClass prop = list.get(index);
				prop.setPrice(Double.parseDouble(priceField.getText()));
				list.set(index, prop);
				p.set(index, prop);

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Price Updated");
				alert.setHeaderText(null);
				alert.setContentText("Price updated successfully.");
				// Show the alert
				alert.showAndWait();

				clearRecords();

			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			check = false;
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No Records Selected");
			alert.setHeaderText(null);
			alert.setContentText("Select the rocord first");

			// Show the alert
			alert.showAndWait();
		}

	}

	@FXML
	void clear(ActionEvent event) {
		check = false;
		clearRecords();
	}

	@FXML
	void clearTable(ActionEvent event) {
		table.getItems().clear();
	}

	@FXML
	void viewAll(ActionEvent event) {

		if (!p.isEmpty()) {
			list.clear();
			list.addAll(p);

		}
		if (list.isEmpty()) {
			// Create an alert indicating that no records are available
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("No Records Available");
			alert.setHeaderText(null);
			alert.setContentText("No records are available in the table.");

			// Show the alert
			alert.showAndWait();
		} else {
			// Set the items of the table to the list
			table.setItems(list);
		}
	}

	@FXML
	void search(ActionEvent event) {

		boolean present = false;
		
		String type = typSearcheField.getText();
		if (type.isEmpty()) {
			// Show an error dialog indicating that the type field is empty
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Parsing type");
			alert.setHeaderText(null);
			alert.setContentText("Search field is empty.");

			// Show the dialog
			alert.showAndWait();

			// Return to prevent adding the row with missing type
			return;
		} else {

			if (p.isEmpty()) {
				// Create an alert indicating that no records are available
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("No Records Available");
				alert.setHeaderText(null);
				alert.setContentText("No records are available in the table.");

				// Show the alert
				alert.showAndWait();
				return;
			} else {
				
				ObservableList<PropertyClass> l = FXCollections.observableArrayList();
				for (int i = 0; i < p.size(); i++) {
					if (p.get(i).getType().equals(type.toLowerCase())) {
						l.add(p.get(i));
						present = true;
					}
				}

				table.setItems(l);
			}
			
			if(present == false)  
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("No record found");
				alert.setHeaderText(null);
				alert.setContentText("No record found with search type : " + type);

				// Show the alert
				alert.showAndWait();
				return;
			}
		}
	}

	public void clearRecords() {
		bathField.clear();
		receptionField.clear();
		bedField.clear();
		countryField.clear();
		priceField.clear();
		streetField.clear();
		townField.clear();
		typeField.clear();
	}

}
