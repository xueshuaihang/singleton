package com.newfeature.stream;

import com.newfeature.lambda.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Shuaihang Xue
 * @date 2020/7/21
 */
public class StreamTest {

    public static void main(String[] args) {
//        streamOf();
//        useFilter();
//        useMap();
//        useFlatMap();
//        useMaxAndMin();
//        useCount();
//        useReduce();
//        useMaxAndMinAndAvgCollect();
//        usePartitioningBy();
//        useGroupingBy();
        useJoining();
        useStringJoiner();
    }

    public static void streamOf() {
        List<Student> students = Stream.of(new Student("小明", 13)
                , new Student("小强", 16), new Student("小红", 18)).collect(Collectors.toList());
        System.out.println(students);
    }

    public static void useFilter() {
        List<Student> students = getStudents();
        List<Student> students1 = students.stream().filter(student -> "小明".equals(student.getName())).collect(Collectors.toList());
        System.out.println(students1);
    }

    public static void useMap() {
        List<Student> students = getStudents();
        List<String> strings = students.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(strings);
    }

    public static void useFlatMap() {
        List<Student> students = getStudents();
        List<Student> students2 = Stream.of(students, students).flatMap(students1 -> students1.stream()).collect(Collectors.toList());
        System.out.println(students2);
    }

    public static void useMaxAndMin() {
        List<Student> students = getStudents();
        Optional<Student> max = students.stream().max(Comparator.comparing(Student::getAge));
        Optional<Student> min = students.stream().min(Comparator.comparing(Student::getAge));
        if (max.isPresent()) {
            System.out.println(max.get());
        }
//        System.out.println(min.orElse(new Student()));
        // or
//        System.out.println(min.orElseGet(() -> new Student()));
        // or
        System.out.println(min.orElseGet(Student::new));
    }

    public static void useCount() {
        List<Student> students = getStudents();
        long count = students.stream().filter(student -> student.getAge() > 15).count();
        System.out.println(count);
    }

    public static void useReduce() {
        Integer reduce = Stream.of(1, 2, 3, 4, 5).reduce(15, (account, x) -> account - x);
        System.out.println(reduce);
    }

    public static void useMaxAndMinAndAvgCollect() {
        List<Student> students = getStudents();
        Optional<Student> maxAgeStudentOptional = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
        Optional<Student> minAgeStudentOptional = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
        Double avgAge = students.stream().collect(Collectors.averagingInt(Student::getAge));
        System.out.println(maxAgeStudentOptional);
        System.out.println(minAgeStudentOptional);
        System.out.println(avgAge);
    }

    public static void usePartitioningBy() {
        List<Student> students = getStudents();
        Map<Boolean, List<Student>> partitionAge = students.stream().collect(Collectors.partitioningBy(student -> student.getAge() < 15));
        System.out.println(partitionAge.get(true));
        System.out.println(partitionAge.get(false));
    }

    public static void useGroupingBy() {
        List<Student> students = getStudents();
        Map<Integer, List<Student>> groupByAgeStudent = students.stream().collect(Collectors.groupingBy(Student::getAge));
        System.out.println(groupByAgeStudent.get(13));
        System.out.println(groupByAgeStudent.get(16));
        System.out.println(groupByAgeStudent.get(18));
    }

//    public static void useMatch() {
//        List<Student> students = getStudents();
//        students.stream().allMatch()
//    }

    /**
     * 对比于StringJoiner，这种方法比直接用StringJoiner更为简便
     */
    public static void useJoining() {
        List<Student> students = getStudents();
        String names = students.stream().map(Student::getName).collect(Collectors.joining(",", "{", "}"));
        System.out.println(names);
    }

    public static void useStringJoiner() {
        List<Student> students = getStudents();
        List<String> names = students.stream().map(Student::getName).collect(Collectors.toList());
        // 使用String.join    其实现原理是使用StringJoiner,但是没有实现添加前缀和后缀的功能
        String afterJoinName = String.join(",", names);
        System.out.println(afterJoinName);

        // 使用StringJoiner
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (String name : names) {
            stringJoiner.add(name);
        }
        System.out.println(stringJoiner.toString());
    }

    public static List<Student> getStudents() {
        return Stream.of(new Student("小明", 13)
                , new Student("小强", 16)
                , new Student("小红", 18)
                , new Student("张三", 18))
                .collect(Collectors.toList());
    }

}
