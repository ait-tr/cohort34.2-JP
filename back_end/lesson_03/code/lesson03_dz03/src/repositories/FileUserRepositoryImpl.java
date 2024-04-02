package repositories;

import model.User;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class FileUserRepositoryImpl implements UserCrudRepository {
    private String fileName;
    private  Long currentID = 1L;

    public FileUserRepositoryImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(User user) {
        user.setId(currentID++);
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName,true))) {
                writer.println(user.getId() + ";" + user.getName()+ ";" + user.getEmail());
                //System.out.println("Пользователи сохранены в файл users.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении в файл: " + user );
            e.printStackTrace();
        }
    }

    @Override
    //1;userName;email
    public List<User> findAll() {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines()
                    .map(s->s.split(";"))
                    .map(uArr -> new User(Long.parseLong(uArr[0]), uArr[1], uArr[2]))
                    .toList();
        } catch (IOException e){
            System.out.println("File read error");
            return Collections.EMPTY_LIST;
        }
    }


    @Override
    //1;userName;email -> {"1", "name", "email"}
    public List<User> findBuNameStartingWith(String prefix) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines()
                    .map(s->s.split(";"))
                    .filter(u->u[1].startsWith(prefix))
                    .map(uArr -> new User(Long.parseLong(uArr[0]), uArr[1], uArr[2]))
                    .toList();
        } catch (IOException e){
            System.out.println("File read error");
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public User findByID(Long id) {
        return findAll().stream()
                .filter(u->u.getId()==id.longValue())
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(User element) {

    }

    @Override
    public void deleteByID(Long id) {

    }
}
