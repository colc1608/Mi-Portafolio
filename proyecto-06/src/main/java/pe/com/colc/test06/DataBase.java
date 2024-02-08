package pe.com.colc.test06;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataBase {

    @Bean(name = "datasource1")
    @Primary
    @ConfigurationProperties("database1.datasource")
    public DataSource crearConexionDataBase1(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "datasource2")
    @ConfigurationProperties("database2.datasource")
    public DataSource crearConexionDataBase2(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcTemplate1")
    public JdbcTemplate jdbcTemplateOne(@Qualifier("datasource1") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean(name = "jdbcTemplate2")
    public JdbcTemplate jdbcTemplateTwo(@Qualifier("datasource2") DataSource ds) {
        return new JdbcTemplate(ds);
    }

}
