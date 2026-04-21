package com.example.loancalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoanCalculator extends Application {

    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfLoanAmount = new TextField();
    private TextField tfMonthlyPayment = new TextField();
    private TextField tfTotalPayment = new TextField();
    private Button btCalculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(5, 5, 5, 5));

        gridPane.add(new Label("Annual Interest Rate:"), 0, 0);
        gridPane.add(tfAnnualInterestRate, 1, 0);

        gridPane.add(new Label("Number of Years:"), 0, 1);
        gridPane.add(tfNumberOfYears, 1, 1);

        gridPane.add(new Label("Loan Amount:"), 0, 2);
        gridPane.add(tfLoanAmount, 1, 2);

        gridPane.add(new Label("Monthly Payment:"), 0, 3);
        gridPane.add(tfMonthlyPayment, 1, 3);
        tfMonthlyPayment.setEditable(false);

        gridPane.add(new Label("Total Payment:"), 0, 4);
        gridPane.add(tfTotalPayment, 1, 4);
        tfTotalPayment.setEditable(false);

        gridPane.add(btCalculate, 1, 5);

        btCalculate.setOnAction(e -> calculateLoanPayment());

        Scene scene = new Scene(gridPane, 300, 250);
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateLoanPayment() {
        double interest = Double.parseDouble(tfAnnualInterestRate.getText());
        int years = Integer.parseInt(tfNumberOfYears.getText());
        double amount = Double.parseDouble(tfLoanAmount.getText());

        Loan loan = new Loan(interest, years, amount);

        tfMonthlyPayment.setText(String.format("%.2f", loan.getMonthlyPayment()));
        tfTotalPayment.setText(String.format("%.2f", loan.getTotalPayment()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
