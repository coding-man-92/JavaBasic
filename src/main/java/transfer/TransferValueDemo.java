package transfer;

/**
 * @author: 宋荣华
 * @date: 2020/4/9
 * @description mianshi.transfer
 */
public class TransferValueDemo {
    public static void main(String[] args) {
        TransferValueDemo test = new TransferValueDemo();
        int age = 20;
        test.changeValue1(age);
        System.out.println("age----:" + age);
        Person person = new Person("zhangsan");
        test.changeValue2(person);
        System.out.println("name----:" + person.getName());
        String str = "abc";
        test.changeValue3(str);
        System.out.println("string----:" + str);
    }

    public void changeValue1(int age) {
        age = 30;
    }

    public void changeValue2(Person person) {
        person.setName("lisi");
    }

    public void changeValue3(String str) {
        str = "xxx";
    }
}
