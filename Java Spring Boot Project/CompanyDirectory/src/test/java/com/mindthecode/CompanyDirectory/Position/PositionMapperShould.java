package com.mindthecode.CompanyDirectory.Position;

import com.mindthecode.CompanyDirectory.mappers.PositionMapper;
import com.mindthecode.CompanyDirectory.models.entities.Position;
import com.mindthecode.CompanyDirectory.models.entities.Unit;
import com.mindthecode.CompanyDirectory.models.responses.PositionResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PositionMapperShould {
    private PositionMapper mapper;

    private Position positionInput;
    private Unit unitInput;
    private PositionResponse output;

    @Before
    public void setup() {
        mapper = new PositionMapper();
        positionInput = new Position(1, "Software Engineer", unitInput);
        positionInput.setId(10);
        unitInput = new Unit("");
        unitInput.setId(20);
        positionInput.setUnit(unitInput);
        output = mapper.mapPositionToResponse(positionInput);
    }

    @Test
    public void keepSameId() {
        Assert.assertEquals(positionInput.getId(), output.getId());
    }

    @Test
    public void keepSamePositionName() {
        Assert.assertEquals(positionInput.getName(), output.getName());
    }

    @Test
    public void keepSameUnit() {
        Assert.assertEquals(positionInput.getUnit(), output.getUnit());
    }

}
