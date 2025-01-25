package com.muhammet.criteria;

public class RunnerExample {
    public static void main(String[] args) {
        CriteriaExample cr = new CriteriaExample();
        //cr.findAll().forEach(System.out::println);
//        cr.selectOneColumn().forEach(System.out::println);
      //  cr.findAllByName("Muhammet").forEach(System.out::println);
       // cr.findAllByNameOrSurname("Muhammet", "TAŞ").forEach(System.out::println);
        /**
         * List<Object[]>
         */
//        cr.findManyColumnLikeName("e").forEach(u->{
//            System.out.println(u[0]+ " - " + u[1] + " - " + u[2]);
//        });
        cr.usingTuple("a");
    }
}
