package dev.marques.jspproject.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    //Connection Module

    private String driver = "com.mysql.cj.jdbc.Driver";

    private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&ServerTimezone=UTC";

    private String user = "root";

    private String password = System.getenv("DB_PASSWORD");


    private Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void inserirContato(JavaBeans contatos) {
        String create = "insert into contatos(nome,fone,email) values(?,?,?)";
        try {
            Connection con = conectar();
            PreparedStatement stmt = con.prepareStatement(create);
            stmt.setString(1, contatos.getNome());
            stmt.setString(2, contatos.getFone());
            stmt.setString(3, contatos.getEmail());

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public List<JavaBeans> getContatos() {
        List<JavaBeans> contatos = new ArrayList<>();
        try {
            Connection con = conectar();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from contatos");
            while (rs.next()) {
                JavaBeans contato = new JavaBeans(rs.getString("idcon"),
                        rs.getString("nome"),
                        rs.getString("fone"),
                        rs.getString("email"));
                contatos.add(contato);
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return contatos;
    }
}
