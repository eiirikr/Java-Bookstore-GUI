package com.ciicc.ict;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BooksStoreNewEdit extends JFrame {
    private JTextField titleText;
    private JButton saveButton;
    private JButton deleteButton;
    private JPanel MainPanel;
    private JTextField authorText;
    private JTextField yearText;
    private JTextField priceText;

    public BooksStoreNewEdit(){
        setContentPane(MainPanel);
        setVisible(true);
        setSize(400,400);
        setLocationRelativeTo(null);
        deleteButton.setVisible(false);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//
                BooksDB.addBook( titleText.getText(),
                        authorText.getText(),
                        Integer.parseInt(yearText.getText()),
                        Double.parseDouble(priceText.getText()));
                BooksDB.readBooks();
                BooksStoreMain.generateTable();
                dispose();
            }
        });

    }
    public BooksStoreNewEdit(boolean edit){
        this();
        deleteButton.setVisible(true);
    }


}
