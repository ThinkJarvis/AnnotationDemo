package com.app.aopdemo;

import android.content.Context;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import dalvik.system.DexFile;

public class AnnotationTools {

    public static List<Class> getClassName(String packageName, Context context, Class<?> annotation) {
        if (packageName == null) {
            packageName = context.getPackageName();
        }
        List<Class> classNameList = new ArrayList<>();
        try {

            DexFile df = new DexFile(context.getPackageCodePath());
            Enumeration<String> enumeration = df.entries();
            while (enumeration.hasMoreElements()) {
                String className = enumeration.nextElement();

                if (className.contains(packageName)) {
                    Class entryClass = Class.forName(className);
                    if (entryClass != null) {
                        Annotation annotation1 = entryClass.getAnnotation(annotation);
                        if (annotation1 != null) {
                            classNameList.add(entryClass);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classNameList;
    }
}
