package com.mcxtzhang.asm.learn1;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;

public class Test1 {
    public static void main(String[] args) throws Exception {
        Printer printer = new Printer();
        ClassReader cr = new ClassReader("Origin");
        cr.accept(printer, 0);
    }

    static class Class1 {
        public Class1(int a) {

        }

        private long f(int n, String s, int[] arr) {
            return 0;
        }

        private void hi(double a, List<String> b) {

        }
    }

    static class Printer extends ClassVisitor {

        public Printer() {
            super(Opcodes.ASM5);
        }

        @Override
        public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
            super.visit(version, access, name, signature, superName, interfaces);
            System.out.println("visit:" + superName + "-" + name);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            System.out.println("visitMethod:" + name + "-" + desc);
            return super.visitMethod(access, name, desc, signature, exceptions);

        }
    }
}
