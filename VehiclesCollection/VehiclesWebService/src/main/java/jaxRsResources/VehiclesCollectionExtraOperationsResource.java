package jaxRsResources;

import services.VehicleService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static configuration.RemoteEjbConfig.getVehicleService;
import static configuration.RemoteEjbConfig.remoteContext;
import static utils.validators.CommonValidator.*;

@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
@Path("/vehicles")
public class VehiclesCollectionExtraOperationsResource {
    private VehicleService vehicleService = getVehicleService(remoteContext());

    @GET
    @Path("/count/type")
    public Response getCountVehiclesWhereTypeIs(@QueryParam("type") String type) {
        validateVehicleType(type);
        return Response.ok(vehicleService.countVehiclesWhereTypeIs(type)).build();
    }


    @GET
    @Path("/name/like")
    public Response getVehiclesWhereNameLike(@QueryParam("nameLike") String nameLike) {
        validateString(nameLike);
        return Response.ok(vehicleService.getVehiclesWhereNameLike(nameLike)).build();
    }


    @GET
    @Path("/enginePowere/less")
    public Response getVehiclesWhereEnginePowerIsLessThan(@QueryParam("enginePower") String enginePowerString) {
        Integer enginePower = validateInteger(enginePowerString);
        return Response.ok(vehicleService.getVehiclesWhereEnginePowerIsLessThan(enginePower)).build();
    }

}
