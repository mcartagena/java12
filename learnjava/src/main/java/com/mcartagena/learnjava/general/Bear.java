package com.mcartagena.learnjava.general;

public class Bear {
    enum FOOD{
        BERRIES {
            public boolean isHealthy(){
                return true;
            }
        },
        INSECTS {
            public boolean isHealthy(){
                return true;
            }
        },
        FISH{
            public boolean isHealthy(){
                return true;
            }
        },
        ROOTS{
            public boolean isHealthy(){
                return true;
            }
        },
        COOKIES{
            public boolean isHealthy(){
                return true;
            }
        }, HONEY{
            public boolean isHealthy(){
                return true;
            }
        }
        ;
        public abstract boolean isHealthy();
    }

    public static void main(String[] args) {
        System.out.println(FOOD.INSECTS);
        System.out.println(FOOD.INSECTS.ordinal());
        System.out.println(FOOD.INSECTS.isHealthy());
        System.out.println(FOOD.COOKIES.isHealthy());
    }
}
