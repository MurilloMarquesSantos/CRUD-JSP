package dev.marques.jspproject.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sql = "select * from contatos order by nome";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                JavaBeans contato = new JavaBeans(rs.getString("idcon"),
                        rs.getString("nome"),
                        rs.getString("fone"),
                        rs.getString("email"));
                contatos.add(contato);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return contatos;
    }

    public void getContatosById(JavaBeans contato) {
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement("select * from contatos where idcon = ?");
            pst.setString(1, contato.getIdcon());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                contato.setIdcon(rs.getString("idcon"));
                contato.setNome(rs.getString("nome"));
                contato.setFone(rs.getString("fone"));
                contato.setEmail(rs.getString("email"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void atualizarContato(JavaBeans contatos) {
        String create = "update contatos set nome = ?, fone = ?, email = ? where idcon = ?";
        try {
            Connection con = conectar();
            PreparedStatement stmt = con.prepareStatement(create);
            stmt.setString(1, contatos.getNome());
            stmt.setString(2, contatos.getFone());
            stmt.setString(3, contatos.getEmail());
            stmt.setString(4, contatos.getIdcon());

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
