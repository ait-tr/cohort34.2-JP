package de.ait.users.repositories.impl;

import de.ait.users.model.Address;
import de.ait.users.model.Address;
import de.ait.users.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AddressRepositoryJDBCTemplateImpl implements AddressRepository {
    {
        System.out.println("qwertyuiop[!!!!!!!!!!!!!!!!!!!");
    }
    private final JdbcTemplate jdbcTemplate;

    // Table Description
    public static final String TABLE_NAME="t_address";
    public static final String ID="id";
    public static final String COUNTRY = "country";
    public static final String ZIPCODE = "zip_code";
    public static final String CITY = "city";
    public static final String STREET ="street";
    public static final String HOUSE ="house";

    private static  final RowMapper<Address> ADDRESS_ROW_MAPPER =(row, rowNum) ->{
        Long id = row.getLong(ID);
        String country = row.getString(COUNTRY);
        String zipcode = row.getString(ZIPCODE);
        String city = row.getString(CITY);
        String street = row.getString(STREET);
        String house = row.getString(HOUSE);
        return new Address(id,country,zipcode,city,street,house);
    };


    @Override
    public List<Address> findAll() {
        String sql = String.format("SELECT * FROM %s", TABLE_NAME);
        return jdbcTemplate.query(sql, ADDRESS_ROW_MAPPER);
    }

    @Override
    public Optional<Address> findById(Long id) {
        String sql = String.format("SELECT * FROM %s WHERE id=?", TABLE_NAME);
        Address address = jdbcTemplate.queryForObject(sql, ADDRESS_ROW_MAPPER,id);
        return Optional.ofNullable(address);
    }




    public Address save(Address address) {
        if(address.getId()!=null){
            return update(address);
        }
        Map<String,Object> values = new HashMap<>();   // map <имя колонки, значение>
        values.put(COUNTRY,address.getCountry());
        values.put(ZIPCODE,address.getZipCode());
        values.put(HOUSE,address.getHouse());
        values.put(CITY,address.getCity());
        values.put(STREET,address.getStreet());

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        Long generatedID =jdbcInsert.usingGeneratedKeyColumns(ID) // указываем авто генерируемую колонку
                .withTableName(TABLE_NAME)          // указываем имя таблицы
                .executeAndReturnKey(values)       // выполняем запрос
                .longValue();

        address.setId(generatedID);

        return address;
    }

    @Override
    public void deleteById(Long id) {
        String sql = String.format("DELETE FROM %s WHERE id=?",TABLE_NAME);
        jdbcTemplate.update(sql,id);
    }

    private Address update(Address address) {
        //UPDATE t_address SET country =?, zip_code =?, city=?, street=? house=? WHERE id=?
        String sql = String.format("UPDATE %s SET %s=?, %s =?, %s=?, %s=?, %s=? WHERE id=?"
                                      ,TABLE_NAME ,COUNTRY ,ZIPCODE ,CITY ,STREET ,HOUSE );

        jdbcTemplate.update(sql
                ,address.getCountry()
                ,address.getZipCode()
                ,address.getCity()
                ,address.getStreet()
                ,address.getHouse()
                ,address.getId());

        return address;
    }


}
