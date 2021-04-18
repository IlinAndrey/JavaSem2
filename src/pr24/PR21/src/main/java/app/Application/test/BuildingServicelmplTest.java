package app.Application.test;

import app.Application.Classes.Building;
import app.Application.Interfaces.BuildingRepository;
import app.Application.Services.BuildingService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)
public class BuildingServicelmplTest {

    @Mock
    private BuildingRepository buildingRepository;
    @Test
    public void getBuilding() {
        buildingRepository=mock(BuildingRepository .class);
        Building building = new Building();
        building.setType("Dom");
        Building building1 = new Building();
        building1.setType("Dom2");
        Mockito.when(building.findAll()).thenReturn(List.of(building,building1));
        BuildingService userService = new BuildingService((BuildingRepository) building);
        Assertions.assertEquals(2, userService.getBuildings().size());
        Assertions.assertEquals("Dom",
                userService.getBuildings().get(0).getType());
    }
}
