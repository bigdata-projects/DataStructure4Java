package linear.array;

/**
 * Created by Administrator on 2017/7/26.
 */
public class PeopleDO {
    private String name;
    private int age;
    private String sex;

    public PeopleDO() {
        super();
    }


    public PeopleDO(String name, int age, String sex) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PeopleDO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PeopleDO peopleDO = (PeopleDO) o;

        if (age != peopleDO.age) return false;
        if (name != null ? !name.equals(peopleDO.name) : peopleDO.name != null) return false;
        return sex != null ? sex.equals(peopleDO.sex) : peopleDO.sex == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}
