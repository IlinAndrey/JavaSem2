package app.Application;

import app.Application.Interfaces.BuildingRepository;
import app.Application.Interfaces.AddressRepository;
import java.io.IOException;

public interface ScheduleMXBean {
    void doScheduledTask() throws IOException;
}
