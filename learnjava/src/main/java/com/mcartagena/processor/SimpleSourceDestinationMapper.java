package com.mcartagena.processor;

import com.mcartagena.model.SimpleDestination;
import com.mcartagena.model.SimpleSource;
import org.mapstruct.Mapper;

@Mapper
public interface SimpleSourceDestinationMapper {
    SimpleDestination sourceToDestination(SimpleSource source);
    SimpleSource destinationToSource(SimpleDestination destination);
}
