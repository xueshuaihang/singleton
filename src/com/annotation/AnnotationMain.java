package com.annotation;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Shuaihang Xue
 * @date 2020/7/22
 */
public class AnnotationMain {

    public static void main(String[] args) throws IllegalAccessException, ParseException, NoSuchFieldException {
        getNoteBook();
    }

    public static void getNoteBook() throws IllegalAccessException, ParseException, NoSuchFieldException {
        NoteBook noteBook = new NoteBook();
        noteBook.setName("MateBook 14");
        noteBook.setProductTimeStr("2019-07-06 14:00:00");
        setProductTimeByProductTimeStr(noteBook);
        System.out.println(noteBook.getProductTime());
    }

    public static void setProductTimeByProductTimeStr(NoteBook noteBook) throws IllegalAccessException, ParseException, NoSuchFieldException {
        Class noteBookClass = NoteBook.class;
        noteBookClass.getFields();
        Field[] fields = noteBookClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(TransferDate.class)) {
                TransferDate transferDate = field.getAnnotation(TransferDate.class);
                String pattern = transferDate.pattern();
                String toSetFiledName = transferDate.filedName();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                field.setAccessible(true);
                String dateStr = (String) field.get(noteBook);
                Date date = simpleDateFormat.parse(dateStr);
                Field toSetFiled = noteBookClass.getDeclaredField(toSetFiledName);
                toSetFiled.setAccessible(true);
                toSetFiled.set(noteBook, date);
            }
        }
    }
}
