package com.ciicc.ict;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.*;

public class BooksStoreMain extends JFrame{
    private JButton newButton;
    private JButton editButton;
    private JTable table1;
    private JPanel MainPanel;
    private JScrollPane scroller;
    private JPanel jpanel2;
    public static List<Books> Books = new ArrayList<>();
    public static BooksStoreMain bsm;

    public BooksStoreMain() {
        setContentPane(MainPanel);
        jpanel2.setVisible(true);
        setVisible(true);
        setSize(400,400);
        setLocationRelativeTo(null);

       Books.add(new Books(1,"Java Programming for 3 years old","John Smith", 2021,39.99));
       Books.add(new Books(2,"Python Basics","Jane Doe", 2020,29.99));
       Books.add(new Books(3,"C++ Essentials","Michael Johnson", 2019,49.99));

        newButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            newBook();
        }
    });
}
void newBook(){

        new BooksStoreNewEdit();
}
public static void generateTable(){
        String[] colnames = {"id","title","author","year","price"};
    Object[][] data = new Object[Books.size()][colnames.length];
    for(int i = 0; i< Books.size(); i++){
        Books book = Books.get(i);
        data[i][0] =book.getId();
        data[i][1] =book.getTitle();
        data[i][2]= book.getAuthor();
        data[i][3]= book.getYearPublished();
        data[i][4]= book.getPrice();
        System.out.println(book);
        System.out.println(data[i][0]);
    }
    DefaultTableModel dtm = new DefaultTableModel(data,colnames);
    bsm.table1.setModel(dtm);
}
//done
    public static void main(String[] args) {
        bsm = new BooksStoreMain();
        BooksDB.readBooks();
        generateTable();
        System.out.println(Books);

    }
}
