package me.sombrero.byte_buddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * 바이트코드 조작하기.
 */
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
         * 방법 3.
         * Java Agent를 jar 파일로 만들어서 자바 실행 시 아래와 같이 JVM 옵션을 추가하는 방법.
         *      -javaagent:/Users/sombrero104/IdeaProjects/MasulsaAgent/target/MasulsaAgent-1.0-SNAPSHOT.jar
         *
         * => 이 방법은 실행 후 class 파일의 바이트코드를 확인해보면 코드가 변경되지 않은 것을 확인할 수 있다.
         *      클래스 파일 자체를 변경하는 것이 아니고..
         *      자바 agent가 클래스 로딩 시점에 적용이 되어 메모리에 올라갈 때 바이트코드가 변경되기 때문..
         *      (위의 다른 방법들과는 다르게 비침투적인(transparent한) 방식..)
         */

        /**
         * 변경되었는지 출력하는 부분.
         */
        System.out.println(new Moja().pullOut());
    }

}
