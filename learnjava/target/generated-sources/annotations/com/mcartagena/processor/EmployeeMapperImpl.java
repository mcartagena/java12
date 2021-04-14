package com.mcartagena.processor;

import com.mcartagena.model.Division;
import com.mcartagena.model.Division.DivisionBuilder;
import com.mcartagena.model.DivisionDTO;
import com.mcartagena.model.DivisionDTO.DivisionDTOBuilder;
import com.mcartagena.model.Employee;
import com.mcartagena.model.Employee.EmployeeBuilder;
import com.mcartagena.model.EmployeeDTO;
import com.mcartagena.model.EmployeeDTO.EmployeeDTOBuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-14T06:31:36-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 12.0.2 (AdoptOpenJDK)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDTO employeeToEmployeeDTO(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDTOBuilder employeeDTO = EmployeeDTO.builder();

        employeeDTO.employeeId( entity.getId() );
        employeeDTO.employeeName( entity.getName() );
        if ( entity.getStartDt() != null ) {
            employeeDTO.employeeStartDt( new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ).format( entity.getStartDt() ) );
        }
        employeeDTO.division( divisionToDivisionDTO( entity.getDivision() ) );

        return employeeDTO.build();
    }

    @Override
    public Employee employeeDTOtoEmployee(EmployeeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmployeeBuilder employee = Employee.builder();

        employee.id( dto.getEmployeeId() );
        employee.name( dto.getEmployeeName() );
        try {
            if ( dto.getEmployeeStartDt() != null ) {
                employee.startDt( new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ).parse( dto.getEmployeeStartDt() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        employee.division( divisionDTOtoDivision( dto.getDivision() ) );

        return employee.build();
    }

    @Override
    public DivisionDTO divisionToDivisionDTO(Division entity) {
        if ( entity == null ) {
            return null;
        }

        DivisionDTOBuilder divisionDTO = DivisionDTO.builder();

        divisionDTO.id( entity.getId() );
        divisionDTO.name( entity.getName() );

        return divisionDTO.build();
    }

    @Override
    public Division divisionDTOtoDivision(DivisionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DivisionBuilder division = Division.builder();

        division.id( dto.getId() );
        division.name( dto.getName() );

        return division.build();
    }
}
