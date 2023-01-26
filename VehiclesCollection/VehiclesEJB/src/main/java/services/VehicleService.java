package services;

import models.dto.common.VehicleFilterDTO;
import models.dto.common.VehiclesCountDTO;
import models.dto.vehicle.VehicleNoIdDTO;
import models.dto.vehicle.VehicleWithIdDTO;

import javax.ejb.Remote;
import java.util.List;
@Remote
public interface VehicleService {

    VehicleWithIdDTO addNewVehicle(VehicleNoIdDTO vehicleNoIdDTO);

    VehicleWithIdDTO updateVehicle(VehicleWithIdDTO vehicleWithIdDTO);

    VehicleWithIdDTO getVehicleById(Long id);

    VehicleWithIdDTO deleteVehicleById(Long id);

    List<VehicleWithIdDTO> getAllVehiclesWithFilter(VehicleFilterDTO filterDTO);

    VehiclesCountDTO countVehiclesWhereTypeIs(String type);

    List<VehicleWithIdDTO> getVehiclesWhereNameLike(String name);

    List<VehicleWithIdDTO> getVehiclesWhereEnginePowerIsLessThan(Integer enginePower);

}
