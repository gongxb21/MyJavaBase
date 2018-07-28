package designpattern.flyweight;

import org.junit.Test;

/**
 * @author gongxb
 * @date 2018/7/29
 * @desc
 * @return
 */
public class CellPhoneTest {

    @Test
    public void test1(){
        CellPhoneFactory cpf=new CellPhoneFactory();
        cpf.getCellPhone("call");
        cpf.getCellPhones();
    }

    @Test
    public void test2(){
        CellPhoneFactory cpf=new CellPhoneFactory();
        cpf.getCellPhone("call");
        cpf.getCellPhones();
        cpf.getCellPhone("callsss");
        cpf.getCellPhones();
    }

    @Test
    public void test3(){
        CellPhoneFactory cpf=new CellPhoneFactory();
        cpf.getCellPhone("call");
        cpf.getCellPhones();
        cpf.getCellPhone("callsss");
        cpf.getCellPhones();
        cpf.getCellPhone("callsss");
        cpf.getCellPhones();
    }


}
