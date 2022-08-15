package com.esanov.librarybackend;

import java.util.*;

public class example {

    public static void main(String[] args) {

        String a = "Amar";
        String b = "Antony";
        String c = "Joshua";
        String d = "Fantomas";

        List<String> arrayList1 = new ArrayList<>(Arrays.asList(a,b,c,d));

        Set<String> set = new HashSet<>();
        set.add("Samsung");
        set.add("IPhone");
        set.add("Sony");
        set.add("Nokia");

        List<String> arrayList2 = new ArrayList<>(set);

        List<String> arrayList3 = new ArrayList<>();
        set.forEach(s -> {
            arrayList3.add(s);
        });

        List<String> arrayList4 = new ArrayList<>();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            arrayList4.add(iterator.next());
        }

        List<String> arrayList5 = new ArrayList<>();
        arrayList5.addAll(set);

        System.out.println(arrayList1);
        System.out.println(arrayList2);
        System.out.println(arrayList3);
        System.out.println(arrayList4);
        System.out.println(arrayList5);

        List<String> arraylist6 = List.of(a,b,c,d);
        System.out.println(arraylist6);
    }

    public void salom(){
        System.out.println("Valekum assalom");
    }
}
