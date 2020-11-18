package Server.Repository;

import java.util.List;

import Server.Pojo.Sex;
import Server.Pojo.WishedPerson;

public interface WishedPersonRepository
{
    WishedPerson createWishedPerson(WishedPerson wishedPerson);

    WishedPerson getWishedPerson(int id);

    List<WishedPerson> getAllWishedPerson();

    void updateWishedPerson(WishedPerson sex);

    void deleteWishedPerson(int id);
}
