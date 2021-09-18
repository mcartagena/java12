package com.mcartagena.learnjava.general;

import java.lang.annotation.Repeatable;

@interface FerociousPack {
    Ferocious[] value();
}

@Repeatable(FerociousPack.class)
@interface Ferocious{
}

@Ferocious @Ferocious class Lion {
}
