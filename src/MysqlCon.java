import java.sql.*;

/*sds
* jdbc - connecting a java appn to sql db
//create table emp(id int(10),name varchar(40),age int(3));
//Driver Manager -> getConnection(url, username, paswd);
* create table emp(id int(10),name varchar(40),age int(3));
-- driver class
- connection
- user name
- password*/
class MysqlCon {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niba", "ea", "cs544");
            //here new_schema_jdbc is the database name, root is the username and root is the password
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from emp");

            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}