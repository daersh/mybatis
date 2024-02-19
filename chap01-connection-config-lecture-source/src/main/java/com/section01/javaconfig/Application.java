package com.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.sql.Connection;
import java.util.Date;

public class Application {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/menudb";
    private static String user = "root";
    private static String password = "mariadb";

    public static void main(String[] args) {
        /*환경설정
        ----------------------------------------------
          * JDBCTransactionFactory: 수동 커밋
          * ManagedTransactionFactory: 자동 커밋
        ----------------------------------------------
          * PooledDataSource: ConnectionPool 사용
          * UnpooledDataSource: ConnectionPool 미사용
        ----------------------------------------------
        * */
        Environment environment = new Environment(
                                                    "dev",
                                                    new JdbcTransactionFactory(),
                                                    new PooledDataSource(driver,url,user,password)
                                                 );

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(Mapper.class); /*구현체 만들어줌 -> 그래서 mapper.selectNow()와 같이 사용 가능*/


        //싱글톤을 통해 한번만 생성하게 해줌
        /*
        * SqlSessionFactory(): SqlSession 객체 생성을 위한 팩토리 역할의 인터페이스
        * SqlSessionFactoryBuilder(): SqlSessionFactory 인터페이스 타입의 하위 구현 객체 생성을 위한 빌드 역할
        * .build(): 설정에 대한 정보를 담고 있는 Configuration 타입의 객체 혹은 외부 설정 파일과 연결된 stream을
        *           매개변수로 전달하면 SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드
        * SqlSession == Connection 객체  [ false = 수동 커밋, true = 자동 커밋  ]
        * */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession session = sqlSessionFactory.openSession(false); //false: 수동 커밋

        Mapper mapper = session.getMapper(Mapper.class);
        Date date = mapper.selectNow();
        System.out.println("date = " + date);
        session.close();
    }
}