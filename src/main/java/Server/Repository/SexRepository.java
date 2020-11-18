package Server.Repository;
import java.util.List;

import Server.Pojo.Sex;


public interface SexRepository
{
    Sex createSex(Sex sex);

    Sex getSex(int id);

    List<Sex> getAllSex();

    void updateSex(Sex sex);

    void deleteSex(int id);
}
