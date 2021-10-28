package com.mcartagena.learnjava.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TaffyFactory {
    public int getPrize(byte[] luck) throws Exception{
        byte[] data = new byte[2];
        int rtn;
        try(InputStream is = new ByteArrayInputStream(luck)){
            rtn = is.read(data);
            System.out.println("data -> " + data[0] + " " + data[1]);
            System.out.println("return -> " + rtn);
            if(!is.markSupported()) return -1;
            is.mark(5);
            rtn = is.read();
            System.out.println("return -> " + rtn);
            rtn = is.read();
            System.out.println("return -> " + rtn);
            is.skip(3);
            is.reset();
            rtn = is.read();
            System.out.println("return -> " + rtn);
            return rtn;
        }
    }

    public static void main(String[] args) throws Exception{
        final TaffyFactory p = new TaffyFactory();
        final var luck = new byte[] {1, 2, 3, 4, 5, 6, 7};
        System.out.print(p.getPrize(luck));
    }
}
