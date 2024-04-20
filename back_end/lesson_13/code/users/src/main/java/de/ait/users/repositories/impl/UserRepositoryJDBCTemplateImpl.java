package de.ait.users.repositories.impl;

import de.ait.users.model.User;
import de.ait.users.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryJDBCTemplateImpl implements UserRepository {

    //private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public static final String TABLE_NAME="t_user";
    public static final String ID="id";
    public static final String NAME = "name";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String AGE ="age";

    private static  final RowMapper<User> USER_ROW_MAPPER =(row, rowNum) ->{
        Long id = row.getLong(ID);
        String name = row.getString(NAME);
        String email = row.getString(EMAIL);
        String password = row.getString(PASSWORD);
        int age = row.getInt(AGE);
        return new User(id,name,password,email,age);
    };


    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM t_user",USER_ROW_MAPPER);
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM t_user WHERE id=?",USER_ROW_MAPPER,id);
        return Optional.ofNullable(user);
    }

    @Override
    public User save(User user) {
        if(user.getId()!=null){
            return update(user);
        }
        Map<String,Object> values = new HashMap<>();   // map <имя колонки, значение>
        values.put(NAME,user.getName());
        values.put(EMAIL,user.getEmail());
        values.put(PASSWORD,user.getPassword());
        values.put(AGE,user.getAge());

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        Long generatedID =jdbcInsert.usingGeneratedKeyColumns(ID) // указываем авто генерируемую колонку
                .withTableName(TABLE_NAME)          // указываем имя таблицы
                .executeAndReturnKey(values)       // выполняем запрос
                .longValue();

        user.setId(generatedID);

        return user;
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM t_user WHERE id=?",id);
    }

    private User update(User user) {

        jdbcTemplate.update("UPDATE t_user SET name =?, email =?, password=?, age=? WHERE id=?"
                ,user.getName()
                ,user.getEmail()
                ,user.getPassword()
                ,user.getAge()
                ,user.getId());

        return user;
    }


}
