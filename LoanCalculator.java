package com.example.loancalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoanCalculator extends Application {

    private TextField tfInterest = new TextField();
    private TextField tfYears = new TextField();
    private TextField tfAmount = new TextField();
    private TextField tfMonthly = new TextField();
    private TextField tfTotal = new TextField();

    @Override
    public void start(Stage stage) {

        GridPane grid = new GridPane();

        grid.add(new Label("Interest Rate:"), 0, 0);
        grid.add(tfInterest, 1, 0);

        grid.add(new Label("Years:"), 0, 1);
        grid.add(tfYears, 1, 1);

        grid.add(new Label("Loan Amount:"), 0, 2);
        grid.add(tfAmount, 1, 2);

        grid.add(new Label("Monthly Payment:"), 0, 3);
        grid.add(tfMonthly, 1, 3);

        grid.add(new Label("Total Payment:"), 0, 4);
        grid.add(tfTotal, 1, 4);

        Button btn = new Button("Calculate");
        grid.add(btn, 1, 5);

        btn.setOnAction(e -> calculate());

        Scene scene = new Scene(grid, 300, 250);
        stage.setTitle("Loan Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private void calculate() {
        double interest = Double.parseDouble(tfInterest.getText());
        int years = Integer.parseInt(tfYears.getText());
        double amount = Double.parseDouble(tfAmount.getText());

        Loan loan = new Loan(interest, years, amount);

        tfMonthly.setText(String.format("%.2f", loan.getMonthlyPayment()));
        tfTotal.setText(String.format("%.2f", loan.getTotalPayment()));
    }

    public static void main(String[] args) {
        launch();
    }
}
