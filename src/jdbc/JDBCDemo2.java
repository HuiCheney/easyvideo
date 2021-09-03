package jdbc;

import entry.Admin;
import entry.User;

import java.util.List;

public class JDBCDemo2 {

    public boolean insert(User user) {
//        String sql = "insert into user (username,password,nicename,phone,sex,birthday,headicon,status) " +
//                "values('詹姆斯','123556','詹皇','15667899321','1','1985-06-10','image/head4.png',1)";
        String sql = "insert into user (username,password,nicename) values(?,?,?)";
        return DBTools.exeUpdate(sql, user.getUsername(), user.getPassword(), user.getPhone());
    }
    public boolean insert(Admin user) {
        String sql = "insert into admin (username,password) values(?,?)";
        return DBTools.exeUpdate(sql, user.getUsername(), user.getPassword());
    }


    public boolean updeta(User user){
        String sql = "update user set username=?,password=?,phone=? where id=?";
        return DBTools.exeUpdate(sql,user.getUsername(),user.getPassword(), user.getPhone(),user.getId());
    }
    public boolean updeta(Admin user){
        String sql = "update user set username=?,password=? where id=?";
        return DBTools.exeUpdate(sql,user.getUsername(),user.getPassword(),user.getId());
    }


    public void select(int status){
        String sql = "select * from user where status=?";
        List<User> list = DBTools.queryList(User.class,sql,status);
        for (User u:list){
            System.out.println(u.getUsername()+" "+u.getPassword()+" "+u.getPhone());
        }
    }
    public void select(int status,String name){
        String sql = "select * from "+name+" where status=?";
        List<User> list = DBTools.queryList(User.class,sql,status);
        for (User u:list){
            System.out.println(u.getUsername()+" "+u.getPassword()+" "+u.getPhone());
        }
    }

    public User selectByUsername(String username){
        String sql = "select * from user where username=?";
        return DBTools.queryOne(User.class,sql,username);
    }


    public static void main(String[] args) {
        JDBCDemo2 demo2 = new JDBCDemo2();
        User user = new User();
        user.setUsername("吴京");
        user.setPassword("698656");
        user.setPhone("13664586166");
        user.setId(5);
//        System.out.println(demo2.insert(user));
//        System.out.println(demo2.updeta(user));
//        demo2.select(1);
        user = demo2.selectByUsername("詹姆斯");
        System.out.println(user.getUsername());
    }

}
