package itacademy.generic.implDto;

import itacademy.generic.db.PrivilegeDto;
import org.junit.Test;

import java.util.List;

public class PrivilegeDtoDaoImplTest {

    @Test
    public void test() {

        PrivilegeDtoDaoImpl privilegeDtoDao = new PrivilegeDtoDaoImpl(PrivilegeDto.class);
        List<PrivilegeDto> all = privilegeDtoDao.findAll();
        System.out.println(all);
    }
}