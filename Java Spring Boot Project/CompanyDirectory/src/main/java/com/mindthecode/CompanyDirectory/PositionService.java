package com.mindthecode.CompanyDirectory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionService {

    @Autowired
    PositionRepo repo;

    @Autowired
    PositionMapper mapper;

    public GenericResponse<AllPositionsResponse> getAllPositions() {
        List<PositionResponse> positions = mapper.mapPositions(repo.findAll());
        if(positions != null && positions.size() > 0)
            return new GenericResponse<>(new AllPositionsResponse(positions));

        return new GenericResponse(new ErrorResponse(0,"Error","No Positions were found"));
    }

    /*need to find one position only because id is primary key*/
    public GenericResponse<PositionResponse> getPositionById(long id) {
        Iterable<Position> retrievedPositions = repo.findAll();
        for (Position position : retrievedPositions) {
            if (position.getId() == id)
                return new GenericResponse<>(mapper.mapPositionToResponse(position));
        }
        return new GenericResponse(new ErrorResponse(0,"Error","Positions with id "+ id +" was not found"));
    }

    /*uncomment when Unit is ready*/
    /*Needs to be tested after creation of Unit*/
    /*
    public GenericResponse<AllPositionsResponse> getPositionsByUnitId(Long unitId) {
        Iterable<Position> retrievedPositions = repo.findAll();
        List<PositionResponse> positionResponses = new ArrayList<>();
        for (Position position : retrievedPositions) {
            if (position.getUnit() !=null && position.getUnit().getId() == unitId) {
                positionResponses.add(mapper.mapPositionToResponse(position));
            }
        }

        if(positionResponses != null && positionResponses.size() > 0)
            return new GenericResponse<>(new AllPositionsResponse(positionResponses));

        return new GenericResponse(new ErrorResponse(0,"Error","No Positions were found"));
    }
    */


}
