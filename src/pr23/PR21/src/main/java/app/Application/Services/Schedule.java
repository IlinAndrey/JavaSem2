package app.Application.Services;


import app.Application.Classes.Address;
import app.Application.Classes.Building;
import app.Application.Controllers.BuildingController;
import app.Application.Controllers.AddressController;
import app.Application.ScheduleMXBean;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class Schedule implements ScheduleMXBean {
    private Boolean isEmpty(final File file) {
        return (file.isDirectory() && (file.list().length > 0));
    }
    @ManagedOperation
    @Scheduled(cron = "0 0/30 * * * *")
    public void doScheduledTask() throws IOException {
        if(isEmpty(new File("C:/Users/User/IdeaProjects/outFile"))){
            for (File myFile : new File("C:/Users/User/IdeaProjects/outFile")
                    .listFiles()) {
                if (myFile.isFile()) myFile.delete();
            }
        }
        BuildingController buildingController = new BuildingController();
        AddressController addressController = new AddressController();
        List <Address> addresses= addressController.getAll();
        List <Building> buildings= buildingController.getAll();
        for (int i=0; i< buildings.size();i++) {
            File building = new File("C:/Users/User/IdeaProjects/outFile");
            FileWriter writer = new FileWriter(building, false);
            writer.write(buildings.get(i).toString());
        }

        for (int i=0; i< addresses.size();i++) {
            File level = new File("C:/Users/User/IdeaProjects/outFile");
            FileWriter writer = new FileWriter(level, false);
            writer.write(addresses.get(i).toString());
        }
    }
}
