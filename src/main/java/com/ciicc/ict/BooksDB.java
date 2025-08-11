package com.ciicc.ict;
import java.sql.*;
public class BooksDB {
    private static String url ="jdbc:mysql://localhost/BooksStore";
    private static String user = "root";
    private static String password = "";
    private static String sqlBooks = "select * from books";
     static Connection conn;
     static Statement statement;
    public static void  con(){
        try{
             conn = DriverManager.getConnection(url,user,password);
             statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
//            ResultSet rs = statement.executeQuery(sqlBooks);
//            int id = 2;
//            ResultSet rs = statement.executeQuery(sqlBooks+" where id = "+id);
////            System.out.println(statement);
//            while(rs.next()){
//                System.out.print(rs.getInt("id")+", ");
//                System.out.print(rs.getString(2)+", ");
//                System.out.print(rs.getString(3)+", ");
//                System.out.print(rs.getInt(4)+", ");
//                System.out.print(rs.getDouble(5)+"\n");
//            }
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
//    Create book
    public static void addBook(String title,
                        String author,
                        int yearPublished,
                        double price){
        try{
            con();
            ResultSet rs = statement.executeQuery(sqlBooks);
            rs.moveToInsertRow();
            rs.updateString(2,title);
            rs.updateString(3,author);
            rs.updateInt(4,yearPublished);
            rs.updateDouble(5,price);
            rs.insertRow();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

    }
    public static void readBooks(){
        try{
            con();
            ResultSet rs = statement.executeQuery(sqlBooks);
            while(rs.next()){
                BooksStoreMain.Books.add(new Books(rs.getInt("id"),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5)));

            }
            conn.close();

        }
        catch (Exception e){

        }

    }
    public static void readBook(int id){
        try{
            con();
            ResultSet rs = statement.executeQuery(sqlBooks+" where id = "+id);
            while(rs.next()){
                BooksStoreMain.Books.add(new Books(rs.getInt("id"),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5)));
            }
            conn.close();

        }
        catch (Exception e){

        }
    }

//    update book
public static void setBook(int id,String title,
                           String author,
                           int yearPublished,
                           double price){
    try{
        con();
        ResultSet rs = statement.executeQuery(sqlBooks+" where id = "+id);
        rs.absolute(1);
        rs.updateString(2,title);
        rs.updateString(3,author);
        rs.updateInt(4,yearPublished);
        rs.updateDouble(5,price);
        rs.updateRow();
        conn.close();
    }
    catch (Exception e){
        System.out.println(e.getLocalizedMessage());
    }

}
//delete book
    public static void delBook(int id){
        try{
            con();
            ResultSet rs = statement.executeQuery(sqlBooks+" where id = "+id);
            rs.absolute(1);
            rs.deleteRow();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    public static void main(String[] args) {
//        new BooksDB().readBooks();
        readBooks();
//        System.out.println("************ new record *****************");
//        addBook("C# advance","w3 schools",2021,99.45);
//        readBooks();
//        delBook(3);
        System.out.println("************ new record *****************");
        readBooks();
    }
}
