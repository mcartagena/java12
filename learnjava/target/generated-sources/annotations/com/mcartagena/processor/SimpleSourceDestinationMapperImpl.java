package com.mcartagena.processor;

import com.mcartagena.model.SimpleDestination;
import com.mcartagena.model.SimpleDestination.SimpleDestinationBuilder;
import com.mcartagena.model.SimpleSource;
import com.mcartagena.model.SimpleSource.SimpleSourceBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-14T06:31:36-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 12.0.2 (AdoptOpenJDK)"
)
public class SimpleSourceDestinationMapperImpl implements SimpleSourceDestinationMapper {

    @Override
    public SimpleDestination sourceToDestination(SimpleSource source) {
        if ( source == null ) {
            return null;
        }

        SimpleDestinationBuilder simpleDestination = SimpleDestination.builder();

        simpleDestination.name( source.getName() );
        simpleDestination.description( source.getDescription() );

        return simpleDestination.build();
    }

    @Override
    public SimpleSource destinationToSource(SimpleDestination destination) {
        if ( destination == null ) {
            return null;
        }

        SimpleSourceBuilder simpleSource = SimpleSource.builder();

        simpleSource.name( destination.getName() );
        simpleSource.description( destination.getDescription() );

        return simpleSource.build();
    }
}
