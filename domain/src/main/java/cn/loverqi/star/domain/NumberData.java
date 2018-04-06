package cn.loverqi.star.domain;

import java.io.Serializable;

/**
 * 统计字段的内部类
 * @author LoverQi
 * @date 2018年4月6日
 */
public class NumberData implements Serializable{
    private static final long serialVersionUID = -5933553356168304290L;
    private int people;
    private double money;
    private double avg;

    public int getPeople() {
        return people;
    }

    public void addPeople(int people) {
        this.people += people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double money) {
        this.money += money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getAvg() {
        avg = people == 0 ? 0 : money / people;
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
}
