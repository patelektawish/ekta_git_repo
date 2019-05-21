package TestCases;

import Data.ExcelData;
import Data.RegisterData;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "modifiedRegisterDataP", dataProviderClass = RegisterData.class)
    public void registerTest(String name, String address, String age) {
        System.out.println("Name is --> " + name);
        System.out.println("Address is --> " + address);
        System.out.println("Age is --> " + age);
    }

    @Test(dataProviderClass = ExcelData.class, dataProvider = "excelDP")
    public void excelDPTest(Object name1, Object name2, Object name3, Object name4) {
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
    }
}
