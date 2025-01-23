package com.muhammet.criteria;

public class RunnerExample {
    public static void main(String[] args) {
        CriteriaExample cr = new CriteriaExample();
        //cr.findAll().forEach(System.out::println);
//        cr.selectOneColumn().forEach(System.out::println);
        cr.findAllByName("Muhammet").forEach(System.out::println);

    }
}
