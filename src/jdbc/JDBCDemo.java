package jdbc;

import java.sql.*;

/**
 * JDBC访问数据库分为六大步骤:
 * 1.加载数据库驱动
 * 2.获取数据库连接对象
 * 3.获取处理sql命令对象
 * 4.执行
 * 5.处理结果
 * 6.关闭资源
 */
public class JDBCDemo {

    /**
     * 添加数据
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void insert() throws ClassNotFoundException, SQLException {
        //准备sql语句
        String sql = "insert into admin(username,password) values('狗蛋','123')";
        //1.加载驱动 Alt+Enter
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库链接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyvideo","root","123456");
        //3.获取处理sql语句的命令对象
        PreparedStatement ps = conn.prepareStatement(sql);
        //4.执行
        int i = ps.executeUpdate();
        //5.处理结果
        if(i > 0){
            System.out.println("添加成功");
        }
        //6.关闭资源
        ps.close();
        conn.close();
    }

    /**
     * 修改数据
     * @param id
     * @param pwd
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void update(int id,String pwd) throws ClassNotFoundException, SQLException {
        //准备sql语句
        String sql = "update admin set password=? where id=?";
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyvideo","root","123456");
        //3.获取处理sql语句的命令对象
        PreparedStatement ps = conn.prepareStatement(sql);
        //预处理(将占位符替换为真实数据)
        ps.setString(1,pwd);
        ps.setInt(2,id);
        //4.执行
        int i = ps.executeUpdate();
        //5.处理结果
        if(i > 0){
            System.out.println("修改成功");
        }
        //6.关闭资源
        ps.close();
        conn.close();
    }

    /**
     * 删除记录
     * @param id
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "delete from admin where id=?";
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyvideo","root","123456");
        //3.获取处理sql语句的命令对象
        PreparedStatement ps = conn.prepareStatement(sql);
        //预处理
        ps.setInt(1,id);
        //4.执行
        int i = ps.executeUpdate();
        //5.处理结果
        if(i > 0){
            System.out.println("删除成功");
        }
        //6.关闭资源
        ps.close();
        conn.close();
    }

    //思考:如何使用一个方法解决所有的insert update delete操作

    public void selectAll() throws ClassNotFoundException, SQLException {
        //准备sql语句
        String sql = "select * from admin";
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyvideo","root","123456");
        //3.获取处理sql语句的命令对象
        PreparedStatement ps = conn.prepareStatement(sql);
        //4.执行(查询)
        ResultSet rs = ps.executeQuery();
        //5.处理结果(循环遍历结果集获取数据)
        while(rs.next()){
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            System.out.println(id+"/"+username+"/"+password);
        }
        //6.关闭资源
        rs.close();
        ps.close();
        conn.close();
    }
    /**
     * 添加数据
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void insert_user() throws ClassNotFoundException, SQLException {
        //准备sql语句
        String sql = "insert into user (username,password,nicename,phone,sex,birthday,headicon,status) " +
                "values('詹姆斯','123556','詹皇','15667899321','1','1985-06-10','image/head4.png',1)";
        //1.加载驱动 Alt+Enter
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库链接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyvideo","root","123456");
        //3.获取处理sql语句的命令对象
        PreparedStatement ps = conn.prepareStatement(sql);
        //4.执行
        int i = ps.executeUpdate();
        //5.处理结果
        if(i > 0){
            System.out.println("添加成功");
        }
        //6.关闭资源
        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //创建对象
        JDBCDemo demo = new JDBCDemo();
//        demo.insert();
//        demo.update(1,"123456");
//        demo.delete(8);
//        demo.selectAll();
        demo.insert_user();
    }

}
