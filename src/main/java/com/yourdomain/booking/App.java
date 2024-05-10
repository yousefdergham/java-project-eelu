package com.yourdomain.booking;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        DBUtil.initializeDatabase();

        VBox layout = new VBox(10);
        TextField nameField = new TextField();
        DatePicker datePicker = new DatePicker();
        Button addButton = new Button("Add Booking");
        ListView<String> bookingsList = new ListView<>();

        addButton.setOnAction(e -> {
            BookingManager.addBooking(nameField.getText(), datePicker.getValue().toString());
            bookingsList.getItems().setAll(BookingManager.getAllBookings());
            nameField.clear();
        });

        layout.getChildren().addAll(new Label("Enter Name:"), nameField, new Label("Select Date:"), datePicker,
                addButton, bookingsList);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("Booking System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
