package com.mcartagena.learnjava.general;

public class OuterVariableScope {
    private int x = 10;

    class InnerVariableScope{
        private int x = 20;
        class Inner {
            private int x = 30;
            public void allTheX(){
                System.out.println(x);
                System.out.println(this.x);
                System.out.println(InnerVariableScope.this.x);
                System.out.println(OuterVariableScope.this.x);
            }
        }
    }

    public static void main(String[] args) {
        OuterVariableScope outer = new OuterVariableScope();
        OuterVariableScope.InnerVariableScope innerVariableScope = outer.new InnerVariableScope();
        OuterVariableScope.InnerVariableScope.Inner inner = innerVariableScope.new Inner();
        inner.allTheX();
    }
}
