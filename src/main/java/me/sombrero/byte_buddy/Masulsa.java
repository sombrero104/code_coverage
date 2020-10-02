package me.sombrero.byte_buddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa {

    public static void main(String[] args) {

        /**
         * 방법 1.
         * 아래 코드로 컴파일한 클래스를 만든 후 출력하는 방법.
         */
        /*try {
            new ByteBuddy().redefine(Moja.class)
                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
                    .make().saveIn(new File("/Users/sombrero104/IdeaProjects/code_coverage/target/classes/"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /**
         * 방법 2.
         * 클래스 파일을 불러와서 뜯어고치지 않고 클래스 이름으로 바로 변경하여 출력하는 방법.
         */
        /*ClassLoader classLoader = Masulsa.class.getClassLoader();
        TypePool typePool = TypePool.Default.of(classLoader);

        try {
            new ByteBuddy().redefine(typePool.describe("me.sombrero.byte_buddy.Moja").resolve()
                        , ClassFileLocator.ForClassLoader.of(classLoader))
                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
                    .make().saveIn(new File("/Users/sombrero104/IdeaProjects/code_coverage/target/classes/"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /**
         * 변경되었는지 출력하는 부분.
         */
        System.out.println(new Moja().pullOut());
    }

}
